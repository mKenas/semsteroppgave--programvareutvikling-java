package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.ReiseForsikring;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.ResieValideringStatus;
import programutvikling.validering.ReiseforsikringValidator;
import programutvikling.validering.Validator;

public class RedigerReiseforsikringKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {
  @FXML
  JFXTextField personNrTekstfelt;
  @FXML
  JFXTextField reiseForsikringssumTekstfelt;
  @FXML
  JFXTextField reiseArligForsikringspremieTekstfelt;
  @FXML
  private
  JFXTextField reiseForsikringsBelopTekstfelt;
  @FXML
  private
  JFXTextField reiseForsikringsomradeTekstfelt;
  @FXML
  private JFXButton lagreForsikringKnapp;
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();

  private Kunde kunde;
  private ReiseForsikring forsikring;


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.toString());

  }


  public void initialize() {

    valideReiseForsikringFelt();
  }




  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

  @Override
  public void setForsikring(Forsikring forsikring) {
    if (forsikring instanceof ReiseForsikring) {
      ReiseForsikring f = (ReiseForsikring) forsikring;

      this.forsikring = f;

      reiseForsikringssumTekstfelt.setText(String.valueOf(f.getForsikringsSum()));
      reiseForsikringsBelopTekstfelt.setText(String.valueOf(f.getForsikringsSum()));
      reiseForsikringsomradeTekstfelt.setText(f.getForsikringsOmrade());
      reiseArligForsikringspremieTekstfelt.setText(String.valueOf(f.getForsikringspremie()));


      validerFeltVedInnlastingAvScene();

    }
  }

  public void handleRedigerReiseforsikringKnapp() {

    Double forsikringssum = Double.valueOf(reiseForsikringssumTekstfelt.getText());
    String forsikringsomrade = reiseForsikringsomradeTekstfelt.getText();
    Double forsikringsbelop = Double.valueOf(reiseForsikringsBelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(reiseArligForsikringspremieTekstfelt.getText());




      forsikring.setForsikringsSum(forsikringssum);
      forsikring.setForsikringsOmrade(forsikringsomrade);
      forsikring.setForsikringsbelop(forsikringsbelop);
      forsikring.setForsikringspremie(forsikringspremie);

      NavigeringTilVisKundeScene();


  }


  private void valideReiseForsikringFelt() {

    nullstillValideringStatus();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    lagreForsikringKnapp.disableProperty().bind(
            ResieValideringStatus.erForsikringbelopGyldig().not()
                    .or(ResieValideringStatus.erForsikringspremieGyldig().not())
                    .or(ResieValideringStatus.erForsikringSumGyldig().not())
                    .or(ResieValideringStatus.erOmrodGyldig().not())

    );
  }

  private void validerFeltVedEndringAvInnputt() {


    Validator.valider(ResieValideringStatus.erForsikringSumGyldig(), reiseForsikringssumTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikringssumMelding());
    Validator.valider(ResieValideringStatus.erForsikringbelopGyldig(), reiseForsikringsBelopTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.valider(ResieValideringStatus.erForsikringspremieGyldig(), reiseArligForsikringspremieTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.valider(ResieValideringStatus.erOmrodGyldig(), reiseForsikringsomradeTekstfelt, ReiseforsikringValidator.getUgyldigForsikrinsOmradeRegex(), ReiseforsikringValidator.getUgyldigForsikrinsOmradeMelding());

  }

  private void validerFeltVedInnlastingAvScene() {

    Validator.validerVedInnlasstingAvScene(ResieValideringStatus.erForsikringSumGyldig(), reiseForsikringssumTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikringssumMelding());
    Validator.validerVedInnlasstingAvScene(ResieValideringStatus.erForsikringbelopGyldig(), reiseForsikringsBelopTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.validerVedInnlasstingAvScene(ResieValideringStatus.erForsikringspremieGyldig(), reiseArligForsikringspremieTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.validerVedInnlasstingAvScene(ResieValideringStatus.erOmrodGyldig(), reiseForsikringsomradeTekstfelt, ReiseforsikringValidator.getUgyldigForsikrinsOmradeRegex(), ReiseforsikringValidator.getUgyldigForsikrinsOmradeMelding());

  }

  private void nullstillValideringStatus() {

    ResieValideringStatus.nullstillValideringStatus();
  }

}


