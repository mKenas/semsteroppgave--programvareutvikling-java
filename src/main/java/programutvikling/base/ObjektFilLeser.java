package programutvikling.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjektFilLeser {


  public static ObservableList<Kunde> read(String filsti) throws IOException, ClassNotFoundException {
    FileChooser filvelger = new FileChooser();
    filvelger.setTitle("Åpne fil");

    FileChooser.ExtensionFilter filEndelse = new FileChooser.ExtensionFilter("JOBJ filer (*.jobj)", "*.jobj");
    FileChooser.ExtensionFilter filEndelse2 = new FileChooser.ExtensionFilter("CSV filer (*.csv)", "*.csv");
    filvelger.getExtensionFilters().addAll(filEndelse, filEndelse2);

    File fil = filvelger.showOpenDialog(null);
    String valgtFilEndelse = filvelger.getSelectedExtensionFilter().getExtensions().get(0);


    if (fil != null) {
      filsti = String.valueOf(fil.toPath());
    }

    if (valgtFilEndelse == "*.jobj") {

      try (FileInputStream fin = new FileInputStream(filsti);
           ObjectInputStream oin = new ObjectInputStream(fin)) {
        List<Kunde> list = (List<Kunde>) oin.readObject();

        return FXCollections.observableList(list);
      }
    }
    // Dette bør fiskes !!
    return null;
  }

}
