package programutvikling.base;

public class BatForsikring extends Forsikring {

  private String eier;
  private String registreringsNr;
  private String batType;
  private String batModell;
  private String batLengde;
  private String arsModell;
  private String motorType;
  private String motorStyrke;


  public BatForsikring() {
    super("Båt Forsikring", 0.0, 0.0, "");
    this.eier = "";
    this.registreringsNr = "";
    this.batType = "";
    this.batModell = "";
    this.batLengde = "";
    this.arsModell = "";
    this.motorType = "";
    this.motorStyrke = "";

  }

  public BatForsikring(Double forsikringsbeløp, Double forsikringspremie, String forsikringsbetingelser, String eier, String registreringsnummer, String baatType, String baatModell, String batLengde, String aarsmodell, String motortype, String motorstyrke) {
    super("Båt Forsikring", forsikringsbeløp, forsikringspremie, forsikringsbetingelser);
    this.eier = eier;
    this.registreringsNr = registreringsnummer;
    this.batType = baatType;
    this.batModell = baatModell;
    this.batLengde = batLengde;
    this.arsModell = aarsmodell;
    this.motorType = motortype;
    this.motorStyrke = motorstyrke;

  }

  public String getEier() {
    return eier;
  }

  public void setEier(String eier) {
    this.eier = eier;
  }

  public String getRegistreringsNr() {
    return registreringsNr;
  }

  public void setRegistreringsNr(String registreringsNr) {
    this.registreringsNr = registreringsNr;
  }

  public String getBatType() {
    return batType;
  }

  public void setBatType(String batType) {
    this.batType = batType;
  }

  public String getBatModell() {
    return batModell;
  }

  public void setBatModell(String batModell) {
    this.batModell = batModell;
  }

  public String getBatLengde() {
    return batLengde;
  }

  public void setBatLengde(String batLengde) {
    this.batLengde = batLengde;
  }

  public String getArsModell() {
    return arsModell;
  }

  public void setArsModell(String arsModell) {
    this.arsModell = arsModell;
  }

  public String getMotorType() {
    return motorType;
  }

  public void setMotorType(String motorType) {
    this.motorType = motorType;
  }

  public String getMotorStyrke() {
    return motorStyrke;
  }

  public void setMotorStyrke(String motorStyrke) {
    this.motorStyrke = motorStyrke;
  }


  @Override
  public String toString() {
    return "BatForsikring{" +
            "eier='" + eier + '\'' +
            ", registreringsNr='" + registreringsNr + '\'' +
            ", batType='" + batType + '\'' +
            ", batModell='" + batModell + '\'' +
            ", batLengde='" + batLengde + '\'' +
            ", arsModell='" + arsModell + '\'' +
            ", motorType='" + motorType + '\'' +
            ", motorStyrke='" + motorStyrke + '\'' +
            "} " + super.toString();
  }
}
