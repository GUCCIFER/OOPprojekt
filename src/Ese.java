public class Ese {
    private String nimi;

    @Override
    public String toString() {
        return nimi;
    }

    Ese(String nimi){
        this.nimi = nimi;
    }
    public String getNimi(){
        return nimi;
    }
}
