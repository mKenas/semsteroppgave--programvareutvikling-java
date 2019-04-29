package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

public class OpprettFritidsboligSceneKontroller implements KontrollerMedKundeInfo {

  @FXML
  TextField boligensAdresseTekstfelt;
  @FXML
  TextField byggeArTekstfelt;
  @FXML
  TextField boligTypeTekstfelt;
  @FXML
  TextField byggeMaterialeTekstfelt;
  @FXML
  TextField standardTekstfelt;
  @FXML
  TextField antallkvadratmeterTekstfelt;
  @FXML
  TextField bygningForsikringsbelopTekstfelt;
  @FXML
  TextField innboForsikringsbelopTekstfelt;
  @FXML
  TextField forsikringsbelopTekstfelt;
  @FXML
  TextField forsikringspremieTekstfelt;
  DataHandlingObjekt dho = new DataHandlingObjekt();
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private Forsikring forsikring;
  @FXML
  private ComboBox kunderListeKomboboks;
  @FXML
  private TextField personNrTekstfelt;

  public void initialize() {

   /* kunderListe = dlo.getKunderListe().getKundeListe();
    kunderListeKomboboks.setItems(kunderListe);*/
    //kunderListeKomboboks.setEditable(true);
    //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);


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
    Double bygningForsikringsbelop = Double.valueOf(bygningForsikringsbelopTekstfelt.getText());
    Double innboForsikringsbelop = Double.valueOf(innboForsikringsbelopTekstfelt.getText());
    Double forsikringsbelop = Double.valueOf(forsikringsbelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(forsikringspremieTekstfelt.getText());


    System.out.println(forsikringsbelop);
    System.out.println(forsikringspremie);


    forsikring = new FritidsboligForsikring(forsikringsbelop, forsikringspremie, "",
            boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);

    //Forsikring<HusOgInnboForsikring> forsikring = new Forsikring<>(1.0,0.0,"");

    //kunde.leggTilForsikring(forsikring);
    dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
    // kunde må slettes fra liste hvis validering mislykkes!

    // dlo.getKunderListe().slettKunde(kunde);

    System.out.println("Fritidsbolig");


    NavigeringTilVisKundeScene();

  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }


}
