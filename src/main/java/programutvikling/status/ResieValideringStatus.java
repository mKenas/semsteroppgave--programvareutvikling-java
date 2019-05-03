package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class ResieValideringStatus {

  private static SimpleBooleanProperty omroddeStatus = new SimpleBooleanProperty(false);



  private static SimpleBooleanProperty forsikringbelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikringSumStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikringpremieStatus = new SimpleBooleanProperty(false);

  public static SimpleBooleanProperty erOmrodeyldig() {
    return omroddeStatus;
  }
  public static SimpleBooleanProperty erforsikringSumGyldig() {
    return forsikringSumStatus;
  }
  public static SimpleBooleanProperty erforsikringbelopGyldig() {
    return forsikringbelopStatus;
  }
  public static SimpleBooleanProperty getForsikringspremieGyldig() {
    return forsikringpremieStatus;
  }


}
