package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.FritidsboligForsikring;

import java.util.List;

public class MappingCSVTiFritidsboligForsikring extends InnlesingMappingStrategy {

  List<FritidsboligForsikring> fritidsboligForsikringliste;

  public MappingCSVTiFritidsboligForsikring(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {

        @Override
        public boolean allowLine(String[] strings) {

          boolean result = false;
          if (strings.length >= 12) {
            String forsikringsNr = strings[11];
            String forsikringsType = strings[15];



            result = !"".equals(forsikringsNr) && forsikringsType.equals("Fritidsbolig Forsikring");


          }


          return result;
          //return true;
        }
      };

    this.fritidsboligForsikringliste = this.mapToCSV( filstil, FritidsboligForsikring.class, filter);
    //System.out.println(list);

  }

  public List<FritidsboligForsikring> getFritidsboligForsikringliste() {
    return fritidsboligForsikringliste;
  }
}
