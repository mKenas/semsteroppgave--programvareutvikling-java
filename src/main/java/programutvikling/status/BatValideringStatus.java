package programutvikling.status;

import javafx.beans.property.SimpleBooleanProperty;

public class BatValideringStatus {

  private static SimpleBooleanProperty forsikrinsBelopStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty forsikrinspremiepStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty eierStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty registreringsNrStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty batTypeStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty batModelltatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty batLengdetatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty arsModellStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty motorTypeStatus = new SimpleBooleanProperty(false);
  private static SimpleBooleanProperty motorStyrkeStatus = new SimpleBooleanProperty(false);


  public static SimpleBooleanProperty erForsikrinsBelopGyldig() {
    return forsikrinsBelopStatus;
  }


  public static SimpleBooleanProperty erForsikrinspremieGyldig() {
    return forsikrinspremiepStatus;
  }

  public static SimpleBooleanProperty erEierGyldig() {
    return eierStatus;
  }


  public static SimpleBooleanProperty erRegistreringsNrGyldig() {
    return registreringsNrStatus;
  }


  public static SimpleBooleanProperty erBattypeGyldig() {
    return batTypeStatus;
  }


  public static SimpleBooleanProperty erBatmodellGyldig() {
    return batModelltatus;
  }


  public static SimpleBooleanProperty erBatlengdeGyldig() {
    return batLengdetatus;
  }


  public static SimpleBooleanProperty erArsmodellGyldig() {
    return arsModellStatus;
  }


  public static SimpleBooleanProperty erMotorTypeGyldig() {
    return motorTypeStatus;
  }


  public static SimpleBooleanProperty erMotorStyrkeGyldig() {
    return motorStyrkeStatus;
  }

  public static void nullstillValideringStatus() {

    BatValideringStatus.erForsikrinsBelopGyldig().set(false);
    BatValideringStatus.erForsikrinspremieGyldig().set(false);
    BatValideringStatus.erEierGyldig().set(false);
    BatValideringStatus.erRegistreringsNrGyldig().set(false);
    BatValideringStatus.erBattypeGyldig().set(false);
    BatValideringStatus.erBatmodellGyldig().set(false);
    BatValideringStatus.erBatlengdeGyldig().set(false);
    BatValideringStatus.erArsmodellGyldig().set(false);
    BatValideringStatus.erMotorTypeGyldig().set(false);
    BatValideringStatus.erMotorStyrkeGyldig().set(false);
  }

}
