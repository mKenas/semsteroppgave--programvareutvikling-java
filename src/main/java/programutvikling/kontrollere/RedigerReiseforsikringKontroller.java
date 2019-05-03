package programutvikling.kontrollere;

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

    Validator.validerFraTekstfelt(reiseForsikringssumTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikringssumMelding());
    Validator.validerFraTekstfelt(reiseForsikringsBelopTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.validerFraTekstfelt(reiseArligForsikringspremieTekstfelt, ReiseforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.validerFraTekstfelt(reiseForsikringsomradeTekstfelt, ReiseforsikringValidator.getUgyldigForsikrinsOmradeRegex(), ReiseforsikringValidator.getUgyldigForsikrinsOmradeMelding());


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

    }
  }

  public void handleRedigerReiseforsikringKnapp() {

    Double forsikringssum = Double.valueOf(reiseForsikringssumTekstfelt.getText());
    String forsikringsomrade = reiseForsikringsomradeTekstfelt.getText();
    Double forsikringsbelop = Double.valueOf(reiseForsikringsBelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(reiseArligForsikringspremieTekstfelt.getText());


    if (reiseForsikringssumTekstfelt.validate() == true &&
            reiseForsikringsBelopTekstfelt.validate() == true &&
            reiseForsikringsomradeTekstfelt.validate() == true &&
            reiseArligForsikringspremieTekstfelt.validate() == true) {

      NavigeringTilVisKundeScene();

      forsikring.setForsikringsSum(forsikringssum);
      forsikring.setForsikringsOmrade(forsikringsomrade);
      forsikring.setForsikringsbelop(forsikringsbelop);
      forsikring.setForsikringspremie(forsikringspremie);

      NavigeringTilVisKundeScene();
    }

  }
}


