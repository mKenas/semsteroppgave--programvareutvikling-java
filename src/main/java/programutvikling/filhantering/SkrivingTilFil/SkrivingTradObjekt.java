package programutvikling.filhantering.SkrivingTilFil;

import javafx.concurrent.Task;
import programutvikling.status.InnlesingOgSkrivingStatus;

import java.util.HashMap;

public class SkrivingTradObjekt extends Task<Void> {


  private String filstil;
  private HashMap<String, Object> dataliste;


  public SkrivingTradObjekt(HashMap<String, Object> dataliste ,String filsti) {
    if (filsti ==null){
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

    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(true);

  }

  @Override
  protected void failed() {
    System.out.println("Task failed");
    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }


  @Override
  protected void cancelled() {
    System.out.println("Task canceled");
    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }

  @Override
  protected void succeeded() {
    System.out.println("Done");
    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);

  }




}



