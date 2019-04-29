package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Navigator;
import programutvikling.status.InnlesingOgSkrivingStatus;


public class DashbordKontroller {

  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  @FXML
  JFXButton registrerKundeKnapp;


  public void initialize() {

    registrerKundeKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingAktiv());
  }


  @FXML
  protected void NavigeringTilRegistrerKundeScene() {

    Navigator.visScene(borderPane, Navigator.getRegistrerKundeScene());

  }

  @FXML
  protected void NavigeringTilKunderScene() {

    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }

}

