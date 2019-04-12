package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;


public class RegistrerKundeSceneKontroller {

  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  @FXML
  private TextField kundeNrTekstFelt;
  @FXML
  private TextField navnTekstFelt;
  @FXML
  private TextField etternavnTekstFelt;
  @FXML
  private TextField fakturaadresseTekstFelt;
  @FXML
  private TextField postnummerTekstFelt;
  @FXML
  private TextField poststedTekstFelt;
  @FXML
  private TextField epostTekstFelt;
  @FXML
  private TextField mobilTekstFelt;


  @FXML
  private void handleRegistrerKundeKnapp() {
    String kundeNr = kundeNrTekstFelt.getText();
    String navn = navnTekstFelt.getText();
    String etternavn = etternavnTekstFelt.getText();
    String fakturaadresse = fakturaadresseTekstFelt.getText();
    String postnummer = postnummerTekstFelt.getText();
    String poststed = poststedTekstFelt.getText();
    String epost = epostTekstFelt.getText();
    String mobil = mobilTekstFelt.getText();

    Kunde kunde = new Kunde(kundeNr, navn, etternavn, epost, mobil, fakturaadresse, postnummer, poststed);


    dso.getKunderListe().leggTilKunde(kunde);
    navigeringTilKunederScene();


  }

  protected void navigeringTilKunederScene() {

    try {
      Navigator.visScene(borderPane, new Navigator().getKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
