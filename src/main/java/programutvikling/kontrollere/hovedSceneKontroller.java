package programutvikling.kontrollere;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataSourceObject;
import programutvikling.kontrollere.feilmeldinger.FileExceptionHandler;

import java.io.IOException;

public class hovedSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  private static final long serialVersionUID = 5;
  @FXML
  protected Button mainSceneKnapp;
  @FXML
  protected BorderPane borderPane;
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  //private Kunde kunde;
  DataSourceObject dso = DataSourceObject.getInstance();
  private ObservableList<Kunde> kunderliste, kunderlisteFraFil;

  public void initialize() {
    kunderliste = dso.getKunderListe().getKunder();

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


    Navigator.visScene(borderPane, Navigator.getForsikringScene());

  }

  @FXML
  protected void handleNavigeringTilKunderScene() {


    Navigator.visScene(borderPane, Navigator.getKunderScene());

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
  protected void handleLagreKnapp() {

    System.out.println(kunderliste);
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

      System.out.println("fra fil; " + kunderlisteFraFil);
      dso.getKunderListe().nullstillKunderListe();
      dso.getKunderListe().getKunder().addAll(kunderlisteFraFil);


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
