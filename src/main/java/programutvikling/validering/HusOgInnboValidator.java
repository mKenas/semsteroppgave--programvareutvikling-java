package programutvikling.validering;

import javafx.beans.property.SimpleBooleanProperty;

public class HusOgInnboValidator {

  private static SimpleBooleanProperty adresseStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty byggeArStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty boligTypeStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty byggeMaterialeStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty boligStanderStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty antallKvadratmeterStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty byggningsbelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty innbobelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikringbelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikringpremieStatus = new SimpleBooleanProperty(false);


  public static SimpleBooleanProperty erAdresseGyldig() {
    return adresseStatus;
  }

  public static SimpleBooleanProperty erByggeArGyldig() {
    return byggeArStatus;
  }

  public static SimpleBooleanProperty erBoligTypeGyldig() {
    return boligTypeStatus;
  }

  public static SimpleBooleanProperty erbyggeMaterialeGyldig() {
    return byggeMaterialeStatus;
  }

  public static SimpleBooleanProperty erBoligStanderGyldig() {
    return boligStanderStatus;
  }

    public static SimpleBooleanProperty erAntallKvadratmeterGyldig() {
    return antallKvadratmeterStatus;
  }
      public static SimpleBooleanProperty erByggningsbelopGyldig() {
    return byggningsbelopStatus;
  }

  public static SimpleBooleanProperty erInnbobelopGyldig() {
    return innbobelopStatus;
  }

  public static SimpleBooleanProperty erforsikringbelopGyldig() {
    return forsikringbelopStatus;
  }




  public static SimpleBooleanProperty getForsikringspremieGyldig() {
    return forsikringpremieStatus;
  }


  private static String UGYLDIG_ADDRESSE_FEILMELDING ="Adressen må være mellom 2-36 skandinaviske bokstaver eller tall";
  private static String UGYLDIG_ADDRESSE_REGEX ="^[0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,36}$";
  private static String UGYLDIG_BYGGE_AR_FEILMELDING ="Boligen må være bygget mellom 1800-tallet til dags dato";
  private static String UGYLDIG_BYGGE_AR_REGEX ="^(18[0-9]\\d|19[0-9]\\d|20[01]\\d)?$";

  private static String UGYLDIG_StING_FELT_REGEX ="^([a-zA-ZäöæøåøÄÖÆØÅ ]{2,20})?$";

  private static String UGYLDIG_BOLIGTYPE_FEILMELDING ="Boligtypen må være mellom 2 til 20 bosktaver";
  private static String UGYLDIG_BYGGEMATERIALE_FEILMELDING ="Byggemateriale må være mellom 2 til 20 bosktaver";
  private static String UGYLDIG_BOLIGSTANDER_FEILMELDING ="Boligstander må være mellom 2 til 20 bosktaver";

  private static String UGYLDIG_ANTALL_KVADRATMETER_FEILMELDING ="Antall kvadratmeter tillater kun 2-4 tall";
  private static String UGYLDIG_ANTALL_KVADRATMETER_REGEX ="^([0-9]{2,4})$";


  private static String UGYLDIG_BELOP_REGEX ="^([0-9]){2,12}|((\\.[0-9]{2,2}))$";


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
    return UGYLDIG_StING_FELT_REGEX;
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
