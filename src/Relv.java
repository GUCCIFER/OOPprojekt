public class Relv {
    private String nimi;
    private int täringuteArv;
    private int tärginuTahkudeArv;
    private int baasDamage;
    private int täpsus;
    public Relv(String nimi, int täringuteArv, int tärginuTahkudeArv, int baasDamage, int täpsus) {
        this.nimi = nimi;
        this.täringuteArv = täringuteArv;
        this.tärginuTahkudeArv = tärginuTahkudeArv;
        this.baasDamage = baasDamage;
        this.täpsus = täpsus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getTäringuteArv() {
        return täringuteArv;
    }

    public void setTäringuteArv(int täringuteArv) {
        this.täringuteArv = täringuteArv;
    }

    public int getTärginuTahkudeArv() {
        return tärginuTahkudeArv;
    }

    public void setTärginuTahkudeArv(int tärginuTahkudeArv) {
        this.tärginuTahkudeArv = tärginuTahkudeArv;
    }

    public int getBaasDamage() {
        return baasDamage;
    }

    public void setBaasDamage(int baasDamage) {
        this.baasDamage = baasDamage;
    }

    public int getTäpsus() {
        return täpsus;
    }

    public void setTäpsus(int täpsus) {
        this.täpsus = täpsus;
    }
}
