package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.KundeValideringStatus;
import programutvikling.validering.KundeValidator;
import programutvikling.validering.Validator;

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

  @FXML
  private JFXButton redigerKnapp;


  public void initialize() {

    validerKundeFelt();
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
    validerKundeFeltVedInnlastingAvScene();


  }

  @FXML
  public void handleRedigerKundeKnapp() {

    NavigeringTilRedigerKundeScene();
  }


  private void validerKundeFelt() {

    nullstillValideringStatus();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }


  private void validerKundeFeltVedInnlastingAvScene() {

    nullstillValideringStatus();

    validerFeltVedInnlastingAvScene();
    validerFeltVedEndringAvInnputt();

    bindeKanppAkriveringTilValideringStatus();

  }

  private void validerFeltVedInnlastingAvScene() {
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erPersonNrGyldig(), personNrTekstFelt, KundeValidator.getUgyldigPersonnummerRegex(), KundeValidator.getUgyldigPersonnummerFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erNavnGyldig(), navnTekstFelt, KundeValidator.getUgyldigNavnRegex(), KundeValidator.getUgyldigNavnFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erEtternavnGyldig(), etternavnTekstFelt, KundeValidator.getUgyldigEtternavnRegex(), KundeValidator.getUgyldigEtternavnFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erAdresseGyldig(), fakturaadresseTekstFelt, KundeValidator.getUgyldigFakturaAdresseRegex(), KundeValidator.getUgyldigFakturaAdresseFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erPostNrGyldig(), postnummerTekstFelt, KundeValidator.getUgyldigPostnummerRegex(), KundeValidator.getUgyldigPostnummerFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erPoststedGyldig(), poststedTekstFelt, KundeValidator.getUgyldigPoststedRegex(), KundeValidator.getUgyldigPoststedFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erEpostGyldig(), epostTekstFelt, KundeValidator.getUgyldigEpostRegex(), KundeValidator.getUgyldigEpostFeilmelding());
    Validator.validerVedInnlasstingAvScene(KundeValideringStatus.erMobilGyldig(), mobilTekstFelt, KundeValidator.getUgyldigMobilRegex(), KundeValidator.getUgyldigMobilFeilmelding());


  }

  private void bindeKanppAkriveringTilValideringStatus() {
    redigerKnapp.disableProperty().bind(
            KundeValideringStatus.erPersonNrGyldig().not()
                    .or(KundeValideringStatus.erNavnGyldig().not())
                    .or(KundeValideringStatus.erEtternavnGyldig().not())
                    .or(KundeValideringStatus.erAdresseGyldig().not())
                    .or(KundeValideringStatus.erPostNrGyldig().not())
                    .or(KundeValideringStatus.erPoststedGyldig().not())
                    .or(KundeValideringStatus.erEpostGyldig().not())
                    .or(KundeValideringStatus.erMobilGyldig().not())

    );
  }

  private void validerFeltVedEndringAvInnputt() {

    Validator.valider(KundeValideringStatus.erPersonNrGyldig(), personNrTekstFelt, KundeValidator.getUgyldigPersonnummerRegex(), KundeValidator.getUgyldigPersonnummerFeilmelding());
    Validator.valider(KundeValideringStatus.erNavnGyldig(), navnTekstFelt, KundeValidator.getUgyldigNavnRegex(), KundeValidator.getUgyldigNavnFeilmelding());
    Validator.valider(KundeValideringStatus.erEtternavnGyldig(), etternavnTekstFelt, KundeValidator.getUgyldigEtternavnRegex(), KundeValidator.getUgyldigEtternavnFeilmelding());
    Validator.valider(KundeValideringStatus.erAdresseGyldig(), fakturaadresseTekstFelt, KundeValidator.getUgyldigFakturaAdresseRegex(), KundeValidator.getUgyldigFakturaAdresseFeilmelding());
    Validator.valider(KundeValideringStatus.erPostNrGyldig(), postnummerTekstFelt, KundeValidator.getUgyldigPostnummerRegex(), KundeValidator.getUgyldigPostnummerFeilmelding());
    Validator.valider(KundeValideringStatus.erPoststedGyldig(), poststedTekstFelt, KundeValidator.getUgyldigPoststedRegex(), KundeValidator.getUgyldigPoststedFeilmelding());
    Validator.valider(KundeValideringStatus.erEpostGyldig(), epostTekstFelt, KundeValidator.getUgyldigEpostRegex(), KundeValidator.getUgyldigEpostFeilmelding());
    Validator.valider(KundeValideringStatus.erMobilGyldig(), mobilTekstFelt, KundeValidator.getUgyldigMobilRegex(), KundeValidator.getUgyldigMobilFeilmelding());

  }


  private void nullstillValideringStatus() {
    KundeValideringStatus.nullstilValideringStatus();

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
