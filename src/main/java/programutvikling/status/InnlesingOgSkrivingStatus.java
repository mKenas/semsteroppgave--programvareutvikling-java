package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class InnlesingOgSkrivingStatus  {

  private static SimpleBooleanProperty innlesingOgSkrivingStatus = new SimpleBooleanProperty(false);

  public static SimpleBooleanProperty erInnlesingEllerSkrivingAktiv() {
    return innlesingOgSkrivingStatus;
  }



}
