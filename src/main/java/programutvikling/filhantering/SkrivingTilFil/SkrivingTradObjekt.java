package programutvikling.filhantering.SkrivingTilFil;

import javafx.concurrent.Task;
import programutvikling.status.InnlesingOgSkrivingStatus;

import java.util.HashMap;

public class SkrivingTradObjekt extends Task<Void> {


  private String filstil;
  private HashMap<String, Object> dataliste;


  public SkrivingTradObjekt(HashMap<String, Object> dataliste ,String filsti) {
    this.filstil = filsti;
    this.dataliste = dataliste;
  }

  @Override
  protected Void call() throws Exception {
    if(filstil.endsWith(".jobj")){
    System.out.println("starter skriving til jobj fil");
    FilSkriver filSkriver = new JOBJFormatSkriver();
    filSkriver.skrivTilFil(this.dataliste,this.filstil);
    }
    else if (filstil.endsWith(".csv")){
      System.out.println("starter skriving til fil csv fil");
      FilSkriver filSkriver = new CSVFormatSkriver();
       filSkriver.skrivTilFil(this.dataliste,this.filstil);

    }


    return null;
  }

  @Override
  protected void running() {
    System.out.println("running");

    InnlesingOgSkrivingStatus.erInnlesingAktiv().set(true);

  }

  @Override
  protected void failed() {
    InnlesingOgSkrivingStatus.erInnlesingAktiv().set(false);
  }


  @Override
  protected void succeeded() {
    System.out.println("Done");
    InnlesingOgSkrivingStatus.erInnlesingAktiv().set(false);

  }




}



