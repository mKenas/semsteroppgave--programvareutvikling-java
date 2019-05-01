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
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.util.ArrayList;
import java.util.HashMap;

public class AvvistSkademeldingListeSceneKontroller {



  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  private Kunde kunde;
  private Skademelding skademelding;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //
  private ObservableList<Skademelding> avvistSkademeldingListe, forsikringerListeFraFil;
  @FXML
  private TableView avvistSkademeldingTabell;

  @FXML
  TableColumn skademeldingNrKolonne;
  @FXML
  TableColumn skadeTypeKolonne;
  @FXML
  TableColumn takseringsbelopKolonne;
  @FXML
  TableColumn<Skademelding, Button> visAvvistSkademeldingKolonne;


  public void initialize() {

    avvistSkademeldingTabell.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
    skademeldingNrKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 30 );
    skadeTypeKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    takseringsbelopKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    visAvvistSkademeldingKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );

    avvistSkademeldingTabell.setPlaceholder(new Label("Ingen avviste skademeldinger er registrert ennå!"));


    avvistSkademeldingListe = dho.getKundeMedSkademeldingListeHandling().getAvvistSkademeldingListe();


    if (avvistSkademeldingListe.size() >= 1) {


      avvistSkademeldingTabell.getItems().setAll(avvistSkademeldingListe);

      leggTilVisAvvistSkademelingKnapp();

    }


    avvistSkademeldingListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Forsikring liste Endret");
        forsikringEndret();
      }
    });


  }


  private void forsikringEndret() {


    avvistSkademeldingTabell.getItems().setAll(avvistSkademeldingListe);

   leggTilVisAvvistSkademelingKnapp();


  }


  private void leggTilVisAvvistSkademelingKnapp() {

    visAvvistSkademeldingKolonne.setCellFactory(TabellKnapp.<Skademelding>genererKnapp(TabellKnapp.VIS_KUNDE_IKONE_STI, "vis-kunde-knapp", (s) -> {
      HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademelding = (HashMap<Kunde, ArrayList<Skademelding>>) dlo.getAllData().get("kundeMedSkadeMeldingListe");

      this.skademelding = s;
      kunde = dho.getKundeMedSkademeldingListeHandling().finnSkademeldingsKunde(s);


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
