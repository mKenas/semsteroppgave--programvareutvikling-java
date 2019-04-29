package programutvikling.kontrollere;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

public class RegistrerSkadeSceneKontroller implements KontrollerMedKundeInfo {
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
  private ObservableList kunderListe;
  private Kunde kunde;
  private Skademelding skademelding;


  public void initialize() {


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

/*

    Date current = new Date();
    //create a date one day before current date
    long prevDay = System.currentTimeMillis() - 1000*60*60*24;
    //create date object
    Date prev = new Date(prevDay);
    //compare both dates
    if(prev.before(current)){
      System.out.println("The date is older than current day");
    } else {
      System.out.println("The date is future day");
    }

    StringConverter<LocalDate> converter = new LocalDateStringConverter() {
      @Override
      public LocalDate fromString(String string) {
        LocalDate date = super.fromString(string);
        if (date.getDayOfWeek() == DayOfWeek.MONDAY) {

          throw new IllegalStateException("I don't like Mondays");

        } else {
          return date ;
        }
      }
    };

    skadeDatoVelger.setConverter(converter);
*/


    String klokkeslett = klokkeslettTekstfelt.getText();
    String skadeDato = skadeDatoVelger.getValue().toString();

    String forsikringsType = forsikringsTypeKomboboks.getSelectionModel().getSelectedItem().toString();
    String skadeType = skadeTypeTekstfelt.getText();
    String skadeBeskrivelse = skadeBeskrivelseTekstfelt.getText();
    String ovrigSkadeInformasjon = ovrigSkadeInformasjonTekstfelt.getText();

    skademelding = new Skademelding(skadeDato, klokkeslett, forsikringsType, skadeType, null, null, skadeBeskrivelse, ovrigSkadeInformasjon);


    dho.getKundeMedSkademeldingListeHandling().leggTilSkademelding(skademelding, kunde);

    NavigeringTilVisKundeScene();


    // NavigeringTilVisKundeScene();

  }
}
