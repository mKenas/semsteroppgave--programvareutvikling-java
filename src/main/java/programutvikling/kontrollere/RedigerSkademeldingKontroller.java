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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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

    //Validator.datoValidering(skadeDatoVelger,"","Skadedato feil");

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



    System.out.println(sdato.isBefore( LocalDate.now().plusDays(1) ));




      skademelding.setForsikringsType(forikringsType);
      skademelding.setSkadeDato(skadeDato);
      skademelding.setKlokkeSlett(klokkeslett);
      skademelding.setSkadeType(skadeType);
      skademelding.setSkadeBeskrivelse(skadeBeskrivelse);
      skademelding.setOvrigSkadeInformasjon(ovrigSkadeInformasjon);

    navigeringTilSkademeldingScene();






   /* try {
      Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(stringDato);
    } catch (ParseException e) {
      e.printStackTrace();
    }*/




      }


  protected void navigeringTilSkademeldingScene() {


    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }


}
