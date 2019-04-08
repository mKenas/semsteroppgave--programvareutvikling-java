package programutvikling.base;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjektFilSkriver {

  public static void write(ObservableList<Kunde> kunderliste, String filsti) throws IOException {

    FileChooser filvelger = new FileChooser();

    filvelger.setTitle("Lagre fil");
    FileChooser.ExtensionFilter filendelse = new FileChooser.ExtensionFilter("JOBJ filer (*.jobj)", "*.jobj");
    FileChooser.ExtensionFilter filendelse2 = new FileChooser.ExtensionFilter("CSV filer (*.csv)", "*.csv");
    filvelger.getExtensionFilters().addAll(filendelse,filendelse2);


    File fil = filvelger.showSaveDialog(null);

    if(fil != null) {
       filsti = String.valueOf(fil.toPath());
    }

    try (
            FileOutputStream fos = new FileOutputStream(filsti);
            ObjectOutputStream out = new ObjectOutputStream(fos);
    ) {
      out.writeObject(new ArrayList<Kunde>(kunderliste));
    }
  }

}
