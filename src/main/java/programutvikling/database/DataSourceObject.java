package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Erstatning;
import programutvikling.base.*;

import java.util.ArrayList;

public final class DataSourceObject implements Observable {

  private static DataSourceObject dso = null;
  private ObservableList<Kunde> kunder = FXCollections.observableArrayList();
  private ArrayList<Forsikring> forsikrings = new ArrayList<>();
  private ArrayList<Skade> skaders = new ArrayList<>();
  private ArrayList<Erstatning> erstatninger = new ArrayList<>();


  private DataSourceObject() {
  }

  public static DataSourceObject getInstance() {
    if (dso == null) {
      dso = new DataSourceObject();
    }
    return dso;
  }

  public ObservableList<Kunde> getKunder() {
    return kunder;
  }

  public void setKunder(ObservableList<Kunde> kunderliste) {

    this.kunder = kunderliste;
  }

  public ArrayList<Forsikring> getForsikrings() {
    return forsikrings;
  }

  public ArrayList<Skade> getSkaders() {
    return skaders;
  }

  public ArrayList<Erstatning> getErstatninger() {
    return erstatninger;
  }

  public void nullstillKunder() {
    this.kunder.clear();


  }

  public void leggTilKunder(ObservableList<Kunde> kunderliste) {
    for (int i = 0; i < kunderliste.size(); i++) {
      Kunde k = kunderliste.get(i);
      this.kunder.add(k);

    }
  }

  public void leggTilKunde(Kunde kunde) {
    this.kunder.add(kunde);
  }

  public void slettlKunde(Kunde kunde) {
    this.kunder.remove(kunde);
  }

  @Override
  public void observe(Observer o) {

  }
}
