package programutvikling.database;

import programutvikling.Erstatning;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skade;

import java.util.ArrayList;

public final class DataSourceObject {

    private static DataSourceObject dso = null;
    private ArrayList<Kunde> kunder = new ArrayList<>();
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

  public ArrayList<Kunde> getKunder() {
    return kunder;
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

  public void leggTilKunde(Kunde kunde) {
    this.kunder.add(kunde);
  }


}
