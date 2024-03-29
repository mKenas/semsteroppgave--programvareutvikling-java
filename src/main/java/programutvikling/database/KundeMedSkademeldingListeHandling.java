package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.egenDefinertTyper.SkademeldingStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class KundeMedSkademeldingListeHandling {


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

    } else {

    }
  }

  public void slettAlleSkademeldingTilKunde(Kunde kunde) {
    if (this.kundeMedSkademeldingListe.containsKey(kunde)) {

      ArrayList<Skademelding> liste = kunde.getSkadeMeldinger();
      for (Skademelding s : liste) {
        this.skademeldingListe.remove(s);
      }
      this.kundeMedSkademeldingListe.remove(kunde);


    } else {

    }
  }

  public void godkjennSkademelding(Skademelding skademelding) {

    skademelding.setStatus(SkademeldingStatus.GODKJENT);


  }

  public void avvisSkademelding(Skademelding skademelding) {
    skademelding.setStatus(SkademeldingStatus.AVVIST);


  }


  public Kunde finnSkademeldingsKunde(HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademelding, Skademelding skademelding) {


    Kunde kunde;


    for (Map.Entry<Kunde, ArrayList<Skademelding>> liste : kundeMedSkademelding.entrySet()) {
      if (liste.getValue().contains(skademelding)) {
        kunde = liste.getKey();
        return kunde;

      }
    }

    return null;
  }

  public ObservableList<Skademelding> filterSkademeldingListe(ObservableList<Skademelding> skademeldingListe, SkademeldingStatus status) {
    Predicate<Skademelding> filter = new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        return skademelding.getStatus() == status;
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
        return skademelding.getStatus() == status || skademelding.getStatus() == status2;
      }
    };

    return skademeldingListe.stream()
            .filter(filter)
            .collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));


  }

  public ObservableList<Skademelding> getSkademeldingListe() {
    return filterSkademeldingListe(SkademeldingStatus.UBEHANDLET, SkademeldingStatus.UNDER_BEHANDLING);

  }

  public ObservableList<Skademelding> getErstatningListe() {
    return filterSkademeldingListe(this.skademeldingListe, SkademeldingStatus.GODKJENT);

  }

  public ObservableList<Skademelding> getAvvistSkademeldingListe() {
    return filterSkademeldingListe(this.skademeldingListe, SkademeldingStatus.AVVIST);

  }

  public ArrayList<Skademelding> filterSkademeldingListeTilKunde(Kunde kunde, SkademeldingStatus status) {

    Predicate<Skademelding> filter = new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        return skademelding.getStatus() == status;
      }
    };

    return kunde.getSkadeMeldinger().stream()
            .filter(filter).collect(Collectors.toCollection(ArrayList::new));


  }

  public ArrayList<Skademelding> filterSkademeldingListeTilKunde(Kunde kunde, SkademeldingStatus status, SkademeldingStatus status2) {

    Predicate<Skademelding> filter = new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        return skademelding.getStatus() == status || skademelding.getStatus() == status2;
      }
    };

    return kunde.getSkadeMeldinger().stream()
            .filter(filter).collect(Collectors.toCollection(ArrayList::new));


  }

  public ArrayList<Skademelding> getErstatningListeTilKunde(Kunde kunde) {

    return filterSkademeldingListeTilKunde(kunde, SkademeldingStatus.GODKJENT);
  }

  public ArrayList<Skademelding> getAvvistSkademeldingListeTilKunde(Kunde kunde) {

    return filterSkademeldingListeTilKunde(kunde, SkademeldingStatus.AVVIST);
  }

  public ArrayList<Skademelding> getSkademeldingListeTilKunde(Kunde kunde) {

    return filterSkademeldingListeTilKunde(kunde, SkademeldingStatus.UBEHANDLET, SkademeldingStatus.UNDER_BEHANDLING);
  }

}
