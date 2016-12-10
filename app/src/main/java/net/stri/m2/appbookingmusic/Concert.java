package net.stri.m2.appbookingmusic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cyrilou on 06/12/2016.
 */

public class Concert {
    private String artiste;
    private int cheminJaquette;
    private String salle;
    private String ville;
    private Date date;
    private Integer prix;
    private Integer nbPlaceTotale;
    private Integer nbPlaceVendu;
    private String genre;
    private String description;

    public Concert(String artiste, int cheminJaquette,String salle, String ville, String dateString, Integer prix, Integer nbPlaceTotale, Integer nbPlaceVendu,String genre,String description){
        this.artiste=artiste;
        this.cheminJaquette = cheminJaquette;
        this.salle=salle;
        this.ville = ville;
        this.prix = prix;
        this.nbPlaceTotale = nbPlaceTotale;
        this.nbPlaceVendu = nbPlaceVendu;
        this.description=description;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        try {
            this.date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getCheminJaquette() {
        return cheminJaquette;
    }

    public void setCheminJaquette(int color) {
        this.cheminJaquette = cheminJaquette;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {this.date = date; }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getNbPlaceTotale() {
        return nbPlaceTotale;
    }

    public void setNbPlaceTotale(Integer nbPlaceTotale) {this.nbPlaceTotale = nbPlaceTotale; }

    public Integer getNbPlaceVendu() {
        return nbPlaceVendu;
    }

    public void setNbPlaceVendu(Integer nbPlaceVendu) {
        this.nbPlaceVendu = nbPlaceVendu;
    }

    public String getComplet(){
        if (this.nbPlaceTotale.compareTo(nbPlaceVendu) == 0)
        {
            return "Complet";
        };
        return "";
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

