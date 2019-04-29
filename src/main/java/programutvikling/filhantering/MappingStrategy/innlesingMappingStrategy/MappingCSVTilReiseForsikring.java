package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.ReiseForsikring;

import java.util.List;

public class MappingCSVTilReiseForsikring extends InnlesingMappingStrategy {

  List<ReiseForsikring> reiseForsikringliste;

  public MappingCSVTilReiseForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {
      @Override
      public boolean allowLine(String[] strings) {

        boolean result = false;
        if (strings.length >= 12) {
          String forsikringsNr = strings[11];
          String forsikringsType = strings[15];


          result = !"".equals(forsikringsNr) && forsikringsType.equals("Reise Forsikring");

        }


        return result;
        //return true;
      }
    };

    this.reiseForsikringliste = this.mapToCSV( filstil, ReiseForsikring.class, filter);
    //System.out.println(list);

  }

  public List<ReiseForsikring> getReiseForsikringliste() {
    return reiseForsikringliste;
  }
}
