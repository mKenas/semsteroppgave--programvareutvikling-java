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

  //private  ObservableMap<Kunde,ArrayList<Forsikring>> kundeMedForsikringListe = FXCollections.observableHashMap();
  private HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe = new HashMap<>();
  private ObservableList<Forsikring> forsikringListe = FXCollections.observableArrayList();

  public KundeMedForsikringListeHandling(HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe, ObservableList<Forsikring> forsikringListe) {
    this.kundeMedForsikringListe = kundeMedForsikringListe;
    this.forsikringListe = forsikringListe;
  }


/*
  public ObservableList<Forsikring> getForsikringListe() {


    ArrayList<ArrayList<Forsikring>> listeAvForsikringListe = new ArrayList<>(kundeMedForsikringListe.values());
    ArrayList<Forsikring> liste = new ArrayList<>();
    listeAvForsikringListe.forEach(l -> l.forEach(forsikring -> liste.add(forsikring)));

    forsikringListe = FXCollections.observableList(forsikringListe);
    return forsikringListe;
  }*/

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
      System.out.println("Forsikring slettet");
    } else {
      System.out.println("Forsikring ikke finnes");
    }
  }

  public void slettAlleForsikringTilKunde(Kunde kunde) {
    if (this.kundeMedForsikringListe.containsKey(kunde)) {

      List<Forsikring> liste =kunde.getForsikringer();
      for (Forsikring f: liste){
        this.forsikringListe.remove(f);
      }

      this.kundeMedForsikringListe.remove(kunde);

      //System.out.println("Forsikring slettet");
    } else {
      //System.out.println("Forsikring ikke finnes");
    }
  }

  public Kunde finnForsikringsEier(HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe ,Forsikring forsikring) {

   // ArrayList<ArrayList<Forsikring>> listeAvForsikringListe = new ArrayList<>(kundeMedForsikringListe.values());
    Kunde kunde;


   /* kundeMedForsikringListe.entrySet().stream()
            .flatMap(m -> m.getValue().stream())
            .forEach(System.out::println);*/


    for (Map.Entry<Kunde, ArrayList<Forsikring>> liste : kundeMedForsikringListe.entrySet()) {
      if (liste.getValue().contains(forsikring)) {
        kunde = liste.getKey();

        return kunde;

      }

    }

    return null;
  }

}
