package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.ReiseForsikring;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
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
    personNrTekstfelt.setText(kunde.toString());

  }


  @FXML
  public void handleOpprettKnapp() {

    Double forsikringsbelop = Double.valueOf(reiseForsikringsBelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(reiseArligForsikringspremieTekstfelt.getText());
    String forsikringsbetingelser = "";
    Double forsikringssum = Double.valueOf(reiseForsikringssumTekstfelt.getText());
    String forsikringsomrade = reiseForsikringsomradeTekstfelt.getText();

    forsikring = new ReiseForsikring(forsikringsbelop, forsikringspremie,"", forsikringsomrade, forsikringssum);

    if(reiseForsikringssumTekstfelt.validate() == true &&
            reiseForsikringsBelopTekstfelt.validate() == true &&
            reiseForsikringsomradeTekstfelt.validate() == true &&
            reiseArligForsikringspremieTekstfelt.validate() == true) {

      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();
    }
  }




  public void initialize() {




    Validator.valider(reiseForsikringssumTekstfelt,"([0-9]{4,14})$","Forsikringssum tillater 4-14 tall");
    Validator.valider(reiseForsikringsBelopTekstfelt,"([0-9]{4,14})$","Forsikringsbeløp tillater 4-14 tall");
    Validator.valider(reiseForsikringsomradeTekstfelt,"^[a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]{2,16}?$","Forsikringsområde må være mellom 2-16 skandinaviske bokstaver og eller tall");
    Validator.valider(reiseArligForsikringspremieTekstfelt,"([0-9]{4,14})$","Forsikringspremie tillater 4-14 tall");


  }


 /* private void validerReiseForsikringoFelt() {

    nullstillValideringStatus();


    validerFeltVedInnlastingAvScene();


    validerFeltVedEndringAvInnputt();


    bindeKanppAkriveringTilValideringStatus();

  }

  private void bindeKanppAkriveringTilValideringStatus() {
    opprettForsikringKnapp.disableProperty().bind(
            InnboOgfritidValideringStatus.erAdresseGyldig().not()
                    .or(InnboOgfritidValideringStatus.erByggeArGyldig().not())
                    .or(InnboOgfritidValideringStatus.erBoligTypeGyldig().not())
                    .or(InnboOgfritidValideringStatus.erbyggeMaterialeGyldig().not())
                    .or(InnboOgfritidValideringStatus.erBoligStanderGyldig().not())
                    .or(InnboOgfritidValideringStatus.erAntallKvadratmeterGyldig().not())
                    .or(InnboOgfritidValideringStatus.erByggningsbelopGyldig().not())
                    .or(InnboOgfritidValideringStatus.erInnbobelopGyldig().not())
                    .or(InnboOgfritidValideringStatus.erforsikringbelopGyldig().not())
                    .or((InnboOgfritidValideringStatus.getForsikringspremieGyldig().not()))
    );
  }

  private void validerFeltVedEndringAvInnputt() {

  }

  private void validerFeltVedInnlastingAvScene() {

  }

  private void nullstillValideringStatus() {

    InnboOgfritidValideringStatus.erAdresseGyldig().set(false);
    InnboOgfritidValideringStatus.erByggeArGyldig().set(false);
    InnboOgfritidValideringStatus.erBoligTypeGyldig().set(false);
    InnboOgfritidValideringStatus.erbyggeMaterialeGyldig().set(false);
    InnboOgfritidValideringStatus.erBoligStanderGyldig().set(false);
    InnboOgfritidValideringStatus.erAntallKvadratmeterGyldig().set(false);
    InnboOgfritidValideringStatus.erByggningsbelopGyldig().set(false);
    InnboOgfritidValideringStatus.erInnbobelopGyldig().set(false);
    InnboOgfritidValideringStatus.erforsikringbelopGyldig().set(false);
    InnboOgfritidValideringStatus.getForsikringspremieGyldig().set(false);
  }*/


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }
  }

