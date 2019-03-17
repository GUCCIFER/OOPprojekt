public class Tegelane {
    private String tegelane;
    private int elud;
    private int kaitse;
    private Relv relv;

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
