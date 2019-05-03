package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.InnlesingOgSkrivingStatus;
import programutvikling.status.KundeValideringStatus;
import programutvikling.validering.KundeValidator;
import programutvikling.validering.Validator;


public class RegistrerKundeSceneKontroller {


  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  Kunde kunde;
  String forsikringsType;
  private BorderPane borderPane = hsk.getBorderPane();
  @FXML
  private JFXTextField personNrTekstFelt;
  @FXML
  private JFXTextField navnTekstFelt;
  @FXML
  private JFXTextField etternavnTekstFelt;
  @FXML
  private JFXTextField fakturaadresseTekstFelt;
  @FXML
  private JFXTextField postnummerTekstFelt;
  @FXML
  private JFXTextField poststedTekstFelt;
  @FXML
  private JFXTextField epostTekstFelt;
  @FXML
  private JFXTextField mobilTekstFelt;
  @FXML
  private JFXComboBox forsikringsTypeKomboBoks;
  @FXML
  private JFXButton registrerKundeKnapp;

  @FXML
  private void handleRegistrerKundeKnapp() {


    String personNr = personNrTekstFelt.getText();
    String navn = navnTekstFelt.getText();
    String etternavn = etternavnTekstFelt.getText();
    String fakturaadresse = fakturaadresseTekstFelt.getText();
    String postnummer = postnummerTekstFelt.getText();
    String poststed = poststedTekstFelt.getText();
    String epost = epostTekstFelt.getText();
    String mobil = mobilTekstFelt.getText();

    kunde = new Kunde(personNr, navn, etternavn, epost, mobil, fakturaadresse, postnummer, poststed);
    forsikringsType = forsikringsTypeKomboBoks.getSelectionModel().getSelectedItem().toString();


      dhl.getKundeListeHandling().leggTilKunde(kunde);
      navigeringTilOpprettForsikringScene();

  }

  public void initialize() {


    registrerKundeKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());

    validerKundeFelt();



  }


  private void validerKundeFelt() {

    nullstillValideringStatus();




    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    registrerKundeKnapp.disableProperty().bind(
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

    Validator.valider(KundeValideringStatus.erPersonNrGyldig(),personNrTekstFelt,KundeValidator.getUgyldigPersonnummerRegex(),KundeValidator.getUgyldigPersonnummerFeilmelding());
    Validator.valider(KundeValideringStatus.erNavnGyldig(),navnTekstFelt,KundeValidator.getUgyldigNavnRegex(),KundeValidator.getUgyldigNavnFeilmelding());
    Validator.valider(KundeValideringStatus.erEtternavnGyldig(),etternavnTekstFelt,KundeValidator.getUgyldigEtternavnRegex(),KundeValidator.getUgyldigEtternavnFeilmelding());
    Validator.valider(KundeValideringStatus.erAdresseGyldig(),fakturaadresseTekstFelt,KundeValidator.getUgyldigFakturaAdresseRegex(),KundeValidator.getUgyldigFakturaAdresseFeilmelding());
    Validator.valider(KundeValideringStatus.erPostNrGyldig(),postnummerTekstFelt,KundeValidator.getUgyldigPostnummerRegex(),KundeValidator.getUgyldigPostnummerFeilmelding());
    Validator.valider(KundeValideringStatus.erPoststedGyldig(),poststedTekstFelt,KundeValidator.getUgyldigPoststedRegex(),KundeValidator.getUgyldigPoststedFeilmelding());
    Validator.valider(KundeValideringStatus.erEpostGyldig(),epostTekstFelt,KundeValidator.getUgyldigEpostRegex(),KundeValidator.getUgyldigEpostFeilmelding());
    Validator.valider(KundeValideringStatus.erMobilGyldig(),mobilTekstFelt,KundeValidator.getUgyldigMobilRegex(),KundeValidator.getUgyldigMobilFeilmelding());

  }


  private void nullstillValideringStatus() {

    KundeValideringStatus.nullstilValideringStatus();


  }



  protected void navigeringTilOpprettForsikringScene() {
    System.out.println(forsikringsType);
    Navigator.visOpprettForsikringSceneMedKundeInfo(borderPane, forsikringsType, kunde);

  }
}
