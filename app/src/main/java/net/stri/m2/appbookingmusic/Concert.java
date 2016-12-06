package net.stri.m2.appbookingmusic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cyrilou on 06/12/2016.
 */

public class Concert {
    private String salle;
    private String ville;
    private Date date;
    private int nbPlaceTotale;
    private int nbPlaceVendu;

    public Concert(String salle, String ville, String date, int nbPlaceTotale){
        this.salle=salle;
        this.ville = ville;
        this.nbPlaceTotale = nbPlaceTotale;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date NewDate = null;
        try {
            NewDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.date = NewDate;
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

    public int getNbPlaceTotale() {
        return nbPlaceTotale;
    }

    public void setNbPlaceTotale(int nbPlaceTotale) {this.nbPlaceTotale = nbPlaceTotale; }

    public int getNbPlaceVendu(int nbPlaceVendu) {
        return nbPlaceVendu;
    }

    public void setNbPlaceVendu(int nbPlaceVendu) {
        this.nbPlaceVendu = nbPlaceVendu;
    }
}
