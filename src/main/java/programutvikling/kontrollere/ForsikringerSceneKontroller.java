package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;
import programutvikling.database.ForsikringerListe;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.io.IOException;

public class ForsikringerSceneKontroller {


  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private Kunde kunde;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //private ObservableList<Kunde> kunderliste, kunderlisteFraFil;
  private ObservableList<Forsikring> forsikringerListe,forsikringerListeFraFil;


  @FXML
  TableColumn<Forsikring, Void> redigerKolonne;
  @FXML
  TableColumn<Forsikring, Button> slettKolonne;
  @FXML
  TableColumn<Forsikring, Void> visForsikringKolonne;

  @FXML
  private TableView tableview;

  public void initialize() {

    System.out.println(dso.getForsikringerListe().getForsikringer());

    if (forsikringerListeFraFil != null) {
      if (forsikringerListe.size() > 0) {

        dso.getForsikringerListe().setForsikringer(forsikringerListeFraFil);


        forsikringEndret();
        System.out.println("forsikringerListe: " + forsikringerListe);

      }
    }

    forsikringerListe = dso.getForsikringerListe().getForsikringer();



    if (forsikringerListe.size() == 0) {
      tableview.setPlaceholder(new Label("Ingen forsikringer er registrert ennå!"));

    }
    if (forsikringerListe.size() >= 1) {


      tableview.getItems().setAll(forsikringerListe);
      //leggTilRedigerKnapp();
      leggTilSlettKnapp();
      //leggTilVisKundeKnapp();

    }


    forsikringerListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Endret");
        forsikringEndret();
      }
    });


  }


  private void forsikringEndret() {


    tableview.getItems().setAll(forsikringerListe);

    //leggTilRedigerKnapp();
    leggTilSlettKnapp();

  }


  private void leggTilSlettKnapp() {



    slettKolonne.setCellFactory(TabellKnapp.<Forsikring>genererKnapp("\uf00d", "slett-knapp",(Forsikring f) -> {
      dso.getForsikringerListe().slettlForsikring(f);
      dso.getKunderListe().slettlForsikring(f);
      tableview.getItems().remove(f);

    }));

  }

  private void leggTilRedigerKnapp() {


  }

  private void leggTilVisKundeKnapp() {



  }


  protected void NavigeringTilRedigerKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getREDIGER_KUNDE_SCENE(), kunde);
  }

    @FXML
    protected void NavigeringTilOpprettForsikringScene () {

      Navigator.visScene(borderPane, Navigator.getOPPRETT_FORSIKRING_SCENE());
    }


}
