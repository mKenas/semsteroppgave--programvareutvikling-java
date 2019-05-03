package programutvikling.filhantering.SkrivingTilFil;

import javafx.concurrent.Task;
import programutvikling.status.InnlesingOgSkrivingStatus;

import java.util.HashMap;

public class SkrivingTradObjekt extends Task<Void> {


  private String filstil;
  private HashMap<String, Object> dataliste;


  public SkrivingTradObjekt(HashMap<String, Object> dataliste, String filsti) {
    if (filsti == null) {
      this.cancel();
    }
    this.filstil = filsti;
    this.dataliste = dataliste;
  }

  @Override
  protected Void call() throws Exception {
    if (isCancelled()) {

      return null;
    }
    if (filstil.endsWith(".jobj")) {

      FilSkriver filSkriver = new JOBJFormatSkriver();
      filSkriver.skrivTilFil(this.dataliste, this.filstil);
    } else if (filstil.endsWith(".csv")) {
      FilSkriver filSkriver = new CSVFormatSkriver();
      filSkriver.skrivTilFil(this.dataliste, this.filstil);

    }


    return null;
  }

  @Override
  protected void running() {


    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(true);

  }

  @Override
  protected void failed() {

    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }


  @Override
  protected void cancelled() {

    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }

  @Override
  protected void succeeded() {

    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }


}



