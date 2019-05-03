package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.SkademeldingStatus;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.validering.SkademeldingValidator;
import programutvikling.validering.Validator;

public class VisSkademeldingSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedSkademeldingInfo {


  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();


  private Kunde kunde;
  private Skademelding skademelding;

  @FXML
  private Label statusLabel;
  @FXML
  private Label personNrLabel;
  @FXML
  private Label skadeDatoLabel;
  @FXML
  private Label klokkeslettLabel;
  @FXML
  private Label forsikringsTypeLabel;
  @FXML
  private Label skadeTypeLabel;
  @FXML
  private JFXTextField takseringsbelopTekstfelt;
  @FXML
  private JFXTextField utbetaltErstatningsbelopTekstfelt;
  @FXML
  private Label opprettelsesdatoLabel;
  @FXML
  private TextArea skadebeskrivelseTekstfelt;
  @FXML
  private TextArea ovrigInformasjonTekstfelt;
  @FXML
  private HBox godkjentAvvistKontainer;
  @FXML
  private JFXButton skademeldingLagreKnapp;
  @FXML
  private JFXButton redigerSkadeMeldingKnapp;
  @FXML
  private Hyperlink slettSkademeldingKnapp;


  private boolean erValideringOk() {

    return takseringsbelopTekstfelt.validate() == true &&
            utbetaltErstatningsbelopTekstfelt.validate() == true;


  }

  public void initialize() {

    Validator.validerFraTekstfelt(takseringsbelopTekstfelt, SkademeldingValidator.getUgyldigBelopRegex(), SkademeldingValidator.getUgyldigForsikringbelopFeilmelding());
    Validator.validerFraTekstfelt(utbetaltErstatningsbelopTekstfelt, SkademeldingValidator.getUgyldigBelopRegex(), SkademeldingValidator.getUgyldigForsikringbelopFeilmelding());

  }


  @FXML
  public void handleTilbakeKnapp() {

    NavigerTilVisKundeScene();


  }


  public void NavigerTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrLabel.setText(kunde.toString());

  }

  @Override
  public void setSkademelding(Skademelding skademelding) {

    this.skademelding = skademelding;

    statusLabel.setText(skademelding.getStatus().toString());
    skadeDatoLabel.setText(skademelding.getSkadeDato());
    klokkeslettLabel.setText(skademelding.getKlokkeSlett());
    forsikringsTypeLabel.setText(skademelding.getForsikringsType());
    skadeTypeLabel.setText(skademelding.getSkadeType());
    skadebeskrivelseTekstfelt.setText(skademelding.getSkadeBeskrivelse());
    ovrigInformasjonTekstfelt.setText(skademelding.getOvrigSkadeInformasjon());
    opprettelsesdatoLabel.setText(skademelding.getOpprettelsesDato());

    if (skademelding.getTakseringsbelop() != null) {
      takseringsbelopTekstfelt.setText(skademelding.getTakseringsbelop().toString());
    }

    if (skademelding.getUtbetaltErstatningsbelop() != null) {
      utbetaltErstatningsbelopTekstfelt.setText(skademelding.getUtbetaltErstatningsbelop().toString());

    }
    skjulSkademeldingKnapper();
  }


  public void handleLagreSkadeMelding() {


    if (erValideringOk()) {

      this.skademelding.setStatus(SkademeldingStatus.UNDER_BEHANDLING);

      Double takseringsBelop = Double.valueOf(takseringsbelopTekstfelt.getText());

      skademelding.setTakseringsbelop(takseringsBelop);

      Double utbetaltErstatningsBelop = Double.valueOf(utbetaltErstatningsbelopTekstfelt.getText());

      skademelding.setUtbetaltErstatningsbelop(utbetaltErstatningsBelop);
    }

  }


  @FXML
  public void handleLagreKnapp() {

    handleLagreSkadeMelding();

  }

  @FXML
  public void handleSkadeMeldingGodkjentKnapp() {

    if (erValideringOk()) {
      Double takseringsbelop = Double.valueOf(takseringsbelopTekstfelt.getText());
      Double utbetaltErstatningsbelop = Double.valueOf(utbetaltErstatningsbelopTekstfelt.getText());


      this.skademelding.setTakseringsbelop(takseringsbelop);
      this.skademelding.setUtbetaltErstatningsbelop(utbetaltErstatningsbelop);

      dho.getKundeMedSkademeldingListeHandling().godkjennSkademelding(skademelding);

      NavigerTilVisKundeScene();
    }


  }

  @FXML
  public void handleSkadeMeldingAvvistKnapp() {

    if (erValideringOk()) {
      Double takseringsbelop = Double.valueOf(takseringsbelopTekstfelt.getText());

      this.skademelding.setTakseringsbelop(takseringsbelop);
      dho.getKundeMedSkademeldingListeHandling().avvisSkademelding(skademelding);

      NavigerTilVisKundeScene();
    }


  }

  public void skjulSkademeldingKnapper() {

    if (skademelding.getStatus() == SkademeldingStatus.AVVIST || skademelding.getStatus() == SkademeldingStatus.GODKJENT) {
      godkjentAvvistKontainer.setVisible(false);
      skademeldingLagreKnapp.setVisible(false);
      takseringsbelopTekstfelt.setDisable(true);
      utbetaltErstatningsbelopTekstfelt.setDisable(true);
      redigerSkadeMeldingKnapp.setVisible(false);
    }

  }

  @FXML
  public void handleRedigerSkademeldingKnapp() {

    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getRedigerSkadeMeldingScene(), kunde, skademelding);

  }

  @FXML
  public void slettSkademeldingKnapp() {

    dho.getKundeMedSkademeldingListeHandling().slettSkademelding(skademelding, kunde);
    NavigerTilVisKundeScene();

  }


}
