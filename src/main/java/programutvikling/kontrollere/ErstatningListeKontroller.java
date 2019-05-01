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

public class ErstatningListeKontroller {



  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  private Kunde kunde;
  private Skademelding skademelding;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //
  private ObservableList<Skademelding> erstatningListe, forsikringerListeFraFil;
  @FXML
  private TableView erstatningTabell;

  @FXML
  TableColumn skademeldingNrKolonne;
  @FXML
  TableColumn skadeTypeKolonne;
  @FXML
  TableColumn takseringsbelopKolonne;
  @FXML
  TableColumn utbetaltBelopKolonne;
  @FXML
  TableColumn<Skademelding, Button> visErstatningKolonne;


  public void initialize() {


    erstatningTabell.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
    skademeldingNrKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 30 );
    skadeTypeKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    takseringsbelopKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    utbetaltBelopKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 20 );
    visErstatningKolonne.setMaxWidth( 1f * Integer.MAX_VALUE * 10 );

    erstatningTabell.setPlaceholder(new Label("Ingen erstatning er registrert ennå!"));


    erstatningListe = dho.getKundeMedSkademeldingListeHandling().getErstatningListe();


    if (erstatningListe.size() >= 1) {


      erstatningTabell.getItems().setAll(erstatningListe);

      leggTilVisErstatningKnapp();

    }


    erstatningListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("erstatning liste Endret");
        erstatningEndret();
      }
    });


  }


  private void erstatningEndret() {


    erstatningTabell.getItems().setAll(erstatningListe);

    leggTilVisErstatningKnapp();


  }


  private void leggTilVisErstatningKnapp() {

    visErstatningKolonne.setCellFactory(TabellKnapp.<Skademelding>genererKnapp(TabellKnapp.VIS_KUNDE_IKONE_STI, "vis-kunde-knapp", (s) -> {
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
