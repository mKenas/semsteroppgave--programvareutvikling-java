package programutvikling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainApp extends Application {


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    //Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

      Font.loadFont(MainApp.class.getResource("fonts/Font-Awesome-5-Free-Regular-400.otf").toExternalForm(), 10);
      Font.loadFont(MainApp.class.getResource("fonts/Font-Awesome-5-Free-Solid-900.otf").toExternalForm(), 10);

    Parent root = FXMLLoader.load(getClass().getResource("views/hovedScene.fxml"));

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("styles/styles.css").toExternalForm());


    //stage.setMinHeight(800);
    //stage.setMinWidth(1150);

    stage.setTitle("Expert forsikring");
    stage.setScene(scene);
    stage.show();


  }

}
