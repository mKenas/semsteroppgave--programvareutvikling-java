package programutvikling.kontrollere.uihjelpere;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.function.Consumer;

public class TabellKnapp<S> extends TableCell<S, Button> {

  private final Button knapp;
  public static String VIS_KUNDE_IKONE = "/programutvikling/ikoner/vis-kunde.png";
  public static String VIS_FORSIKRING_IKONE = "/programutvikling/ikoner/forsikring.png";
  public static String VIS_SKADEMELDING_IKONE = "/programutvikling/ikoner/skademelding.png";
  public static String VIS_ERSTATNING_IKONE = "/programutvikling/ikoner/erstatning.png";
  public static String VIS_AVVIST_SKADEMELDING_IKONE = "/programutvikling/ikoner/avvistSkademelding.png";



  public TabellKnapp(String bildeSti, Consumer<S> funksjon) {

  ImageView bilde = new ImageView(getClass().getResource(bildeSti).toExternalForm());
  bilde.setFitWidth(40);
  bilde.setFitHeight(40);
    this.knapp = new Button();
    this.knapp.setCursor(Cursor.HAND);
    this.knapp.setGraphic(bilde);

    this.knapp.setOnAction((ActionEvent e) -> {
      funksjon.accept(getvalgtElement());
    });

  }



  public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> genererKnapp(String bildeSti, Consumer<S> funksjon) {


    return param -> new TabellKnapp<>(bildeSti, funksjon);
  }



  public S getvalgtElement() {
    return (S) getTableView().getItems().get(getIndex());
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
