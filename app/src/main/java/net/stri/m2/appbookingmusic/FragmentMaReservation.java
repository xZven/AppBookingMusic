package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;

public class FragmentMaReservation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static Concert concert;

    private OnFragmentInteractionListener mListener;

    public FragmentMaReservation() {
        // Required empty public constructor
    }

    public static FragmentMaReservation newInstance(Concert concertP) {
        FragmentMaReservation fragment = new FragmentMaReservation();
        concert=concertP;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ma_reservation, container, false);
        return view;
    }

    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        //Initialisation du billet
        //Initialisation des éléments du layout
        ImageView jaquette = (ImageView) view.findViewById(R.id.jaquette);
        TextView artiste = (TextView) view.findViewById(R.id.artiste);
        TextView salle = (TextView) view.findViewById(R.id.salle);
        TextView ville = (TextView) view.findViewById(R.id.ville);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView prix = (TextView) view.findViewById(R.id.textViewPrix);
        Button buttonVoirBillet = (Button) view.findViewById(R.id.buttonVoirBillet);

        //Saisie des nouvelles informations
        jaquette.setImageResource(concert.getCheminJaquette());
        artiste.setText(concert.getArtiste());
        salle.setText(concert.getSalle());
        ville.setText(concert.getVille());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy à hh:mm");
        String dateString = sdf.format(concert.getDate());
        date.setText(dateString);
        prix.setText(concert.getPrix().toString()+" €");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
