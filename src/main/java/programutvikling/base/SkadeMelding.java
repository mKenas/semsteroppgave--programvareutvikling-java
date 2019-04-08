package programutvikling.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SkadeMelding {

  private Date skadeDato;
  private String skadenummer;
  private String skadeType;
  private String skadeBeskrivelse;
  private ArrayList vitner;
  private Double takseringsbeløp;
  private Double utbetaltErstatningsbeløp;
  private DateFormat datoFormat;


  public SkadeMelding(String skadenummer, String skadeType, String skadeBeskrivelse, ArrayList vitner, Double takseringsbeløp, Double utbetaltErstatningsbeløp) {
    this.skadenummer = skadenummer;
    this.skadeType = skadeType;
    this.skadeBeskrivelse = skadeBeskrivelse;
    this.vitner = vitner;
    this.takseringsbeløp = takseringsbeløp;
    this.utbetaltErstatningsbeløp = utbetaltErstatningsbeløp;
    this.datoFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    this.skadeDato = new Date();
  }
}
