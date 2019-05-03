package programutvikling.kontrollere;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.validering.SkademeldingValidator;
import programutvikling.validering.Validator;

import java.time.LocalDate;

public class RedigerSkademeldingKontroller implements KontrollerMedSkademeldingInfo, KontrollerMedKundeInfo {
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Skademelding skademelding;
  private Kunde kunde;


  @FXML
  private JFXTextField personNrTekstfelt;
  @FXML
  private JFXComboBox forsikringsTypeKomboboks;
  @FXML
  private JFXDatePicker skadeDatoVelger;
  @FXML
  private JFXTextField klokkeslettTekstfelt;
  @FXML
  private JFXTextField skadeTypeTekstfelt;
  @FXML
  private JFXTextArea skadeBeskrivelseTekstfelt;
  @FXML
  private JFXTextArea ovrigSkadeInformasjonTekstfelt;


  public void initialize() {

    Validator.validerFraTekstfelt(klokkeslettTekstfelt, SkademeldingValidator.getUgyldigKlokkeslettRegex(), SkademeldingValidator.getUgyldigKlokkeslettMelding());
    Validator.validerFraTekstfelt(skadeTypeTekstfelt, SkademeldingValidator.getUgyldigSkadetypeRegex(), SkademeldingValidator.getUgyldigSkadetypeMelding());

    Validator.validerFraTekstArea(skadeBeskrivelseTekstfelt, SkademeldingValidator.getUgyldigSkadebeskrivelseRegex(), SkademeldingValidator.getUgyldigSkadebeskrivelseMelding());
    Validator.validerFraTekstArea(ovrigSkadeInformasjonTekstfelt, SkademeldingValidator.getUgyldigSkadeinformasjonRegex(), SkademeldingValidator.getUgyldigSkadeinformasjonMelding());


  }

  @Override
  public void setSkademelding(Skademelding skademelding) {

    this.skademelding = skademelding;

    forsikringsTypeKomboboks.getSelectionModel().select(skademelding.getForsikringsType());
    skadeDatoVelger.setValue(LocalDate.parse(skademelding.getSkadeDato()));
    klokkeslettTekstfelt.setText(skademelding.getKlokkeSlett());
    skadeTypeTekstfelt.setText(skademelding.getSkadeType());
    skadeBeskrivelseTekstfelt.setText(skademelding.getSkadeBeskrivelse());
    ovrigSkadeInformasjonTekstfelt.setText(skademelding.getOvrigSkadeInformasjon());

  }

  @Override
  public void setKunde(Kunde kunde) {

    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.toString());


    Validator.validerFraTekstfelt(klokkeslettTekstfelt, SkademeldingValidator.getUgyldigKlokkeslettRegex(), SkademeldingValidator.getUgyldigKlokkeslettMelding());
    Validator.validerFraTekstfelt(skadeTypeTekstfelt, SkademeldingValidator.getUgyldigSkadetypeRegex(), SkademeldingValidator.getUgyldigSkadetypeMelding());

    Validator.validerFraTekstArea(skadeBeskrivelseTekstfelt, SkademeldingValidator.getUgyldigSkadebeskrivelseRegex(), SkademeldingValidator.getUgyldigSkadebeskrivelseMelding());
    Validator.validerFraTekstArea(ovrigSkadeInformasjonTekstfelt, SkademeldingValidator.getUgyldigSkadeinformasjonRegex(), SkademeldingValidator.getUgyldigSkadeinformasjonMelding());


  }

  @FXML
  public void handleRedigerSkademeldingKnapp() {

    if (klokkeslettTekstfelt.validate() == true &&
            skadeTypeTekstfelt.validate() == true &&
            skadeBeskrivelseTekstfelt.validate() == true &&
            ovrigSkadeInformasjonTekstfelt.validate() == true) {

      String forikringsType = forsikringsTypeKomboboks.getValue().toString();
      String skadeDato = skadeDatoVelger.getValue().toString();
      String klokkeslett = klokkeslettTekstfelt.getText();
      String skadeType = skadeTypeTekstfelt.getText();
      String skadeBeskrivelse = skadeBeskrivelseTekstfelt.getText();
      String ovrigSkadeInformasjon = ovrigSkadeInformasjonTekstfelt.getText();


      LocalDate sdato = skadeDatoVelger.getValue();


      skademelding.setForsikringsType(forikringsType);
      skademelding.setSkadeDato(skadeDato);
      skademelding.setKlokkeSlett(klokkeslett);
      skademelding.setSkadeType(skadeType);
      skademelding.setSkadeBeskrivelse(skadeBeskrivelse);
      skademelding.setOvrigSkadeInformasjon(ovrigSkadeInformasjon);

      navigeringTilSkademeldingScene();


    }


  }


  protected void navigeringTilSkademeldingScene() {


    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }


}
