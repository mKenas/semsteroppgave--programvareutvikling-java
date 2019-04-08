package programutvikling.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import programutvikling.kontrollere.RedigerKundeSceneKontroller;

import java.io.IOException;

public class Navigator {


  private final String DASHBORD_SCENE;
  private final String FORSIKRING_SCENE;
  private final String KUNDER_SCENE;
  private final String REGISTRER_KUNDE_SCENE;
  private final String REDIGER_KUNDE_SCENE;
  private final String ERSTATNINGER_SCENE;
  private final String SKADER_SCENE;
  private final String VIS_KUNDE_SCENE;

  public Navigator() throws IOException {
    this.DASHBORD_SCENE = "/programutvikling/views/dashbordScene.fxml";
    this.FORSIKRING_SCENE = "/programutvikling/views/forsikringer.fxml";
    this.KUNDER_SCENE = "/programutvikling/views/kunderScene.fxml";
    this.REGISTRER_KUNDE_SCENE = "/programutvikling/views/registrerKundeScene.fxml";
    this.REDIGER_KUNDE_SCENE = "/programutvikling/views/redigerKundeScene.fxml";
    this.ERSTATNINGER_SCENE = "/programutvikling/views/erstatningerScene.fxml";
    this.SKADER_SCENE = "/programutvikling/views/skaderScene.fxml";
    this.VIS_KUNDE_SCENE = "/programutvikling/views/visKundeScene.fxml";
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

  public static void visSceneMedKundeInfo(BorderPane borderPane, String fxml, Kunde kunde) {

    Parent root = null;

    try {
      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
      root = loader.load();
      RedigerKundeSceneKontroller rkk = loader.getController();
      rkk.setKunde(kunde);

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }

  public String getDashbordScene() {
    return DASHBORD_SCENE;
  }

  public String getForsikringScene() {
    return FORSIKRING_SCENE;
  }

  public String getKunderScene() {
    return KUNDER_SCENE;
  }

  public String getRegistrerKundeScene() {
    return REGISTRER_KUNDE_SCENE;
  }

  public String getREDIGER_KUNDE_SCENE() {
    return REDIGER_KUNDE_SCENE;
  }

  public String getERSTATNINGER_SCENE() {
    return ERSTATNINGER_SCENE;
  }

  public String getSKADER_SCENE() {
    return SKADER_SCENE;
  }

  public String getVIS_KUNDE_SCENE() {
    return VIS_KUNDE_SCENE;
  }
}


