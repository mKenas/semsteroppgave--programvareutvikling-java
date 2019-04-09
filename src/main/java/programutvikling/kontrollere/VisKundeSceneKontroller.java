package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class VisKundeSceneKontroller implements KontrollerMedData {

  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde = null;

  @FXML
  private Label kundeNrLabel;
  @FXML
  private Label navnLabel;
  @FXML
  private Label etternavnLabel;
  @FXML
  private Label epostLabel;
  @FXML
  private Label mobilLabel;
  @FXML
  private Label fakturaadresseLabel;
  @FXML
  private Label postnummerLabel;
  @FXML
  private Label poststedLabel;
  @FXML
  private Label opprettelsesdatoLabel;



  public void initialize() {


  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    kundeNrLabel.setText(k.getKundeNr());
    navnLabel.setText(k.getNavn());
    etternavnLabel.setText(k.getEtternavn());
    epostLabel.setText(k.getEpost());
    mobilLabel.setText(k.getMobil());
    fakturaadresseLabel.setText(k.getFakturaAdresse());
    postnummerLabel.setText(k.getPostnummer());
    poststedLabel.setText(k.getPoststed());
    opprettelsesdatoLabel.setText(k.getOpprettelsesDato());


    System.out.println(k.getOpprettelsesDato());
  }

  @FXML
  public void handleRedigerKundeKnapp() {

    NavigeringTilRegistrerKundeScene();
  }


  protected void NavigeringTilRegistrerKundeScene() {
    kunde.setKundeNr(kundeNrLabel.getText());
    kunde.setNavn(navnLabel.getText());
    kunde.setEtternavn(etternavnLabel.getText());
    kunde.setEpost(epostLabel.getText());
    kunde.setMobil(mobilLabel.getText());
    kunde.setFakturaAdresse(fakturaadresseLabel.getText());
    kunde.setPostnummer(postnummerLabel.getText());
    kunde.setPoststed(poststedLabel.getText());


    try {
      Navigator.visScene(borderPane, new Navigator().getKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
