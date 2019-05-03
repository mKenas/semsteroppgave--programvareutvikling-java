package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.FritidsboligForsikring;

import java.util.List;

public class MappingCSVTiFritidsboligForsikring extends InnlesingMappingStrategy {

  List<FritidsboligForsikring> fritidsboligForsikringsliste;

  public MappingCSVTiFritidsboligForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {

      @Override
      public boolean allowLine(String[] strings) {

        boolean erFritidsboligForsikring = false;
        if (strings.length >= 12) {
          String forsikringsNr = strings[11];
          String forsikringsType = strings[15];


          erFritidsboligForsikring = !"".equals(forsikringsNr) && forsikringsType.equals("Fritidsbolig Forsikring");


        }


        return erFritidsboligForsikring;
      }
    };

    this.fritidsboligForsikringsliste = objektTilCSV(filstil, FritidsboligForsikring.class, filter);


  }

  public List<FritidsboligForsikring> getFritidsboligForsikringsliste() {
    return fritidsboligForsikringsliste;
  }
}
