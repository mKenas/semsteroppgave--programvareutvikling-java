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
    if (filsti ==null){
      this.cancel();
    }


    this.handlingFullfortfunksjon = handlingFullførtFuksjon;

      this.filstil = filsti;


  }

  @Override
  protected HashMap<String,Object> call() throws IOException, ClassNotFoundException, CSVFormatAvvikHandler {

    if (isCancelled()) {

    }

    if(filstil.endsWith(".jobj")){


    FilLeser filLeser = new JOBJFormatLeser();
    this.dataliste = filLeser.lesFraFil(this.filstil);


    }
    else if (filstil.endsWith(".csv")){
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

    handlingFullfortfunksjon.run();

  }




}



