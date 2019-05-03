package programutvikling.kontrollere;

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


  private Kunde kunde;
  private Forsikring forsikring;


  public void initialize() {


    Validator.validerFraTekstfelt(forsikringsBelopTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.validerFraTekstfelt(forsikringsPremieTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.validerFraTekstfelt(batensEierTekstfelt, BatforsikringValidator.getUgyldigEierRegex(), BatforsikringValidator.getUgyldigEierFeilmelding());
    Validator.validerFraTekstfelt(batensRegistreringsNummerTekstfelt, BatforsikringValidator.getUgyldigRegistreringsnummerRegex(), BatforsikringValidator.getUgyldigRegistreringsnummerFeilmelding());
    Validator.validerFraTekstfelt(batTypeTekstfelt, BatforsikringValidator.getUgyldigBattypeRegex(), BatforsikringValidator.getUgyldigBattypeFeilmelding());
    Validator.validerFraTekstfelt(batModellTekstfelt, BatforsikringValidator.getUgyldigBatmodellRegex(), BatforsikringValidator.getUgyldigBatmodellFeilmelding());
    Validator.validerFraTekstfelt(batLengdeTekstfelt, BatforsikringValidator.getUgyldigBatlengdeRegex(), BatforsikringValidator.getUgyldigBatlengdeFeilmelding());
    Validator.validerFraTekstfelt(batensAarsModellTekstfelt, BatforsikringValidator.getUgyldigArsmodellRegex(), BatforsikringValidator.getUgyldigArsmodellFeilmelding());
    Validator.validerFraTekstfelt(batensMotortypeTekstfelt, BatforsikringValidator.getUgyldigMotorTypeRegex(), BatforsikringValidator.getUgyldigMotorTypeFeilmelding());
    Validator.validerFraTekstfelt(batensMotorstyrkeTekstfelt, BatforsikringValidator.getUgyldigMotorStyrkeRegex(), BatforsikringValidator.getUgyldigMotorStyrkeFeilmelding());


  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());

  }

  @FXML
  public void handleOpprettBatForsikringKnapp() {


    if (forsikringsBelopTekstfelt.validate() == true &&
            forsikringsPremieTekstfelt.validate() == true &&
            batensEierTekstfelt.validate() == true &&
            batensRegistreringsNummerTekstfelt.validate() == true &&
            batTypeTekstfelt.validate() == true &&
            batModellTekstfelt.validate() == true &&
            batLengdeTekstfelt.validate() == true &&
            batensAarsModellTekstfelt.validate() == true &&
            batensMotortypeTekstfelt.validate() == true &&
            batensMotorstyrkeTekstfelt.validate() == true) {

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
  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }

}
