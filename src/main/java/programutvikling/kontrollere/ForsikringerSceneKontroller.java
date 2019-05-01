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
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;



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



  public void initialize() {

    forsikringTabell.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
    forsikringNrKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 30 );
    typeKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    belopKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    premieKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    visKnappKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );

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

    leggTilVisForsikringKnapp();


  }


  private void leggTilVisForsikringKnapp() {

    visKnappKolonne.setCellFactory(TabellKnapp.<Forsikring>genererKnapp(TabellKnapp.VIS_KUNDE_IKONE_STI, "vis-kunde-knapp", (f) -> {
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
