package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.util.function.Predicate;


public class KunderSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  @FXML
  TableColumn<Kunde, Button> redigerKolonne;
  @FXML
  TableColumn<Kunde, Button> slettKolonne;
  @FXML
  TableColumn<Kunde, Button> visKundeKolonne;

  private Kunde kunde;
  private BorderPane borderPane = hsk.getBorderPane();
  private ObservableList<Kunde> kunderliste, kunderlisteFraFil;
  @FXML
  private TableView kunderTabell;

  @FXML
  private TextField KunderFilterTesktfelt;

  public void initialize() {

    kunderTabell.setPlaceholder(new Label("Ingen kunder er registrert ennå!"));

/*    if (kunderlisteFraFil != null) {
      if (kunderlisteFraFil.size() > 0) {

        dlo.getKunderListe().setKunder(kunderlisteFraFil);


        kundeEndret();
        System.out.println("kunder liste: " + kunderliste);

      }
    }*/

    kunderliste = dlo.getKundeListe();


    if (kunderliste.size() == 0) {


    }
    if (kunderliste.size() >= 1) {


      kunderTabell.getItems().setAll(kunderliste);
      leggTilRedigerKnapp();
      leggTilSlettKnapp();
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
    FilteredList<Kunde> filteredList = new FilteredList<>(kunderliste);


    KunderFilterTesktfelt.textProperty().addListener((observable, oldValue, newValue) -> {
      filteredList.setPredicate(
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

      kunderliste = FXCollections.observableArrayList(filteredList);

      kunderTabell.setItems(FXCollections.observableList(kunderliste));

    });

  }


  private void kundeEndret() {


    kunderTabell.getItems().setAll(kunderliste);


    leggTilRedigerKnapp();
    leggTilSlettKnapp();
    leggTilVisKundeKnapp();

  }


  private void leggTilSlettKnapp() {

  /*
    Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>> cellFactory = new Callback<>() {
      @Override
      public TableCell<Kunde, Void> call(final TableColumn<Kunde, Void> param) {
        final TableCell<Kunde, Void> cell = new TableCell<>() {

          private final Button knapp = new Button("\uf00d");

          {
            knapp.getStyleClass().add("slett-knapp");
            knapp.setCursor(Cursor.HAND);
            knapp.setOnAction((ActionEvent event) -> {
              kunde = getTableView().getItems().get(getIndex());
              System.out.println("Kunde: " + kunde);

              kunderliste.remove(getIndex());
              dlo.getKunderListe().slettKunde(kunde);


            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(knapp);
            }
          }
        };
        return cell;
      }
    };

    slettKolonne.setCellFactory(cellFactory);*/

    // Knapp knapp = new Knapp(slettKolonne);
    slettKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp("\uf00d", "slett-knapp", (Kunde k) -> {
      dhl.getKundeListeHandling().slettKunde(k);
      kunderTabell.getItems().remove(k);

      //return p;
    }));

  }

  private void leggTilRedigerKnapp() {


    redigerKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp("\uF044", "rediger-knapp", (Kunde k) -> {
      //kunderTabell.getItems().remove(p);
      kunde = k;
      NavigeringTilRedigerKundeScene();
      //return p;
    }));

  }

  private void leggTilVisKundeKnapp() {


    visKundeKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp("\uf2c2", "vis-kunde-knapp", (Kunde k) -> {
      //kunderTabell.getItems().remove(p);
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
