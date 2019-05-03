package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.BatForsikring;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.validering.Validator;

public class OpprettBaatForsikringSceneKontroller implements KontrollerMedKundeInfo {

  @FXML
  private TextField personNrTekstfelt;
  @FXML
  JFXTextField forsikringsBelopTekstfelt;
  @FXML
  JFXTextField forsikringsPremieTekstfelt;
  @FXML
  JFXTextField batensEierTekstfelt;
  @FXML
  JFXTextField batensRegistreringsNummerTekstfelt;
  @FXML
  JFXTextField batTypeTekstfelt;
  @FXML
  JFXTextField batModellTekstfelt;
  @FXML
  JFXTextField batLengdeTekstfelt;
  @FXML
  JFXTextField batensAarsModellTekstfelt;
  @FXML
  JFXTextField batensMotortypeTekstfelt;
  @FXML
  JFXTextField batensMotorstyrkeTekstfelt;





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

    Validator.valider(forsikringsBelopTekstfelt,"([0-9]{4,14})$","Forsikringsbeløp tillater 4-14 tall");
    Validator.valider(forsikringsPremieTekstfelt,"([0-9]{4,14})$","Forsikringspremie tillater 4-14 tall");
    Validator.valider(batensEierTekstfelt,"^[a-zA-ZäöæøåøÄÖÆØÅ ]{2,16}?$","Navnet må være mellom 2-16 skandinaviske bokstaver");
    Validator.valider(batensRegistreringsNummerTekstfelt,"^([A-Za-z]{3})([0-9]{3})$","Registreringsnummeret må være på 'ABC123' format ");
    Validator.valider(batTypeTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,16})?$","Båttypen må være mellom 2-16 skandinaviske bokstaver");
    Validator.valider(batModellTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]){2,16}?$","Båtmodellen må være mellom 2-16 skandinaviske bokstaver og eller tall");
    Validator.valider(batLengdeTekstfelt,"^([0-9]{1,8})$","Båtlengde i fot tillater kun 1-8 tall");
    Validator.valider(batensAarsModellTekstfelt,"^(18[0-9]\\d|19[0-9]\\d|20[01]\\d)?$","Årsmodellen må være fra 1800-tallet til dags dato");
    Validator.valider(batensMotortypeTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,16})?$","Motortypen må være mellom 2-16 bokstaver");
    Validator.valider(batensMotorstyrkeTekstfelt,"^([0-9]{1,3})?$","Motorstyrken 1-3 tall oppgitt i HK");


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



    if(forsikringsBelopTekstfelt.validate() == true &&
            forsikringsPremieTekstfelt.validate() == true &&
            batensEierTekstfelt.validate() == true &&
            batensRegistreringsNummerTekstfelt.validate() == true &&
            batTypeTekstfelt.validate() == true &&
            batModellTekstfelt.validate() == true &&
            batLengdeTekstfelt.validate() == true &&
            batensAarsModellTekstfelt.validate() == true &&
            batensMotortypeTekstfelt.validate() == true &&
            batensMotorstyrkeTekstfelt.validate() == true) {

      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
        System.out.println();
      NavigeringTilVisKundeScene();
    }
  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

    @FXML
    public void VisForsikringVillkar(ActionEvent actionEvent) {

    }

}
