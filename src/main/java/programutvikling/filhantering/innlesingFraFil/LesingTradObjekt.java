package programutvikling.filhantering.innlesingFraFil;

import javafx.concurrent.Task;
import programutvikling.feilmeldinger.CSVFormatAvvikHandler;
import programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy.GyldigCSVFil;
import programutvikling.status.InnlesingOgSkrivingStatus;

import java.io.IOException;
import java.util.HashMap;

public class LesingTradObjekt extends Task<HashMap<String,Object>> {


  private Runnable handlingFullfortfunksjon;

  private String filstil;
  private HashMap<String,Object> dataliste;


  public LesingTradObjekt(String filsti,Runnable handlingFullførtFuksjon) {
    this.handlingFullfortfunksjon = handlingFullførtFuksjon;
    this.filstil = filsti;
  }

  @Override
  protected HashMap<String,Object> call() throws IOException, ClassNotFoundException, CSVFormatAvvikHandler {

    if (isCancelled()) {
      System.out.println("task cancelled");

    }

    if(filstil.endsWith(".jobj")){
    System.out.println("starter lesing fra jobj fil");
    FilLeser filLeser = new JOBJFormatLeser();
    this.dataliste = filLeser.lesFraFil(this.filstil);
    }
    else if (filstil.endsWith(".csv")){
      System.out.println("starter lesing fra fil csv fil");
      boolean gyldigCSVFil = GyldigCSVFil.sjekkCSVFilErGyldig(this.filstil);
      if (gyldigCSVFil) {

        FilLeser filLeser = new CSVFormatLeser();
        this.dataliste = filLeser.lesFraFil(this.filstil);
      }
      else {
        throw  new CSVFormatAvvikHandler("CSV filen er ikke kompatible! Kun CSV filer med semikolon separerte kolonner er tillatt.");
      }

    }



    return dataliste;
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

  // succeeded kjører i main-UI tråden, og UI elementer kan manipuleres her
  @Override
  protected void succeeded() {
    InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv().set(false);
    System.out.println("Done");
    handlingFullfortfunksjon.run();

  }




}



