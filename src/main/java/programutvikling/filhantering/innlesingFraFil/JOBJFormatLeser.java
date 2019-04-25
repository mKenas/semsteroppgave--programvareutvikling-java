package programutvikling.filhantering.innlesingFraFil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class JOBJFormatLeser extends FilLeser {
  @Override
  public HashMap<String, Object> lesFraFil(String filsti) throws IOException, ClassNotFoundException {
    FileInputStream fin = new FileInputStream(filsti);
    ObjectInputStream oin = new ObjectInputStream(fin);
    //List<Kunde> list = (List<Kunde>) oin.readObject();
    HashMap<String,Object> dataliste = (HashMap<String,Object>) oin.readObject();

    //return FXCollections.observableList(list);
    return dataliste;
  }
}
