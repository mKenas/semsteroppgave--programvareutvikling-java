package programutvikling.validering;

public class SkademeldingValidator {


  private static String UGYLDIG_KLOKKESLETT_MELDING = "Klokkeslett må være i 'HH:MM' format";
  private static String UGYLDIG_KLOKKESLETT_REGEX = "(^[0-9]{2}(:)[0-9]{2})?$";

  private static String UGYLDIG_SKADETYPE_MELDING = "Skadetypen må være mellom 2-20 skandinaviske bokstaver";
  private static String UGYLDIG_SKADETYPE_REGEX = "^([0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$";

  private static String UGYLDIG_SKADEBESKRIVELSE_MELDING = "Skadetypen må være mellom 2-20 skandinaviske bokstaver";
  private static String UGYLDIG_SKADEBESKRIVELSE_REGEX = "^([0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,140})?$";

  private static String UGYLDIG_SKADEINFORMASJON_MELDING = "Øvrig informasjon må være mellom 0-140 skandinaviske og tall";
  private static String UGYLDIG_SKADEINFORMASJON_REGEX = "^([0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,140})?$";

  private static String UGYLDIG_BELOP_REGEX = "^([0-9]){2,12}((\\.[0-9]{1,2})?)$";
  private static String UGYLDIG_FORSIKRINGBELOP_FEILMELDING = "Beløp tillater 2-12 tall";

  public static String getUgyldigForsikringbelopFeilmelding() {
    return UGYLDIG_FORSIKRINGBELOP_FEILMELDING;
  }

  public static String getUgyldigBelopRegex() {
    return UGYLDIG_BELOP_REGEX;
  }

  public static String getUgyldigKlokkeslettMelding() {
    return UGYLDIG_KLOKKESLETT_MELDING;
  }

  public static String getUgyldigKlokkeslettRegex() {
    return UGYLDIG_KLOKKESLETT_REGEX;
  }

  public static String getUgyldigSkadetypeMelding() {
    return UGYLDIG_SKADETYPE_MELDING;
  }

  public static String getUgyldigSkadetypeRegex() {
    return UGYLDIG_SKADETYPE_REGEX;
  }

  public static String getUgyldigSkadebeskrivelseMelding() {
    return UGYLDIG_SKADEBESKRIVELSE_MELDING;
  }

  public static String getUgyldigSkadebeskrivelseRegex() {
    return UGYLDIG_SKADEBESKRIVELSE_REGEX;
  }

  public static String getUgyldigSkadeinformasjonMelding() {
    return UGYLDIG_SKADEINFORMASJON_MELDING;
  }

  public static String getUgyldigSkadeinformasjonRegex() {
    return UGYLDIG_SKADEINFORMASJON_REGEX;
  }
}
