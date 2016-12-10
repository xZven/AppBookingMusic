package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentPaiement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentPaiement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPaiement extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static Concert concert;
    private static Integer nbPlace;

    private OnFragmentInteractionListener mListener;

    public FragmentPaiement() {
        // Required empty public constructor
    }

    public static FragmentPaiement newInstance(Concert concertP, Integer nbPlaceP) {
        FragmentPaiement fragment = new FragmentPaiement();
        concert=concertP;
        nbPlace=nbPlaceP;
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
        return inflater.inflate(R.layout.fragment_paiement, container, false);
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
        TextView editTextPrix = (TextView) view.findViewById(R.id.editTextPrix);
        TextView editTextNbPlaces = (TextView) view.findViewById(R.id.editTextNbPlaces);
        TextView editTextPrixTotal = (TextView) view.findViewById(R.id.editTextPrixTotal);
        Button buttonPayer = (Button) view.findViewById(R.id.buttonPayer);

        //Saisie des nouvelles informations
        jaquette.setImageResource(concert.getCheminJaquette());
        artiste.setText(concert.getArtiste());
        salle.setText(concert.getSalle());
        ville.setText(concert.getVille());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy à hh:mm");
        String dateString = sdf.format(concert.getDate());
        date.setText(dateString);
        editTextPrix.setText(concert.getPrix().toString()+" €");
        editTextNbPlaces.setText(nbPlace.toString());
        Integer prixTotal = concert.getPrix()*nbPlace;
        editTextPrixTotal.setText(prixTotal.toString()+" €");

        //Action du bouton payer
        buttonPayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentPaiementAccepte = null;
                fragmentPaiementAccepte = FragmentPaiementAccepte.newInstance(concert);
                if (fragmentPaiementAccepte != null) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment, fragmentPaiementAccepte);
                    ft.commit();
                }
            }
        });
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
