package programutvikling.database;

public class DataHandlingObjekt {
  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  KundeMedForsikringListeHandling kundeMedForsikringListeHandling;
  KundeListeHandling kundeListeHandling;
  KundeMedSkademeldingListeHandling kundeMedSkademeldingListeHandling;

  public DataHandlingObjekt() {
    this.kundeMedForsikringListeHandling = new KundeMedForsikringListeHandling(dlo.getKundeMedForsikringListe(), dlo.getForsikringListe());
    this.kundeListeHandling = new KundeListeHandling(dlo.getKundeListe());
    this.kundeMedSkademeldingListeHandling = new KundeMedSkademeldingListeHandling(dlo.getKundeMedSkadeMeldingListe(), dlo.getAlleSkadeMeldinger());


  }

  public KundeMedForsikringListeHandling getKundeMedForsikringListeHandling() {
    return kundeMedForsikringListeHandling;
  }

  public KundeListeHandling getKundeListeHandling() {
    return kundeListeHandling;
  }

  public KundeMedSkademeldingListeHandling getKundeMedSkademeldingListeHandling() {
    return kundeMedSkademeldingListeHandling;
  }
}
