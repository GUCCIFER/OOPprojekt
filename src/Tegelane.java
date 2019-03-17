public class Tegelane {
    private String tegelane;
    private int elud;
    private int kaitse;

    public void setElud(int elud) {
        this.elud = elud;
    }
    public Tegelane(String tegelane, int elud, int kaitse) {
        this.tegelane = tegelane;
        this.elud = elud;
        this.kaitse = kaitse;
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
