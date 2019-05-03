package programutvikling.validering;

public class ReiseforsikringValidator {

    private static String UGYLDIG_BELOP_REGEX = "^([0-9]){2,12}|((\\.[0-9]{1,2}))$";

    private static String UGYLDIG_FORSIKRINGSSUM_MELDING = "Forsikringssum tillater 2-12 tall";

    private static String UGYLDIG_FORSIKRINS_BELOP_MELDING = "Forsikringsbeløp tillater 2-12 tall";

    private static String UGYLDIG_FORSIKRINSPREMIE_MELDING = "Forsikringspremie tillater 2-12 tall";

    private static String UGYLDIG_FORSIKRINS_OMRADE_MELDING = "Forsikringsområde må være mellom 2-16 skandinaviske bokstaver og eller tall";
    private static String UGYLDIG_FORSIKRINS_OMRADE_REGEX = "^[a-zA-ZäöæøåøÄÖÆØÅ[0-9] ]{2,16}?$";

    public static String getUgyldigBelopRegex() {
        return UGYLDIG_BELOP_REGEX;
    }

    public static String getUgyldigForsikringssumMelding() {
        return UGYLDIG_FORSIKRINGSSUM_MELDING;
    }

    public static String getUgyldigForsikrinsBelopMelding() {
        return UGYLDIG_FORSIKRINS_BELOP_MELDING;
    }

    public static String getUgyldigForsikrinspremieMelding() {
        return UGYLDIG_FORSIKRINSPREMIE_MELDING;
    }

    public static String getUgyldigForsikrinsOmradeMelding() {
        return UGYLDIG_FORSIKRINS_OMRADE_MELDING;
    }

    public static String getUgyldigForsikrinsOmradeRegex() {
        return UGYLDIG_FORSIKRINS_OMRADE_REGEX;
    }
}
