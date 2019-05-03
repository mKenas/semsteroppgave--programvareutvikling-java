package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KundeMedForsikringListeHandling {


  private HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe = new HashMap<>();
  private ObservableList<Forsikring> forsikringListe = FXCollections.observableArrayList();

  public KundeMedForsikringListeHandling(HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe, ObservableList<Forsikring> forsikringListe) {
    this.kundeMedForsikringListe = kundeMedForsikringListe;
    this.forsikringListe = forsikringListe;
  }




  public void leggTilForsikring(Forsikring forsikring, Kunde kunde) {

    kunde.leggTilForsikring(forsikring);

    this.kundeMedForsikringListe.put(kunde, kunde.getForsikringer());
    this.forsikringListe.add(forsikring);


  }

  public void slettForsikring(Forsikring forsikring, Kunde kunde) {
    if (this.kundeMedForsikringListe.containsKey(kunde)) {

      kunde.getForsikringer().remove(forsikring);
      this.kundeMedForsikringListe.put(kunde, kunde.getForsikringer());
      this.forsikringListe.remove(forsikring);

    } else {

    }
  }

  public void slettAlleForsikringTilKunde(Kunde kunde) {
    if (this.kundeMedForsikringListe.containsKey(kunde)) {

      ArrayList<Forsikring> liste =kunde.getForsikringer();
      for (Forsikring f: liste){
        this.forsikringListe.remove(f);
      }

      this.kundeMedForsikringListe.remove(kunde);


    } else {

    }
  }

  public Kunde finnForsikringsEier(HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe ,Forsikring forsikring) {


    Kunde kunde;



    for (Map.Entry<Kunde, ArrayList<Forsikring>> liste : kundeMedForsikringListe.entrySet()) {
      if (liste.getValue().contains(forsikring)) {
        kunde = liste.getKey();

        return kunde;

      }

    }

    return null;
  }

}
