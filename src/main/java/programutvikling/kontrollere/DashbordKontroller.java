package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Navigator;


public class DashbordKontroller {

  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();


  public void initialize() {


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

