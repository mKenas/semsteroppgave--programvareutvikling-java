package programutvikling.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Kunde implements Serializable, Observable {

  private static final long serialVersionUID = 1;

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

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
    observersHandler.update();

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

}



