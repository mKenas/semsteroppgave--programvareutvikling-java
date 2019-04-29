package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.HusOgInnboForsikring;
import programutvikling.base.ReiseForsikring;

import java.util.List;

public class MappingCSVTilHusOgInnboForsikring extends InnlesingMappingStrategy {

  List<HusOgInnboForsikring> husOgInnboForsikringliste;

  public MappingCSVTilHusOgInnboForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {

        @Override
        public boolean allowLine(String[] strings) {

          boolean result = false;
          if (strings.length >= 12) {
            String forsikringsNr = strings[11];
            String forsikringsType = strings[15];


            result = !"".equals(forsikringsNr) && forsikringsType.equals("Hus Og Innbo Forsikring");

          }


          return result;
          //return true;
        }
      };

    this.husOgInnboForsikringliste = this.mapToCSV( filstil, HusOgInnboForsikring.class, filter);
    //System.out.println(list);

  }

  public List<HusOgInnboForsikring> getHusOgInnboForsikringliste() {
    return husOgInnboForsikringliste;
  }
}
