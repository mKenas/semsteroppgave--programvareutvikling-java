package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.ReiseForsikring;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.ResieValideringStatus;
import programutvikling.validering.ReiseforsikringValidator;
import programutvikling.validering.Validator;

public class OpprettReiseforsikringKontroller implements KontrollerMedKundeInfo {
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
  private JFXButton opprettForsikringKnapp;

  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde;
  private Forsikring forsikring;


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.toString());

  }


  @FXML
  public void handleOpprettKnapp() {


      Double forsikringsbelop = Double.valueOf(reiseForsikringsBelopTekstfelt.getText());
      Double forsikringspremie = Double.valueOf(reiseArligForsikringspremieTekstfelt.getText());
      String forsikringsbetingelser = "";
      Double forsikringssum = Double.valueOf(reiseForsikringssumTekstfelt.getText());
      String forsikringsomrade = reiseForsikringsomradeTekstfelt.getText();

      forsikring = new ReiseForsikring(forsikringsbelop, forsikringspremie, "", forsikringsomrade, forsikringssum);


      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();

  }


  public void initialize() {

    valideReiseForsikringFelt();
  }


  private void valideReiseForsikringFelt() {

    nullstillValideringStatus();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    opprettForsikringKnapp.disableProperty().bind(
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


  private void nullstillValideringStatus() {

    ResieValideringStatus.nullstillValideringStatus();
  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }
  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }
}

