package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.HusOgInnboForsikring;

import java.util.List;

public class MappingCSVTilHusOgInnboForsikring extends InnlesingMappingStrategy {

  List<HusOgInnboForsikring> husOgInnboForsikringsliste;

  public MappingCSVTilHusOgInnboForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {

      @Override
      public boolean allowLine(String[] strings) {

        boolean erHusOgInnboForsikring = false;
        if (strings.length >= 12) {
          String forsikringsNr = strings[11];
          String forsikringsType = strings[15];


          erHusOgInnboForsikring = !"".equals(forsikringsNr) && forsikringsType.equals("Hus Og Innbo Forsikring");

        }


        return erHusOgInnboForsikring;

      }
    };

    this.husOgInnboForsikringsliste = objektTilCSV(filstil, HusOgInnboForsikring.class, filter);

  }

  public List<HusOgInnboForsikring> getHusOgInnboForsikringsliste() {
    return husOgInnboForsikringsliste;
  }
}
