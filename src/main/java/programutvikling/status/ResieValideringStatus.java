package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class ResieValideringStatus {

  private static SimpleBooleanProperty omrodeStatus = new SimpleBooleanProperty(false);


  private static SimpleBooleanProperty forsikringbelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikringSumStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikringpremieStatus = new SimpleBooleanProperty(false);

  public static SimpleBooleanProperty erOmrodGyldig() {
    return omrodeStatus;
  }

  public static SimpleBooleanProperty erForsikringSumGyldig() {
    return forsikringSumStatus;
  }

  public static SimpleBooleanProperty erForsikringbelopGyldig() {
    return forsikringbelopStatus;
  }

  public static SimpleBooleanProperty erForsikringspremieGyldig() {
    return forsikringpremieStatus;
  }


  public static void nullstillValideringStatus() {

    ResieValideringStatus.erOmrodGyldig().set(false);
    ResieValideringStatus.erForsikringSumGyldig().set(false);
    ResieValideringStatus.erForsikringbelopGyldig().set(false);
    ResieValideringStatus.erForsikringspremieGyldig().set(false);
  }
}
