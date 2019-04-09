package programutvikling.kontrollere;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataSourceObject;
import programutvikling.kontrollere.uihelpers.FileExceptionHandler;

import java.io.IOException;

public class hovedSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON="";
  @FXML
  protected Button mainSceneKnapp;
  @FXML
  protected BorderPane borderPane;
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  //private Kunde kunde;
  DataSourceObject dso = DataSourceObject.getInstance();
  private ObservableList<Kunde> kunderliste, kunderlisteFraFil;

  public void initialize() {
    kunderliste = dso.getKunder();

    hsk.setBorderPane(borderPane);
    Platform.runLater(() -> mainSceneKnapp.requestFocus());

    try {
      Navigator.visScene(borderPane, new Navigator().getDashbordScene());
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  @FXML
  protected void handleNavigeringTilDashbord() {


    try {
      Navigator.visScene(borderPane, new Navigator().getDashbordScene());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleNavigeringTilForsikringerScene() {


    try {
      Navigator.visScene(borderPane, new Navigator().getForsikringScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleNavigeringTilKunderScene() {


    try {
      Navigator.visScene(borderPane, new Navigator().getKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleNavigeringTilSkaderScene() {


    try {
      Navigator.visScene(borderPane, new Navigator().getSKADER_SCENE());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleNavigeringTilErstatningerScene() {


    try {
      Navigator.visScene(borderPane, new Navigator().getERSTATNINGER_SCENE());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleLagreKnapp() {


    try {
      ObjektFilSkriver.write(kunderliste, KUNDE_FIL_LOKASJON);
      System.out.println("Kundene lagret");
    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    }


  }


  @FXML
  protected void handleApneKnapp() {


    try {


      kunderlisteFraFil = ObjektFilLeser.read(KUNDE_FIL_LOKASJON);


      dso.nullstillKunder();
      dso.getKunder().addAll(kunderlisteFraFil);


    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }




  @FXML
  protected void handleAvsluttKnapp() {

    Platform.exit();
  }


}
