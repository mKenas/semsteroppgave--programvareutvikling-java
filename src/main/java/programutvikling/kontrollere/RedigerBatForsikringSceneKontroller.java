package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.BatForsikring;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.BatValideringStatus;
import programutvikling.validering.BatforsikringValidator;
import programutvikling.validering.ReiseforsikringValidator;
import programutvikling.validering.Validator;

public class RedigerBatForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  @FXML
  JFXTextField forsikringsBelopTekstfelt;
  @FXML
  JFXTextField forsikringsPremieTekstfelt;
  @FXML
  JFXTextField batensEierTekstfelt;
  @FXML
  JFXTextField batensRegistreringsNummerTekstfelt;
  @FXML
  JFXTextField batTypeTekstfelt;
  @FXML
  JFXTextField batModellTekstfelt;
  @FXML
  JFXTextField batLengdeTekstfelt;
  @FXML
  JFXTextField batensAarsModellTekstfelt;
  @FXML
  JFXTextField batensMotortypeTekstfelt;
  @FXML
  JFXTextField batensMotorstyrkeTekstfelt;
  DataHandlingObjekt dho = new DataHandlingObjekt();
  @FXML
  private TextField personNrTekstfelt;
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde;
  private BatForsikring forsikring;
  @FXML
  private JFXButton lagreForsikringKnapp;


  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof BatForsikring) {
      BatForsikring f = (BatForsikring) forsikring;

      this.forsikring = f;

      forsikringsBelopTekstfelt.setText(String.valueOf(f.getForsikringsbelop()));
      forsikringsPremieTekstfelt.setText(String.valueOf(f.getForsikringspremie()));
      batensEierTekstfelt.setText(f.getEier());
      batensRegistreringsNummerTekstfelt.setText(f.getRegistreringsNr());
      batTypeTekstfelt.setText(f.getBatType());
      batModellTekstfelt.setText(f.getBatModell());
      batLengdeTekstfelt.setText(f.getBatLengde());
      batensAarsModellTekstfelt.setText(f.getArsModell());
      batensMotortypeTekstfelt.setText(f.getMotorType());
      batensMotorstyrkeTekstfelt.setText(f.getMotorStyrke());


      validerFeltVedInnlastingAvScene();
    }
  }



  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());

  }

  @FXML
  public void handleLagreBatForsikringKnapp() {

    Double forsikringsBelop = Double.valueOf(forsikringsBelopTekstfelt.getText());
    Double forsikringsPremie = Double.valueOf(forsikringsPremieTekstfelt.getText());
    String forsikringsBetingelser = "";
    String batensEier = batensEierTekstfelt.getText();
    String batensRegistreringsnummer = batensRegistreringsNummerTekstfelt.getText();
    String batType = batTypeTekstfelt.getText();
    String batModell = batModellTekstfelt.getText();
    String batensLengde = batLengdeTekstfelt.getText();
    String batensAarsModell = batensAarsModellTekstfelt.getText();
    String batensMotortype = batensMotortypeTekstfelt.getText();
    String batensMotorstyrke = batensMotorstyrkeTekstfelt.getText();




      forsikring.setForsikringsbelop(forsikringsBelop);
      forsikring.setForsikringspremie(forsikringsPremie);
      forsikring.setEier(batensEier);
      forsikring.setRegistreringsNr(batensRegistreringsnummer);
      forsikring.setBatType(batType);
      forsikring.setBatModell(batModell);
      forsikring.setBatLengde(batensLengde);
      forsikring.setArsModell(batensAarsModell);
      forsikring.setMotorType(batensMotortype);
      forsikring.setMotorStyrke(batensMotorstyrke);

      NavigeringTilVisKundeScene();

  }


  public void initialize() {

    valideBatForsikringFelt();
  }


  private void valideBatForsikringFelt() {

    nullstillValideringStatus();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    lagreForsikringKnapp.disableProperty().bind(
            BatValideringStatus.erForsikrinsBelopGyldig().not()
                    .or(BatValideringStatus.erForsikrinspremieGyldig().not())
                    .or(BatValideringStatus.erEierGyldig().not())
                    .or(BatValideringStatus.erRegistreringsNrGyldig().not())
                    .or(BatValideringStatus.erBattypeGyldig().not())
                    .or(BatValideringStatus.erBatmodellGyldig().not())
                    .or(BatValideringStatus.erBatlengdeGyldig().not())
                    .or(BatValideringStatus.erArsmodellGyldig().not())
                    .or(BatValideringStatus.erMotorTypeGyldig().not())
                    .or(BatValideringStatus.erMotorStyrkeGyldig().not())

    );
  }

  private void validerFeltVedEndringAvInnputt() {
    Validator.valider(BatValideringStatus.erForsikrinsBelopGyldig(), forsikringsBelopTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.valider(BatValideringStatus.erForsikrinspremieGyldig(), forsikringsPremieTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.valider(BatValideringStatus.erEierGyldig(), batensEierTekstfelt, BatforsikringValidator.getUgyldigEierRegex(), BatforsikringValidator.getUgyldigEierFeilmelding());
    Validator.valider(BatValideringStatus.erRegistreringsNrGyldig(), batensRegistreringsNummerTekstfelt, BatforsikringValidator.getUgyldigRegistreringsnummerRegex(), BatforsikringValidator.getUgyldigRegistreringsnummerFeilmelding());
    Validator.valider(BatValideringStatus.erBattypeGyldig(), batTypeTekstfelt, BatforsikringValidator.getUgyldigBattypeRegex(), BatforsikringValidator.getUgyldigBattypeFeilmelding());
    Validator.valider(BatValideringStatus.erBatmodellGyldig(), batModellTekstfelt, BatforsikringValidator.getUgyldigBatmodellRegex(), BatforsikringValidator.getUgyldigBatmodellFeilmelding());
    Validator.valider(BatValideringStatus.erBatlengdeGyldig(), batLengdeTekstfelt, BatforsikringValidator.getUgyldigBatlengdeRegex(), BatforsikringValidator.getUgyldigBatlengdeFeilmelding());
    Validator.valider(BatValideringStatus.erArsmodellGyldig(), batensAarsModellTekstfelt, BatforsikringValidator.getUgyldigArsmodellRegex(), BatforsikringValidator.getUgyldigArsmodellFeilmelding());
    Validator.valider(BatValideringStatus.erMotorTypeGyldig(), batensMotortypeTekstfelt, BatforsikringValidator.getUgyldigMotorTypeRegex(), BatforsikringValidator.getUgyldigMotorTypeFeilmelding());
    Validator.valider(BatValideringStatus.erMotorStyrkeGyldig(), batensMotorstyrkeTekstfelt, BatforsikringValidator.getUgyldigMotorStyrkeRegex(), BatforsikringValidator.getUgyldigMotorStyrkeFeilmelding());


  }

  private void validerFeltVedInnlastingAvScene() {
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erForsikrinsBelopGyldig(), forsikringsBelopTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erForsikrinspremieGyldig(), forsikringsPremieTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erEierGyldig(), batensEierTekstfelt, BatforsikringValidator.getUgyldigEierRegex(), BatforsikringValidator.getUgyldigEierFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erRegistreringsNrGyldig(), batensRegistreringsNummerTekstfelt, BatforsikringValidator.getUgyldigRegistreringsnummerRegex(), BatforsikringValidator.getUgyldigRegistreringsnummerFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erBattypeGyldig(), batTypeTekstfelt, BatforsikringValidator.getUgyldigBattypeRegex(), BatforsikringValidator.getUgyldigBattypeFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erBatmodellGyldig(), batModellTekstfelt, BatforsikringValidator.getUgyldigBatmodellRegex(), BatforsikringValidator.getUgyldigBatmodellFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erBatlengdeGyldig(), batLengdeTekstfelt, BatforsikringValidator.getUgyldigBatlengdeRegex(), BatforsikringValidator.getUgyldigBatlengdeFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erArsmodellGyldig(), batensAarsModellTekstfelt, BatforsikringValidator.getUgyldigArsmodellRegex(), BatforsikringValidator.getUgyldigArsmodellFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erMotorTypeGyldig(), batensMotortypeTekstfelt, BatforsikringValidator.getUgyldigMotorTypeRegex(), BatforsikringValidator.getUgyldigMotorTypeFeilmelding());
    Validator.validerVedInnlasstingAvScene(BatValideringStatus.erMotorStyrkeGyldig(), batensMotorstyrkeTekstfelt, BatforsikringValidator.getUgyldigMotorStyrkeRegex(), BatforsikringValidator.getUgyldigMotorStyrkeFeilmelding());


  }


  private void nullstillValideringStatus() {

    BatValideringStatus.nullstillValideringStatus();
  }




  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


}
