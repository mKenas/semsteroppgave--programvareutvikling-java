package programutvikling.kontrollere.uihjelpere;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import programutvikling.base.Kunde;
import programutvikling.database.DataSourceObject;
import programutvikling.database.KunderListe;

public class TabellSlettKnapp extends TableCell {

  private Kunde kunde;
  private DataSourceObject dso = DataSourceObject.getInstance();
  private KunderListe kunderliste = dso.getKunderListe();
  private TableColumn kolonne = new TableColumn();

  public TabellSlettKnapp(TableColumn kolonne) {
    this.kolonne = kolonne;

    Callback<TableColumn<Kunde, Void>, TableCell<Kunde, Void>> cellFactory = new Callback<>() {
      @Override
      public TableCell<Kunde, Void> call(final TableColumn<Kunde, Void> param) {
        final TableCell<Kunde, Void> cell = new TableCell<>() {

          //Kunde kunde = getTableView().getItems().get(getIndex());
          private final Button knapp = new Button("\uf00d");

          {
            knapp.getStyleClass().add("slett-knapp");
            knapp.setCursor(Cursor.HAND);
            knapp.setOnAction((ActionEvent event) -> {
              kunde = getTableView().getItems().get(getIndex());
              System.out.println(getTableView().getItems());
              System.out.println("Kunde: " + kunde);

              kunderliste.getKunder().remove(getIndex());
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

    kolonne.setCellFactory(cellFactory);
  }


}
