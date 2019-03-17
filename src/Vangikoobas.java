import javax.swing.*;

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
            tegelane.setElud(tegelane.getElud()-löögiDamage(relv));
        }
    }
    public static String sisestus(String message){
        return JOptionPane.showInputDialog(null, message, "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
    }
    public static void main(String[] args) {
        System.out.println("TUTORIAL");
        Tegelane peaTegelane = new Tegelane(sisestus("Sisetage oma tegelase nimi"), parseInt(sisestus("Sisetage oma tegelase elud")), parseInt(sisestus("Sisetage oma tegelase kaitse tase")));
        peaTegelane.setRelv(new Relv( sisestus("Sisetage oma tegelase nimi"),Integer.parseInt(sisestus("Sisetage oma tegelase elud")), Integer.parseInt(sisestus("Sisetage om,a tegelase elud")),Integer.parseInt(sisestus("Sisetage oma tegelase elud")),Integer.parseInt(sisestus("Sisetage oma tegelase elud"))));
    }
}
