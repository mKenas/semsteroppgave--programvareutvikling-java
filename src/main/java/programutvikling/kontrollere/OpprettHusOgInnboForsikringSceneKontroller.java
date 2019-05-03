package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.HusOgInnboForsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.InnboOgfritidValideringStatus;
import programutvikling.validering.InnboOgFritidValidator;
import programutvikling.validering.Validator;

public class OpprettHusOgInnboForsikringSceneKontroller implements KontrollerMedKundeInfo {
  @FXML
  JFXTextField boligensAdresseTekstfelt;
  @FXML
  JFXTextField byggeArTekstfelt;
  @FXML
  JFXTextField boligTypeTekstfelt;
  @FXML
  JFXTextField byggeMaterialeTekstfelt;
  @FXML
  JFXTextField standardTekstfelt;
  @FXML
  JFXTextField antallkvadratmeterTekstfelt;
  @FXML
  JFXTextField bygningForsikringsbelopTekstfelt;
  @FXML
  JFXTextField innboForsikringsbelopTekstfelt;
  @FXML
  JFXTextField forsikringsbelopTekstfelt;
  @FXML
  JFXTextField forsikringspremieTekstfelt;
  @FXML
  private JFXTextField personNrTekstfelt;

  @FXML
  private JFXButton opprettForsikringKnapp;




  DataHandlingObjekt dho = new DataHandlingObjekt();
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();


  private Kunde kunde;
  private Forsikring forsikring;




  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());

  }


  public void handleOpprettHusOgInnboForsikringKnapp() {



    String boligensAdresse = boligensAdresseTekstfelt.getText();
    String byggeAr = byggeArTekstfelt.getText();
    String boligType = boligTypeTekstfelt.getText();
    String byggeMateriale = byggeMaterialeTekstfelt.getText();
    String standard = standardTekstfelt.getText();
    String antallkvadratmeter = antallkvadratmeterTekstfelt.getText();
    String bygningForsikringsbelop = bygningForsikringsbelopTekstfelt.getText();
    String innboForsikringsbelop = innboForsikringsbelopTekstfelt.getText();
    Double forsikringsbelop = Double.valueOf(forsikringsbelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(forsikringspremieTekstfelt.getText());





      forsikring = new HusOgInnboForsikring(forsikringsbelop, forsikringspremie,
              boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);

      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();





  }

  public void initialize() {


    validerHusOgInnboFelt();


  }

  private void validerHusOgInnboFelt() {

    nullstillValideringStatus();


    validerFeltVedInnlastingAvScene();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    opprettForsikringKnapp.disableProperty().bind(
            InnboOgfritidValideringStatus.erAdresseGyldig().not()
            .or(InnboOgfritidValideringStatus.erByggeArGyldig().not())
            .or(InnboOgfritidValideringStatus.erBoligTypeGyldig().not())
            .or(InnboOgfritidValideringStatus.erbyggeMaterialeGyldig().not())
            .or(InnboOgfritidValideringStatus.erBoligStanderGyldig().not())
            .or(InnboOgfritidValideringStatus.erAntallKvadratmeterGyldig().not())
            .or(InnboOgfritidValideringStatus.erByggningsbelopGyldig().not())
            .or(InnboOgfritidValideringStatus.erInnbobelopGyldig().not())
            .or(InnboOgfritidValideringStatus.erforsikringbelopGyldig().not())
            .or((InnboOgfritidValideringStatus.getForsikringspremieGyldig().not()))
            );
  }

  private void validerFeltVedEndringAvInnputt() {
    Validator.valider(InnboOgfritidValideringStatus.erAdresseGyldig(),boligensAdresseTekstfelt,InnboOgFritidValidator.getUgyldigAddresseRegex(),InnboOgFritidValidator.getUgyldigAddresseFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erByggeArGyldig(),byggeArTekstfelt,InnboOgFritidValidator.getUgyldigByggeArRegex(),InnboOgFritidValidator.getUgyldigByggeArFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erBoligTypeGyldig(),boligTypeTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigBoligtypeFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erbyggeMaterialeGyldig(),byggeMaterialeTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigByggematerialeFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erBoligStanderGyldig(),standardTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigBoligstanderFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erAntallKvadratmeterGyldig(),antallkvadratmeterTekstfelt,InnboOgFritidValidator.getUgyldigAntallKvadratmeterRegex(),InnboOgFritidValidator.getUgyldigAntallKvadratmeterFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erByggningsbelopGyldig(),bygningForsikringsbelopTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigByggningsbelopFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erInnbobelopGyldig(),innboForsikringsbelopTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigInnbobelopFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.erforsikringbelopGyldig(),forsikringsbelopTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigForsikringbelopFeilmelding());
    Validator.valider(InnboOgfritidValideringStatus.getForsikringspremieGyldig(),forsikringspremieTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigForsikringpremieFeilmelding());
  }

  private void validerFeltVedInnlastingAvScene() {
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erByggeArGyldig(),byggeArTekstfelt,InnboOgFritidValidator.getUgyldigByggeArRegex(),InnboOgFritidValidator.getUgyldigByggeArFeilmelding());

    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erBoligTypeGyldig(),boligTypeTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigBoligtypeFeilmelding());

    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erbyggeMaterialeGyldig(),byggeMaterialeTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigByggematerialeFeilmelding());

    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erBoligStanderGyldig(),standardTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigBoligstanderFeilmelding());
  }

  private void nullstillValideringStatus() {

    InnboOgfritidValideringStatus.nullstilValideringStatus();

  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }
}
