package programutvikling.kontrollere.uihjelpere;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.function.Consumer;

public class TabellKnapp<S> extends TableCell<S, Button> {

  private final Button knapp;

  public TabellKnapp(String tittel, String stil, Consumer< S> funksjon) {


    this.knapp = new Button(tittel);
    this.knapp.getStyleClass().add(stil);
    this.knapp.setCursor(Cursor.HAND);

    this.knapp.setOnAction((ActionEvent e) -> {
      funksjon.accept(getvalgtElement());
    });

  }

  public S getvalgtElement() {
    return (S) getTableView().getItems().get(getIndex());
  }

  public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> genererKnapp(String tittel, String stil, Consumer< S> funksjon) {


    return param -> new TabellKnapp<>(tittel,stil, funksjon);
  }

  @Override
  public void updateItem(Button item, boolean empty) {
    super.updateItem(item, empty);

    if (empty) {
      setGraphic(null);
    } else {
      setGraphic(knapp);
    }
  }
}
