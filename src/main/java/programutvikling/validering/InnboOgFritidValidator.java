package programutvikling.validering;

public class InnboOgFritidValidator {


  private static String UGYLDIG_ADDRESSE_FEILMELDING ="Adressen må være mellom 2-36 skandinaviske bokstaver eller tall";
  private static String UGYLDIG_ADDRESSE_REGEX ="^[0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,36}$";
  private static String UGYLDIG_BYGGE_AR_FEILMELDING ="Boligen må være bygget mellom 1800-tallet til dags dato";
  private static String UGYLDIG_BYGGE_AR_REGEX ="^(18[0-9]\\d|19[0-9]\\d|20[01]\\d)?$";

  private static String UGYLDIG_STRING_FELT_REGEX ="^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$";

  private static String UGYLDIG_BOLIGTYPE_FEILMELDING ="Boligtypen må være mellom 2 til 20 bosktaver";
  private static String UGYLDIG_BYGGEMATERIALE_FEILMELDING ="Byggemateriale må være mellom 2 til 20 bosktaver";
  private static String UGYLDIG_BOLIGSTANDER_FEILMELDING ="Boligstander må være mellom 2 til 20 bosktaver";

  private static String UGYLDIG_ANTALL_KVADRATMETER_FEILMELDING ="Antall kvadratmeter tillater kun 2-4 tall";
  private static String UGYLDIG_ANTALL_KVADRATMETER_REGEX ="^([0-9]{2,4})$";


  private static String UGYLDIG_BELOP_REGEX ="^([0-9]){2,12}((\\.[0-9]{1,2})?)$";


  private static String UGYLDIG_BYGGNINGSBELOP_FEILMELDING ="Bygningensforsikringsbeløp tillater 2-12 tall";

  private static String UGYLDIG_INNBOBELOP_FEILMELDING ="Innboforsikringsbeløp tillater 2-12 tall";

  private static String UGYLDIG_FORSIKRINGBELOP_FEILMELDING ="Forsikringsbeløp tillater 2-12 tall";

  private static String UGYLDIG_FORSIKRINGPREMIE_FEILMELDING ="Forsikringspremie tillater 2-12 tall";








  public static String getUgyldigAddresseFeilmelding() {
    return UGYLDIG_ADDRESSE_FEILMELDING;
  }

  public static String getUgyldigAddresseRegex() {
    return UGYLDIG_ADDRESSE_REGEX;
  }

  public static String getUgyldigByggeArFeilmelding() {
    return UGYLDIG_BYGGE_AR_FEILMELDING;
  }

  public static String getUgyldigByggeArRegex() {
    return UGYLDIG_BYGGE_AR_REGEX;
  }

  public static String getUgyldigBoligtypeFeilmelding() {
    return UGYLDIG_BOLIGTYPE_FEILMELDING;
  }

  public static String getUGyldigStringRegex() {
    return UGYLDIG_STRING_FELT_REGEX;
  }

  public static String getUgyldigByggematerialeFeilmelding() {
    return UGYLDIG_BYGGEMATERIALE_FEILMELDING;
  }


  public static String getUgyldigBoligstanderFeilmelding() {
    return UGYLDIG_BOLIGSTANDER_FEILMELDING;
  }


  public static String getUgyldigAntallKvadratmeterFeilmelding() {
    return UGYLDIG_ANTALL_KVADRATMETER_FEILMELDING;
  }

  public static String getUgyldigAntallKvadratmeterRegex() {
    return UGYLDIG_ANTALL_KVADRATMETER_REGEX;
  }

  public static String getUgyldigByggningsbelopFeilmelding() {
    return UGYLDIG_BYGGNINGSBELOP_FEILMELDING;
  }

  public static String getUgyldigBelopRegex() {
    return UGYLDIG_BELOP_REGEX;
  }

  public static String getUgyldigInnbobelopFeilmelding() {
    return UGYLDIG_INNBOBELOP_FEILMELDING;
  }

  public static String getUgyldigForsikringbelopFeilmelding() {
    return UGYLDIG_FORSIKRINGBELOP_FEILMELDING;
  }


  public static String getUgyldigForsikringpremieFeilmelding() {
    return UGYLDIG_FORSIKRINGPREMIE_FEILMELDING;
  }






}
