package programutvikling.base;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Kunde implements Serializable, Observable {

  private static final long serialVersionUID = 1;

  private ObservableHelper observersHandler = new ObservableHelper();
  private String kundeNr;
  private String navn;
  private String etternavn;
  private String epost;
  private String mobil;
  private String fakturaAdresse;
  private String postnummer;
  private String poststed;
  private DateFormat datoFormat;
  private Date registreringsDato;

  private ArrayList<Forsikring> forsikringer;

  public Kunde(String navn, String fakturaAdresse) {
    this.navn = navn;
    this.fakturaAdresse = fakturaAdresse;



  }

  public Kunde(String personnummer, String navn, String etternavn,String epost, String mobil, String fakturaAdresse, String postnummer, String poststed) {
    this.kundeNr = personnummer;
    this.navn = navn;
    this.etternavn = etternavn;
    this.epost = epost;
    this.mobil = mobil;
    this.fakturaAdresse = fakturaAdresse;
    this.postnummer = postnummer;
    this.poststed = poststed;
    this.datoFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    this.registreringsDato = new Date();
  }

  @Override
  public void observe(Observer o) {
    observersHandler.add(o);
  }

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
    observersHandler.update();

  }

  public String getKundeNr() {
    return kundeNr;
  }

  public void setKundeNr(String kundeNr) {
    this.kundeNr = kundeNr;
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

  public String getPostnummer() {
    return postnummer;
  }

  public void setPostnummer(String postnummer) {
    this.postnummer = postnummer;
  }

  public String getPoststed() {
    return poststed;
  }

  public void setPoststed(String poststed) {
    this.poststed = poststed;
  }

  public Date getRegistreringsDato() {
    return registreringsDato;
  }



  public String getFakturaAdresse() {
    return fakturaAdresse;
  }

  public void setFakturaAdresse(String fakturaAdresse) {
    this.fakturaAdresse = fakturaAdresse;
    observersHandler.update();

  }

  @Override
  public String toString() {
    return String.format("Navn: %s, Fakturaadresse: %s", navn, fakturaAdresse);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Kunde kunde = (Kunde) o;
    return Objects.equals(kundeNr, kunde.kundeNr) &&
            Objects.equals(navn, kunde.navn) &&
            Objects.equals(etternavn, kunde.etternavn) &&
            Objects.equals(fakturaAdresse, kunde.fakturaAdresse) &&
            Objects.equals(postnummer, kunde.postnummer) &&
            Objects.equals(poststed, kunde.poststed) &&
            Objects.equals(registreringsDato, kunde.registreringsDato);
  }

  @Override
  public int hashCode() {

    return Objects.hash(kundeNr, navn, etternavn, fakturaAdresse, postnummer, poststed, registreringsDato);
  }
}







