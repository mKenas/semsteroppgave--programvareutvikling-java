package programutvikling.kontrollere;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.SkademeldingValideringStatus;
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
  private JFXButton registrerSkademeldingKnapp;

  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();

  private Kunde kunde;
  private Skademelding skademelding;


  public void initialize() {
    validerSkademeldingFelt();


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

  private void validerSkademeldingFelt() {

    nullstillValideringStatus();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    registrerSkademeldingKnapp.disableProperty().bind(
            SkademeldingValideringStatus.erKlokkeslettGyldig().not()
                    .or(SkademeldingValideringStatus.erSkadetypeGyldig().not())
                    .or(SkademeldingValideringStatus.erSkadebeskrivelseGyldig().not())
                    .or(SkademeldingValideringStatus.erSkadeinformasjonGyldig().not())

    );
  }

  private void validerFeltVedEndringAvInnputt() {

    Validator.valider(SkademeldingValideringStatus.erKlokkeslettGyldig(), klokkeslettTekstfelt, SkademeldingValidator.getUgyldigKlokkeslettRegex(), SkademeldingValidator.getUgyldigKlokkeslettMelding());
    Validator.valider(SkademeldingValideringStatus.erSkadetypeGyldig(), skadeTypeTekstfelt, SkademeldingValidator.getUgyldigSkadetypeRegex(), SkademeldingValidator.getUgyldigSkadetypeMelding());

    Validator.valider(SkademeldingValideringStatus.erSkadebeskrivelseGyldig(), skadeBeskrivelseTekstfelt, SkademeldingValidator.getUgyldigSkadebeskrivelseRegex(), SkademeldingValidator.getUgyldigSkadebeskrivelseMelding());
    Validator.valider(SkademeldingValideringStatus.erSkadeinformasjonGyldig(), ovrigSkadeInformasjonTekstfelt, SkademeldingValidator.getUgyldigSkadeinformasjonRegex(), SkademeldingValidator.getUgyldigSkadeinformasjonMelding());


  }

  private void validerFeltVedInnlastingAvScene() {

  }

  private void nullstillValideringStatus() {

    SkademeldingValideringStatus.nullstillValideringStatus();
  }


}
