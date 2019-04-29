package programutvikling.base;

public class FritidsboligForsikring extends Forsikring {

  private String boligAdresse;
  private String byggeaar;
  private String boligType;
  private String byggeMateriale;
  private String standard;
  private String storrelse;
  private String bygningsForsikringsbelop;
  private String innboForsikringsbelop;
  private String forsikringsType;

  public FritidsboligForsikring(Double forsikringsbelop, Double forsikringspremie, String forsikringsbetingelser,
                                String boligAdresse, String byggeaar, String boligType, String byggeMateriale,
                                String standard, String storrelse, String bygningsForsikringsbelop,
                                String innboForsikringsbelop) {
    super(forsikringsbelop, forsikringspremie, forsikringsbetingelser);
    this.boligAdresse = boligAdresse;
    this.byggeaar = byggeaar;
    this.boligType = boligType;
    this.byggeMateriale = byggeMateriale;
    this.standard = standard;
    this.storrelse = storrelse;
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
    this.innboForsikringsbelop = innboForsikringsbelop;
    this.forsikringsType = "Fritidsbolig Forsikring";
  }


  public String getBoligAdresse() {
    return boligAdresse;
  }

  public String getByggeaar() {
    return byggeaar;
  }

  public String getBoligType() {
    return boligType;
  }

  public String getByggeMateriale() {
    return byggeMateriale;
  }

  public String getStandard() {
    return standard;
  }

  public String getStorrelse() {
    return storrelse;
  }

  public String getBygningsForsikringsbelop() {
    return bygningsForsikringsbelop;
  }

  public String getInnboForsikringsbelop() {
    return innboForsikringsbelop;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }


  public void setBoligAdresse(String boligAdresse) {
    this.boligAdresse = boligAdresse;
  }

  public void setByggeaar(String byggeaar) {
    this.byggeaar = byggeaar;
  }

  public void setBoligType(String boligType) {
    this.boligType = boligType;
  }

  public void setByggeMateriale(String byggeMateriale) {
    this.byggeMateriale = byggeMateriale;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }

  public void setStorrelse(String storrelse) {
    this.storrelse = storrelse;
  }

  public void setBygningsForsikringsbelop(String bygningsForsikringsbelop) {
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
  }

  public void setInnboForsikringsbelop(String innboForsikringsbelop) {
    this.innboForsikringsbelop = innboForsikringsbelop;
  }

  public void setForsikringsType(String forsikringsType) {
    this.forsikringsType = forsikringsType;
  }
}
