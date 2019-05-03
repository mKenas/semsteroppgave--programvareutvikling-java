package programutvikling.validering;

public class BatforsikringValidator {


  private static String UGYLDIG_BELOP_REGEX = "([0-9]){2,12}((\\.[0-9]{1,2})?)$";

  private static String UGYLDIG_FORSIKRINS_BELOP_MELDING = "Forsikringsbeløp tillater 2-12 tall";

  private static String UGYLDIG_FORSIKRINSPREMIE_MELDING = "Forsikringspremie tillater 2-12 tall";

  private static String UGYLDIG_EIER_FEILMELDING = "Eierens navn må være mellom 2-16 skandinaviske bokstaver";
  private static String UGYLDIG_EIER_REGEX = "^[a-zA-ZäöæøåøÄÖÆØÅ ]{2,16}?$";

  private static String UGYLDIG_REGISTRERINGSNUMMER_FEILMELDING = "Registreringsnummeret må være på 'ABC123' format";
  private static String UGYLDIG_REGISTRERINGSNUMMER_REGEX = "^([A-Za-z]{3})([0-9]{3})$";

  private static String UGYLDIG_BATTYPE_FEILMELDING = "Båttypen må være mellom 2-16 skandinaviske bokstaver";
  private static String UGYLDIG_BATTYPE_REGEX = "^([a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]){2,16}?$";

  private static String UGYLDIG_BATMODELL_FEILMELDING = "Båtmodellen må være mellom 2-16 skandinaviske bokstaver og eller tall";
  private static String UGYLDIG_BATMODELL_REGEX = "^([a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]){2,16}?$";

  private static String UGYLDIG_BATLENGDE_FEILMELDING = "Båtlengde må være mellom 1-8 tall";
  private static String UGYLDIG_BATLENGDE_REGEX = "^([0-9]{1,8})$";

  private static String UGYLDIG_ARSMODELL_FEILMELDING = "Årsmodellen må være fra 1800-tallet til dags dato";
  private static String UGYLDIG_ARSMODELL_REGEX = "^(18[0-9]\\d|19[0-9]\\d|20[01]\\d)?";

  private static String UGYLDIG_MOTOR_TYPE_FEILMELDING = "Motortypen må være mellom 2-16 bokstaver";
  private static String UGYLDIG_MOTOR_TYPE_REGEX = "^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,16})?$";

  private static String UGYLDIG_MOTOR_STYRKE_FEILMELDING = "Motorstyrken må være mellom 1-4 tall oppgitt i HK";
  private static String UGYLDIG_MOTOR_STYRKE_REGEX = "^([0-9]{1,4})?$";

  public static String getUgyldigBelopRegex() {
    return UGYLDIG_BELOP_REGEX;
  }

  public static String getUgyldigForsikrinsBelopMelding() {
    return UGYLDIG_FORSIKRINS_BELOP_MELDING;
  }

  public static String getUgyldigForsikrinspremieMelding() {
    return UGYLDIG_FORSIKRINSPREMIE_MELDING;
  }

  public static String getUgyldigEierFeilmelding() {
    return UGYLDIG_EIER_FEILMELDING;
  }

  public static String getUgyldigEierRegex() {
    return UGYLDIG_EIER_REGEX;
  }

  public static String getUgyldigRegistreringsnummerFeilmelding() {
    return UGYLDIG_REGISTRERINGSNUMMER_FEILMELDING;
  }

  public static String getUgyldigRegistreringsnummerRegex() {
    return UGYLDIG_REGISTRERINGSNUMMER_REGEX;
  }

  public static String getUgyldigBattypeFeilmelding() {
    return UGYLDIG_BATTYPE_FEILMELDING;
  }

  public static String getUgyldigBattypeRegex() {
    return UGYLDIG_BATTYPE_REGEX;
  }

  public static String getUgyldigBatmodellFeilmelding() {
    return UGYLDIG_BATMODELL_FEILMELDING;
  }

  public static String getUgyldigBatmodellRegex() {
    return UGYLDIG_BATMODELL_REGEX;
  }

  public static String getUgyldigBatlengdeFeilmelding() {
    return UGYLDIG_BATLENGDE_FEILMELDING;
  }

  public static String getUgyldigBatlengdeRegex() {
    return UGYLDIG_BATLENGDE_REGEX;
  }

  public static String getUgyldigArsmodellFeilmelding() {
    return UGYLDIG_ARSMODELL_FEILMELDING;
  }

  public static String getUgyldigArsmodellRegex() {
    return UGYLDIG_ARSMODELL_REGEX;
  }

  public static String getUgyldigMotorTypeFeilmelding() {
    return UGYLDIG_MOTOR_TYPE_FEILMELDING;
  }

  public static String getUgyldigMotorTypeRegex() {
    return UGYLDIG_MOTOR_TYPE_REGEX;
  }

  public static String getUgyldigMotorStyrkeFeilmelding() {
    return UGYLDIG_MOTOR_STYRKE_FEILMELDING;
  }

  public static String getUgyldigMotorStyrkeRegex() {
    return UGYLDIG_MOTOR_STYRKE_REGEX;
  }
}