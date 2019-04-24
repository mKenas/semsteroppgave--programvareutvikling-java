package programutvikling.kontrollere;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.feilmeldinger.FileExceptionHandler;
import programutvikling.kontrollere.uihjelpere.FilVelger;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hovedSceneKontroller {

  private static final String DATA_FIL_LOKASJON = "big.jobj";
  private static final long serialVersionUID = 5;
  @FXML
  protected Button mainSceneKnapp;
  @FXML
  protected BorderPane borderPane;
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();


  private HashMap<String,Object> allData,allDataFraFil;


  public void initialize() {

    hsk.setBorderPane(borderPane);
    Platform.runLater(() -> mainSceneKnapp.requestFocus());

    Navigator.visScene(borderPane, Navigator.getDashbordScene());


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

      ObjektFilSkriver.write(allData, DATA_FIL_LOKASJON);
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

      Task<HashMap<String, Object>> task = new LesingTradObjekt(filVelger.getFilsti(), this::oppdatereGuiMedDataLastetFraFil);
      task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
        @Override
        public void handle(WorkerStateEvent t) {
          allDataFraFil = task.getValue();
        }
      });
      service.execute(task);
    }

  }

  private void oppdatereGuiMedDataLastetFraFil() {

//oppdatere GUIet etter at tråden er ferdig kjørt.
      System.out.println("Ferdig med å laste fra fil");

      dlo.setAllData(allDataFraFil);

  }


  @FXML
  protected void handleAvsluttKnapp() {

    Platform.exit();
/*    Kunde k = new Kunde("asd","asd","","","","","","");
    dhl.getKundeListeHandling().leggTilKunde(k);
    for (int i=0; i<10000; i++){
      dhl.getKundeMedForsikringListeHandling().leggTilForsikring( new HusOgInnboForsikring(0.0,0.0,"a","a","a","a","","","","","")
              ,k);
      dhl.getKundeMedSkademeldingListeHandling().leggTilSkademelding(new Skademelding("a","s","ssss","sss",0.0,0.0,"",""),k);
    }*/

  }


}
