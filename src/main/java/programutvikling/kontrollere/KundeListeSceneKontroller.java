package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.SokeFelt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;
import programutvikling.status.InnlesingOgSkrivingStatus;


public class KundeListeSceneKontroller {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  @FXML
  TableColumn personNrKolonne;
  @FXML
  TableColumn navnKolonne;
  @FXML
  TableColumn etterNavnKolonne;
  @FXML
  TableColumn fakturaAdresseKolonne;
  @FXML
  TableColumn<Kunde, Button> visKundeKolonne;
  private Kunde kunde;
  private BorderPane borderPane = hsk.getBorderPane();
  private ObservableList<Kunde> kunderliste;
  @FXML
  private TableView kunderTabell;
  @FXML
  private TextField kunderFilterTesktfelt;

  @FXML
  private JFXButton registrerKundeKnapp;

  public void initialize() {

    registrerKundeKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());
    kunderTabell.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    personNrKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 20);
    navnKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 20);
    etterNavnKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 20);
    fakturaAdresseKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 30);
    visKundeKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 10);


    kunderTabell.setPlaceholder(new Label("Ingen kunder er registrert ennå!"));

    kunderliste = dlo.getKundeListe();


    if (kunderliste.size() >= 1) {

      kunderTabell.getItems().setAll(kunderliste);

      leggTilVisKundeKnapp();

    }


    kunderliste.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        kundeEndret();
      }
    });


    SokeFelt sokeFelt = new SokeFelt(kunderTabell, kunderFilterTesktfelt, kunderliste, SokeFelt.getKundeFilteringLogikk(kunderFilterTesktfelt));


  }


  private void kundeEndret() {

    kunderTabell.getItems().setAll(kunderliste);

    leggTilVisKundeKnapp();

  }


  private void leggTilVisKundeKnapp() {

    visKundeKolonne.setCellFactory(TabellKnapp.genererKnapp(TabellKnapp.VIS_KUNDE_IKONE, (Kunde k) -> {

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
