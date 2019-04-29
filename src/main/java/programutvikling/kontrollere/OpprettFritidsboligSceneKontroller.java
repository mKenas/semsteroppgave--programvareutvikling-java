package programutvikling.kontrollere;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.validering.Validator;

public class OpprettFritidsboligSceneKontroller implements KontrollerMedKundeInfo {

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

  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());


  }


  public void handleOpprettFritidsboligForsikringKnapp() {

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


    System.out.println(forsikringsbelop);
    System.out.println(forsikringspremie);


    forsikring = new FritidsboligForsikring(forsikringsbelop, forsikringspremie, "",
            boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);

    //Forsikring<HusOgInnboForsikring> forsikring = new Forsikring<>(1.0,0.0,"");

    //kunde.leggTilForsikring(forsikring);

    // kunde må slettes fra liste hvis validering mislykkes!

    // dlo.getKunderListe().slettKunde(kunde);




    if(boligensAdresseTekstfelt.validate() == true &&
            byggeArTekstfelt.validate() == true &&
            boligTypeTekstfelt.validate() == true &&
            byggeMaterialeTekstfelt.validate() == true &&
            standardTekstfelt.validate() == true &&
            antallkvadratmeterTekstfelt.validate() == true &&
            bygningForsikringsbelopTekstfelt.validate() == true &&
            innboForsikringsbelopTekstfelt.validate() == true &&
            forsikringsbelopTekstfelt.validate() == true &&
            forsikringspremieTekstfelt.validate() == true) {

    }
      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();
    System.out.println("Fritidsbolig");
  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


}
