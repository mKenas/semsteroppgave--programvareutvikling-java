package programutvikling.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class KundeObjektLeser {

  public static ObservableList<Kunde> read(String path) throws IOException, ClassNotFoundException {
    try (FileInputStream fin = new FileInputStream(path);
         ObjectInputStream oin = new ObjectInputStream(fin)) {
      List<Kunde> list = (List<Kunde>) oin.readObject();

      return FXCollections.observableList(list);
    }
  }

}
