package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class InnlesingOgSkrivingStatus  {

  private static SimpleBooleanProperty lasterInnFraFil = new SimpleBooleanProperty(false);

  public static SimpleBooleanProperty erInnlesingEllerSkrivingAktiv() {
    return lasterInnFraFil;
  }



}
