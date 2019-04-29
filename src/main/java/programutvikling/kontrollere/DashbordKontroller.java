package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Navigator;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.InnlesingOgSkrivingStatus;


public class DashbordKontroller {

  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  @FXML
  JFXButton registrerKundeKnapp;


  public void initialize() {

    registrerKundeKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());
  }


  @FXML
  protected void handlNavigeringTilRegistrerKundeScene() {

    Navigator.visScene(borderPane, Navigator.getRegistrerKundeScene());

  }

  @FXML
  protected void handlNavigeringTilKunderScene() {

    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }

  @FXML
  protected void handleNavigeringTilForsikringerScene(ActionEvent actionEvent) {

    Navigator.visScene(borderPane, Navigator.getForsikringListeScene());
  }


  @FXML
  protected void handleNavigeringTilSkademeldingerScene(ActionEvent actionEvent) {

    Navigator.visScene(borderPane, Navigator.getSkademeldingerScene());
  }
}

