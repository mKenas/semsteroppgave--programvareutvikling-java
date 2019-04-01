package programutvikling.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Navigator {


  private final String DASHBORD_SCENE;
  private final String FORSIKRING_SCENE;
  private final String KUNDER_SCENE;

  public Navigator() throws IOException {
    this.DASHBORD_SCENE = "/programutvikling/views/dashbord.fxml";
    this.FORSIKRING_SCENE = "/programutvikling/views/forsikringer.fxml";
    this.KUNDER_SCENE = "/programutvikling/views/kunderScene.fxml";
  }


  public String hentDashbordScene() {
    return DASHBORD_SCENE;
  }

  public String hentForsikringScene() {
    return FORSIKRING_SCENE;
  }

  public String hentKunderScene() {
    return KUNDER_SCENE;
  }


  public static void visScene(BorderPane borderPane, String fxml) {

    Parent root = null;

    try {
      root = FXMLLoader.load(Navigator.class.getResource(fxml));

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }


}
