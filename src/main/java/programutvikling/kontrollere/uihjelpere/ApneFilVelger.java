package programutvikling.kontrollere.uihjelpere;

import javafx.stage.FileChooser;

import java.io.File;

public class ApneFilVelger {

  private static FileChooser filvelger;

  private String valgtFilEndelse;
  private String filsti;


  public ApneFilVelger() {
    filvelger = new FileChooser();

    filvelger.setTitle("Åpne Fil");

    FileChooser.ExtensionFilter filEndelse = new FileChooser.ExtensionFilter("JOBJ filer (*.jobj)", "*.jobj");
    FileChooser.ExtensionFilter filEndelse2 = new FileChooser.ExtensionFilter("CSV filer (*.csv)", "*.csv");
    filvelger.getExtensionFilters().addAll(filEndelse, filEndelse2);

    File fil = filvelger.showOpenDialog(null);
    {
      if (filvelger.getSelectedExtensionFilter() != null)
        this.valgtFilEndelse = filvelger.getSelectedExtensionFilter().getExtensions().get(0);
    }


    if (fil != null) {

      this.filsti = String.valueOf(fil.toPath());

    }


  }

  public static FileChooser getFilvelger() {
    return filvelger;
  }

  public String getValgtFilEndelse() {
    return valgtFilEndelse;
  }

  public String getFilsti() {
    return filsti;
  }
}
