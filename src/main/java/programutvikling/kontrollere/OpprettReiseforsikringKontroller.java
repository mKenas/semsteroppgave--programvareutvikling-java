package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.validering.Validator;

public class OpprettReiseforsikringKontroller implements KontrollerMedKundeInfo {
  @FXML
  JFXTextField personNrTekstfelt;
  @FXML
  JFXTextField reiseForsikringssumTekstfelt;
  @FXML
  private
  JFXTextField reiseForsikringsBelopTekstfelt;
  @FXML
  private
  JFXTextField reiseForsikringsomradeTekstfelt;
  @FXML
  JFXTextField reiseArligForsikringspremieTekstfelt;




  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private Forsikring forsikring;


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.getPersonNr());

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


    if(reiseForsikringssumTekstfelt.validate() == true &&
            reiseForsikringsBelopTekstfelt.validate() == true &&
            reiseForsikringsomradeTekstfelt.validate() == true &&
            reiseArligForsikringspremieTekstfelt.validate() == true) {

      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();
    }
  }




  public void initialize() {




    Validator.valider(reiseForsikringssumTekstfelt,"([0-9]{4,14})$","Forsikringsbeløp tillater 4-14 tall");
    Validator.valider(reiseForsikringsBelopTekstfelt,"([0-9]{4,14})$","Forsikringspremie tillater 4-14 tall");
    Validator.valider(reiseForsikringsomradeTekstfelt,"^[a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]{2,16}?$","Forsikringsområde må være mellom 2-16 skandinaviske bokstaver og eller tall");
    Validator.valider(reiseArligForsikringspremieTekstfelt,"([0-9]{4,14})$","Forsikringspremie tillater 4-14 tall");


  }




  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }
  }

