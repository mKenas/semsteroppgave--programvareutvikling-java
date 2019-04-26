package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class RegistrerKundeSceneKontroller {


  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  Kunde kunde;
  String forsikringsType;
  private BorderPane borderPane = hsk.getBorderPane();
  @FXML
  private TextField personNrTekstFelt;
  @FXML
  private TextField navnTekstFelt;
  @FXML
  private TextField etternavnTekstFelt;
  @FXML
  private TextField fakturaadresseTekstFelt;
  @FXML
  private TextField postnummerTekstFelt;
  @FXML
  private TextField poststedTekstFelt;
  @FXML
  private TextField epostTekstFelt;
  @FXML
  private TextField mobilTekstFelt;
  @FXML
  private ComboBox forsikringsTypeKomboBoks;

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

   /* ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    //Kunde k = new Kunde("","","","","","","","");

    Set<ConstraintViolation<Kunde>> violations = validator.validate(k);

    for (ConstraintViolation<Kunde> violation : violations) {
      System.out.println(violation.getMessage());
    }
*/

    dhl.getKundeListeHandling().leggTilKunde(kunde);
    navigeringTilOpprettForsikringScene();


  }


  protected void navigeringTilOpprettForsikringScene() {
    System.out.println(forsikringsType);

    Navigator.visForsikringSceneMedKundeInfo(borderPane, forsikringsType, kunde);

  }
}
