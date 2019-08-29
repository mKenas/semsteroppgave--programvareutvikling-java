package programutvikling.base;

import programutvikling.egenDefinertTyper.SkademeldingStatus;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Skademelding implements Serializable {
  private String skademeldingNr;
  private String skadeDato;
  private String klokkeSlett;
  private String forsikringsType;
  private String skadeType;
  private String skadeBeskrivelse;
  private String ovrigSkadeInformasjon;
  private Double takseringsbelop;
  private Double utbetaltErstatningsbelop;
  private DateFormat datoFormat;
  private String opprettelsesDato;
  private SkademeldingStatus status;

  public Skademelding() {


    this.skademeldingNr = UUID.randomUUID().toString();
    this.skadeDato = "";
    this.klokkeSlett = "";
    this.forsikringsType = "";
    this.skadeType = "";
    this.takseringsbelop = 0.0;
    this.utbetaltErstatningsbelop = 0.0;
    this.skadeBeskrivelse = "";
    this.ovrigSkadeInformasjon = "";

    this.datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    this.opprettelsesDato = "";

    this.status = SkademeldingStatus.UBEHANDLET;
  }

  public Skademelding(String skadeDato, String klokkeSlett, String forsikringsType, String skadeType, Double takseringsbelop, Double utbetaltErstatningsbelop, String skadeBeskrivelse, String ovrigSkadeInformasjon) {
    this.skademeldingNr = UUID.randomUUID().toString();
    this.skadeDato = skadeDato;
    this.klokkeSlett = klokkeSlett;
    this.forsikringsType = forsikringsType;
    this.skadeType = skadeType;
    this.takseringsbelop = takseringsbelop;
    this.utbetaltErstatningsbelop = utbetaltErstatningsbelop;
    this.skadeBeskrivelse = skadeBeskrivelse;
    this.ovrigSkadeInformasjon = ovrigSkadeInformasjon;

    this.datoFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    this.opprettelsesDato = datoFormat.format(new Date());

    this.status = SkademeldingStatus.UBEHANDLET;
  }

  public String getSkadeDato() {
    return skadeDato;
  }

  public void setSkadeDato(String skadeDato) {
    this.skadeDato = skadeDato;
  }

  public String getSkademeldingNr() {
    return skademeldingNr;
  }

  public void setSkademeldingNr(String skademeldingNr) {
    this.skademeldingNr = skademeldingNr;
  }

  public String getForsikringsType() {
    return forsikringsType;
  }

  public void setForsikringsType(String forsikringsType) {
    this.forsikringsType = forsikringsType;
  }

  public String getSkadeType() {
    return skadeType;
  }

  public void setSkadeType(String skadeType) {
    this.skadeType = skadeType;
  }

  public String getSkadeBeskrivelse() {
    return skadeBeskrivelse;
  }

  public void setSkadeBeskrivelse(String skadeBeskrivelse) {
    this.skadeBeskrivelse = skadeBeskrivelse;
  }

  public String getOvrigSkadeInformasjon() {
    return ovrigSkadeInformasjon;
  }

  public void setOvrigSkadeInformasjon(String ovrigSkadeInformasjon) {
    this.ovrigSkadeInformasjon = ovrigSkadeInformasjon;
  }

  public Double getTakseringsbelop() {
    return takseringsbelop;
  }

  public void setTakseringsbelop(Double takseringsbelop) {
    this.takseringsbelop = takseringsbelop;
  }

  public Double getUtbetaltErstatningsbelop() {
    return utbetaltErstatningsbelop;
  }

  public void setUtbetaltErstatningsbelop(Double utbetaltErstatningsbelop) {
    this.utbetaltErstatningsbelop = utbetaltErstatningsbelop;
  }

  public SkademeldingStatus getStatus() {
    return status;
  }

  public void setStatus(SkademeldingStatus status) {
    this.status = status;
  }

  public String getOpprettelsesDato() {
    return opprettelsesDato;
  }

  public void setOpprettelsesDato(String opprettelsesDato) {
    this.opprettelsesDato = opprettelsesDato;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Skademelding that = (Skademelding) o;
    return Objects.equals(skademeldingNr, that.skademeldingNr);
  }

  public String getKlokkeSlett() {
    return klokkeSlett;
  }

  public void setKlokkeSlett(String klokkeSlett) {
    this.klokkeSlett = klokkeSlett;
  }

  @Override
  public int hashCode() {

    return Objects.hash(skademeldingNr);
  }

  @Override
  public String toString() {
    return "Skademelding{" +
            "skademeldingNr='" + skademeldingNr + '\'' +
            ", skadeDato='" + skadeDato + '\'' +
            ", klokkeSlett='" + klokkeSlett + '\'' +
            ", forsikringsType='" + forsikringsType + '\'' +
            ", skadeType='" + skadeType + '\'' +
            ", skadeBeskrivelse='" + skadeBeskrivelse + '\'' +
            ", ovrigSkadeInformasjon='" + ovrigSkadeInformasjon + '\'' +
            ", takseringsbelop=" + takseringsbelop +
            ", utbetaltErstatningsbelop=" + utbetaltErstatningsbelop +
            ", datoFormat=" + datoFormat +
            ", opprettelsesDato='" + opprettelsesDato + '\'' +
            ", status=" + status +
            '}';
  }
}
