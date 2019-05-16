package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class SkademeldingValideringStatus {

  private static SimpleBooleanProperty forsikrinsBelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty klokkeslettStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty datoStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty skadetypeStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty skadebeskrivelseStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty skadeinformasjonStatus = new SimpleBooleanProperty(false);


  public static SimpleBooleanProperty erForsikringbelopGyldig() {
    return forsikrinsBelopStatus;
  }


  public static SimpleBooleanProperty erKlokkeslettGyldig() {
    return klokkeslettStatus;
  }

  public static SimpleBooleanProperty erDatoGyldig() {
    return datoStatus;
  }


  public static SimpleBooleanProperty erSkadetypeGyldig() {
    return skadetypeStatus;
  }


  public static SimpleBooleanProperty erSkadebeskrivelseGyldig() {
    return skadebeskrivelseStatus;
  }


  public static SimpleBooleanProperty erSkadeinformasjonGyldig() {
    return skadeinformasjonStatus;
  }

  public static void nullstillValideringStatus() {
    SkademeldingValideringStatus.erForsikringbelopGyldig().set(false);
    SkademeldingValideringStatus.erKlokkeslettGyldig().set(false);
    SkademeldingValideringStatus.erDatoGyldig().set(false);
    SkademeldingValideringStatus.erSkadetypeGyldig().set(false);
    SkademeldingValideringStatus.erSkadebeskrivelseGyldig().set(false);
    SkademeldingValideringStatus.erSkadeinformasjonGyldig().set(false);

  }


}
