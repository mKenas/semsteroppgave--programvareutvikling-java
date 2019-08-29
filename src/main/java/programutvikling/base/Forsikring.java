package programutvikling.base;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public abstract class Forsikring implements Serializable {

  private String forsikringsNr;
  private String forsikringsType;
  private Double forsikringsbelop;
  private Double forsikringspremie;
  private String forsikringsbetingelser;
  private String oprettelsesDato;
  private DateFormat datoFormat;

  public Forsikring() {

  }

  public Forsikring(String forsikringsType, Double forsikringsbelop, Double forsikringspremie, String forsikringsbetingelser) {
    this.forsikringsNr = UUID.randomUUID().toString();
    this.forsikringsType = forsikringsType;
    this.forsikringsbelop = forsikringsbelop;
    this.forsikringspremie = forsikringspremie;
    this.forsikringsbetingelser = forsikringsbetingelser;
    this.datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    this.oprettelsesDato = datoFormat.format(new Date());


  }

  public Forsikring(String forsikringsType, String forsikringsNr, Double forsikringsbelop, Double forsikringspremie, String forsikringsbetingelser) {
    this.forsikringsNr = forsikringsNr;
    this.forsikringsType = forsikringsType;
    this.forsikringsbelop = forsikringsbelop;
    this.forsikringspremie = forsikringspremie;
    this.forsikringsbetingelser = forsikringsbetingelser;
    this.datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    this.oprettelsesDato = datoFormat.format(new Date());

  }

  public String getOprettelsesDato() {
    return oprettelsesDato;
  }

  public void setOprettelsesDato(String oprettelsesDato) {
    this.oprettelsesDato = oprettelsesDato;
  }

  public Double getForsikringsbelop() {
    return forsikringsbelop;
  }

  public void setForsikringsbelop(Double forsikringsbelop) {
    this.forsikringsbelop = forsikringsbelop;
  }

  public Double getForsikringspremie() {
    return forsikringspremie;
  }

  public void setForsikringspremie(Double forsikringspremie) {
    this.forsikringspremie = forsikringspremie;
  }

  public String getForsikringsbetingelser() {
    return forsikringsbetingelser;
  }

  public void setForsikringsbetingelser(String forsikringsbetingelser) {
    this.forsikringsbetingelser = forsikringsbetingelser;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }

  public void setForsikringsType(String forsikringsType) {
    this.forsikringsType = forsikringsType;
  }

  public String getForsikringsNr() {
    return forsikringsNr;
  }

  public void setForsikringsNr(String forsikringsNr) {
    this.forsikringsNr = forsikringsNr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Forsikring that = (Forsikring) o;
    return Objects.equals(forsikringsNr, that.forsikringsNr);
  }

  @Override
  public int hashCode() {

    return Objects.hash(forsikringsNr);
  }

  @Override
  public String toString() {
    return "Forsikring{" +
            "forsikringsNr='" + forsikringsNr + '\'' +
            ", oprettelsesDato='" + oprettelsesDato + '\'' +
            ", forsikringsbelop=" + forsikringsbelop +
            ", forsikringspremie=" + forsikringspremie +
            ", forsikringsbetingelser='" + forsikringsbetingelser + '\'' +
            '}';
  }
}


