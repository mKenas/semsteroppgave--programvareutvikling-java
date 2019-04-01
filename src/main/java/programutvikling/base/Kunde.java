package programutvikling.base;

import java.util.ArrayList;
import java.util.Date;

public class Kunde implements Observable {

  private ObservableHelper observersHandler = new ObservableHelper();
  private String navn;
  private String fakturaAdresse;
  private Date registreringsDato;
  private String Forsikringsnummer;
  private ArrayList<Forsikring> forsikringer;

  public Kunde(String navn, String fakturaAdresse) {
    this.navn = navn;
    this.fakturaAdresse = fakturaAdresse;
  }

  @Override
  public void observe(Observer o) {
    observersHandler.add(o);
  }

  public String hentNavn() {
    return navn;
  }

  public String hentFakturaAdresse() {
    return fakturaAdresse;
  }

  public void setNavn(String navn) {
    this.navn = navn;
    observersHandler.update();

  }

  public void setFakturaAdresse(String fakturaAdresse) {
    this.fakturaAdresse = fakturaAdresse;
    observersHandler.update();

  }

  @Override
  public String toString() {
    return String.format("Navn: %s, Fakturaadresse: %s", navn, fakturaAdresse);
  }

}
