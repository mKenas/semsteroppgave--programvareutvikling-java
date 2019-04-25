package programutvikling.status;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;

public class InnlesingOgSkrivingStatus implements Observable {

  private static SimpleBooleanProperty lasterInnFraFil = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty lagrerTilFil = new SimpleBooleanProperty(false);;

  public static SimpleBooleanProperty erInnlesingAktiv() {
    return lasterInnFraFil;
  }

  public static void setInnlesingStatus(SimpleBooleanProperty lasterInnFraFil) {
    InnlesingOgSkrivingStatus.lasterInnFraFil = lasterInnFraFil;
  }

  public static SimpleBooleanProperty erSkrivingAktiv() {
    return lagrerTilFil;
  }

  public static void setSkrivingAktiv(SimpleBooleanProperty lagrerTilFil) {
    InnlesingOgSkrivingStatus.lagrerTilFil = lagrerTilFil;
  }

  @Override
  public void addListener(InvalidationListener invalidationListener) {

  }

  @Override
  public void removeListener(InvalidationListener invalidationListener) {

  }
}
