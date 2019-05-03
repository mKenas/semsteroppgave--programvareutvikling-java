package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.SkademeldingStatus;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.SokeFelt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class SkademeldingListeKontroller {



  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  @FXML
  TableColumn<Skademelding, Button> visSkademeldingKnapp;
  private Kunde kunde;
  private Skademelding skademelding;
  private BorderPane borderPane = hsk.getBorderPane();

  private ObservableList<Skademelding> skademeldingListe;
  @FXML
  private TableView skademeldingTabell;
  @FXML
  TableColumn skademeldingNrKolonne;
  @FXML
  TableColumn skadeTypeKolonne;
  @FXML
  TableColumn takseringsbelopKolonne;

  @FXML
  TextField skademeldingFilterTesktfelt;

  public void initialize() {

    skademeldingTabell.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
    skademeldingNrKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 30 );
    skadeTypeKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    takseringsbelopKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );

    visSkademeldingKnapp.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );

    skademeldingTabell.setPlaceholder(new Label("Ingen skademelding er registrert ennå!"));



    skademeldingListe = dlo.getFiltrertSkademeldingListe();


    if (skademeldingListe.size() >= 1) {


      skademeldingTabell.getItems().setAll(skademeldingListe);

      leggTilVisSkademeldingKnapp();

    }


    skademeldingListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {

        forsikringEndret();
      }
    });

    SokeFelt sokeFelt = new SokeFelt(skademeldingTabell,skademeldingFilterTesktfelt,skademeldingListe,
            SokeFelt.getSkademeldingFilteringLogikk(skademeldingFilterTesktfelt));


  }


  private void forsikringEndret() {


    skademeldingTabell.getItems().setAll(skademeldingListe);

    leggTilVisSkademeldingKnapp();


  }


  private void leggTilVisSkademeldingKnapp() {

    visSkademeldingKnapp.setCellFactory(TabellKnapp.<Skademelding>genererKnapp(TabellKnapp.VIS_SKADEMELDING_IKONE, (s) -> {
      HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademelding = dlo.getKundeMedSkadeMeldingListe();

      this.skademelding = s;
      kunde = dho.getKundeMedSkademeldingListeHandling().finnSkademeldingsKunde(kundeMedSkademelding,s);


      navigerTilVisErstatningScene();

    }));

  }




  @FXML
  protected void navigerTilVisErstatningScene() {

    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }
}
