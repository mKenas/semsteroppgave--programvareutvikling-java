package programutvikling.kontrollere;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.validering.Validator;

import java.util.ArrayList;

public class RedigerFritidsboligForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private ArrayList<Forsikring> forsikringer;
  private FritidsboligForsikring forsikring;

  private Kunde kunde;


  @FXML
  JFXTextField boligensAdresseTekstfelt;
  @FXML
  JFXTextField byggeArTekstfelt;
  @FXML
  JFXTextField boligTypeTekstfelt;
  @FXML
  JFXTextField byggeMaterialeTekstfelt;
  @FXML
  JFXTextField standardTekstfelt;
  @FXML
  JFXTextField antallkvadratmeterTekstfelt;
  @FXML
  JFXTextField bygningForsikringsbelopTekstfelt;
  @FXML
  JFXTextField innboForsikringsbelopTekstfelt;
  @FXML
  JFXTextField forsikringsbelopTekstfelt;
  @FXML
  JFXTextField forsikringspremieTekstfelt;
  @FXML
  private JFXTextField personNrTekstfelt;
  @FXML
  private JFXComboBox kunderListeKomboboks;



  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrTekstfelt.setText(kunde.getPersonNr());

  }


  @Override
  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof FritidsboligForsikring) {
      FritidsboligForsikring f = (FritidsboligForsikring) forsikring;

      this.forsikring = f;
      //personNrLabel.setText(f);
      boligensAdresseTekstfelt.setText(f.getBoligAdresse());
      byggeArTekstfelt.setText(f.getByggeaar());
      boligTypeTekstfelt.setText(f.getBoligType());
      byggeMaterialeTekstfelt.setText(f.getByggeMateriale());
      standardTekstfelt.setText(f.getStandard());
      antallkvadratmeterTekstfelt.setText(f.getStorrelse());
      bygningForsikringsbelopTekstfelt.setText(String.valueOf(f.getInnboForsikringsbelop()));
      innboForsikringsbelopTekstfelt.setText(String.valueOf(f.getInnboForsikringsbelop()));
      forsikringsbelopTekstfelt.setText(String.valueOf(f.getBygningsForsikringsbelop()));
      forsikringspremieTekstfelt.setText(String.valueOf(f.getForsikringspremie()));

    }

  }


  @FXML
  public void handleTilbakeKnapp() {

    NavigeringTilKunderScene();

  }

  protected void NavigeringTilKunderScene() {
    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }


/*  @FXML
  public void handleSlettForsikringKnapp() {

    dho.getKundeMedForsikringListeHandling().slettForsikring(forsikring, kunde);
    navigeringTilKunderScene();

  }*/

  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

/*  public void initialize() {

   *//* kunderListe = dlo.getKunderListe().getKundeListe();
    kunderListeKomboboks.setItems(kunderListe);*//*
    //kunderListeKomboboks.setEditable(true);
    //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);




  }*/


  public void handleRedigerFritidsboligForsikringKnapp() {

    String boligensAdresse = boligensAdresseTekstfelt.getText();
    String byggeAr = byggeArTekstfelt.getText();
    String boligType = boligTypeTekstfelt.getText();
    String byggeMateriale = byggeMaterialeTekstfelt.getText();
    String standard = standardTekstfelt.getText();
    String antallkvadratmeter = antallkvadratmeterTekstfelt.getText();
    String bygningForsikringsbelop = bygningForsikringsbelopTekstfelt.getText();
    String innboForsikringsbelop = innboForsikringsbelopTekstfelt.getText();
    Double forsikringsbelop = Double.valueOf(forsikringsbelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(forsikringspremieTekstfelt.getText());



    //Forsikring<HusOgInnboForsikring> forsikring = new Forsikring<>(1.0,0.0,"");
    //kunde.leggTilForsikring(forsikring);

    // kunde må slettes fra liste hvis validering mislykkes!
    // dlo.getKunderListe().slettKunde(kunde);




      forsikring.setBoligAdresse(boligensAdresse);
      forsikring.setByggeaar(byggeAr);
      forsikring.setBoligType(boligType);
      forsikring.setByggeMateriale(byggeMateriale);
      forsikring.setStandard(standard);
      forsikring.setStorrelse(antallkvadratmeter);
      forsikring.setBygningsForsikringsbelop(bygningForsikringsbelop);
      forsikring.setInnboForsikringsbelop(innboForsikringsbelop);
      forsikring.setForsikringsbelop(forsikringsbelop);
      forsikring.setForsikringspremie(forsikringspremie);

      NavigeringTilVisKundeScene();
    }


  public void initialize() {

    Validator.valider(boligensAdresseTekstfelt,"^[0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,36}$","Adressen må være mellom 2-36 skandinaviske bokstaver");
    Validator.valider(byggeArTekstfelt,"^(18[0-9]\\d|19[0-9]\\d|20[01]\\d)?$","Boligen må være bygget mellom 1800-tallet til dags dato");
    Validator.valider(boligTypeTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$","Boligtypen må være mellom 2 til 20 bosktaver");
    Validator.valider(byggeMaterialeTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$","Byggemateriale må være mellom 2 til 20 bosktaver");
    Validator.valider(standardTekstfelt,"^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$","Byggemateriale må være mellom 2 til 20 bosktaver");
    Validator.valider(antallkvadratmeterTekstfelt,"^([0-9]{2,4})$","Antall kvadratmeter tillater kun 2-4 tall");
    Validator.valider(bygningForsikringsbelopTekstfelt,"([0-9]{4,14})$","Bygningensforsikringsbeløp tillater 4-14 tall");
    Validator.valider(innboForsikringsbelopTekstfelt,"([0-9]{4,14})$","Innboforsikringsbeløp tillater 4-14 tall");
    Validator.valider(forsikringsbelopTekstfelt,"([0-9]{4,14})$","Forsikringsbeløp tillater 4-14 tall");
    Validator.valider(forsikringspremieTekstfelt,"([0-9]{4,14})$","Forsikringspremie tillater 4-14 tall");

  //TODO gå igjennom uednret versjon, finne hvilke felter som trenger validering og ikke, samt endre focusproperty slik at man ikke får feil med mindre man taster feil.

  }


}
