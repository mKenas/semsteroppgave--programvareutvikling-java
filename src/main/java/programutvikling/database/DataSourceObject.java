package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Erstatning;
import programutvikling.base.Observable;
import programutvikling.base.Observer;
import programutvikling.base.Skade;

public final class DataSourceObject implements Observable {

  private static DataSourceObject dso = null;
  private KunderListe kunderListe = KunderListe.getInstance();

  private ForsikringerListe forsikringerListe = ForsikringerListe.getInstance();
  private ObservableList<Skade> skaders = FXCollections.observableArrayList();
  private ObservableList<Erstatning> erstatninger = FXCollections.observableArrayList();


  private DataSourceObject() {
  }

  public static DataSourceObject getInstance() {
    if (dso == null) {
      dso = new DataSourceObject();
    }
    return dso;
  }

  public KunderListe getKunderListe() {
    return kunderListe;
  }

  public ForsikringerListe getForsikringerListe() {
    return forsikringerListe;
  }


  public ObservableList<Skade> getSkaders() {
    return skaders;
  }

  public ObservableList<Erstatning> getErstatninger() {
    return erstatninger;
  }


  @Override
  public void observe(Observer o) {

  }


}
