package programutvikling.base;

import programutvikling.egenDefinertTyper.SkademeldingStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Kunde implements Serializable {

  private static final long serialVersionUID = 1;

  //private ObservableHelper observersHandler = new ObservableHelper();
@NotEmpty(message = "kan ikke være tomt")
  private String personNr;
  private String navn;
  private String etternavn;
  private String epost;
  private String mobil;
  private String fakturaAdresse;
  private String postnummer;
  private String poststed;
  private String opprettelsesDato;

  //bytte til Arrarylist

  private ArrayList<Forsikring> forsikringer;
  private ArrayList<Skademelding> skadeMeldinger;
  private ArrayList<Skademelding> erstatninger;
  private ArrayList<Skademelding> avvisteErstatninger;

  public Kunde(String navn, String fakturaAdresse) {
    this.navn = navn;
    this.fakturaAdresse = fakturaAdresse;


  }

  public Kunde(String personnummer, String navn, String etternavn, String epost, String mobil, String fakturaAdresse, String postnummer, String poststed) {
    String dato;
    SimpleDateFormat datoFormat;

    this.personNr = personnummer;
    this.navn = navn;
    this.etternavn = etternavn;
    this.epost = epost;
    this.mobil = mobil;
    this.fakturaAdresse = fakturaAdresse;
    this.postnummer = postnummer;
    this.poststed = poststed;
    datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    dato = datoFormat.format(new Date());
    this.opprettelsesDato = dato;
    this.forsikringer = new ArrayList<>();
    this.skadeMeldinger = new ArrayList<>();
    this.erstatninger = new ArrayList<>();
    this.avvisteErstatninger = new ArrayList<>();


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

  public String getOpprettelsesDato() {
    return this.opprettelsesDato;
  }

  public void leggTilForsikring(Forsikring forsikring) {

    this.forsikringer.add(forsikring);

  }

  public void leggTilSkadeMelding(Skademelding skademelding) {

    this.skadeMeldinger.add(skademelding);

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

  public ArrayList<Skademelding> getErstatninger() {
    return erstatninger;
  }

  public void setErstatninger(ArrayList<Skademelding> erstatninger) {
    this.erstatninger = erstatninger;
  }

  public ArrayList<Skademelding> getAvvisteErstatninger() {
    return avvisteErstatninger;
  }

  public void godkjennSkademelding(Skademelding skademelding) {
    skademelding.setStatus(SkademeldingStatus.GODKJENT);
    this.skadeMeldinger.remove(skademelding);
    this.erstatninger.add(skademelding);


  }

  public void avvisSkademelding(Skademelding skademelding) {
    skademelding.setStatus(SkademeldingStatus.AVVIST);
    this.skadeMeldinger.remove(skademelding);
    this.avvisteErstatninger.add(skademelding);


  }

  @Override
  public String toString() {
    return String.format("%s %s %s", personNr, navn, etternavn);
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
}







