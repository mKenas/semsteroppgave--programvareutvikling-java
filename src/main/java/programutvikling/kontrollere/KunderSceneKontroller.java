package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import programutvikling.base.Kunde;

public class KunderSceneKontroller {

  private Kunde kunde;

  @FXML
  private Label lblNavn;

  public void initialize() {

    kunde = new Kunde("Mohamad", "Oslo");


    kunde.observe(this::kundeEndret);
    kundeEndret();
    kunde.setNavn("Emre");
  }

  private void kundeEndret() {
    lblNavn.setText(kunde.hentNavn());

  }


}
