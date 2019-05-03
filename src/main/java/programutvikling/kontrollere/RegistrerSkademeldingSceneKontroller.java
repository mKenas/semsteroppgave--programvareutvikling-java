package programutvikling.kontrollere;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.validering.SkademeldingValidator;
import programutvikling.validering.Validator;

public class RegistrerSkademeldingSceneKontroller implements KontrollerMedKundeInfo {
  @FXML
  JFXTextField personNrTekstfelt;
  @FXML
  JFXTextField klokkeslettTekstfelt;
  @FXML
  JFXDatePicker skadeDatoVelger;
  @FXML
  JFXComboBox forsikringsTypeKomboboks;
  @FXML
  JFXTextField skadeTypeTekstfelt;
  @FXML
  JFXTextArea skadeBeskrivelseTekstfelt;
  @FXML
  JFXTextArea ovrigSkadeInformasjonTekstfelt;
  @FXML


  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();

  private Kunde kunde;
  private Skademelding skademelding;


  public void initialize() {

    Validator.validerFraTekstfelt(klokkeslettTekstfelt, SkademeldingValidator.getUgyldigKlokkeslettRegex(), SkademeldingValidator.getUgyldigKlokkeslettMelding());
    Validator.validerFraTekstfelt(skadeTypeTekstfelt, SkademeldingValidator.getUgyldigSkadetypeRegex(), SkademeldingValidator.getUgyldigSkadetypeMelding());

    Validator.validerFraTekstArea(skadeBeskrivelseTekstfelt, SkademeldingValidator.getUgyldigSkadebeskrivelseRegex(), SkademeldingValidator.getUgyldigSkadebeskrivelseMelding());
    Validator.validerFraTekstArea(ovrigSkadeInformasjonTekstfelt, SkademeldingValidator.getUgyldigSkadeinformasjonRegex(), SkademeldingValidator.getUgyldigSkadeinformasjonMelding());



  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());


  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


  public void handleRegistrerSkadeKnapp(ActionEvent actionEvent) {


    if(klokkeslettTekstfelt.validate() == true &&
            skadeTypeTekstfelt.validate() == true &&
            skadeBeskrivelseTekstfelt.validate() == true &&
            ovrigSkadeInformasjonTekstfelt.validate() == true ){

      String klokkeslett = klokkeslettTekstfelt.getText();
      String skadeDato = skadeDatoVelger.getValue().toString();

      String forsikringsType = forsikringsTypeKomboboks.getSelectionModel().getSelectedItem().toString();
      String skadeType = skadeTypeTekstfelt.getText();
      String skadeBeskrivelse = skadeBeskrivelseTekstfelt.getText();
      String ovrigSkadeInformasjon = ovrigSkadeInformasjonTekstfelt.getText();

      skademelding = new Skademelding(skadeDato, klokkeslett, forsikringsType, skadeType, null, null, skadeBeskrivelse, ovrigSkadeInformasjon);


      dho.getKundeMedSkademeldingListeHandling().leggTilSkademelding(skademelding, kunde);

      NavigeringTilVisKundeScene();


    }





  }
}
