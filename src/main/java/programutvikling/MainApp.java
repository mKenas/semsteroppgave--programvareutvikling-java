package programutvikling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    //Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
    Parent root = FXMLLoader.load(getClass().getResource("views/hovedScene.fxml"));

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("styles/styles.css").toExternalForm());


    stage.setMinHeight(800);
    stage.setMinWidth(1150);

    stage.setTitle("Expert forsikring");
    stage.setScene(scene);
    stage.show();


  }

}
