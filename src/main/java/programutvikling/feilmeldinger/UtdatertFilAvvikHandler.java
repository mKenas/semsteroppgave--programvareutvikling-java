package programutvikling.feilmeldinger;

import javafx.scene.control.Alert;

import java.io.InvalidClassException;

public class UtdatertFilAvvikHandler {


  public static void genererUtdatertFilAvvikMelding(InvalidClassException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Utdatert fil");
    alert.setHeaderText("Utdatert fil");
    alert.setContentText("Feil oppstod i lesing av JOBJ fil. \nMelding: " + e.getMessage());

    alert.showAndWait();
  }


}
