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

    //Validator.datoValidering(skadeDatoVelger,"","Skadedato feil");

    Validator.valider(klokkeslettTekstfelt,"(^[0-9]{2}(:)[0-9]{2})?$","Klokkeslett må være i 'HH:MM' format");
    Validator.valider(skadeTypeTekstfelt,"^([0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$","Skadetypen må være mellom 2-20 skandinaviske bokstaver");
    Validator.validerTekstOmrade(skadeBeskrivelseTekstfelt,"^([0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,140})?$","Beskrivelsen må være mellom 0-140 skandinaviske og tall");
    Validator.validerTekstOmrade(ovrigSkadeInformasjonTekstfelt,"^([0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,140})?$","Øvrig informasjon må være mellom 0-140 skandinaviske og tall");

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
    personNrTekstfelt.setText(kunde.getPersonNr());

  }

  @FXML
    public void handleRedigerSkademeldingKnapp() {

    String forikringsType = forsikringsTypeKomboboks.getValue().toString();
    String skadeDato = skadeDatoVelger.getValue().toString();
    String klokkeslett = klokkeslettTekstfelt.getText();
    String skadeType = skadeTypeTekstfelt.getText();
    String skadeBeskrivelse = skadeBeskrivelseTekstfelt.getText();
    String ovrigSkadeInformasjon = ovrigSkadeInformasjonTekstfelt.getText();


    LocalDate sdato = skadeDatoVelger.getValue();


    System.out.println(sdato.isBefore(LocalDate.now().plusDays(1)));

    boolean riktigDato = sdato.isBefore(LocalDate.now().plusDays(1));



    if (sdato.isBefore(LocalDate.now().plusDays(1)) && klokkeslettTekstfelt.validate()  &&
            skadeBeskrivelseTekstfelt.validate() && ovrigSkadeInformasjonTekstfelt.validate()) {


      skademelding.setForsikringsType(forikringsType);
      skademelding.setSkadeDato(skadeDato);
      skademelding.setKlokkeSlett(klokkeslett);
      skademelding.setSkadeType(skadeType);
      skademelding.setSkadeBeskrivelse(skadeBeskrivelse);
      skademelding.setOvrigSkadeInformasjon(ovrigSkadeInformasjon);

      navigeringTilSkademeldingScene();

    }

 /*   else if (riktigDato == false) {

      System.out.println("Skademeldingsdatoen kan ikke være i fremtiden!!!");
      skadeDatoVelger.getValidators().add(Validator.validerDato(skadeDatoVelger, "Skademeldingsdatoen kan ikke være i fremtiden!!!"));

      skadeDatoVelger.validate()

    }*/
  }


  protected void navigeringTilSkademeldingScene() {


    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }


}
