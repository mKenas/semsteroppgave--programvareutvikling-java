package programutvikling.base;

import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class KundeObjektSkriver {

  public static void write(ObservableList<Kunde> kunderliste, String path) throws IOException {
    try (
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);
    ) {
      out.writeObject(new ArrayList<Kunde>(kunderliste));
    }
  }

}
