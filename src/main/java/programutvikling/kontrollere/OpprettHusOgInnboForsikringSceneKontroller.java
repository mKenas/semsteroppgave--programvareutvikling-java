package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class OpprettHusOgInnboForsikringSceneKontroller implements KontrollerMedKundeInfo{
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

  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataSourceObject dso = DataSourceObject.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private Forsikring forsikring;
  @FXML
  private ComboBox kunderListeKomboboks;
  @FXML
  private TextField personNrTekstfelt;

  public void initialize() {

   /* kunderListe = dso.getKunderListe().getKunder();
    kunderListeKomboboks.setItems(kunderListe);*/
    //kunderListeKomboboks.setEditable(true);
    //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);


  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());



  }

  @FXML
  public void NavigeringTilHusOGInnboForsikringScene() {

    Navigator.visScene(borderPane, Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE());

  }

  public void handleOpprettHusOgInnboForsikringKnapp() {
    boolean kundeEksisterer = false;
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


    forsikring = new HusOgInnboForsikring(forsikringsbelop, forsikringspremie, "",
           boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);

    //Forsikring<HusOgInnboForsikring> forsikring = new Forsikring<>(1.0,0.0,"");

    kunde.leggTilForsikring(forsikring);
    // kunde må slettes fra liste hvis validering mislykkes!

     // dso.getKunderListe().slettlKunde(kunde);




    NavigeringTilVisKundeScene();

  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(),kunde);

  }


}
