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
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

public class ErstatningListeKontroller {



  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  @FXML
  TableColumn<Skademelding, Button> visErstatningKolonne;
  private Kunde kunde;
  private Skademelding skademelding;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //
  private ObservableList<Skademelding> erstatningListe, forsikringerListeFraFil;
  @FXML
  private TableView erstatningTabell;

  public void initialize() {

    erstatningTabell.setPlaceholder(new Label("Ingen erstatning er registrert ennå!"));


    erstatningListe = dlo.getErstatningListe();


    if (erstatningListe.size() >= 1) {


      erstatningTabell.getItems().setAll(erstatningListe);

      leggTilVisErstatningKnapp();

    }


    erstatningListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Forsikring liste Endret");
        forsikringEndret();
      }
    });


  }


  private void forsikringEndret() {


    erstatningTabell.getItems().setAll(erstatningListe);

    //leggTilRedigerKnapp();


  }


  private void leggTilVisErstatningKnapp() {

    visErstatningKolonne.setCellFactory(TabellKnapp.<Skademelding>genererKnapp("\uf2c2", "vis-kunde-knapp", (s) -> {
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
