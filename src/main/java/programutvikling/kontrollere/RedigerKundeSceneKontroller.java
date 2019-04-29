package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
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
  private JFXTextField personNrTekstFelt;
  @FXML
  private JFXTextField navnTekstFelt;
  @FXML
  private JFXTextField etternavnTekstFelt;
  @FXML
  private JFXTextField epostTekstFelt;
  @FXML
  private JFXTextField mobilTekstFelt;
  @FXML
  private JFXTextField fakturaadresseTekstFelt;
  @FXML
  private JFXTextField postnummerTekstFelt;
  @FXML
  private JFXTextField poststedTekstFelt;


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
    postnummerTekstFelt.setText(k.getPostnummer());
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
    kunde.setPostnummer(postnummerTekstFelt.getText());
    kunde.setPoststed(poststedTekstFelt.getText());


    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }
}
