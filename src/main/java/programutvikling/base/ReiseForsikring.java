package programutvikling.base;

public class ReiseForsikring extends Forsikring {

  private String Forsikringsområde;
  private Double forsikringssum;
  private String forsikringsType;

  public ReiseForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, String forsikringsområde, Double forsikringssum) {
    super(forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    //Forsikringsområde = forsikringsområde;
    this.forsikringssum = forsikringssum;
    this.forsikringsType = "Reise Forsikring";
  }

  public String getForsikringsområde() {
    return Forsikringsområde;
  }

  public Double getForsikringssum() {
    return forsikringssum;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }
}
