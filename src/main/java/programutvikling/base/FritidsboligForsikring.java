package programutvikling.base;

public class FritidsboligForsikring extends Forsikring {

  private String boligAdresse;
  private String byggeaar;
  private String boligType;
  private String byggeMateriale;
  private String standard;
  private String storrelse;
  private String bygningsForsikringsbelop;
  private String innboForsikringsbelop;

  public FritidsboligForsikring(Double forsikringsbelop, Double forsikringspremie, String forsikringsbetingelser,
                                String boligAdresse, String byggeaar, String boligType, String byggeMateriale,
                                String standard, String storrelse, String bygningsForsikringsbelop,
                                String innboForsikringsbelop) {
    super(forsikringsbelop, forsikringspremie, forsikringsbetingelser);
    this.boligAdresse = boligAdresse;
    this.byggeaar = byggeaar;
    this.boligType = boligType;
    this.byggeMateriale = byggeMateriale;
    this.standard = standard;
    this.storrelse = storrelse;
    this.bygningsForsikringsbelop = bygningsForsikringsbelop;
    this.innboForsikringsbelop = innboForsikringsbelop;
  }
}
