package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
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
import programutvikling.validering.BatforsikringValidator;
import programutvikling.validering.ReiseforsikringValidator;
import programutvikling.validering.Validator;

public class RedigerBatForsikringSceneKontroller implements KontrollerMedKundeInfo,KontrollerMedForsikringInfo {

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
  private BatForsikring forsikring;




  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof BatForsikring) {
      BatForsikring f = (BatForsikring) forsikring;

      this.forsikring = f;

      forsikringsBelopTekstfelt.setText(String.valueOf(f.getForsikringsbelop()));
      forsikringsPremieTekstfelt.setText(String.valueOf(f.getForsikringspremie()));
      batensEierTekstfelt.setText(f.getEier());
      batensRegistreringsNummerTekstfelt.setText(f.getRegistreringsNr());
      batTypeTekstfelt.setText(f.getBatType());
      batModellTekstfelt.setText(f.getBatModell());
      batLengdeTekstfelt.setText(f.getBatLengde());
      batensAarsModellTekstfelt.setText(f.getArsModell());
      batensMotortypeTekstfelt.setText(f.getMotorType());
      batensMotorstyrkeTekstfelt.setText(f.getMotorStyrke());

    }
  }


  public void initialize() {

   /* kunderListe = dlo.getKunderListe().getKundeListe();
    kunderListeKomboboks.setItems(kunderListe);*/
    //kunderListeKomboboks.setEditable(true);
    //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);

    Validator.valider(forsikringsBelopTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinsBelopMelding());
    Validator.valider(forsikringsPremieTekstfelt, BatforsikringValidator.getUgyldigBelopRegex(), ReiseforsikringValidator.getUgyldigForsikrinspremieMelding());
    Validator.valider(batensEierTekstfelt, BatforsikringValidator.getUgyldigEierRegex(), BatforsikringValidator.getUgyldigEierFeilmelding());
    Validator.valider(batensRegistreringsNummerTekstfelt, BatforsikringValidator.getUgyldigRegistreringsnummerRegex(), BatforsikringValidator.getUgyldigRegistreringsnummerFeilmelding());
    Validator.valider(batTypeTekstfelt, BatforsikringValidator.getUgyldigBattypeRegex(), BatforsikringValidator.getUgyldigBattypeFeilmelding());
    Validator.valider(batModellTekstfelt, BatforsikringValidator.getUgyldigBatmodellRegex(), BatforsikringValidator.getUgyldigBatmodellFeilmelding());
    Validator.valider(batLengdeTekstfelt, BatforsikringValidator.getUgyldigBatlengdeRegex(), BatforsikringValidator.getUgyldigBatlengdeFeilmelding());
    Validator.valider(batensAarsModellTekstfelt, BatforsikringValidator.getUgyldigArsmodellRegex(), BatforsikringValidator.getUgyldigArsmodellFeilmelding());
    Validator.valider(batensMotortypeTekstfelt, BatforsikringValidator.getUgyldigMotorTypeRegex(), BatforsikringValidator.getUgyldigMotorTypeFeilmelding());
    Validator.valider(batensMotorstyrkeTekstfelt, BatforsikringValidator.getUgyldigMotorStyrkeRegex(), BatforsikringValidator.getUgyldigMotorStyrkeFeilmelding());

/*    Validator.valider(forsikringsBelopTekstfelt,"^([0-9]){2,12}(\\.[0-9]+)$","Forsikringsbeløp tillater 2-12 tall");
    Validator.valider(forsikringsPremieTekstfelt,"^([0-9]){2,12}(\\.[0-9]+)$","Forsikringspremie tillater 2-12 tall");
    Validator.valider(batensEierTekstfelt,"^[a-zA-ZäöæøåøÄÖÆØÅ ]{2,16}?$","Navnet må være mellom 2-16 skandinaviske bokstaver");
    Validator.valider(batensRegistreringsNummerTekstfelt,"^([A-Za-z]{3})([0-9]{3})$","Registreringsnummeret må være på 'ABC123' format ");
    Validator.valider(batTypeTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,16})?$","Båttypen må være mellom 2-16 skandinaviske bokstaver");
    Validator.valider(batModellTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]){2,16}?$","Båtmodellen må være mellom 2-16 skandinaviske bokstaver og eller tall");
    Validator.valider(batLengdeTekstfelt,"^([0-9]{1,8})$","Båtlengde i fot tillater kun 1-8 tall");
    Validator.valider(batensAarsModellTekstfelt,"^(18[0-9]\\d|19[0-9]\\d|20[01]\\d)?$","Årsmodellen må være fra 1800-tallet til dags dato");
    Validator.valider(batensMotortypeTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,16})?$","Motortypen må være mellom 2-16 bokstaver");
    Validator.valider(batensMotorstyrkeTekstfelt,"^([0-9]{1,3})?$","Motorstyrken 1-3 tall oppgitt i HK");*/


  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());

  }

  @FXML
  public void handleLagreBatForsikringKnapp() {

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

      forsikring.setForsikringsbelop(forsikringsBelop);
      forsikring.setForsikringspremie(forsikringsPremie);
      forsikring.setEier(batensEier);
      forsikring.setRegistreringsNr(batensRegistreringsnummer);
      forsikring.setBatType(batType);
      forsikring.setBatModell(batModell);
      forsikring.setBatLengde(batensLengde);
      forsikring.setArsModell(batensAarsModell);
      forsikring.setMotorType(batensMotortype);
      forsikring.setMotorStyrke(batensMotorstyrke);

      NavigeringTilVisKundeScene();
    }
  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


}
