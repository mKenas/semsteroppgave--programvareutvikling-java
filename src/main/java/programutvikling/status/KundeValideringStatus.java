package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class KundeValideringStatus {

  private static SimpleBooleanProperty personNrStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty navnStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty etterNavnStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty epostStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty mobilStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty adresseStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty postNrStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty poststedStatus = new SimpleBooleanProperty(false);


  public static SimpleBooleanProperty erPersonNrGyldig() {
    return personNrStatus;
  }

  public static SimpleBooleanProperty erNavnGyldig() {
    return navnStatus;
  }

  public static SimpleBooleanProperty erEtternavnGyldig() {
    return etterNavnStatus;
  }

  public static SimpleBooleanProperty erEpostGyldig() {
    return epostStatus;
  }

  public static SimpleBooleanProperty erMobilGyldig() {
    return mobilStatus;
  }

  public static SimpleBooleanProperty erAdresseGyldig() {
    return adresseStatus;
  }

  public static SimpleBooleanProperty erPostNrGyldig() {
    return postNrStatus;
  }

  public static SimpleBooleanProperty erPoststedGyldig() {
    return poststedStatus;
  }


  public static void nullstilValideringStatus() {

    KundeValideringStatus.erPersonNrGyldig().set(false);
    KundeValideringStatus.erNavnGyldig().set(false);
    KundeValideringStatus.erEtternavnGyldig().set(false);
    KundeValideringStatus.erAdresseGyldig().set(false);
    KundeValideringStatus.erPostNrGyldig().set(false);
    KundeValideringStatus.erPoststedGyldig().set(false);
    KundeValideringStatus.erEpostGyldig().set(false);
    KundeValideringStatus.erMobilGyldig().set(false);
  }

}
