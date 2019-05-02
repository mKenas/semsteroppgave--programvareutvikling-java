package programutvikling.filhantering.innlesingFraFil;


import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVFormatLeser extends FilLeser {
  @Override
  public HashMap<String, Object> lesFraFil(String filsti) throws IOException, ClassNotFoundException {


    MappingCSVTilKunde mappingCSVTilKundeliste = new MappingCSVTilKunde(filsti);
    //System.out.println("Kundeliste");
    //System.out.println(mappingCSVTilKundeliste.getKundeliste());



    MappingCSVTilReiseForsikring mappingCSVTilReiseForsikring  = new MappingCSVTilReiseForsikring(filsti);
    //System.out.println("ReiseForsikringliste");
    //System.out.println(mappingCSVTilReiseForsikring.getReiseForsikringsliste());


    MappingCSVTilHusOgInnboForsikring mappingCSVTilHusOgInnboForsikring  = new MappingCSVTilHusOgInnboForsikring(filsti);
    //System.out.println("HusOgInnboForsikringliste");
    //System.out.println(mappingCSVTilHusOgInnboForsikring.getHusOgInnboForsikringsliste());

    MappingCSVTiBatForsikring mappingCSVTiBatForsikring  = new MappingCSVTiBatForsikring(filsti);
    //System.out.println("BatForsikringliste");
    //System.out.println(mappingCSVTiBatForsikring.getBatForsikringsliste());

    MappingCSVTiFritidsboligForsikring mappingCSVTiFritidsboligForsikring = new MappingCSVTiFritidsboligForsikring(filsti);
    //System.out.println("FritidsboligForsikringliste");
    //System.out.println(mappingCSVTiFritidsboligForsikring.getFritidsboligForsikringsliste());



    MappingCSVTilSkademelding mappingCSVTilSkademelding  = new MappingCSVTilSkademelding(filsti);
    //System.out.println("Skademelding");
    //System.out.println(mappingCSVTilSkademelding.getSkademeldingListe());


    HashMap<String, Object> dataliste = new HashMap<>();
    ArrayList<Kunde> kundeliste = new ArrayList<>();
    ArrayList<Forsikring> forsikringliste = new ArrayList<>();
    ArrayList<Skademelding> skademeldingListe = new ArrayList<>();

    HashMap<Kunde,ArrayList<Forsikring>> kundeMedForsikringListe = new HashMap<>();
    HashMap<Kunde,ArrayList<Skademelding>> kundeMedSkadeMeldingListe = new HashMap<>();

    kundeliste.addAll(mappingCSVTilKundeliste.getKundeliste());
    forsikringliste.addAll(mappingCSVTilHusOgInnboForsikring.getHusOgInnboForsikringsliste());
    forsikringliste.addAll(mappingCSVTilReiseForsikring.getReiseForsikringsliste());
    forsikringliste.addAll(mappingCSVTiBatForsikring.getBatForsikringsliste());
    forsikringliste.addAll(mappingCSVTiFritidsboligForsikring.getFritidsboligForsikringsliste());
    skademeldingListe.addAll(mappingCSVTilSkademelding.getSkademeldingListe());




    for (Forsikring f: forsikringliste) {

      for (Kunde k : kundeliste) {
        if (k.getForsikringNrListe().contains(f.getForsikringsNr())) {

          k.leggTilForsikring(f);

        }
      }
    }


    for (Skademelding s: skademeldingListe) {

      for (Kunde k : kundeliste) {
        if (k.getSkadeMeldingNrListe().contains(s.getSkademeldingNr())) {

          k.leggTilSkadeMelding(s);


        }
      }
    }

    for (Kunde k: kundeliste){
      kundeMedForsikringListe.put(k,k.getForsikringer());
      kundeMedSkadeMeldingListe.put(k,k.getSkadeMeldinger());
    }


    dataliste.put("kundeListe", kundeliste);
    dataliste.put("forsikringListe", forsikringliste);
    dataliste.put("skademeldingListe", skademeldingListe);

    dataliste.put("kundeMedForsikringListe", kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe", kundeMedSkadeMeldingListe);


    return dataliste;

  }

}
