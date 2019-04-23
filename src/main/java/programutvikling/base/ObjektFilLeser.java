package programutvikling.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import programutvikling.database.DataLagringObjekt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ObjektFilLeser {


  public static HashMap<String,Object> read(String filsti) throws IOException, ClassNotFoundException {
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

      FileInputStream fin = new FileInputStream(filsti);
      ObjectInputStream oin = new ObjectInputStream(fin);
      //List<Kunde> list = (List<Kunde>) oin.readObject();
      HashMap<String,Object> list = (HashMap<String,Object>) oin.readObject();

      //return FXCollections.observableList(list);
      return list;

    }
/*
    if (valgtFilEndelse == "*.csv") {
      List<String> records = new ArrayList<>();
      try (BufferedReader br = new BufferedReader(new FileReader(filsti))) {
        String line;
        while ((line = br.readLine()) != null) {
          List<String> values = Arrays.asList(line.split(","));
          List<Kunde> kunder = new ArrayList<>();

          values.forEach(val -> System.out.println(val));

          //System.out.println(values);
          //records.add(values);

        }
        System.out.println(records);
      }
      //return FXCollections.observableList(records);
    }
    */
    // Dette bør fiskes !!
    return new HashMap<>();

  }

}
