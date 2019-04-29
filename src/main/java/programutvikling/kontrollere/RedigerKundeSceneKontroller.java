package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataLagringObjekt;

public class RedigerKundeSceneKontroller implements KontrollerMedKundeInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde = null;

  @FXML
  private TextField personNrTekstFelt;
  @FXML
  private TextField navnTekstFelt;
  @FXML
  private TextField etternavnTekstFelt;
  @FXML
  private TextField epostTekstFelt;
  @FXML
  private TextField mobilTekstFelt;
  @FXML
  private TextField fakturaadresseTekstFelt;
  @FXML
  private TextField postnummerTekstFelt;
  @FXML
  private TextField poststedTekstFelt;


  public void initialize() {


  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    personNrTekstFelt.setText(k.getPersonNr());
    navnTekstFelt.setText(k.getNavn());
    etternavnTekstFelt.setText(k.getEtternavn());
    epostTekstFelt.setText(k.getEpost());
    mobilTekstFelt.setText(k.getMobil());
    fakturaadresseTekstFelt.setText(k.getFakturaAdresse());
    postnummerTekstFelt.setText(k.getPostNr());
    poststedTekstFelt.setText(k.getPoststed());


  }

  @FXML
  public void handleRedigerKundeKnapp() {

    NavigeringTilRedigerKundeScene();
  }


  protected void NavigeringTilRedigerKundeScene() {

    kunde.setPersonNr(personNrTekstFelt.getText());
    kunde.setNavn(navnTekstFelt.getText());
    kunde.setEtternavn(etternavnTekstFelt.getText());
    kunde.setEpost(epostTekstFelt.getText());
    kunde.setMobil(mobilTekstFelt.getText());
    kunde.setFakturaAdresse(fakturaadresseTekstFelt.getText());
    kunde.setPostNr(postnummerTekstFelt.getText());
    kunde.setPoststed(poststedTekstFelt.getText());


    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }
}
