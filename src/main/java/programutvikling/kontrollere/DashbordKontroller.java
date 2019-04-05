package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Navigator;

import java.io.IOException;


public class DashbordKontroller {

  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();


  public void initialize() {


  }

  @FXML
  protected void handleRegistrerKundeKnapp() {

    this.NavigeringTilRegistrerKundeScene();


  }


  protected void NavigeringTilRegistrerKundeScene() {

    try {
      Navigator.visScene(borderPane, new Navigator().getRegistrerKundeScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


}

