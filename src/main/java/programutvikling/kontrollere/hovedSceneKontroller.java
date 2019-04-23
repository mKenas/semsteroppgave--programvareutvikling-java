package programutvikling.kontrollere;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.feilmeldinger.FileExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class hovedSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  private static final long serialVersionUID = 5;
  @FXML
  protected Button mainSceneKnapp;
  @FXML
  protected BorderPane borderPane;
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  //private Kunde kunde;
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  private ObservableList<Kunde> kunderliste, kunderlisteFraFil;
  private ObservableList<Forsikring> forsikringliste;
  private HashMap<String,Object> allData,allDataFraFil;


  public void initialize() {
  /*    kunderliste = dlo.getKundeListe();
    forsikringliste = dlo.getForsikringListe();*/


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

      ObjektFilSkriver.write(allData, KUNDE_FIL_LOKASJON);
      //ObjektFilSkriver.write(kunderliste, KUNDE_FIL_LOKASJON);
      System.out.println("Kundene lagret");
    } catch (IOException e) {

      FileExceptionHandler.generateIOExceptionMsg(e);

    }


  }


  @FXML
  protected void handleApneKnapp() {


    try {

      allDataFraFil = ObjektFilLeser.read(KUNDE_FIL_LOKASJON);

     dlo.setAllData(allDataFraFil);





     // System.out.println("fra fil; " + allDataFraFil);




    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

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
