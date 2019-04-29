package programutvikling.base;

public class HusOgInnboForsikring extends Forsikring {

  private String boligAdresse;
  private String byggeAr;
  private String boligType;
  private String byggeMateriale;
  private String standard;
  private String storrelse;
  private String bygningsForsikringsbelop;
  private String innboForsikringsbelop;
  private String forsikringsType;

  public HusOgInnboForsikring() {
    super(0.0,0.0,"");
    this.boligAdresse = "";
    this.byggeAr = "2";
    this.boligType = "";
    this.byggeMateriale = "";
    this.standard = "";
    this.storrelse = "";
    this.bygningsForsikringsbelop = "";
    this.innboForsikringsbelop = "";
    this.forsikringsType = "Hus Og Innbo Forsikring";
  }

  public HusOgInnboForsikring(Double forsikringsbelop, Double forsikringspremie, String forsikringsbetingelser,
                              String boligAdresse, String byggeAr, String boligType, String byggeMateriale,
                              String standard, String storrelse, String bygningsForsikringsbelop,
                              String innboForsikringsbelop) {
    super(forsikringsbelop, forsikringspremie, forsikringsbetingelser);
    this.boligAdresse = boligAdresse;
    this.byggeAr = byggeAr;
    this.boligType = boligType;
    this.byggeMateriale = byggeMateriale;
    this.standard = standard;
    this.storrelse = storrelse;
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
    this.innboForsikringsbelop = innboForsikringsbelop;
    this.forsikringsType = "Hus Og Innbo Forsikring";
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

  public String getBygningsForsikringsbelop() {
    return bygningsForsikringsbelop;
  }

  public void setBygningsForsikringsbelop(String bygningsForsikringsbelop) {
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
  }

  public String getInnboForsikringsbelop() {
    return innboForsikringsbelop;
  }

  public void setInnboForsikringsbelop(String innboForsikringsbelop) {
    this.innboForsikringsbelop = innboForsikringsbelop;
  }

  public void setForsikringsType(String forsikringsType) {
    this.forsikringsType = forsikringsType;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }


  @Override
  public String toString() {
    return "super: " + super.toString() +
            "HusOgInnboForsikring{" +
            "boligAdresse='" + boligAdresse + '\'' +
            ", byggeAr='" + byggeAr + '\'' +
            ", boligType='" + boligType + '\'' +
            ", byggeMateriale='" + byggeMateriale + '\'' +
            ", standard='" + standard + '\'' +
            ", storrelse='" + storrelse + '\'' +
            ", bygningsForsikringsbelop='" + bygningsForsikringsbelop + '\'' +
            ", innboForsikringsbelop='" + innboForsikringsbelop + '\'' +
            ", forsikringsType='" + forsikringsType + '\'' +
            '}';
  }
}
