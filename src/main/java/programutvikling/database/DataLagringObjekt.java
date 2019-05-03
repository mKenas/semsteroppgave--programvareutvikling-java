package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.*;
import programutvikling.egenDefinertTyper.SkademeldingStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class DataLagringObjekt implements Serializable {

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


  public ObservableList<Skademelding> getSkademeldingListe() {
    return skademeldingListe;
  }

  public ObservableList<Skademelding> getFiltrertSkademeldingListe() {
    return skademeldingListe.filtered(new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        return skademelding.getStatus() == SkademeldingStatus.UBEHANDLET
                || skademelding.getStatus() == SkademeldingStatus.UNDER_BEHANDLING;

      }
    });

  }


  public ObservableList<Skademelding> getErstatningListe() {
    return skademeldingListe.filtered(new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        return skademelding.getStatus() == SkademeldingStatus.GODKJENT;

      }
    });

  }

  public ObservableList<Skademelding> getAvvisteSkademeldingListe() {
    return skademeldingListe.filtered(new Predicate<Skademelding>() {
      @Override
      public boolean test(Skademelding skademelding) {
        return skademelding.getStatus() == SkademeldingStatus.AVVIST;

      }
    });

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

  public List<HusOgInnboForsikring> getHusOgInnboForsikringListe() {

    return this.forsikringListe
            .stream()
            .filter(f -> f instanceof HusOgInnboForsikring)
            .map(f -> (HusOgInnboForsikring) f)
            .collect(Collectors.toList());


  }

  public List<ReiseForsikring> getReiseForsikringListe() {

    return this.forsikringListe
            .stream()
            .filter(f -> f instanceof ReiseForsikring)
            .map(f -> (ReiseForsikring) f)
            .collect(Collectors.toList());

  }

  public List<FritidsboligForsikring> getFritidsboligForsikringListe() {
    return this.forsikringListe
            .stream()
            .filter(f -> f instanceof FritidsboligForsikring)
            .map(f -> (FritidsboligForsikring) f)
            .collect(Collectors.toList());

  }

  public List<BatForsikring> getBatorsikringListe() {
    return this.forsikringListe
            .stream()
            .filter(f -> f instanceof BatForsikring)
            .map(f -> (BatForsikring) f)
            .collect(Collectors.toList());

  }

  public HashMap<String, Object> getAllData() {


    HashMap<String, Object> dataliste = new HashMap<>();
    dataliste.put("kundeListe", new ArrayList(this.kundeListe));
    dataliste.put("forsikringListe", new ArrayList(this.forsikringListe));
    dataliste.put("husOgInnboForsikringListe", new ArrayList(this.getHusOgInnboForsikringListe()));
    dataliste.put("fritidsboligForsikringListe", this.getFritidsboligForsikringListe());
    dataliste.put("reiseForsikringListe", this.getReiseForsikringListe());
    dataliste.put("batorsikringListe", this.getBatorsikringListe());

    dataliste.put("skademeldingListe", new ArrayList(this.skademeldingListe));


    dataliste.put("kundeMedForsikringListe", this.kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe", this.kundeMedSkadeMeldingListe);

    return dataliste;
  }


  public void setAllData(HashMap<String, Object> dataliste) {


    this.kundeListe.setAll(FXCollections.observableList((ArrayList<Kunde>) dataliste.get("kundeListe")));

    this.forsikringListe.setAll(FXCollections.observableList((ArrayList<Forsikring>) dataliste.get("forsikringListe")));

    this.skademeldingListe.setAll(FXCollections.observableList((ArrayList<Skademelding>) dataliste.get("skademeldingListe")));


    this.kundeMedForsikringListe = (HashMap<Kunde, ArrayList<Forsikring>>) dataliste.get("kundeMedForsikringListe");

    this.kundeMedSkadeMeldingListe = (HashMap<Kunde, ArrayList<Skademelding>>) dataliste.get("kundeMedSkadeMeldingListe");


  }
}
