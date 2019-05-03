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
import programutvikling.validering.HusOgInnboValidator;
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


    System.out.println(forsikringsbelop);
    System.out.println(forsikringspremie);


      forsikring = new HusOgInnboForsikring(forsikringsbelop, forsikringspremie,
              boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);

      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();





  }

  public void initialize() {


    validerHusOgInnboFelt();


  }

  private void validerHusOgInnboFelt() {
    Validator.valider(HusOgInnboValidator.erAdresseGyldig(),boligensAdresseTekstfelt,HusOgInnboValidator.getUgyldigAddresseRegex(),HusOgInnboValidator.getUgyldigAddresseFeilmelding());
    Validator.valider(HusOgInnboValidator.erByggeArGyldig(),byggeArTekstfelt,HusOgInnboValidator.getUgyldigByggeArRegex(),HusOgInnboValidator.getUgyldigByggeArFeilmelding());
    Validator.valider(HusOgInnboValidator.erBoligTypeGyldig(),boligTypeTekstfelt,HusOgInnboValidator.getUGyldigStringRegex(),HusOgInnboValidator.getUgyldigBoligtypeFeilmelding());
    Validator.valider(HusOgInnboValidator.erbyggeMaterialeGyldig(),byggeMaterialeTekstfelt,HusOgInnboValidator.getUGyldigStringRegex(),HusOgInnboValidator.getUgyldigByggematerialeFeilmelding());
    Validator.valider(HusOgInnboValidator.erBoligStanderGyldig(),standardTekstfelt,HusOgInnboValidator.getUGyldigStringRegex(),HusOgInnboValidator.getUgyldigBoligstanderFeilmelding());
    Validator.valider(HusOgInnboValidator.erAntallKvadratmeterGyldig(),antallkvadratmeterTekstfelt,HusOgInnboValidator.getUgyldigAntallKvadratmeterRegex(),HusOgInnboValidator.getUgyldigAntallKvadratmeterFeilmelding());
    Validator.valider(HusOgInnboValidator.erByggningsbelopGyldig(),bygningForsikringsbelopTekstfelt,HusOgInnboValidator.getUgyldigBelopRegex(),HusOgInnboValidator.getUgyldigByggningsbelopFeilmelding());
    Validator.valider(HusOgInnboValidator.erInnbobelopGyldig(),innboForsikringsbelopTekstfelt,HusOgInnboValidator.getUgyldigBelopRegex(),HusOgInnboValidator.getUgyldigInnbobelopFeilmelding());
    Validator.valider(HusOgInnboValidator.erforsikringbelopGyldig(),forsikringsbelopTekstfelt,HusOgInnboValidator.getUgyldigBelopRegex(),HusOgInnboValidator.getUgyldigForsikringbelopFeilmelding());
    Validator.valider(HusOgInnboValidator.getForsikringspremieGyldig(),forsikringspremieTekstfelt,HusOgInnboValidator.getUgyldigBelopRegex(),HusOgInnboValidator.getUgyldigForsikringpremieFeilmelding());


    opprettForsikringKnapp.disableProperty().bind(HusOgInnboValidator.erAdresseGyldig().not()
            .or(HusOgInnboValidator.erByggeArGyldig().not())
            .or(HusOgInnboValidator.erBoligTypeGyldig().not())
            .or(HusOgInnboValidator.erbyggeMaterialeGyldig().not())
            .or(HusOgInnboValidator.erBoligStanderGyldig().not())
            .or(HusOgInnboValidator.erAntallKvadratmeterGyldig().not())
            .or(HusOgInnboValidator.erByggningsbelopGyldig().not())
            .or(HusOgInnboValidator.erInnbobelopGyldig().not())
            .or(HusOgInnboValidator.erforsikringbelopGyldig().not())
            .or((HusOgInnboValidator.getForsikringspremieGyldig().not()))
            );
  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }
}
