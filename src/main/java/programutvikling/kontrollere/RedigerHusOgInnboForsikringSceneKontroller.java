package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.HusOgInnboForsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.InnboOgfritidValideringStatus;
import programutvikling.validering.InnboOgFritidValidator;
import programutvikling.validering.Validator;

public class RedigerHusOgInnboForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private HusOgInnboForsikring forsikring;

  private Kunde kunde;


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
private JFXButton lagretForsikringKnapp;





  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.toString());

  }


  @Override
  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof HusOgInnboForsikring) {
      HusOgInnboForsikring f = (HusOgInnboForsikring) forsikring;

      this.forsikring = f;
      boligensAdresseTekstfelt.setText(f.getBoligAdresse());
      byggeArTekstfelt.setText(f.getByggeAr());
      boligTypeTekstfelt.setText(f.getBoligType());
      byggeMaterialeTekstfelt.setText(f.getByggeMateriale());
      standardTekstfelt.setText(f.getStandard());
      antallkvadratmeterTekstfelt.setText(f.getStorrelse());
      bygningForsikringsbelopTekstfelt.setText(String.valueOf(f.getInnboForsikringsbelop()));
      innboForsikringsbelopTekstfelt.setText(String.valueOf(f.getInnboForsikringsbelop()));
      forsikringsbelopTekstfelt.setText(String.valueOf(f.getBygningsForsikringsbelop()));
      forsikringspremieTekstfelt.setText(String.valueOf(f.getForsikringspremie()));

      validerHusOgInnboFeltVedInnlasting();

    }

  }


  @FXML
  public void handleTilbakeKnapp() {

    NavigeringTilKunderScene();
  }

  protected void NavigeringTilKunderScene() {
    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }



  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }




  public void handleRedigerHusOgInnboForsikringKnapp() {

    String boligensAdresse = boligensAdresseTekstfelt.getText();
    String byggeAr = byggeArTekstfelt.getText();
    String boligType = boligTypeTekstfelt.getText();
    String byggeMateriale = byggeMaterialeTekstfelt.getText();
    String standard = standardTekstfelt.getText();
    String antallkvadratmeter = antallkvadratmeterTekstfelt.getText();
    Double bygningForsikringsbelop = Double.valueOf(bygningForsikringsbelopTekstfelt.getText());
    Double innboForsikringsbelop = Double.valueOf(innboForsikringsbelopTekstfelt.getText());
    Double forsikringsbelop = Double.valueOf(forsikringsbelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(forsikringspremieTekstfelt.getText());


    forsikring.setBoligAdresse(boligensAdresse);
    forsikring.setByggeAr(byggeAr);
    forsikring.setBoligType(boligType);
    forsikring.setByggeMateriale(byggeMateriale);
    forsikring.setStandard(standard);
    forsikring.setStorrelse(antallkvadratmeter);
    forsikring.setBygningsForsikringsbelop(bygningForsikringsbelop.toString());
    forsikring.setInnboForsikringsbelop(innboForsikringsbelop.toString());
    forsikring.setForsikringsbelop(forsikringsbelop);
    forsikring.setForsikringspremie(forsikringspremie);



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

  private void validerHusOgInnboFeltVedInnlasting() {

    nullstillValideringStatus();


    validerFeltVedInnlastingAvScene();



    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    lagretForsikringKnapp.disableProperty().bind(
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



    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erAdresseGyldig(),boligensAdresseTekstfelt,InnboOgFritidValidator.getUgyldigAddresseRegex(),InnboOgFritidValidator.getUgyldigAddresseFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erByggeArGyldig(),byggeArTekstfelt,InnboOgFritidValidator.getUgyldigByggeArRegex(),InnboOgFritidValidator.getUgyldigByggeArFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erBoligTypeGyldig(),boligTypeTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigBoligtypeFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erbyggeMaterialeGyldig(),byggeMaterialeTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigByggematerialeFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erBoligStanderGyldig(),standardTekstfelt,InnboOgFritidValidator.getUGyldigStringRegex(),InnboOgFritidValidator.getUgyldigBoligstanderFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erAntallKvadratmeterGyldig(),antallkvadratmeterTekstfelt,InnboOgFritidValidator.getUgyldigAntallKvadratmeterRegex(),InnboOgFritidValidator.getUgyldigAntallKvadratmeterFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erByggningsbelopGyldig(),bygningForsikringsbelopTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigByggningsbelopFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erInnbobelopGyldig(),innboForsikringsbelopTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigInnbobelopFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.erforsikringbelopGyldig(),forsikringsbelopTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigForsikringbelopFeilmelding());
    Validator.validerVedInnlasstingAvScene(InnboOgfritidValideringStatus.getForsikringspremieGyldig(),forsikringspremieTekstfelt,InnboOgFritidValidator.getUgyldigBelopRegex(),InnboOgFritidValidator.getUgyldigForsikringpremieFeilmelding());
  }

  private void nullstillValideringStatus() {

    InnboOgfritidValideringStatus.nullstilValideringStatus();
  }


}
