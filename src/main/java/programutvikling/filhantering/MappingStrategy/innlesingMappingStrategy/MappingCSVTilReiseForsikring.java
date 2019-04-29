package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.ReiseForsikring;

import java.util.List;

public class MappingCSVTilReiseForsikring extends InnlesingMappingStrategy {

  List<ReiseForsikring> reiseForsikringsliste;

  public MappingCSVTilReiseForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {
      @Override
      public boolean allowLine(String[] strings) {

        boolean erReiseForsikring = false;
        if (strings.length >= 12) {
          String forsikringsNr = strings[11];
          String forsikringsType = strings[15];


          erReiseForsikring = !"".equals(forsikringsNr) && forsikringsType.equals("Reise Forsikring");

        }


        return erReiseForsikring;
        //return true;
      }
    };

    this.reiseForsikringsliste = this.objektTilCSV( filstil, ReiseForsikring.class, filter);
    //System.out.println(list);

  }

  public List<ReiseForsikring> getReiseForsikringsliste() {
    return reiseForsikringsliste;
  }
}
