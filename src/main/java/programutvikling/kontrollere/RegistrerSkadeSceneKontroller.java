package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import programutvikling.base.*;
import programutvikling.database.DataSourceObject;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class RegistrerSkadeSceneKontroller implements KontrollerMedKundeInfo{
  @FXML
  TextField personNrTekstfelt;
  @FXML
  TextField klokkeslettTekstfelt;
  @FXML
  DatePicker skadeDatoVelger;
  @FXML
  ComboBox forsikringsTypeKomboboks;
  @FXML
  TextField skadeTypeTekstfelt;
  @FXML
  TextArea skadeBeskrivelseTekstfelt;
  @FXML
  TextArea ovrigSkadeInformasjonTekstfelt;

  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataSourceObject dso = DataSourceObject.getInstance();
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

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(),kunde);

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

    skademelding = new Skademelding(skadeDato,klokkeslett,forsikringsType,skadeType,null,null,skadeBeskrivelse,ovrigSkadeInformasjon);


    kunde.leggTilSkadeMelding(skademelding);

    NavigeringTilVisKundeScene();








   // NavigeringTilVisKundeScene();

  }
}
