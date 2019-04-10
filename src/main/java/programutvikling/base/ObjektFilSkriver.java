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
    FileChooser.ExtensionFilter filEndelse = new FileChooser.ExtensionFilter("JOBJ filer (*.jobj)", "*.jobj");
    FileChooser.ExtensionFilter filEndelse2 = new FileChooser.ExtensionFilter("CSV filer (*.csv)", "*.csv");
    filvelger.getExtensionFilters().addAll(filEndelse,filEndelse2);


    File fil = filvelger.showSaveDialog(null);

    String valgtFilEndelse = filvelger.getSelectedExtensionFilter().getExtensions().get(0);
    if(fil != null) {
       filsti = String.valueOf(fil.toPath());



    }
    if (valgtFilEndelse =="*.jobj"){

      try (
              FileOutputStream fos = new FileOutputStream(filsti);
              ObjectOutputStream out = new ObjectOutputStream(fos);
      ) {
        out.writeObject(new ArrayList<Kunde>(kunderliste));
      }
    }


  }

}
