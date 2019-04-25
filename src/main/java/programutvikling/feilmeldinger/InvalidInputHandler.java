package programutvikling.feilmeldinger;

import javafx.scene.control.Alert;

public class InvalidInputHandler {

  public static void generateAlert(String msg) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Feil persondata");
    alert.setHeaderText("Feil persondata");
    alert.setContentText(msg);

    alert.showAndWait();
  }

}
