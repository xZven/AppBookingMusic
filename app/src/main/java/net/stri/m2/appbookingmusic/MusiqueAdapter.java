package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyrilou on 06/12/2016.
 */

public class MusiqueAdapter extends ArrayAdapter<Musique> {

    public MusiqueAdapter(Context context, List<Musique> musique) {
        super(context, 0, musique);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_concerts,parent, false);
        }

        MusiqueViewHolder viewHolder = (MusiqueViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new MusiqueViewHolder();
            viewHolder.artiste  =    (TextView)  convertView.findViewById(R.id.artiste);
            viewHolder.jaquette =    (ImageView) convertView.findViewById(R.id.jaquette);
            convertView.setTag(viewHolder);
        }

        Musique musique = getItem(position);

        viewHolder.artiste.setText(musique.getArtiste());
        //viewHolder.jaquette.setImageDrawable(new ColorDrawable(musique.getCheminJaquette()));
        viewHolder.jaquette.setImageResource(musique.getCheminJaquette());


        return convertView;
    }

    private class MusiqueViewHolder{
        public TextView artiste;
        public ImageView jaquette;
    }
}
