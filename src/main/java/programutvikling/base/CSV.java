package programutvikling.base;

import java.io.*;
import java.util.ArrayList;

public class CSV {


  private static final String CSV_SEPARATOR = ",";

  public static void skriv(ArrayList<Kunde> kunder) {


    try {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("products.csv"), "UTF-8"));
      for (Kunde kunde : kunder) {
        StringBuffer oneLine = new StringBuffer();
        oneLine.append(kunde.getPersonNr().trim().length() == 0 ? "" : kunde.getPersonNr());
        oneLine.append(CSV_SEPARATOR);
        oneLine.append(kunde.getNavn().trim().length() == 0 ? "" : kunde.getNavn());
        oneLine.append(CSV_SEPARATOR);
        bw.write(oneLine.toString());
        bw.newLine();
      }
      bw.flush();
      bw.close();
    } catch (UnsupportedEncodingException e) {
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
  }

}
