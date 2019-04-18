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
import programutvikling.database.DataSourceObject;
import programutvikling.kontrollere.uihjelpere.TabellKnapp;

import java.io.IOException;
import java.util.function.Predicate;


public class KunderSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  DataSourceObject dso = DataSourceObject.getInstance();
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
  private TableView tableview;

  @FXML private TextField KunderFilterTesktfelt;

  public void initialize() {

    if (kunderlisteFraFil != null) {
      if (kunderlisteFraFil.size() > 0) {

        dso.getKunderListe().setKunder(kunderlisteFraFil);


        kundeEndret();
        System.out.println("kunder liste: " + kunderliste);

      }
    }

    kunderliste = dso.getKunderListe().getKunder();


    if (kunderliste.size() == 0) {
      tableview.setPlaceholder(new Label("Ingen kunder er registrert ennå!"));

    }
    if (kunderliste.size() >= 1) {


      tableview.getItems().setAll(kunderliste);
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





    KunderFilterTesktfelt.textProperty().addListener((observable, oldValue, newValue)->{
      filteredList.setPredicate(
              new Predicate<Kunde>() {
                @Override
                public boolean test(Kunde kunde) {
                  if (kunde.getPersonNr().contains(KunderFilterTesktfelt.getText())|| kunde.getNavn().contains(KunderFilterTesktfelt.getText())) {
                    return true;
                  }
                  return false;
                }

              }

      );

      kunderliste = FXCollections.observableArrayList(filteredList);

      tableview.setItems(FXCollections.observableList(kunderliste));

    });

  }


  private void kundeEndret() {


    tableview.getItems().setAll(kunderliste);


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
              dso.getKunderListe().slettlKunde(kunde);


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
    slettKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp("\uf00d","slett-knapp", (Kunde k) -> {
      dso.getKunderListe().slettlKunde(k);
      tableview.getItems().remove(k);

      //return p;
    }));

  }

  private void leggTilRedigerKnapp() {

/*

    Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>> cellFactory = new Callback<>() {
      @Override
      public TableCell<Kunde, Void> call(final TableColumn<Kunde, Void> param) {
        final TableCell<Kunde, Void> cell = new TableCell<>() {

          private final Button knapp = new Button("\uF044");

          {
            knapp.getStyleClass().add("rediger-knapp");
            knapp.setCursor(Cursor.HAND);
            knapp.setOnAction((ActionEvent event) -> {
              kunde = getTableView().getItems().get(getIndex());
              System.out.println("Kunde: " + kunde);


              NavigeringTilRedigerKundeScene();

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

    redigerKolonne.setCellFactory(cellFactory);
*/

    redigerKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp("\uF044","rediger-knapp", (Kunde k) -> {
      //tableview.getItems().remove(p);
      kunde = k;
      NavigeringTilRedigerKundeScene();
      //return p;
    }));

  }

  private void leggTilVisKundeKnapp() {


   /* Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>> cellFactory = new Callback<>() {
      @Override
      public TableCell<Kunde, Void> call(final TableColumn<Kunde, Void> param) {
        final TableCell<Kunde, Void> cell = new TableCell<>() {

          private final Button knapp = new Button("\uf2c2");

          {
            knapp.getStyleClass().add("vis-kunde-knapp");
            knapp.setCursor(Cursor.HAND);
            knapp.setOnAction((ActionEvent event) -> {
              kunde = getTableView().getItems().get(getIndex());
              System.out.println("Kunde: " + kunde);


              NavigeringTilVisKundeScene();

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

    visKundeKolonne.setCellFactory(cellFactory);*/
    visKundeKolonne.setCellFactory(TabellKnapp.<Kunde>genererKnapp("\uf2c2","vis-kunde-knapp",(Kunde k) -> {
      //tableview.getItems().remove(p);
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
