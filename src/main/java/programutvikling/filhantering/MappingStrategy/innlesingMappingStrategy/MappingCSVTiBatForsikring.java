package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.BatForsikring;

import java.util.List;

public class MappingCSVTiBatForsikring extends InnlesingMappingStrategy {

  List<BatForsikring> batForsikringsliste;

  public MappingCSVTiBatForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {

        @Override
        public boolean allowLine(String[] strings) {

          boolean erBatForsikring = false;
          if (strings.length >= 12) {
            String forsikringsNr = strings[11];
            String forsikringsType = strings[15];


            erBatForsikring = !"".equals(forsikringsNr) && forsikringsType.equals("Båt Forsikring");

          }


          return erBatForsikring;
        }
      };

    this.batForsikringsliste = this.objektTilCSV( filstil, BatForsikring.class, filter);

  }

  public List<BatForsikring> getBatForsikringsliste() {
    return batForsikringsliste;
  }
}
