package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import programutvikling.base.Skademelding;

public final class DataSourceObject {

  private static DataSourceObject dso = null;
  private KunderListe kunderListe = KunderListe.getInstance();

  private ForsikringerListe forsikringerListe = ForsikringerListe.getInstance();
  private ObservableList<Skademelding> skadeMeldinger = FXCollections.observableArrayList();



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


  public ObservableList<Skademelding> getSkadeMeldinger() {
    return skadeMeldinger;
  }






}
