package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

public class OpprettReiseforsikringKontroller implements KontrollerMedKundeInfo {
  @FXML
  TextField personNrTekstfelt;
  @FXML
  TextField reiseForsikringssumTekstfelt;
  @FXML
  private
  TextField reiseForsikringsBelopTekstfelt;
  @FXML
  private
  TextField reiseForsikringsomradeTekstfelt;
  @FXML
  TextField reiseArligForsikringspremieTekstfelt;




  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private Forsikring forsikring;


  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());


  }


  @FXML
  public void handleOpprettReiseforsikringKnapp() {

    Double forsikringsbelop = Double.valueOf(reiseForsikringsBelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(reiseArligForsikringspremieTekstfelt.getText());
    String forsikringsbetingelser = "";
    Double forsikringssum = Double.valueOf(reiseForsikringssumTekstfelt.getText());
    String forsikringsomrade = reiseForsikringsomradeTekstfelt.getText();

    forsikring = new ReiseForsikring(forsikringsbelop, forsikringspremie,"", forsikringsomrade, forsikringssum);

    dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);

    NavigeringTilVisKundeScene();

  }


  public void initialize() {


  }




  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }
  }

