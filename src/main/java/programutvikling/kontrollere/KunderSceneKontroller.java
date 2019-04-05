package programutvikling.kontrollere;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import programutvikling.base.*;
import programutvikling.database.DataSourceObject;
import programutvikling.kontrollere.uihelpers.FileExceptionHandler;

import java.io.IOException;


public class KunderSceneKontroller {

  private static final String KUNDE_FIL_LOKASJON = "kunder.jobj";
  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  @FXML
  TableColumn<Kunde, Void> redigerKolonne;
  @FXML
  TableColumn<Kunde, Void> slettKolonne;
  private Kunde kunde;
  private BorderPane borderPane = hsk.getBorderPane();
  private ObservableList<Kunde> kunderliste, kunderlisteFraFil;
  @FXML
  private TableView tableview;

  public void initialize() {

    if (kunderlisteFraFil != null) {
      if (kunderlisteFraFil.size() > 0) {

        dso.setKunder(kunderlisteFraFil);


        kundeEndret();
        System.out.println("kunder liste: " + kunderliste);

      }
    }

    kunderliste = dso.getKunder();


    if (kunderliste.size() >= 1) {


      tableview.getItems().setAll(kunderliste);
      leggTilRedigerKnapp();
      leggTilSlettKnapp();

    }


    kunderliste.addListener(new InvalidationListener() {
      @Override
      public void invalidated(Observable observable) {
        System.out.println("Endret");
        kundeEndret();
      }
    });


  }


  private void kundeEndret() {


    tableview.getItems().setAll(kunderliste);


    leggTilRedigerKnapp();
    leggTilSlettKnapp();

  }


  public void lagreKunde() {
    try {
      KundeObjektSkriver.write(kunderliste, KUNDE_FIL_LOKASJON);
      System.out.println("Kundene lagret");
    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    }
  }


  public void lasteKunde() {
    try {
      kunderlisteFraFil = KundeObjektLeser.read(KUNDE_FIL_LOKASJON);
      System.out.println("Kundene lastet");
      dso.setKunder(kunderlisteFraFil);
      kunderliste = kunderlisteFraFil;
      tableview.setItems(kunderliste);
      leggTilRedigerKnapp();
      leggTilSlettKnapp();

    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }


  private void leggTilSlettKnapp() {
    //TableColumn<Kunde, Void> kolonne = new TableColumn("Slett");
    //TableColumn colBtn = (TableColumn) tableview.getColumns().get(2);


    Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>> cellFactory = new Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>>() {
      @Override
      public TableCell<Kunde, Void> call(final TableColumn<Kunde, Void> param) {
        final TableCell<Kunde, Void> cell = new TableCell<Kunde, Void>() {

          private final Button knapp = new Button("Slett");

          {
            knapp.getStyleClass().add("slett-knapp");
            knapp.setCursor(Cursor.HAND);
            knapp.setOnAction((ActionEvent event) -> {
              kunde = getTableView().getItems().get(getIndex());
              System.out.println("Kunde: " + kunde);

              kunderliste.remove(getIndex());
              dso.slettlKunde(kunde);


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

    slettKolonne.setCellFactory(cellFactory);

    //tableview.getColumns().add(kolonne);

  }

  private void leggTilRedigerKnapp() {
//    TableColumn<Kunde, Void> kolonne = new TableColumn("Rediger");


    Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>> cellFactory = new Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>>() {
      @Override
      public TableCell<Kunde, Void> call(final TableColumn<Kunde, Void> param) {
        final TableCell<Kunde, Void> cell = new TableCell<Kunde, Void>() {

          private final Button knapp = new Button("Rediger");


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

    //tableview.getColumns().add(kolonne);
    //tableview.getColumns().setAll(kolonne);

  }


  protected void NavigeringTilRedigerKundeScene() {

    Parent root = null;

    try {


      FXMLLoader loader = new FXMLLoader(getClass().getResource(new Navigator().getREDIGER_KUNDE_SCENE()));
      root = loader.load();
      RedigerKundeSceneKontroller rkk = loader.getController();
      rkk.setKunde(kunde);

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }


}
