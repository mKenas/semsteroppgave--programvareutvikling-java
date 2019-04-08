package programutvikling.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Forsikring {

  private Date oprettelsesDato;
  private Double forsikringsbelop;
  private Double forsikringspremie;
  private String forsikringsbetingelser;
  private DateFormat datoFormat;

  public Forsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser) {
    this.forsikringsbelop = forsikringsbeløp;
    this.forsikringspremie = forsikringspremie;
    this.forsikringsbetingelser = forsikringsbetingelser;
    this.datoFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    this.oprettelsesDato = new Date();

  }
}
