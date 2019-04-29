package programutvikling.kontrollere;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.validering.Validator;


public class RegistrerKundeSceneKontroller {


  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  Kunde kunde;
  String forsikringsType;
  private BorderPane borderPane = hsk.getBorderPane();
  @FXML
  private JFXTextField personNrTekstFelt;
  @FXML
  private JFXTextField navnTekstFelt;
  @FXML
  private JFXTextField etternavnTekstFelt;
  @FXML
  private JFXTextField fakturaadresseTekstFelt;
  @FXML
  private JFXTextField postnummerTekstFelt;
  @FXML
  private JFXTextField poststedTekstFelt;
  @FXML
  private JFXTextField epostTekstFelt;
  @FXML
  private JFXTextField mobilTekstFelt;
  @FXML
  private JFXComboBox forsikringsTypeKomboBoks;

  @FXML
  private void handleRegistrerKundeKnapp() {
    String personNr = personNrTekstFelt.getText();
    String navn = navnTekstFelt.getText();
    String etternavn = etternavnTekstFelt.getText();
    String fakturaadresse = fakturaadresseTekstFelt.getText();
    String postnummer = postnummerTekstFelt.getText();
    String poststed = poststedTekstFelt.getText();
    String epost = epostTekstFelt.getText();
    String mobil = mobilTekstFelt.getText();

    kunde = new Kunde(personNr, navn, etternavn, epost, mobil, fakturaadresse, postnummer, poststed);
    forsikringsType = forsikringsTypeKomboBoks.getSelectionModel().getSelectedItem().toString();



    if (personNrTekstFelt.validate() == true /*&&
            navnTekstFelt.validate() == true &&
            etternavnTekstFelt.validate() == true &&
            fakturaadresseTekstFelt.validate() == true &&
            postnummerTekstFelt.validate() == true &&
            epostTekstFelt.validate() == true &&
            mobilTekstFelt.validate() == true*/     ) {
      dhl.getKundeListeHandling().leggTilKunde(kunde);
      navigeringTilOpprettForsikringScene();
    }
  }

  public void initialize() {





    Validator.valider(personNrTekstFelt,"^[0-9]{11}$","Personnummer tillater kun 11 tall");
/*  Validator.valider(navnTekstFelt,"^[a-zA-ZäöæøåøÄÖÆØÅ]{2,16}$","Navnet må være mellom 2-16 skandinaviske bokstaver");
    Validator.valider(etternavnTekstFelt,"^[a-zA-ZäöæøåøÄÖÆØÅ]{2,16}$","Etternavnet må være mellom 2-16 skandinaviske bokstaver");
    Validator.valider(fakturaadresseTekstFelt,"^[0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,36}$","Adressen må være mellom 2-36 skandinaviske bokstaver");
    Validator.valider(postnummerTekstFelt,"^[0-9]{4}","Postnummeret må være på 4 tall");
    Validator.valider(poststedTekstFelt,"^[a-zA-ZäöæøåøÄÖÆØÅ]{2,18}$","Poststedet må være på 2-18 bokstaver");
    Validator.valider(epostTekstFelt,"^[a-zA-Z0-9]+@[a-zA-Z0-9]{0,42}$","Poststedet må være på 2-18 bokstaver");
    Validator.valider(mobilTekstFelt,"^[0-9]{8}$","Telefonnummer må være på 8 tall");*/

  }


  protected void navigeringTilOpprettForsikringScene() {
    System.out.println(forsikringsType);
    Navigator.visForsikringSceneMedKundeInfo(borderPane, forsikringsType, kunde);

  }
}
