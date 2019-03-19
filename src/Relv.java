public class Relv {
    private String nimi;
    private int võimsus;
    private int täpsus;

    public Relv(String nimi, int võimsus, int täpsus) {
        this.nimi = nimi;
        this.võimsus = võimsus;
        this.täpsus = täpsus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getVõimsus() {
        return võimsus;
    }

    public void setVõimsus(int võimsus) {
        this.võimsus = võimsus;
    }

    public int getTäpsus() {
        return täpsus;
    }

    public void setTäpsus(int täpsus) {
        this.täpsus = täpsus;
    }
}
