package programutvikling.base;

import java.util.ArrayList;

public class ReiseForsikring extends Forsikring {

  private String Forsikringsområde;
  private Double forsikringssum;

  public ReiseForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, String forsikringsområde, Double forsikringssum) {
    super(forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    //Forsikringsområde = forsikringsområde;
    this.forsikringssum = forsikringssum;
  }

  public String getForsikringsområde() {
    return Forsikringsområde;
  }

  public Double getForsikringssum() {
    return forsikringssum;
  }

}
