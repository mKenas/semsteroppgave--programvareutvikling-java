package programutvikling.kontrollere.feilmeldinger;

import javafx.scene.control.Alert;


public class KundeEksistererExceptionHandler {

  public static void genererKundeEksistererExceptionMsg() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Duplikat feil");
    alert.setHeaderText("Personnummer er allerede registrert");
    alert.setContentText("Feil oppstod i oppretting av kunde.");

    alert.showAndWait();
  }
}
