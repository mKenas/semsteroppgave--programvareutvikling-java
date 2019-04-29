package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

public class OpprettBaatForsikringSceneKontroller implements KontrollerMedKundeInfo {

  @FXML
  private TextField personNrTekstfelt;
  @FXML
  TextField forsikringsBelopTekstfelt;
  @FXML
  TextField forsikringsPremieTekstfelt;
  @FXML
  TextField batensEierTekstfelt;
  @FXML
  TextField batensRegistreringsNummerTekstfelt;
  @FXML
  TextField batTypeTekstfelt;
  @FXML
  TextField batModellTekstfelt;
  @FXML
  TextField batLengdeTekstfelt;
  @FXML
  TextField batensAarsModellTekstfelt;
  @FXML
  TextField batensMotortypeTekstfelt;
  @FXML
  TextField batensMotorstyrkeTekstfelt;





  DataHandlingObjekt dho = new DataHandlingObjekt();
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private Forsikring forsikring;



  public void initialize() {

   /* kunderListe = dlo.getKunderListe().getKundeListe();
    kunderListeKomboboks.setItems(kunderListe);*/
    //kunderListeKomboboks.setEditable(true);
    //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);


  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());

  }

  @FXML
  public void handleOpprettBatForsikringKnapp() {



    Double forsikringsBelop = Double.valueOf(forsikringsBelopTekstfelt.getText());
    Double forsikringsPremie = Double.valueOf(forsikringsPremieTekstfelt.getText());
    String forsikringsBetingelser = "";
    String batensEier = batensEierTekstfelt.getText();
    String batensRegistreringsnummer = batensRegistreringsNummerTekstfelt.getText();
    String batType = batTypeTekstfelt.getText();
    String batModell = batModellTekstfelt.getText();
    String batensLengde = batLengdeTekstfelt.getText();
    String batensAarsModell = batensAarsModellTekstfelt.getText();
    String batensMotortype = batensMotortypeTekstfelt.getText();
    String batensMotorstyrke = batensMotorstyrkeTekstfelt.getText();


    forsikring = new BatForsikring(forsikringsBelop, forsikringsPremie, "", batensEier, batensRegistreringsnummer, batType, batModell, batensLengde, batensAarsModell, batensMotortype, batensMotorstyrke);

    dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);

    NavigeringTilVisKundeScene();

  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


}
