public class Tegelane {
    private String tegelane;
    private int elud;
    private int armorClass;

    public int getArmorClass() {
        return armorClass;
    }

    public int getElud() {
        return elud;
    }

    public void setElud(int elud) {
        this.elud = elud;
    }

    public Tegelane(String tegelane, int elud, int armorClass) {
        this.tegelane = tegelane;
        this.elud = elud;
        this.armorClass = armorClass;
    }
}
