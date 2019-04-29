package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  public List<HusOgInnboForsikring> getHusOgInnboForsikringListe() {

  return  this.forsikringListe
            .stream()
            .filter(f -> f instanceof HusOgInnboForsikring)
            .map(f -> (HusOgInnboForsikring) f)
          .collect(Collectors.toList());

          //.collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));

  }

  public List<ReiseForsikring> getReiseForsikringListe() {

    return  this.forsikringListe
            .stream()
            .filter(f -> f instanceof ReiseForsikring)
            .map(f -> (ReiseForsikring) f)
            .collect(Collectors.toList());
            //.collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
  }

  public List<FritidsboligForsikring> getFritidsboligForsikringListe() {
    return  this.forsikringListe
            .stream()
            .filter(f -> f instanceof FritidsboligForsikring)
            .map(f -> (FritidsboligForsikring) f)
            .collect(Collectors.toList());
            //.collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
  }

  public List<BatForsikring> getBatorsikringListe() {
    return  this.forsikringListe
            .stream()
            .filter(f -> f instanceof BatForsikring)
            .map(f -> (BatForsikring) f)
            .collect(Collectors.toList());
    //.collect(Collectors.collectingAndThen(Collectors.toList(), l -> FXCollections.observableArrayList(l)));
  }

  public HashMap<String,Object> getAllData(){

 /*   HashMap<String,Object> dataliste = new HashMap<>();
    dataliste.put("kundeListe",new ArrayList(this.kundeListe));
    dataliste.put("forsikringListe",new ArrayList(this.forsikringListe));
    dataliste.put("skademeldingListe",new ArrayList(this.skademeldingListe));

    dataliste.put("kundeMedForsikringListe",this.kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe",this.kundeMedSkadeMeldingListe);*/

    HashMap<String,Object> dataliste = new HashMap<>();
    dataliste.put("kundeListe",new ArrayList(this.kundeListe));
    dataliste.put("forsikringListe",new ArrayList(this.forsikringListe));
    dataliste.put("husOgInnboForsikringListe",new ArrayList(this.getHusOgInnboForsikringListe()));
    dataliste.put("fritidsboligForsikringListe",this.getFritidsboligForsikringListe());
    dataliste.put("reiseForsikringListe",this.getReiseForsikringListe());
    dataliste.put("batorsikringListe",this.getBatorsikringListe());

    dataliste.put("skademeldingListe",new ArrayList(this.skademeldingListe));



    dataliste.put("kundeMedForsikringListe",this.kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe",this.kundeMedSkadeMeldingListe);

   return dataliste;
  }

/*  public HashMap<String,Object> getAllDataMedAlleForsikringer(){

    HashMap<String,Object> dataliste = new HashMap<>();
    dataliste.put("kundeListe",new ArrayList(this.kundeListe));
    dataliste.put("forsikringListe",new ArrayList(this.forsikringListe));
    dataliste.put("husOgInnboForsikringListe",new ArrayList(this.getHusOgInnboForsikringListe()));
    dataliste.put("fritidsboligForsikringListe",this.getFritidsboligForsikringListe());
    dataliste.put("reiseForsikringListe",this.getReiseForsikringListe());
    dataliste.put("batorsikringListe",this.getBatorsikringListe());

    dataliste.put("skademeldingListe",new ArrayList(this.skademeldingListe));



    dataliste.put("kundeMedForsikringListe",this.kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe",this.kundeMedSkadeMeldingListe);

    return dataliste;
  }*/
  public void setAllData(HashMap<String,Object> dataliste){



    this.kundeListe.setAll(FXCollections.observableList((ArrayList<Kunde>)dataliste.get("kundeListe")));
    //System.out.println("kundeListe");
    //System.out.println(this.kundeListe);
    this.forsikringListe.setAll(FXCollections.observableList((ArrayList<Forsikring>)dataliste.get("forsikringListe")));
    //System.out.println("forsikringListe");
    //System.out.println(this.forsikringListe);
    this.skademeldingListe.setAll(FXCollections.observableList((ArrayList<Skademelding>)dataliste.get("skademeldingListe")));
    //System.out.println("skademeldingListe");
    //System.out.println(this.skademeldingListe);

    this.kundeMedForsikringListe = (HashMap<Kunde,ArrayList<Forsikring>>)dataliste.get("kundeMedForsikringListe");

    this.kundeMedSkadeMeldingListe = (HashMap<Kunde,ArrayList<Skademelding>>)dataliste.get("kundeMedSkadeMeldingListe");




  }
}
