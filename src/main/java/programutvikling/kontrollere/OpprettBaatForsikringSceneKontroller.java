package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
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

public class OpprettBaatForsikringSceneKontroller implements KontrollerMedKundeInfo {

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
  @FXML
  private JFXButton opprettForsikringKnapp;


  private Kunde kunde;
  private Forsikring forsikring;



  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());

  }

  @FXML
  public void handleOpprettBatForsikringKnapp() {


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


      forsikring = new BatForsikring(forsikringsBelop, forsikringsPremie, "", batensEier, batensRegistreringsnummer, batType, batModell, batensLengde, batensAarsModell, batensMotortype, batensMotorstyrke);


      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();

  }


  public void initialize() {

    valideBatForsikringFelt();
  }


  private void valideBatForsikringFelt() {

    nullstillValideringStatus();

    validerFeltVedInnlastingAvScene();

    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    opprettForsikringKnapp.disableProperty().bind(
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

  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }

}
