package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.SokeFelt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.util.ArrayList;
import java.util.HashMap;

public class AvvistSkademeldingListeSceneKontroller {


  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  @FXML
  TableColumn skademeldingNrKolonne;
  @FXML
  TableColumn skadeTypeKolonne;
  @FXML
  TableColumn takseringsbelopKolonne;
  @FXML
  TableColumn<Skademelding, Button> visAvvistSkademeldingKolonne;
  @FXML
  TextField skademeldingFilterTesktfelt;
  private Kunde kunde;
  private Skademelding skademelding;
  private BorderPane borderPane = hsk.getBorderPane();
  private ObservableList<Skademelding> avvistSkademeldingListe;
  @FXML
  private TableView avvistSkademeldingTabell;

  public void initialize() {

    avvistSkademeldingTabell.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    skademeldingNrKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 30);
    skadeTypeKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 20);
    takseringsbelopKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 20);
    visAvvistSkademeldingKolonne.setMaxWidth(1f * Integer.MAX_VALUE * 10);

    avvistSkademeldingTabell.setPlaceholder(new Label("Ingen avviste skademeldinger er registrert ennå!"));


    avvistSkademeldingListe = dlo.getAvvisteSkademeldingListe();


    if (avvistSkademeldingListe.size() >= 1) {


      avvistSkademeldingTabell.getItems().setAll(avvistSkademeldingListe);

      leggTilVisAvvistSkademelingKnapp();

    }


    avvistSkademeldingListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {

        forsikringEndret();
      }
    });


    SokeFelt sokeFelt = new SokeFelt(avvistSkademeldingTabell, skademeldingFilterTesktfelt, avvistSkademeldingListe,
            SokeFelt.getSkademeldingFilteringLogikk(skademeldingFilterTesktfelt));


  }


  private void forsikringEndret() {


    avvistSkademeldingTabell.getItems().setAll(avvistSkademeldingListe);

    leggTilVisAvvistSkademelingKnapp();


  }


  private void leggTilVisAvvistSkademelingKnapp() {

    visAvvistSkademeldingKolonne.setCellFactory(TabellKnapp.genererKnapp(TabellKnapp.VIS_AVVIST_SKADEMELDING_IKONE, (s) -> {
      HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademelding = dlo.getKundeMedSkadeMeldingListe();

      this.skademelding = s;
      kunde = dho.getKundeMedSkademeldingListeHandling().finnSkademeldingsKunde(kundeMedSkademelding, s);


      navigerTilVisErstatningScene();

    }));

  }


  @FXML
  protected void navigeringTilOpprettForsikringScene() {

    Navigator.visScene(borderPane, Navigator.getOPPRETT_FORSIKRING_SCENE());
  }

  @FXML
  protected void navigerTilVisErstatningScene() {

    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }
}
