package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import programutvikling.base.*;
import programutvikling.base.klassHjelpere.SkademeldingStatus;
import programutvikling.database.DataSourceObject;

public  class VisSkademeldingSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedSkademeldingInfo {


  DataSourceObject dso = DataSourceObject.getInstance();
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
  private TextField takseringsbelopTekstfelt;
  @FXML
  private TextField utbetaltErstatningsbelopTekstfelt;
  @FXML
  private Label opprettelsesdatoLabel;
  @FXML
  private TextArea skadebeskrivelseTekstfelt;
  @FXML
  private TextArea ovrigInformasjonTekstfelt;

  @FXML
  private HBox godkjentAvvistKontainer;

  @FXML
  private Button skademeldingLagreKnapp;

  @FXML
  private Button redigerSkadeMeldingKnapp;


/*  @FXML
  private RadioButton godkjentRadioKnapp;
  @FXML
  private RadioButton avissRadioKnapp;

  @FXML
  private RadioButton underBehandlingRadioKnapp;*/




  public void initialize() {


  }



  @FXML
  public void handleTilbakeKnapp() {

    NavigerTilVisKundeScene();


  }

  protected void NavigeringTilKunderScene() {
    Navigator.visScene(borderPane, Navigator.getKunderScene());

  }

  public void NavigerTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrLabel.setText(kunde.getPersonNr());

  }

  @Override
  public void setSkademelding(Skademelding skademelding) {

    this.skademelding = skademelding;

    statusLabel.setText(skademelding.getStatus().toString());
    skadeDatoLabel.setText(skademelding.getSkadeDato());
    klokkeslettLabel.setText(skademelding.getKlokkeSlett());
    forsikringsTypeLabel.setText(skademelding.getForsikringsType());
    skadeTypeLabel.setText(skademelding.getSkadeType());
    skadebeskrivelseTekstfelt.setText(skademelding.getOvrigSkadeInformasjon());
    ovrigInformasjonTekstfelt.setText(skademelding.getOvrigSkadeInformasjon());
    opprettelsesdatoLabel.setText(skademelding.getOpprettelsesDato());

    if (skademelding.getTakseringsbelop() != null ) {
      takseringsbelopTekstfelt.setText(skademelding.getTakseringsbelop().toString());
    }

    if (skademelding.getUtbetaltErstatningsbelop() != null) {
      utbetaltErstatningsbelopTekstfelt.setText(skademelding.getUtbetaltErstatningsbelop().toString());

    }

    skjulSkademeldingKnapper();
  }


  public void godkjennSkadeMelding(){


    Double takseringsbelop = Double.valueOf(takseringsbelopTekstfelt.getText());
    Double utbetaltErstatningsbelop = Double.valueOf(utbetaltErstatningsbelopTekstfelt.getText());
    this.skademelding.setTakseringsbelop(takseringsbelop);
    this.skademelding.setUtbetaltErstatningsbelop(utbetaltErstatningsbelop);

    kunde.godkjennSkademelding(skademelding);



  }
  public void avvisSkademelding(){

    Double takseringsbelop = Double.valueOf(takseringsbelopTekstfelt.getText());
    this.skademelding.setTakseringsbelop(takseringsbelop);
    kunde.avvisSkademelding(skademelding);

  }

  public void handleLagreSkadeMelding() {

    this.skademelding.setStatus(SkademeldingStatus.UNDER_BEHANDLING);

    Double takseringsBelop = Double.valueOf(takseringsbelopTekstfelt.getText());

    skademelding.setTakseringsbelop(takseringsBelop);

    Double utbetaltErstatningsBelop = Double.valueOf(utbetaltErstatningsbelopTekstfelt.getText());

    skademelding.setUtbetaltErstatningsbelop(utbetaltErstatningsBelop);

  }


  @FXML
  public void handleAvslaSkademeldingKnapp(){


  }

  @FXML
  public void handleLagreKnapp(){

    handleLagreSkadeMelding();

  }

  @FXML
  public void handleSkadeMeldingGodkjentKnapp() {

    godkjennSkadeMelding();
    NavigerTilVisKundeScene();

  }

  @FXML
  public void handleSkadeMeldingAvvistKnapp() {

    avvisSkademelding();
    NavigerTilVisKundeScene();
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

    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getRedigerSkadeMeldingScene(),kunde,skademelding);


  }


  //TODO logikk slik at man ikke kan godkjenne også avvise samme skademelding og få to versjoner av samme.

}
