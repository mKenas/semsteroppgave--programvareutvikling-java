package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

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
  private RadioButton godkjentRadioKnapp;
  @FXML
  private RadioButton avissRadioKnapp;

  @FXML
  private RadioButton underBehandlingRadioKnapp;




  public void initialize() {


  }



  @FXML
  public void handleTilbakeKnapp() {



    NavigeringTilKunderScene();
  }

  protected void NavigeringTilKunderScene() {
    Navigator.visScene(borderPane, Navigator.getKunderScene());

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

  }


  public void handleGodkjennSkademeldingKnapp(){

    System.out.println(kunde);
    Double takseringsbelop = Double.valueOf(takseringsbelopTekstfelt.getText());
    Double utbetaltErstatningsbelop = Double.valueOf(utbetaltErstatningsbelopTekstfelt.getText());
    this.skademelding.setTakseringsbelop(takseringsbelop);
    this.skademelding.setUtbetaltErstatningsbelop(utbetaltErstatningsbelop);

    kunde.godkjennSkademelding(skademelding);



  }
  public void handleAvvisSkademelding(){

    kunde.avvisSkademelding(skademelding);
  }

  @FXML
  public void handleAvslaSkademeldingKnapp(){


  } @FXML
  public void handleLagreKnapp(){

    if (godkjentRadioKnapp.isSelected())
    {
      handleGodkjennSkademeldingKnapp();
    }
    else if (avissRadioKnapp.isSelected()){

      handleAvvisSkademelding();
    }

    else if (underBehandlingRadioKnapp.isSelected())
    {
      //handleLagreSkadeMelding();
    }


  }
}
