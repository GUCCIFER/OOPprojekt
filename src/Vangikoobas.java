import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Vangikoobas {
    public static int löögiDamage(Relv relv){
        int tehtavKahju = relv.getBaasDamage();
        for (int i = 0; i < relv.getTäringuteArv(); i++){
            tehtavKahju += 1+(((int)(Math.random())*relv.getTärginuTahkudeArv()));
        }
        return  tehtavKahju;
    }
    public static boolean kasSaabPihta(Relv relv, Tegelane tegelane){
        if ((int) (Math.random()*20) + relv.getTäpsus() + 1 > tegelane.getKaitse()){
            return true;
        }
        return false;
    }
    public static void Löök(Relv relv, Tegelane tegelane){
        if (kasSaabPihta(relv, tegelane)){
            int kahju = löögiDamage(relv);
            tegelane.setElud(tegelane.getElud()-kahju);
            System.out.println(tegelane.getTegelane() + "sai " + kahju + " punkti kahju ja tal on nüüd " + tegelane.getElud() + " elu" );
        }
    }
    public static String sisestus(String message){
        return JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static int intSisestus(String message){
        return Integer.parseInt(JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE));
    }
    public static Relv pahalaseRelv(){
        return new Relv( sisestus("Sisetage oma tegelase nimi"),intSisestus("Sisetage oma tegelase elud"), intSisestus("Sisetage om,a tegelase elud"),intSisestus("Sisetage oma tegelase elud"),intSisestus("Sisetage oma tegelase elud"));
    }
    public static void main(String[] args) {
        System.out.println("TUTORIAL");
        List<Tegelane> pahalased = new ArrayList<>();
        Relv scimmi = new Relv("Scimitar", 2, 5, 3, 3);
        Tegelane peaTegelane = new Tegelane(sisestus("Sisetage oma tegelase nimi"), intSisestus("Sisetage oma tegelase elud"), intSisestus("Sisetage oma tegelase kaitse tase"));
        peaTegelane.setRelv(new Relv( sisestus("Sisetage oma Relva"),intSisestus("Sisetage mitu korda relvaga lööd(1-3)"), intSisestus("Sisetage oma relva tugevus(1-12"),intSisestus("Sisetage oma relva baastugevus(1-3)"),intSisestus("Sisetage oma relva täpsus(1-7)")));
        for (int i = 0; i < intSisestus("Sisestage vastaste arv"); i++) {
            pahalased.add(new Tegelane(sisestus("Sisetage oma pahalase nimi"), intSisestus("Sisetage pahalase elud"), intSisestus("Sisetage pahalase kaitse tase"), scimmi));
        }
        while (pahalased.size() != 0 && peaTegelane.getElud() > 0){
            String target = sisestus("Keda sa ründad?");
            for (Tegelane pahalane: pahalased){
                if (pahalane.getTegelane().equals(target)){
                    Löök(peaTegelane.getRelv(), pahalane);
                    if (pahalane.getElud() < 1){
                        pahalased.remove(pahalane);
                    }
                    break;
                }

            }
            for (Tegelane pahalane: pahalased){
                Löök(pahalane.getRelv(), peaTegelane);
                if (peaTegelane.getElud() < 1){
                    break;
                }
            }



        }
    }
}
