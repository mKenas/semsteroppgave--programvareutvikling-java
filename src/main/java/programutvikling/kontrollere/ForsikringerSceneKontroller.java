package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.Handling;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.SokeFelt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public class ForsikringerSceneKontroller {


  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private Kunde kunde;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  private ObservableList<Forsikring> forsikringerListe;
  @FXML
  private TableView forsikringTabell;
  @FXML
  TableColumn forsikringNrKolonne;
  @FXML
  TableColumn typeKolonne;
  @FXML
  TableColumn belopKolonne;
  @FXML
  TableColumn premieKolonne;
  @FXML
  TableColumn<Forsikring, Button> visKnappKolonne;
  @FXML
  TextField forsikringFilterTesktfelt;



  public void initialize() {





    forsikringTabell.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
    forsikringNrKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 30 );
    typeKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    belopKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    premieKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    visKnappKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );

    forsikringTabell.setPlaceholder(new Label("Ingen forsikringer er registrert ennå!"));


    forsikringerListe = dlo.getForsikringListe();
    System.out.println(forsikringerListe.size());


    if (forsikringerListe.size() >= 1) {


      forsikringTabell.getItems().setAll(forsikringerListe);

      leggTilVisForsikringKnapp();

    }


    forsikringerListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Forsikring liste Endret");
        forsikringEndret();
      }
    });



    SokeFelt sokeFelt = new SokeFelt(forsikringTabell,forsikringFilterTesktfelt,forsikringerListe,
            SokeFelt.getForsikringFilteringLogikk(forsikringFilterTesktfelt));

  }


  private void forsikringEndret() {

    for (Map.Entry<Kunde, ArrayList<Forsikring>> liste : dlo.getKundeMedForsikringListe().entrySet()) {
      System.out.println("Kunde");
      System.out.println(liste.getKey());
      System.out.println("forsikring");
      System.out.println(liste.getValue());}

    forsikringTabell.getItems().setAll(forsikringerListe);

    leggTilVisForsikringKnapp();




  }


  private void leggTilVisForsikringKnapp() {

    visKnappKolonne.setCellFactory(TabellKnapp.<Forsikring>genererKnapp(TabellKnapp.VIS_FORSIKRING_IKONE, (f) -> {


    HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikring = (HashMap<Kunde, ArrayList<Forsikring>>) dlo.getAllData().get("kundeMedForsikringListe");


      forsikring = f;
      kunde = dho.getKundeMedForsikringListeHandling().finnForsikringsEier(kundeMedForsikring,f);

      System.out.println(kunde);


      navigerTilVisForsikringScene();

    }));

  }


  @FXML
  protected void navigeringTilOpprettForsikringScene() {

    Navigator.visScene(borderPane, Navigator.getOPPRETT_FORSIKRING_SCENE());
  }

  @FXML
  protected void navigerTilVisForsikringScene() {



    Navigator.visSceneMedForsikringInfo(borderPane, Handling.VIS,forsikring, kunde );
  }


}
