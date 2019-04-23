package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.base.klassHjelpere.SkademeldingStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class DataLagringObjekt {

  private static DataLagringObjekt dlo = null;


  private HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe = new HashMap<>();
  private ObservableList<Forsikring> forsikringListe = FXCollections.observableArrayList();
  private ObservableList<Kunde> kundeListe = FXCollections.observableArrayList();

  private ObservableList<Skademelding> skademeldingListe = FXCollections.observableArrayList();
  private HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkadeMeldingListe = new HashMap<>();


  private DataLagringObjekt() {
  }

  public static DataLagringObjekt getInstance() {
    if (dlo == null) {
      dlo = new DataLagringObjekt();
    }
    return dlo;
  }


  public ObservableList<Skademelding> getAlleSkadeMeldinger() {
    return skademeldingListe;
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
            .filter(filter).collect(Collectors.toCollection(ArrayList::new));


  }

  public ObservableList<Kunde> getKundeListe() {
    return kundeListe;
  }

  public HashMap<Kunde, ArrayList<Forsikring>> getKundeMedForsikringListe() {
    return kundeMedForsikringListe;
  }

  public void setKundeMedForsikringListe(HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe) {
    this.kundeMedForsikringListe = kundeMedForsikringListe;
  }

  public ObservableList<Forsikring> getForsikringListe() {
    return forsikringListe;
  }

  public void setForsikringListe(ObservableList<Forsikring> forsikringListe) {
    this.forsikringListe = forsikringListe;
  }

  public HashMap<Kunde, ArrayList<Skademelding>> getKundeMedSkadeMeldingListe() {
    return kundeMedSkadeMeldingListe;
  }
}
