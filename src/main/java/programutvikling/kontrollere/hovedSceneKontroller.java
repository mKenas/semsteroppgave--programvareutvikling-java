package programutvikling.kontrollere;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.filhantering.SkrivingTilFil.CSVFormatSkriver;
import programutvikling.filhantering.SkrivingTilFil.FilSkriver;
import programutvikling.filhantering.innlesingFraFil.LesingTradObjekt;
import programutvikling.feilmeldinger.FileExceptionHandler;
import programutvikling.kontrollere.uihjelpere.FilVelger;
import programutvikling.status.InnlesingOgSkrivingStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hovedSceneKontroller {


  private static final long serialVersionUID = 5;
  @FXML
  protected Button mainSceneKnapp;
  @FXML
  protected BorderPane borderPane;
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  Task<HashMap<String, Object>> leseFilHandling;


  private HashMap<String,Object> allData,allDataFraFil;


  public void initialize() {

    hsk.setBorderPane(borderPane);
    Platform.runLater(() -> mainSceneKnapp.requestFocus());

    Navigator.visScene(borderPane, Navigator.getDashbordScene());
    mainSceneKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingAktiv());


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
  protected void handleNavigeringTilSkaderScene() {


    Navigator.visScene(borderPane, Navigator.getSKADER_SCENE());

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

    try {

      ObjektFilSkriver.write(allData, "");
      //ObjektFilSkriver.write(kunderliste, DATA_FIL_LOKASJON);
      System.out.println("Data er lagret");
    } catch (IOException e) {

      FileExceptionHandler.generateIOExceptionMsg(e);

    }


  }


  @FXML
  protected void handleApneKnapp() {

    FilVelger filVelger = new FilVelger();
    if (filVelger.getValgtFilEndelse() == "*.jobj") {

      ExecutorService service = Executors.newSingleThreadExecutor();

      leseFilHandling = new LesingTradObjekt(filVelger.getFilsti(),this::deaktiverDataEndring ,this::oppdatereGuiMedDataLastetFraFil);
      leseFilHandling.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
        @Override
        public void handle(WorkerStateEvent t) {
          allDataFraFil = leseFilHandling.getValue();
        }
      });
      service.execute(leseFilHandling);
    }




  }

  private void deaktiverDataEndring() {

//oppdatere GUIet etter at tråden er ferdig kjørt.
 //mainSceneKnapp.setDisable(true);
    InnlesingOgSkrivingStatus.erInnlesingAktiv().set(true);

  }


  private void oppdatereGuiMedDataLastetFraFil() {

//oppdatere GUIet etter at tråden er ferdig kjørt.
      System.out.println("Ferdig med å laste fra fil");

      dlo.setAllData(allDataFraFil);
    //mainSceneKnapp.setDisable(false);
    InnlesingOgSkrivingStatus.erInnlesingAktiv().set(false);

  }


  @FXML
  protected void handleAvsluttKnapp() {

    Platform.exit();
 /*   Kunde k = new Kunde("asd","asd","","","","","","");
    dhl.getKundeListeHandling().leggTilKunde(k);
    for (int i=0; i<10000; i++){
      dhl.getKundeMedForsikringListeHandling().leggTilForsikring( new HusOgInnboForsikring(0.0,0.0,"a","a","a","a","","","","","")
              ,k);
      dhl.getKundeMedSkademeldingListeHandling().leggTilSkademelding(new Skademelding("a","s","ssss","sss",0.0,0.0,"",""),k);
    }
*/
  }


}
