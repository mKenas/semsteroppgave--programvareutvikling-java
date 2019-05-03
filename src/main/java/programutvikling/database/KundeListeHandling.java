package programutvikling.database;

import javafx.collections.ObservableList;
import programutvikling.base.Kunde;
import programutvikling.feilmeldinger.KundeEksistererExceptionHandler;

public class KundeListeHandling {

  private ObservableList<Kunde> kundeListe;

  public KundeListeHandling(ObservableList<Kunde> kundeListe) {
    this.kundeListe = kundeListe;
  }

  public void leggTilKunde(Kunde kunde) {

    if (!this.kundeListe.contains(kunde)) {
      this.kundeListe.add(kunde);
    } else KundeEksistererExceptionHandler.genererKundeEksistererExceptionMsg();

  }

  public void slettKunde(Kunde kunde) {

    this.kundeListe.remove(kunde);

  }







  public void nullstillKundeListe() {
    this.kundeListe.clear();


  }


}
