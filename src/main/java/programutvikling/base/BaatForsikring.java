package programutvikling.base;

public class BaatForsikring extends Forsikring {

  private String eier;
  private String registreringsnummer;
  private String baatType;
  private String baatModell;
  private String batLengde;
  private String aarsmodell;
  private String motortype;
  private String motorstyrke;
  private String forsikringsType;

  public BaatForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, String eier, String registreringsnummer, String baatType, String baatModell, String batLengde, String aarsmodell, String motortype, String motorstyrke) {
    super(forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    this.eier = eier;
    this.registreringsnummer = registreringsnummer;
    this.baatType = baatType;
    this.baatModell = baatModell;
    this.batLengde = batLengde;
    this.aarsmodell = aarsmodell;
    this.motortype = motortype;
    this.motorstyrke = motorstyrke;
    this.forsikringsType = "Båt Forsikring";
  }

  public String getEier() {
    return eier;
  }

  public void setEier(String eier) {
    this.eier = eier;
  }

  public String getRegistreringsnummer() {
    return registreringsnummer;
  }

  public void setRegistreringsnummer(String registreringsnummer) {
    this.registreringsnummer = registreringsnummer;
  }

  public String getBaatType() {
    return baatType;
  }

  public void setBaatType(String baatType) {
    this.baatType = baatType;
  }

  public String getBaatModell() {
    return baatModell;
  }

  public void setBaatModell(String baatModell) {
    this.baatModell = baatModell;
  }

  public String getBatLengde() {
    return batLengde;
  }

  public void setBatLengde(String batLengde) {
    this.batLengde = batLengde;
  }

  public String getAarsmodell() {
    return aarsmodell;
  }

  public void setAarsmodell(String aarsmodell) {
    this.aarsmodell = aarsmodell;
  }

  public String getMotortype() {
    return motortype;
  }

  public void setMotortype(String motortype) {
    this.motortype = motortype;
  }

  public String getMotorstyrke() {
    return motorstyrke;
  }

  public void setMotorstyrke(String motorstyrke) {
    this.motorstyrke = motorstyrke;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }
}
