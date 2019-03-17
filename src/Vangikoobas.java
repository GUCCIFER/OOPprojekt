import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Vangikoobas {


    public static String sisestus(String message){
        return JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static int intSisestus(String message){
        return Integer.parseInt(JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE));
    }
    public static Relv pahalaseRelv(){
        return new Relv( sisestus("Sisetage pahalase relva nimi"),intSisestus("Sisetage pahalase relva täpsus"), intSisestus("Sisetage pahalase relva võimsus"));
    }
    public static void main(String[] args) {
        System.out.println("TUTORIAL");
        List<Tegelane> pahalased = new ArrayList<>();
        Relv scimmi = new Relv("Scimitar", 5, 5);
        Tegelane peaTegelane = new Tegelane(sisestus("Sisetage oma tegelase nimi"), intSisestus("Sisetage oma tegelase elud"), intSisestus("Sisetage oma tegelase kaitse tase"));
        peaTegelane.setRelv(new Relv( sisestus("Sisetage oma Relva nimi"),intSisestus("Sisetage mitu korda relvaga lööd(1-3)"), intSisestus("Sisetage oma relva täpsus(1-12")));
        int pahalasteArv = intSisestus("Sisestage vastaste arv");
        for (int i = 0; i < pahalasteArv; i++) {
            pahalased.add(new Tegelane(sisestus("Sisetage oma pahalase nimi"), intSisestus("Sisetage pahalase elud"), intSisestus("Sisetage pahalase kaitse tase"), scimmi));
        }
        while (pahalased.size() != 0 && peaTegelane.getElud() > 0){
            String target = sisestus("Keda sa ründad?");
            for (Tegelane pahalane: pahalased){
                if (pahalane.getTegelane().toLowerCase().equals(target.toLowerCase())){
                    peaTegelane.Löök(pahalane);
                    if (pahalane.getElud() < 1){
                        pahalased.remove(pahalane);
                    }
                    break;
                }

            }
            for (Tegelane pahalane: pahalased){
                pahalane.Löök(peaTegelane);
                if (peaTegelane.getElud() < 1){
                    break;
                }
            }



        }
    }
}
