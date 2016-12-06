package net.stri.m2.appbookingmusic;

/**
 * Created by Cyrilou on 06/12/2016.
 */

public class Musique {
    private int cheminJaquette;
    private String artiste;

    public Musique(int cheminJaquette, String artiste) {
        this.cheminJaquette = cheminJaquette;
        this.artiste = artiste;
    }
    public int getCheminJaquette() {
        return cheminJaquette;
    }

    public void setCheminJaquette(int color) {
        this.cheminJaquette = cheminJaquette;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

}
