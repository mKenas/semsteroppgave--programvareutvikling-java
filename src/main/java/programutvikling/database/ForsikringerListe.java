package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;


public class ForsikringerListe {

  private static ForsikringerListe fl = null;
  private ObservableList<Forsikring> forsikringer = FXCollections.observableArrayList();

  private ForsikringerListe() {
  }

  public static ForsikringerListe getInstance() {
    if (fl == null) {
      fl = new ForsikringerListe();
    }
    return fl;
  }

  public void setForsikringer(ObservableList<Forsikring> forsikringer) {
    this.forsikringer = forsikringer;
  }

  public ObservableList<Forsikring> getForsikringer() {
    return forsikringer;
  }

  public void leggTilForsikring(Forsikring forsikring) {

    if (!this.forsikringer.contains(forsikring)) {

      this.forsikringer.add(forsikring);

    }
  }

  public void slettlForsikring(Forsikring forsikring) {
    this.forsikringer.remove(forsikring);
  }


  public void nullstillForsikringerListe() {
    this.forsikringer.clear();

  }

}
