package programutvikling.validering;

public class registrerKundeValidator {

    private static String UGYLDIG_PERSONNUMMER_FEILMELDING = "Personnummer tillater kun 11 tall";
    private static String UGYLDIG_PERSONNUMMER_REGEX = "^[0-9]{11}$";

    private static String UGYLDIG_NAVN_FEILMELDING = "Navnet må være mellom 2-16 skandinaviske bokstaver";
    private static String UGYLDIG_NAVN_REGEX = "^[a-zA-ZäöæøåøÄÖÆØÅ]{2,16}$";

    private static String UGYLDIG_ETTERNAVN_FEILMELDING = "Etternavnet må være mellom 2-16 skandinaviske bokstaver";
    private static String UGYLDIG_ETTERNAVN_REGEX = "^[a-zA-ZäöæøåøÄÖÆØÅ]{2,16}$";

    private static String UGYLDIG_FAKTURA_ADRESSE_FEILMELDING = "Adressen må være mellom 2-36 skandinaviske bokstaver eller tall";
    private static String UGYLDIG_FAKTURA_ADRESSE_REGEX = "^[0-9a-zA-ZäöæøåøÄÖÆØÅ ]{2,36}$";

    private static String UGYLDIG_POSTNUMMER_FEILMELDING = "Postnummeret må være på 4 tall";
    private static String UGYLDIG_POSTNUMMER_REGEX = "^[0-9]{4}";

    private static String UGYLDIG_POSTSTED_FEILMELDING = "Poststedet må være på 2-18 bokstaver";
    private static String UGYLDIG_POSTSTED_REGEX = "^[a-zA-ZäöæøåøÄÖÆØÅ]{2,18}$";

    private static String UGYLDIG_EPOST_FEILMELDING = "Eposten må inneholde tall eller bokstaver før og etter '@'";
    private static String UGYLDIG_EPOST_REGEX = "^[a-zA-Z0-9]+@[a-zA-Z0-9]{0,42}$";

    private static String UGYLDIG_MOBIL_FEILMELDING = "Telefonnummer må være på 8 tall";
    private static String UGYLDIG_MOBIL_REGEX = "^[0-9]{8}$";


    public static String getUgyldigPersonnummerFeilmelding() {
        return UGYLDIG_PERSONNUMMER_FEILMELDING;
    }

    public static String getUgyldigPersonnummerRegex() {
        return UGYLDIG_PERSONNUMMER_REGEX;
    }

    public static String getUgyldigNavnFeilmelding() {
        return UGYLDIG_NAVN_FEILMELDING;
    }

    public static String getUgyldigNavnRegex() {
        return UGYLDIG_NAVN_REGEX;
    }

    public static String getUgyldigEtternavnFeilmelding() {
        return UGYLDIG_ETTERNAVN_FEILMELDING;
    }

    public static String getUgyldigEtternavnRegex() {
        return UGYLDIG_ETTERNAVN_REGEX;
    }

    public static String getUgyldigFakturaAdresseFeilmelding() {
        return UGYLDIG_FAKTURA_ADRESSE_FEILMELDING;
    }

    public static String getUgyldigFakturaAdresseRegex() {
        return UGYLDIG_FAKTURA_ADRESSE_REGEX;
    }

    public static String getUgyldigPostnummerFeilmelding() {
        return UGYLDIG_POSTNUMMER_FEILMELDING;
    }

    public static String getUgyldigPostnummerRegex() {
        return UGYLDIG_POSTNUMMER_REGEX;
    }

    public static String getUgyldigPoststedFeilmelding() {
        return UGYLDIG_POSTSTED_FEILMELDING;
    }

    public static String getUgyldigPoststedRegex() {
        return UGYLDIG_POSTSTED_REGEX;
    }

    public static String getUgyldigEpostFeilmelding() {
        return UGYLDIG_EPOST_FEILMELDING;
    }

    public static String getUgyldigEpostRegex() {
        return UGYLDIG_EPOST_REGEX;
    }

    public static String getUgyldigMobilFeilmelding() {
        return UGYLDIG_MOBIL_FEILMELDING;
    }

    public static String getUgyldigMobilRegex() {
        return UGYLDIG_MOBIL_REGEX;
    }
}
