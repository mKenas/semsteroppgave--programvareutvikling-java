package programutvikling.base;

import java.util.ArrayList;

public class ReiseForsikring extends Forsikring {

  private ArrayList<String> Forsikringsområde;
  private Double forsikringssum;

  public ReiseForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, ArrayList<String> forsikringsområde, Double forsikringssum) {
    super(forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    Forsikringsområde = forsikringsområde;
    this.forsikringssum = forsikringssum;
  }
}
