package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class InnboOgfritidValideringStatus {

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


  public static void nullstilValideringStatus() {

    InnboOgfritidValideringStatus.erAdresseGyldig().set(false);
    InnboOgfritidValideringStatus.erByggeArGyldig().set(false);
    InnboOgfritidValideringStatus.erBoligTypeGyldig().set(false);
    InnboOgfritidValideringStatus.erbyggeMaterialeGyldig().set(false);
    InnboOgfritidValideringStatus.erBoligStanderGyldig().set(false);
    InnboOgfritidValideringStatus.erAntallKvadratmeterGyldig().set(false);
    InnboOgfritidValideringStatus.erByggningsbelopGyldig().set(false);
    InnboOgfritidValideringStatus.erInnbobelopGyldig().set(false);
    InnboOgfritidValideringStatus.erforsikringbelopGyldig().set(false);
    InnboOgfritidValideringStatus.getForsikringspremieGyldig().set(false);
  }


}
