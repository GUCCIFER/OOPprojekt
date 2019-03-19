public class Tegelane {
    private String tegelane;
    private int elud;
    private int kaitse;
    private Relv relv;

    public int löögiDamage() {
        return 1 + (int) ((Math.random()) * relv.getVõimsus());
    }

    @Override
    public String toString() {
        return tegelane;
    }

    boolean kasSaabPihta(Tegelane tegelane) {
        int a = ((int) (Math.random() * 20) + relv.getTäpsus() + 1);
        if (a > tegelane.getKaitse()) {
            System.out.println(this.getTegelane() + " rünnaku veeretus on: " + a + " ning see läbis " + tegelane + " kaitsepunktid: " + tegelane.getKaitse());
            return true;
        }
        System.out.println(this.getTegelane() + " ründe veeretus on: " + a + " kuid see ei läbinud "
                + tegelane + " kaitsepunkte: " + tegelane.getKaitse());
        return false;
    }

    public void Löök(Tegelane ohver) {
        if (kasSaabPihta(ohver)) {
            int kahju = löögiDamage();
            ohver.setElud(ohver.getElud() - kahju);
            System.out.println(this.getTegelane() + " ründas ja " + ohver.getTegelane() + " sai " + kahju + " punkti kahju ja tal on nüüd " + ohver.getElud() + " elu");
        }
    }

    public void setElud(int elud) {
        this.elud = elud;
    }

    public Tegelane(String tegelane, int elud, int kaitse) {
        this.tegelane = tegelane;
        this.elud = elud;
        this.kaitse = kaitse;
    }

    public Tegelane(String tegelane, int elud, int kaitse, Relv relv) {
        this.tegelane = tegelane;
        this.elud = elud;
        this.kaitse = kaitse;
        this.relv = relv;
    }

    public Relv getRelv() {
        return relv;
    }

    public void setRelv(Relv relv) {
        this.relv = relv;
    }

    public String getTegelane() {
        return tegelane;
    }

    public void setTegelane(String tegelane) {
        this.tegelane = tegelane;
    }

    public int getElud() {
        return elud;
    }

    public int getKaitse() {
        return kaitse;
    }

    public void setKaitse(int kaitse) {
        this.kaitse = kaitse;
    }
}
