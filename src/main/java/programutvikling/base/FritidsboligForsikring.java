package programutvikling.base;

public class FritidsboligForsikring extends Forsikring {

  private String boligAdresse;
  private String byggeAr;
  private String boligType;
  private String byggeMateriale;
  private String standard;
  private String storrelse;
  private Double bygningsForsikringsbelop;
  private Double innboForsikringsbelop;


  public FritidsboligForsikring() {

    super("Fritidsbolig Forsikring",0.0,0.0,"");
    this.boligAdresse = "";
    this.byggeAr = "";
    this.boligType = "";
    this.byggeMateriale = "";
    this.standard = "";
    this.storrelse = "";
    this.bygningsForsikringsbelop = 0.0;
    this.innboForsikringsbelop = 0.0;

  }

  public FritidsboligForsikring(Double forsikringsbelop, Double forsikringspremie, String forsikringsbetingelser,
                                String boligAdresse, String byggeaar, String boligType, String byggeMateriale,
                                String standard, String storrelse, Double bygningsForsikringsbelop,
                                Double innboForsikringsbelop) {
    super("Fritidsbolig Forsikring",forsikringsbelop, forsikringspremie, forsikringsbetingelser);
    this.boligAdresse = boligAdresse;
    this.byggeAr = byggeaar;
    this.boligType = boligType;
    this.byggeMateriale = byggeMateriale;
    this.standard = standard;
    this.storrelse = storrelse;
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
    this.innboForsikringsbelop = innboForsikringsbelop;

  }

  public String getBoligAdresse() {
    return boligAdresse;
  }

  public void setBoligAdresse(String boligAdresse) {
    this.boligAdresse = boligAdresse;
  }

  public String getByggeAr() {
    return byggeAr;
  }

  public void setByggeAr(String byggeAr) {
    this.byggeAr = byggeAr;
  }

  public String getBoligType() {
    return boligType;
  }

  public void setBoligType(String boligType) {
    this.boligType = boligType;
  }

  public String getByggeMateriale() {
    return byggeMateriale;
  }

  public void setByggeMateriale(String byggeMateriale) {
    this.byggeMateriale = byggeMateriale;
  }

  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }

  public String getStorrelse() {
    return storrelse;
  }

  public void setStorrelse(String storrelse) {
    this.storrelse = storrelse;
  }

  public Double getBygningsForsikringsbelop() {
    return bygningsForsikringsbelop;
  }

  public void setBygningsForsikringsbelop(Double bygningsForsikringsbelop) {
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
  }

  public Double getInnboForsikringsbelop() {
    return innboForsikringsbelop;
  }

  public void setInnboForsikringsbelop(Double innboForsikringsbelop) {
    this.innboForsikringsbelop = innboForsikringsbelop;
  }



  @Override
  public String toString() {
    return "FritidsboligForsikring{" +
            "boligAdresse='" + boligAdresse + '\'' +
            ", byggeAr='" + byggeAr + '\'' +
            ", boligType='" + boligType + '\'' +
            ", byggeMateriale='" + byggeMateriale + '\'' +
            ", standard='" + standard + '\'' +
            ", storrelse='" + storrelse + '\'' +
            ", bygningsForsikringsbelop=" + bygningsForsikringsbelop +
            ", innboForsikringsbelop=" + innboForsikringsbelop +
            "} " + super.toString();
  }
}
