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

public class SkademeldingListeKontroller {



  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();

  @FXML
  TableColumn<Skademelding, Button> visSkademeldingKnapp;
  private Kunde kunde;
  private Skademelding skademelding;
  private Forsikring forsikring;
  private BorderPane borderPane = hsk.getBorderPane();
  //
  private ObservableList<Skademelding> skademeldingListe, forsikringerListeFraFil;
  @FXML
  private TableView skademeldingTabell;

  public void initialize() {

    skademeldingTabell.setPlaceholder(new Label("Ingen skademelding er registrert ennå!"));


    skademeldingListe = dho.getKundeMedSkademeldingListeHandling().getSkademeldingListe();


    if (skademeldingListe.size() >= 1) {


      skademeldingTabell.getItems().setAll(skademeldingListe);

      leggTilVisErstatningKnapp();

    }


    skademeldingListe.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Forsikring liste Endret");
        forsikringEndret();
      }
    });


  }


  private void forsikringEndret() {


    skademeldingTabell.getItems().setAll(skademeldingListe);

    //leggTilRedigerKnapp();


  }


  private void leggTilVisErstatningKnapp() {

    visSkademeldingKnapp.setCellFactory(TabellKnapp.<Skademelding>genererKnapp("\uf2c2", "vis-kunde-knapp", (s) -> {
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
