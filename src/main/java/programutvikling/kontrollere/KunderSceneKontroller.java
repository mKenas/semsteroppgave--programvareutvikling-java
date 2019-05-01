package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.SokeFelt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.util.function.Predicate;


public class KunderSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  @FXML
  TableColumn<Kunde, Button> visKundeKolonne;
  @FXML
  TableColumn personNrKolonne;
  @FXML
  TableColumn navnKolonne;
  @FXML
  TableColumn etterNavnKolonne;
  @FXML
  TableColumn fakturaAdresseKolonne;

  private Kunde kunde;
  private BorderPane borderPane = hsk.getBorderPane();
  private ObservableList<Kunde> kunderliste, kunderlisteFraFil;
  @FXML
  private TableView kunderTabell;

  @FXML
  private TextField KunderFilterTesktfelt;

  public void initialize() {


    kunderTabell.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
    personNrKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    navnKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    etterNavnKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    fakturaAdresseKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 30 );
    visKundeKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );


    kunderTabell.setPlaceholder(new Label("Ingen kunder er registrert ennå!"));

    kunderliste = dlo.getKundeListe();


    if (kunderliste.size() >= 1) {

      kunderTabell.getItems().setAll(kunderliste);

      leggTilVisKundeKnapp();

    }


    kunderliste.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Endret");
        kundeEndret();
      }
    });


    /***Filtring***/

    Predicate<Kunde> betingelse =   new Predicate<Kunde>() {
      @Override
      public boolean test(Kunde kunde) {
        if (kunde.getPersonNr().contains(KunderFilterTesktfelt.getText()) || kunde.getNavn().contains(KunderFilterTesktfelt.getText())) {
          return true;
        }
        return false;
      }

    };



    SokeFelt sokeFelt = new SokeFelt(kunderTabell,KunderFilterTesktfelt,kunderliste,betingelse);
   /*  FilteredList<Kunde> filtrertListe = new FilteredList<>(kunderliste);




   KunderFilterTesktfelt.textProperty().addListener((observable, oldValue, newValue) -> {
      filtrertListe.setPredicate(
              new Predicate<Kunde>() {
                @Override
                public boolean test(Kunde kunde) {
                  if (kunde.getPersonNr().contains(KunderFilterTesktfelt.getText()) || kunde.getNavn().contains(KunderFilterTesktfelt.getText())) {
                    return true;
                  }
                  return false;
                }

              }

      );

      kunderliste = FXCollections.observableArrayList(filtrertListe);

      kunderTabell.setItems(FXCollections.observableList(kunderliste));

    });*/

  }


  private void kundeEndret() {


    kunderTabell.getItems().setAll(kunderliste);


    leggTilVisKundeKnapp();

  }





  private void leggTilVisKundeKnapp() {


    visKundeKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp(TabellKnapp.VIS_KUNDE_IKONE_STI, "vis-kunde-knapp", (Kunde k) -> {
      //
      kunde = k;
      NavigeringTilVisKundeScene();
    }));

  }


  protected void NavigeringTilRedigerKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getREDIGER_KUNDE_SCENE(), kunde);
  }

  protected void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);
  }

  @FXML
  protected void handleRegistrerKundeKnapp() {

    this.NavigeringTilRegistrerKundeScene();


  }


  protected void NavigeringTilRegistrerKundeScene() {

    Navigator.visScene(borderPane, Navigator.getRegistrerKundeScene());

  }

}
