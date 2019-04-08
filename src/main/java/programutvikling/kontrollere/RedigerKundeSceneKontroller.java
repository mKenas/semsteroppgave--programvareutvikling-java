package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class RedigerKundeSceneKontroller {

  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde = null;

  @FXML
  private TextField kundeNrTekstFelt;
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
    kundeNrTekstFelt.setText(k.getKundeNr());
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

    NavigeringTilRegistrerKundeScene();
  }


  protected void NavigeringTilRegistrerKundeScene() {
    kunde.setKundeNr(kundeNrTekstFelt.getText());
    kunde.setNavn(navnTekstFelt.getText());
    kunde.setEtternavn(etternavnTekstFelt.getText());
    kunde.setEpost(epostTekstFelt.getText());
    kunde.setMobil(mobilTekstFelt.getText());
    kunde.setFakturaAdresse(fakturaadresseTekstFelt.getText());
    kunde.setPostnummer(postnummerTekstFelt.getText());
    kunde.setPoststed(poststedTekstFelt.getText());


    try {
      Navigator.visScene(borderPane, new Navigator().getKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
