import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Vangikoobas {


    public static String sisestus(String message) {
        return JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static int intSisestus(String message) {
        String vastus = (JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE));
        int vastus_arv;
        try {
            vastus_arv = Integer.parseInt(vastus);
            return vastus_arv;
        } catch (IllegalArgumentException e) {
            return intSisestus(message);
        }
    }

    public static int intSisestus(String message, int max) {
        String vastus = (JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE));
        int vastus_arv;
        try {
            vastus_arv = Integer.parseInt(vastus);
            if (vastus_arv > max) {
                return intSisestus(message, max);
            } else
                return vastus_arv;
        } catch (IllegalArgumentException e) {
            return intSisestus(message, max);
        }
    }

    public static Relv pahalaseRelv() {
        return new Relv(sisestus("Sisetage pahalase relva nimi"), intSisestus("Sisetage pahalase relva täpsus"), intSisestus("Sisetage pahalase relva võimsus"));
    }
    public static int sisestus(String message, Object[] valikud) {
        Object[] valikud_sõnena = new Object[valikud.length];
        for (int i = 0; i < valikud.length; i++) {
            valikud_sõnena[i] = valikud[i].toString();
        }
        return JOptionPane.showOptionDialog(null, message, "Tee oma valik",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, valikud_sõnena, valikud_sõnena[0]);
    }
    public static void pahalasteLisamine(List<Tegelane> pahalased, Object[] valikud) {
        int valik = sisestus("Lisa endale vastaseid", valikud);
         if (valik==0){
                Relv Mõõk = new Relv("Scimitar", 5, 5);
                pahalased.add(new Tegelane("Goblin", 15, 12, Mõõk));
                pahalasteLisamine(pahalased, valikud);
         }
         else if (valik==1){
             Relv claws = new Relv("Küünised", 11, 5);
             pahalased.add(new Tegelane("Succubus", 6, 17, claws));
             pahalasteLisamine(pahalased, valikud);
         }
         else if  (valik==2){
                pahalased.add(new Tegelane(sisestus("Sisetage oma pahalase nimi(Ärge lisage identseid nimesid mitme pahalase korral)"), intSisestus("Sisetage pahalase elud"), intSisestus("Sisetage pahalase kaitse tase"), pahalaseRelv()));
                pahalasteLisamine(pahalased, valikud);}
        }
    public static void pood(Tegelane peaTegelane){
        Object[] valikud = {"Elueliksiir","Jõueliksiir","Täpsuseeliksiir", "Jätka"};
        int valik = sisestus("Osta endale poest midagi", valikud);
        if (valik==0){
            peaTegelane.lisaEse(new Ese("Elueliksiir"));
            pood(peaTegelane);
        }
        else if (valik==1){
            peaTegelane.lisaEse(new Ese("Jõueliksiir"));
            pood(peaTegelane);
        }
        else if  (valik==2){
            peaTegelane.lisaEse(new Ese("Täpsuseliksiir"));
            pood(peaTegelane);
        }
    }
    public static void valik(Tegelane peaTegelane){
        Object[] valikud = {"Kasuta eset","Ründa vaenlast"};
        int valik;
        valik = sisestus("Tee valik", valikud);
        if (valik==0){
            Object[] esemete_massiiv = peaTegelane.getEsemed().toArray();
            int target = sisestus("Mis eset kasutad?", esemete_massiiv);
            if (peaTegelane.getEsemed().get(target).getNimi().equals("Elueliksiir")){
                peaTegelane.eemaldaEse(target);
                peaTegelane.setElud(peaTegelane.getElud() + 12);
                System.out.println(peaTegelane + " joob eliksiiri ja see taastab ta tervise. Tal on nüüd " + peaTegelane.getElud() + " elu" );
                if (peaTegelane.getEsemed().size() > 0) {
                    valik(peaTegelane);
                }
            }
            else if (peaTegelane.getEsemed().get(target).getNimi().equals("Jõueliksiir")){
                peaTegelane.eemaldaEse(target);
                peaTegelane.strPotted = true;
                if (peaTegelane.getEsemed().size() > 0) {
                    valik(peaTegelane);
                }
            }
            else if (peaTegelane.getEsemed().get(target).getNimi().equals("Täpsuseliksiir")){
                peaTegelane.eemaldaEse(target);
                peaTegelane.atkPotted = true;
                if (peaTegelane.getEsemed().size() > 0) {
                    valik(peaTegelane);
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("TUTORIAL");
        List<Tegelane> pahalased = new ArrayList<>();
        Tegelane peaTegelane = new Tegelane(sisestus("Sisetage oma tegelase nimi"), intSisestus("Sisetage oma tegelase elud"), intSisestus("Sisetage oma tegelase kaitse tase (Vahemikus 8-20)"));
        peaTegelane.setRelv(new Relv(sisestus("Sisetage oma Relva nimi"), intSisestus("Sisetage oma relva võimsus(4-20)"), intSisestus("Sisetage oma relva täpsus(Vahemikus 1-12)")));
        pood(peaTegelane);
        Object[] valikud = {"Goblin","Succubus","Loo enda tehtud vastane", "Jätka"};
        pahalasteLisamine(pahalased, valikud);
        if (pahalased.size()==0){
            System.out.println("Palju õnne! Sa ei lisanud ühtegi vastast! Seega oled võitnud");
        }
        while (pahalased.size()>0) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Peategelane:");
            System.out.println(peaTegelane + "||Kaitsetase: " + peaTegelane.getKaitse() + "||Elud: " + peaTegelane.getElud());
            System.out.println("------------------------------------------------------------");
            System.out.println("Pahalaste list:");
            for (Tegelane pahalane : pahalased) {
                System.out.println(pahalane + "||Kaitsetase: " + pahalane.getKaitse() + "||Elud: " + pahalane.getElud());
            }
            System.out.println("------------------------------------------------------------");
            if (peaTegelane.getEsemed().size() > 0) {
            valik(peaTegelane);
            }
                Object[] pahalased_massiiv = pahalased.toArray();
                int target = sisestus("Keda sa ründad?", pahalased_massiiv);
                peaTegelane.Löök(pahalased.get(target));
                if (pahalased.get(target).getElud() < 1) {
                    System.out.println("Sa tapsid " + pahalased.get(target).getTegelane());
                    pahalased.remove(target);
                }
                for (Tegelane pahalane : pahalased) {
                    pahalane.Löök(peaTegelane);
                    if (peaTegelane.getElud() < 1) {
                        System.out.println("Said surma, mäng läbi");
                        break;
                    }
                }
                if (pahalased.size() == 0) {
                    System.out.println("Sa võitsid!");
                    break;
                }
        }
    }
}
