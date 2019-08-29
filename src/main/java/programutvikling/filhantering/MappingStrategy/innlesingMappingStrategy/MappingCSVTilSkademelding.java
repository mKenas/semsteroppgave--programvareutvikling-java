package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;

import java.util.List;

public class MappingCSVTilSkademelding extends InnlesingMappingStrategy<Kunde> {


  List<Skademelding> skademeldingListe;

  public MappingCSVTilSkademelding(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {
      @Override
      public boolean allowLine(String[] strings) {

        boolean erSkademelding = false;
        if (strings.length >= 20) {
          String skadesNr = strings[34];


          erSkademelding = !"".equals(skadesNr);

          if (erSkademelding) {


            if (strings[40].equals(""))
              strings[40] = "0.0";

            if (strings[41].equals(""))
              strings[41] = "0.0";

          }

        }


        return erSkademelding;
      }
    };

    this.skademeldingListe = objektTilCSV(filstil, Skademelding.class, filter);


  }

  public List<Skademelding> getSkademeldingListe() {
    return skademeldingListe;
  }
}
