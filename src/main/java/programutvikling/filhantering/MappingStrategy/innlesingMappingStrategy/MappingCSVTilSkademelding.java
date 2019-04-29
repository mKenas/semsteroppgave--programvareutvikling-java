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

        boolean result = false;
        if (strings.length >= 20) {
          String skadesNr = strings[34];





          result = !"".equals(skadesNr);

          if (result){
            // check if double values not null
            //System.out.println("strings[40] " + strings[40]);
            //System.out.println("strings[41] " +strings[41]);
            if (strings[40].equals("") )
              strings[40] = "0.0";

            if (strings[41].equals(""))
              strings[41] = "0.0";

          }

        }


        return result;
        //return true;
      }
    };

    this.skademeldingListe = this.mapToCSV( filstil, Skademelding.class, filter);
    //System.out.println(list);

  }

  public List<Skademelding> getSkademeldingListe() {
    return skademeldingListe;
  }
}
