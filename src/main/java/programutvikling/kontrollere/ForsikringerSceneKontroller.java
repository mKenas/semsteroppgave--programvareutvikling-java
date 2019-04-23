package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;


public class ForsikringerSceneKontroller {


  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  @FXML
  TableColumn<Forsikring, Button> visForsikringKolonne;
  private Kunde kunde;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //private ObservableList<Kunde> kunderliste, kunderlisteFraFil;
  private ObservableList<Forsikring> forsikringerListe, forsikringerListeFraFil;
  @FXML
  private TableView forsikringTabell;

  public void initialize() {

    forsikringTabell.setPlaceholder(new Label("Ingen forsikringer er registrert ennå!"));


    forsikringerListe = dlo.getForsikringListe();


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


  }


  private void forsikringEndret() {


    forsikringTabell.getItems().setAll(forsikringerListe);

    //leggTilRedigerKnapp();


  }


  private void leggTilVisForsikringKnapp() {

    visForsikringKolonne.setCellFactory(TabellKnapp.<Forsikring>genererKnapp("\uf2c2", "vis-kunde-knapp", (f) -> {
      forsikring = f;
      kunde = dho.getKundeMedForsikringListeHandling().finnForsikringsEier(f);


      navigerTilVisForsikringScene();

    }));

  }


  @FXML
  protected void navigeringTilOpprettForsikringScene() {

    Navigator.visScene(borderPane, Navigator.getOPPRETT_FORSIKRING_SCENE());
  }

  @FXML
  protected void navigerTilVisForsikringScene() {

    Navigator.visSceneMedForsikringInfo(borderPane, Navigator.getVIS_HUS_OG_INNBO_FORSIKRING_SCENE(), kunde, forsikring);
  }


}
