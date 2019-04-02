package programutvikling.kontrollere;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Navigator;

import java.io.IOException;

public class hovedSceneKontroller {

  KunderSceneKontroller ksc = new KunderSceneKontroller();

  public void initialize() {


    Platform.runLater(() -> mainSceneKnapp.requestFocus());

  }

  @FXML
  protected Button mainSceneKnapp;
  @FXML
  BorderPane borderPane;

  @FXML
  protected void handleNavigeringTilDashbord() {


    try {
      Navigator.visScene(borderPane, new Navigator().hentDashbordScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleNavigeringTilForsikringerScene() {


    try {
      Navigator.visScene(borderPane, new Navigator().hentForsikringScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  protected void handleNavigeringTilKunderScene() {


    try {
      Navigator.visScene(borderPane, new Navigator().hentKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

@FXML
  protected void handleLagreKnapp(){

  ksc.lagreKunde();
}


  @FXML
  protected void handApneKnapp(){

    ksc.lasteKunde();
  }


}
