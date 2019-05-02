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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

    Validator.datoValidering(skadeDatoVelger, "", "Skadedato feil");

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

    skademelding.setForsikringsType(forikringsType);
    skademelding.setSkadeDato(skadeDato);
    skademelding.setKlokkeSlett(klokkeslett);
    skademelding.setSkadeType(skadeType);
    skademelding.setSkadeBeskrivelse(skadeBeskrivelse);
    skademelding.setOvrigSkadeInformasjon(ovrigSkadeInformasjon);

    String opprettelsesDato = skademelding.getOpprettelsesDato();

    System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

/*    String dato = skademelding.getOpprettelsesDato();
    String stringDato = (dato);

    System.out.println(skadeDato); // 2019-04-01
    System.out.println(dato); // 02.05.2019 11:39
    System.out.println(stringDato); //02.05.2019 11:39


    String skadeString = skadeDato;

    SimpleDateFormat fraBruker = new SimpleDateFormat(skadeString);
    SimpleDateFormat mittFormat = new SimpleDateFormat("dd/MM/yyyy");


    try {
      String nyttFormat = mittFormat.format(fraBruker.parse(skadeString));
      System.out.println(nyttFormat);
    } catch (ParseException e) {
      e.printStackTrace();
    }*/
/*    String opprettelsesDatoNY = skademelding.getOpprettelsesDato();
    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    Date NYOpprettelses = null;
    try {
      NYOpprettelses = (Date)formatter.parse(opprettelsesDatoNY);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    SimpleDateFormat nyFormatter = new SimpleDateFormat("yyyy-MM-DD");
    String resultat = nyFormatter.format(NYOpprettelses);

    System.out.println(resultat);*/








    navigeringTilSkademeldingScene();

  }


  protected void navigeringTilSkademeldingScene() {


    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }


}
