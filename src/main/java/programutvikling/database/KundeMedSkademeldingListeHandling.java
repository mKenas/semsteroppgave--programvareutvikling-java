package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.base.klassHjelpere.SkademeldingStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class KundeMedSkademeldingListeHandling {

  //private  ObservableMap<Kunde,ArrayList<Forsikring>> kundeMedForsikringListe = FXCollections.observableHashMap();
  private HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademeldingListe = new HashMap<>();
  private ObservableList<Skademelding> skademeldingListe = FXCollections.observableArrayList();

  public KundeMedSkademeldingListeHandling(HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademeldingListe, ObservableList<Skademelding> skademeldingListe) {
    this.kundeMedSkademeldingListe = kundeMedSkademeldingListe;
    this.skademeldingListe = skademeldingListe;
  }


  public void leggTilSkademelding(Skademelding skademelding, Kunde kunde) {

    kunde.leggTilSkadeMelding(skademelding);
    this.kundeMedSkademeldingListe.put(kunde, kunde.getSkadeMeldinger());
    this.skademeldingListe.add(skademelding);


  }

  public void slettSkademelding(Skademelding skademelding, Kunde kunde) {
    if (this.kundeMedSkademeldingListe.containsKey(kunde)) {

      kunde.getSkadeMeldinger().remove(skademelding);
      this.kundeMedSkademeldingListe.put(kunde, kunde.getSkadeMeldinger());
      this.skademeldingListe.remove(skademelding);
      System.out.println("Skademelding slettet");
    } else {
      System.out.println("Skademelding ikke finnes");
    }
  }

  public void godkjennSkademelding(Skademelding skademelding) {

    skademelding.setStatus(SkademeldingStatus.GODKJENT);


  }

  public void avvisSkademelding(Skademelding skademelding) {
    skademelding.setStatus(SkademeldingStatus.AVVIST);


  }


  public Kunde finnSkademeldingsKunde(Skademelding skademelding) {

    ArrayList<ArrayList<Skademelding>> listeAvForsikringListe = new ArrayList<>(kundeMedSkademeldingListe.values());
    Kunde kunde;

   /* kundeMedForsikringListe.entrySet().stream()
            .flatMap(m -> m.getValue().stream())
            .forEach(System.out::println);*/


    for (Map.Entry<Kunde, ArrayList<Skademelding>> liste : this.kundeMedSkademeldingListe.entrySet()) {
      if (liste.getValue().contains(skademelding)) {
        kunde = liste.getKey();
        return kunde;

      }
    }

    return null;
  }

  public ObservableList<Skademelding> filterSkademeldingListe(ObservableList<Skademelding> skademeldingListe ,SkademeldingStatus status) {
    Predicate<Skademelding> filter = new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        if (skademelding.getStatus() == status) {
          return true;
        }
        return false;
      }
    };

    return skademeldingListe.stream()
            .filter(filter)
            .collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));


  }

  public ObservableList<Skademelding> filterSkademeldingListe(SkademeldingStatus status, SkademeldingStatus status2) {
    Predicate<Skademelding> filter = new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        if (skademelding.getStatus() == status || skademelding.getStatus() == status2) {
          return true;
        }
        return false;
      }
    };

    return skademeldingListe.stream()
            .filter(filter)
            .collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));


  }
  public ObservableList<Skademelding>  getSkademeldingListe() {
    return filterSkademeldingListe(SkademeldingStatus.UBEHANDLET, SkademeldingStatus.UNDER_BEHANDLING);

  }
  public ObservableList<Skademelding>  getErstatningListe() {
    return filterSkademeldingListe(this.skademeldingListe,SkademeldingStatus.GODKJENT);

  }

  public ObservableList<Skademelding> getAvvistSkademeldingListe() {
    return filterSkademeldingListe(this.skademeldingListe,SkademeldingStatus.AVVIST);

  }

  public ArrayList<Skademelding>  getErstatningListeTilKunde(Kunde kunde, SkademeldingStatus status) {

    Predicate<Skademelding> filter = new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        if (skademelding.getStatus() == status ) {
          return true;
        }
        return false;
      }
    };

    return kunde.getSkadeMeldinger().stream()
            .filter(filter).collect(Collectors.toCollection( ArrayList::new));


  }

}
