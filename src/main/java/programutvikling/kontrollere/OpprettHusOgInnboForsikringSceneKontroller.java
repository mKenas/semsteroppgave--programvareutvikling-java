package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.HusOgInnboForsikring;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class OpprettHusOgInnboForsikringSceneKontroller {
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
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataSourceObject dso = DataSourceObject.getInstance();
  private ObservableList kunderListe;
  @FXML
  private ComboBox kunderListeKomboboks;

  public void initialize() {

    kunderListe = dso.getKunderListe().getKunder();
    kunderListeKomboboks.setItems(kunderListe);
    //kunderListeKomboboks.setEditable(true);
    //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);


  }


  @FXML
  public void NavigeringTilHusOGInnboForsikringScene() {

    try {
      Navigator.visScene(borderPane, new Navigator().getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void handleOpprettHusOgInnboForsikringKnapp() {

    String boligensAdresse = boligensAdresseTekstfelt.getText();
    String byggeAr = byggeArTekstfelt.getText();
    String boligType = boligTypeTekstfelt.getText();
    String byggeMateriale = byggeMaterialeTekstfelt.getText();
    String standard = standardTekstfelt.getText();
    String antallkvadratmeter = antallkvadratmeterTekstfelt.getText();
    String bygningForsikringsbelop = bygningForsikringsbelopTekstfelt.getText();
    String innboForsikringsbelop = innboForsikringsbelopTekstfelt.getText();


    HusOgInnboForsikring forsikring = new HusOgInnboForsikring(0.0, 0.0, "",
            boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);


    String[] kundeNr = kunderListeKomboboks.getValue().toString().split(" ");
    System.out.println(kundeNr[0]);

    dso.getKunderListe().getKunder().forEach(kunde -> {


      if (kunde.getKundeNr().equals(kundeNr[0])) {
        kunde.leggTilForsikring(forsikring);
        dso.getForsikringerListe().leggTilForsikring(forsikring);
      }
    });


  }


}
