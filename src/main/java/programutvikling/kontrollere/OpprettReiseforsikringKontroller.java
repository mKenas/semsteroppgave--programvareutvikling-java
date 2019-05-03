package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.ReiseForsikring;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
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
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private Forsikring forsikring;


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.toString());

  }


  @FXML
  public void handleOpprettKnapp() {

    if (reiseForsikringssumTekstfelt.validate() == true &&
            reiseForsikringsBelopTekstfelt.validate() == true &&
            reiseForsikringsomradeTekstfelt.validate() == true &&
            reiseArligForsikringspremieTekstfelt.validate() == true) {

      Double forsikringsbelop = Double.valueOf(reiseForsikringsBelopTekstfelt.getText());
      Double forsikringspremie = Double.valueOf(reiseArligForsikringspremieTekstfelt.getText());
      String forsikringsbetingelser = "";
      Double forsikringssum = Double.valueOf(reiseForsikringssumTekstfelt.getText());
      String forsikringsomrade = reiseForsikringsomradeTekstfelt.getText();

      forsikring = new ReiseForsikring(forsikringsbelop, forsikringspremie, "", forsikringsomrade, forsikringssum);


      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();
    }
  }


  public void initialize() {


    Validator.validerFraTekstfelt(reiseForsikringssumTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikringssumMelding());
    Validator.validerFraTekstfelt(reiseForsikringsBelopTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.validerFraTekstfelt(reiseArligForsikringspremieTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.validerFraTekstfelt(reiseForsikringsomradeTekstfelt, ReiseforsikringValidator.getUgyldigForsikrinsOmradeRegex(), ReiseforsikringValidator.getUgyldigForsikrinsOmradeMelding());

  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }
}

