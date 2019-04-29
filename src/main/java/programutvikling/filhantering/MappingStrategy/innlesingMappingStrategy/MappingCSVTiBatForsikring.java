package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.BatForsikring;

import java.util.List;

public class MappingCSVTiBatForsikring extends InnlesingMappingStrategy {

  List<BatForsikring> baatForsikringliste;

  public MappingCSVTiBatForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {

        @Override
        public boolean allowLine(String[] strings) {

          boolean result = false;
          if (strings.length >= 12) {
            String forsikringsNr = strings[11];
            String forsikringsType = strings[15];


            result = !"".equals(forsikringsNr) && forsikringsType.equals("Båt Forsikring");

          }


          return result;
          //return true;
        }
      };

    this.baatForsikringliste = this.mapToCSV( filstil, BatForsikring.class, filter);
    //System.out.println(list);

  }

  public List<BatForsikring> getBatForsikringliste() {
    return baatForsikringliste;
  }
}
