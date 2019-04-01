package programutvikling.base;

public class InvalidAgeException extends IllegalArgumentException {

  public InvalidAgeException() {
    super("Alder må være mellom 0 og 120");
  }

}
