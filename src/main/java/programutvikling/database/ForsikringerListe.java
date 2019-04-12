package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;


public class ForsikringerListe {

  private static ForsikringerListe fl = null;
  private ObservableList<Forsikring> forsikringerListe = FXCollections.observableArrayList();

  private ForsikringerListe() {
  }

  public static ForsikringerListe getInstance() {
    if (fl == null) {
      fl = new ForsikringerListe();
    }
    return fl;
  }


  public void leggTilForsikring(Forsikring forsikring) {

    this.forsikringerListe.add(forsikring);

  }

}
