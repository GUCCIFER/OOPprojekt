import javax.swing.*;

public class Vangikoobas {
    public int löögiDamage(Relv relv){
        int tehtavKahju = relv.getBaasDamage();
        for (int i = 0; i < relv.getTäringuteArv(); i++){
            tehtavKahju += 1+(((int)(Math.random())*relv.getTärginuTahkudeArv()));
        }
        return  tehtavKahju;
    }
    public boolean kasSaabPihta(Relv relv, Tegelane tegelane){
        if ((int) (Math.random()*20) + relv.getTäpsus() + 1 > tegelane.getKaitse()){
            return true;
        }
        return false;
    }
    public void Löök(Relv relv, Tegelane tegelane){
        if (kasSaabPihta(relv, tegelane)){
            tegelane.setElud(tegelane.getElud()-löögiDamage(relv));
        }
    }
    public static void main(String[] args) {
        String sisestatakse = JOptionPane.showInputDialog(null, "Sisesta midagi ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);
    }
}
