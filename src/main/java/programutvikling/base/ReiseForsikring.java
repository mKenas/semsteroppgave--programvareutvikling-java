package programutvikling.base;

public class ReiseForsikring extends Forsikring {

  private String forsikringsOmrade;
  private Double forsikringsSum;
  private String forsikringsType;

  public ReiseForsikring() {
    this.forsikringsOmrade ="";
    this.forsikringsSum =0.0;
    this.forsikringsType = "Reise Forsikring";

  }

  public ReiseForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, String forsikringsOmrade, Double forsikringssum) {
    super(forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    this.forsikringsOmrade = forsikringsOmrade;
    this.forsikringsSum = forsikringssum;
    this.forsikringsType = "Reise Forsikring";
  }

  public String getForsikringsOmrade() {
    return forsikringsOmrade;
  }

  public Double getForsikringsSum() {
    return forsikringsSum;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }

  public void setForsikringsOmrade(String forsikringsOmrade) {
    this.forsikringsOmrade = forsikringsOmrade;
  }

  public void setForsikringsSum(Double forsikringsSum) {
    this.forsikringsSum = forsikringsSum;
  }

  public void setForsikringsType(String forsikringsType) {
    this.forsikringsType = forsikringsType;
  }

  @Override
  public String toString() {
    return "ReiseForsikring{" +
            "forsikringsOmrade='" + forsikringsOmrade + '\'' +
            ", forsikringsSum=" + forsikringsSum +
            ", forsikringsType='" + forsikringsType + '\'' +
            "} " + super.toString();
  }
}
