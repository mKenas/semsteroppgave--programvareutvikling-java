package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.base.klassHjelpere.SkademeldingStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
  public HashMap<String,Object> getAllData(){

    HashMap<String,Object> dataliste = new HashMap<>();
    dataliste.put("kundeListe",new ArrayList(this.kundeListe));
    dataliste.put("forsikringListe",new ArrayList(this.forsikringListe));
    dataliste.put("skademeldingListe",new ArrayList(this.skademeldingListe));

    dataliste.put("kundeMedForsikringListe",this.kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe",this.kundeMedSkadeMeldingListe);

   return dataliste;
  }
  public void setAllData(HashMap<String,Object> dataliste){



    this.kundeListe.setAll(FXCollections.observableList((ArrayList<Kunde>)dataliste.get("kundeListe")));
    this.forsikringListe.setAll(FXCollections.observableList((ArrayList<Forsikring>)dataliste.get("forsikringListe")));
    this.skademeldingListe.setAll(FXCollections.observableList((ArrayList<Skademelding>)dataliste.get("skademeldingListe")));

    this.kundeMedForsikringListe = (HashMap<Kunde,ArrayList<Forsikring>>)dataliste.get("kundeMedForsikringListe");

    this.kundeMedSkadeMeldingListe = (HashMap<Kunde,ArrayList<Skademelding>>)dataliste.get("kundeMedSkadeMeldingListe");




  }
}
