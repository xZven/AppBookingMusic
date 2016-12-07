package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.*;

/**
 * Created by Cyrilou on 06/12/2016.
 */

public class ConcertAdapter extends ArrayAdapter<Concert> {

    public ConcertAdapter(Context context, List<Concert> concert) {
        super(context, 0, concert);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_concerts,parent, false);
        }

        ConcertViewHolder viewHolder = (ConcertViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ConcertViewHolder();
            viewHolder.artiste  =    (TextView)  convertView.findViewById(R.id.artiste);
            viewHolder.jaquette =    (ImageView) convertView.findViewById(R.id.jaquette);
            viewHolder.salle  =    (TextView)  convertView.findViewById(R.id.salle);
            viewHolder.ville  =    (TextView)  convertView.findViewById(R.id.ville);
            viewHolder.date  =    (TextView)  convertView.findViewById(R.id.date);
            viewHolder.complet  =    (TextView)  convertView.findViewById(R.id.complet);
            convertView.setTag(viewHolder);
        }

        Concert concert = getItem(position);

        viewHolder.artiste.setText(concert.getArtiste());
        viewHolder.jaquette.setImageResource(concert.getCheminJaquette());
        viewHolder.salle.setText(concert.getSalle());
        viewHolder.ville.setText("- "+concert.getVille());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy à HH:mm");
        String dateString = sdf.format(concert.getDate());
        viewHolder.date.setText(dateString);
        Integer NbPlaceTotale = concert.getNbPlaceTotale();
        Integer NbPlaceVendu = concert.getNbPlaceVendu();
        viewHolder.complet.setText(concert.getComplet());
        return convertView;
    }

    private class ConcertViewHolder{
        public TextView artiste;
        public ImageView jaquette;
        public TextView salle;
        public TextView ville;
        public TextView date;
        public TextView complet;
    }
}
