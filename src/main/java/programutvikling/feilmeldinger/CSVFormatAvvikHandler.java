package programutvikling.feilmeldinger;

import javafx.scene.control.Alert;

public class CSVFormatAvvikHandler extends Exception{


  public CSVFormatAvvikHandler(String message) {
    super(message);
  }

  public static void generateCSVFormatExceptionMsg(CSVFormatAvvikHandler e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Ugyldig CSV fil ");
    alert.setHeaderText("Ugyldig CSV fil");
    alert.setContentText("Feil oppstod i lesing av CSV fil. \nMelding: " + e.getMessage());

    alert.showAndWait();
  }



}
