package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.feilmeldinger.CSVFormatAvvikHandler;
import programutvikling.feilmeldinger.UtdatertFilAvvikHandler;
import programutvikling.filhantering.SkrivingTilFil.SkrivingTradObjekt;
import programutvikling.filhantering.innlesingFraFil.LesingTradObjekt;
import programutvikling.kontrollere.uihjelpere.ApneFilVelger;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.LagreFilVelger;
import programutvikling.status.InnlesingOgSkrivingStatus;

import java.io.InvalidClassException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hovedSceneKontroller {


  @FXML
  protected JFXButton mainSceneKnapp;
  @FXML
  protected BorderPane borderPane;
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  Task<HashMap<String, Object>> leseFilHandling;
  Task<Void> skriveTilFilHandling;


  private HashMap<String, Object> allData, allDataFraFil;


  public void initialize() {

    hsk.setBorderPane(borderPane);
    Platform.runLater(() -> mainSceneKnapp.requestFocus());

    Navigator.visScene(borderPane, Navigator.getDashbordScene());
    mainSceneKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());


  }

  @FXML
  protected void handleNavigeringTilDashbord() {


    Navigator.visScene(borderPane, Navigator.getDashbordScene());

  }

  @FXML
  protected void handleNavigeringTilForsikringerScene() {


    Navigator.visScene(borderPane, Navigator.getForsikringListeScene());

  }

  @FXML
  protected void handleNavigeringTilKunderScene() {


    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }


  @FXML
  protected void handleNavigeringTilErstatningerScene() {


    Navigator.visScene(borderPane, Navigator.getERSTATNINGER_SCENE());

  }

  @FXML
  protected void handleNavigeringTilAvvistSkademeldingListeScene() {


    Navigator.visScene(borderPane, Navigator.getAvvistSkademeldingListeScene());

  }

  @FXML
  protected void handleLagreKnapp() {

    allData = dlo.getAllData();


    LagreFilVelger filVelger = new LagreFilVelger();

    ExecutorService service = Executors.newSingleThreadExecutor();

    skriveTilFilHandling = new SkrivingTradObjekt(allData, filVelger.getFilsti());


    service.execute(skriveTilFilHandling);


  }


  @FXML
  protected void handleApneKnapp() {

    ApneFilVelger filVelger = new ApneFilVelger();

    ExecutorService service = Executors.newSingleThreadExecutor();


    leseFilHandling = new LesingTradObjekt(filVelger.getFilsti(), this::oppdatereGuiMedDataLastetFraFil);
    leseFilHandling.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
      @Override
      public void handle(WorkerStateEvent t) {

        if (leseFilHandling.getValue() != null)
          allDataFraFil = leseFilHandling.getValue();

      }
    });

    leseFilHandling.setOnFailed(evt -> {


      if (leseFilHandling.getException().getClass() == InvalidClassException.class) {
        UtdatertFilAvvikHandler.genererUtdatertFilAvvikMelding((InvalidClassException) leseFilHandling.getException());
      } else if (leseFilHandling.getException().getClass() == CSVFormatAvvikHandler.class) {


        CSVFormatAvvikHandler.generateCSVFormatExceptionMsg((CSVFormatAvvikHandler) leseFilHandling.getException());
      }


      leseFilHandling.cancel();


    });
    service.execute(leseFilHandling);


  }


  private void oppdatereGuiMedDataLastetFraFil() {
    if (allDataFraFil != null) {

      dlo.setAllData(allDataFraFil);
    }
    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }


  @FXML
  protected void handleAvsluttKnapp() {

    Platform.exit();

  }

  @FXML
  public void handleNavigeringTilSkademeldingScene(ActionEvent actionEvent) {

    Navigator.visScene(borderPane, Navigator.getSkademeldingerScene());
  }
}
