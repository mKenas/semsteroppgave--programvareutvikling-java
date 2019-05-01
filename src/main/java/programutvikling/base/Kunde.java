package programutvikling.base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Kunde implements Serializable {

  private static final long serialVersionUID = 1;

  //private ObservableHelper observersHandler = new ObservableHelper();
//@NotEmpty(message = "kan ikke være tomt")
  private String personNr;
  private String navn;
  private String etternavn;
  private String epost;
  private String mobil;
  private String fakturaAdresse;
  private String postNr;
  private String poststed;
  private String opprettelsesDato;

  //bytte til Arrarylist

  private ArrayList<Forsikring> forsikringer;
  private ArrayList<Skademelding> skadeMeldinger;


  private String  forsikringNrListe;
  private String  skadeMeldingNrListe;

  public Kunde() {

    String dato;
    SimpleDateFormat datoFormat;

    this.personNr = "";
    this.navn = "";
    this.etternavn = "";
    this.epost = "";
    this.mobil = "";
    this.fakturaAdresse = "";
    this.postNr = "";
    this.poststed = "";
    datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    dato = datoFormat.format(new Date());
    this.opprettelsesDato = dato;
    this.forsikringer = new ArrayList<>();
    this.skadeMeldinger = new ArrayList<>();

    this.forsikringNrListe = "";
    this.skadeMeldingNrListe="";

  }

  public Kunde(String navn, String fakturaAdresse) {
    this.navn = navn;
    this.fakturaAdresse = fakturaAdresse;


  }

  public Kunde(String personNr, String navn, String etternavn, String epost, String mobil, String fakturaAdresse, String postNr, String poststed) {
    String dato;
    SimpleDateFormat datoFormat;

    this.personNr = personNr;
    this.navn = navn;
    this.etternavn = etternavn;
    this.epost = epost;
    this.mobil = mobil;
    this.fakturaAdresse = fakturaAdresse;
    this.postNr = postNr;
    this.poststed = poststed;
    datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    dato = datoFormat.format(new Date());
    this.opprettelsesDato = dato;
    this.forsikringer = new ArrayList<>();
    this.skadeMeldinger = new ArrayList<>();

    this.forsikringNrListe = "";
    this.skadeMeldingNrListe="";


  }


  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
    //observersHandler.update();

  }

  public String getPersonNr() {
    return personNr;
  }

  public void setPersonNr(String personNr) {
    this.personNr = personNr;
  }

  public String getEtternavn() {
    return etternavn;
  }

  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }

  public String getEpost() {
    return epost;
  }

  public void setEpost(String epost) {
    this.epost = epost;
  }

  public String getMobil() {
    return mobil;
  }

  public void setMobil(String mobil) {
    this.mobil = mobil;
  }

  public String getPostNr() {
    return postNr;
  }

  public void setPostNr(String postNr) {
    this.postNr = postNr;
  }

  public String getPoststed() {
    return poststed;
  }

  public void setPoststed(String poststed) {
    this.poststed = poststed;
  }

  public String getOpprettelsesDato() {
    return this.opprettelsesDato;
  }

  public void leggTilForsikring(Forsikring forsikring) {

    this.forsikringer.add(forsikring);
    this.setForsikringNrListe(this.getForsikringNrListe() + "|" +forsikring.getForsikringsNr());


  }


  public void leggTilSkadeMelding(Skademelding skademelding) {

    this.skadeMeldinger.add(skademelding);
    this.setSkadeMeldingNrListe(this.getSkadeMeldingNrListe() + "|" +skademelding.getSkademeldingNr());

  }

  public ArrayList<Forsikring> getForsikringer() {
    return forsikringer;
  }

  public String getFakturaAdresse() {
    return fakturaAdresse;
  }

  public void setFakturaAdresse(String fakturaAdresse) {
    this.fakturaAdresse = fakturaAdresse;
    //observersHandler.update();

  }

  public ArrayList<Skademelding> getSkadeMeldinger() {
    return skadeMeldinger;
  }




/*  public void setErstatninger(ArrayList<Skademelding> erstatninger) {
    this.erstatninger = erstatninger;
  }*/



public void nullstilleAlleLister(){
  this.forsikringer.clear();
  this.skadeMeldinger.clear();
}


  public String getForsikringNrListe() {
   /* List<String > forsikringNr = new ArrayList<>();

    for (Forsikring f: this.forsikringer)
    {

      forsikringNr.add(f.getForsikringsNr());
    }
    this.forsikringNrListe= String.join("|", forsikringNr);*/
    return forsikringNrListe;
  }

  public String getSkadeMeldingNrListe() {
    return skadeMeldingNrListe;
  }

  public void setSkadeMeldingNrListe(String skadeMeldingNrListe) {
    this.skadeMeldingNrListe = skadeMeldingNrListe;
  }

  public void setForsikringNrListe(String forsikringNrListe) {
    this.forsikringNrListe = forsikringNrListe;
  }

/*
  @Override
  public String toString() {
    return String.format("%s %s %s", personNr, navn, etternavn);
  }*/

  @Override
  public String toString() {
    return "Kunde{" +
            "personNr='" + personNr + '\'' +
            ", navn='" + navn + '\'' +
            ", etternavn='" + etternavn + '\'' +
            ", epost='" + epost + '\'' +
            ", mobil='" + mobil + '\'' +
            ", fakturaAdresse='" + fakturaAdresse + '\'' +
            ", postNr='" + postNr + '\'' +
            ", poststed='" + poststed + '\'' +
            ", opprettelsesDato='" + opprettelsesDato + '\'' +
            ", forsikringer=" + forsikringer +
            ", skadeMeldinger=" + skadeMeldinger +
            ", forsikringNrListe='" + forsikringNrListe + '\'' +
            ", skadeMeldingNrListe='" + skadeMeldingNrListe + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Kunde kunde = (Kunde) o;
    return Objects.equals(personNr, kunde.personNr);
  }

  @Override
  public int hashCode() {

    return Objects.hash(personNr);
  }

  public void setOpprettelsesDato(String opprettelsesDato) {
    this.opprettelsesDato = opprettelsesDato;
  }
}







