package programutvikling.base;

import javafx.stage.FileChooser;
import programutvikling.filhantering.SkrivingTilFil.CSVFormatSkriver;
import programutvikling.filhantering.SkrivingTilFil.FilSkriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ObjektFilSkriver {

  private static final String CSV_SEPARATOR = ",";

  public  static  void write(HashMap<String,Object> liste, String filsti) throws IOException {

    FileChooser filvelger = new FileChooser();

    filvelger.setTitle("Lagre fil");
    FileChooser.ExtensionFilter filEndelse = new FileChooser.ExtensionFilter("JOBJ filer (*.jobj)", "*.jobj");
    FileChooser.ExtensionFilter filEndelse2 = new FileChooser.ExtensionFilter("CSV filer (*.csv)", "*.csv");
    filvelger.getExtensionFilters().addAll(filEndelse, filEndelse2);


    File fil = filvelger.showSaveDialog(null);

    String valgtFilEndelse = filvelger.getSelectedExtensionFilter().getExtensions().get(0);
    if (fil != null) {
      filsti = String.valueOf(fil.toPath());


    }
    if (valgtFilEndelse == "*.jobj") {

      try (
              FileOutputStream fos = new FileOutputStream(filsti);
              ObjectOutputStream out = new ObjectOutputStream(fos);
      ) {
        out.writeObject(liste);
      }

/*    } else if (valgtFilEndelse == "*.csv") {


      try {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filsti), "UTF-8"));
        ArrayList<Kunde> kunder = new ArrayList<Kunde>(liste);
        StringBuffer oneLine = new StringBuffer();
        //oneLine.append("sep=,");
        //bw.newLine();
        oneLine.append("KundeNr");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append("Navn");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append("Etternavn\n");


        for (Kunde kunde : kunder) {

          oneLine.append(kunde.getPersonNr().trim().length() == 0 ? "" : kunde.getPersonNr());
          oneLine.append(CSV_SEPARATOR);

          oneLine.append(kunde.getNavn().trim().length() == 0 ? "" : kunde.getNavn());
          oneLine.append(CSV_SEPARATOR);

          oneLine.append(kunde.getEtternavn().trim().length() == 0 ? "" : kunde.getEtternavn());
          oneLine.append("\n");


        }
        bw.write(oneLine.toString());
        bw.flush();
        bw.close();

      } catch (UnsupportedEncodingException e) {
      } catch (FileNotFoundException e) {
      } catch (IOException e) {

 //     }
*/
    }
    else if (valgtFilEndelse == "*.csv"){
      FilSkriver filSkriver = new CSVFormatSkriver();
      filSkriver.skrivTilFil(null,filsti);

    }
  }

}
