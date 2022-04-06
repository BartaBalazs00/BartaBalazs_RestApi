package hu.petrik.bartabalazs_restapi;

public class Varos {
    private int id;
    private String nev;
    private String orszag;
    private int lakossagSzama;

    public Varos(int id, String nev, String orszag, int lakossagSzama) {
        this.id = id;
        this.nev = nev;
        this.orszag = orszag;
        this.lakossagSzama = lakossagSzama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    public int getLakossagSzama() {
        return lakossagSzama;
    }

    public void setLakossagSzama(int lakossagSzama) {
        this.lakossagSzama = lakossagSzama;
    }
}
