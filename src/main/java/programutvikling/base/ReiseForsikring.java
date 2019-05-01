package programutvikling.base;

public class ReiseForsikring extends Forsikring {

  private String forsikringsOmrade;
  private Double forsikringsSum;


  public ReiseForsikring() {
    super("Reise Forsikring",0.0,0.0,"");
    this.forsikringsOmrade ="";
    this.forsikringsSum =0.0;


  }

  public ReiseForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, String forsikringsOmrade, Double forsikringssum) {
    super("Reise Forsikring",forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    this.forsikringsOmrade = forsikringsOmrade;
    this.forsikringsSum = forsikringssum;

  }

  public String getForsikringsOmrade() {
    return forsikringsOmrade;
  }

  public Double getForsikringsSum() {
    return forsikringsSum;
  }


  public void setForsikringsOmrade(String forsikringsOmrade) {
    this.forsikringsOmrade = forsikringsOmrade;
  }

  public void setForsikringsSum(Double forsikringsSum) {
    this.forsikringsSum = forsikringsSum;
  }



  @Override
  public String toString() {
    return "ReiseForsikring{" +
            "forsikringsOmrade='" + forsikringsOmrade + '\'' +
            ", forsikringsSum=" + forsikringsSum +
            "} " + super.toString();
  }
}
