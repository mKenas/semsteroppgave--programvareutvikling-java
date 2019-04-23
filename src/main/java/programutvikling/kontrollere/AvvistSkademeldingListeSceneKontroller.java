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

public class AvvistSkademeldingListeSceneKontroller {



  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  @FXML
  TableColumn<Skademelding, Button> visAvvistSkademeldingKolonne;
  private Kunde kunde;
  private Skademelding skademelding;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //
  private ObservableList<Skademelding> avvistSkademeldingListe, forsikringerListeFraFil;
  @FXML
  private TableView avvistSkademeldingTabell;

  public void initialize() {

    avvistSkademeldingTabell.setPlaceholder(new Label("Ingen erstatning er registrert ennå!"));


    avvistSkademeldingListe = dho.getKundeMedSkademeldingListeHandling().getAvvistSkademeldingListe();


    if (avvistSkademeldingListe.size() >= 1) {


      avvistSkademeldingTabell.getItems().setAll(avvistSkademeldingListe);

      leggTilVisErstatningKnapp();

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

    //leggTilRedigerKnapp();


  }


  private void leggTilVisErstatningKnapp() {

    visAvvistSkademeldingKolonne.setCellFactory(TabellKnapp.<Skademelding>genererKnapp("\uf2c2", "vis-kunde-knapp", (s) -> {
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
