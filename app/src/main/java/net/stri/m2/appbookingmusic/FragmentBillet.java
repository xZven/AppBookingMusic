package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBillet.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBillet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBillet extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static Concert concert;
    private Integer nbPlace;

    private OnFragmentInteractionListener mListener;

    public FragmentBillet() {
        // Required empty public constructor
    }

    public static FragmentBillet newInstance(Concert concertP) {
        FragmentBillet fragment = new FragmentBillet();
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

    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        //Initialisation du billet
        //Initialisation des éléments du layout
        ImageView jaquette = (ImageView) view.findViewById(R.id.jaquette);
        TextView artiste = (TextView) view.findViewById(R.id.artiste);
        TextView salle = (TextView) view.findViewById(R.id.salle);
        TextView ville = (TextView) view.findViewById(R.id.ville);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView prix = (TextView) view.findViewById(R.id.textViewPrix);
        TextView description = (TextView) view.findViewById(R.id.textViewDescription);
        Button buttonReserver = (Button) view.findViewById(R.id.buttonReserver);

        //Saisie des nouvelles informations
        jaquette.setImageResource(concert.getCheminJaquette());
        artiste.setText(concert.getArtiste());
        salle.setText(concert.getSalle());
        ville.setText(concert.getVille());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy à hh:mm");
        String dateString = sdf.format(concert.getDate());
        date.setText(dateString);
        prix.setText(concert.getPrix().toString()+" €");
        description.setText(concert.getDescription());
        description.setMovementMethod(new ScrollingMovementMethod());


        //Creation du choix du nombre de place
        Spinner spinnerNbPlace = (Spinner) view.findViewById(R.id.spinnerNbPlace);
        ArrayAdapter<Integer> dataSpinnerAdapter = new ArrayAdapter<Integer>(super.getContext(), android.R.layout.simple_spinner_item, genererListeNbPlaces());
        dataSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNbPlace.setAdapter(dataSpinnerAdapter);
        spinnerNbPlace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                nbPlace = Integer.parseInt(item);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                nbPlace = 1;
            }
        });

        //Action du bouton réserver
        buttonReserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity myContext = getActivity();
                FragmentManager fm = myContext.getSupportFragmentManager();
                try{
                    ConnectionManagerFragmentENC etat = (ConnectionManagerFragmentENC) fm.findFragmentById(R.id.fragmentCM);
                    if(etat==null|| !etat.isInLayout())
                    {
                        Toast.makeText(getContext(), "Veuillez vous connecter avant de réserver un billet s'il vous plaît. ", Toast.LENGTH_LONG).show();
                        Fragment fragmentConnexion = null;
                        fragmentConnexion = new FragmentConnexion();
                        if (fragmentConnexion != null) {
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.fragment, fragmentConnexion);
                            ft.commit();
                        }
                    }
                }catch(Exception e){
                    ConnectionManagerFragmentEC etat = (ConnectionManagerFragmentEC) fm.findFragmentById(R.id.fragmentCM);
                    if(etat==null|| !etat.isInLayout()) {
                        Fragment fragmentPaiement = null;
                        fragmentPaiement = FragmentPaiement.newInstance(concert,nbPlace);
                        if (fragmentPaiement != null) {
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.fragment, fragmentPaiement);
                            ft.commit();
                        }
                    }
                };
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_billet, container, false);
        return view;
    }

    private List<Integer> genererListeNbPlaces(){
        // Spinner Drop down elements
        List<Integer> nbPlaces = new ArrayList<Integer>();
        nbPlaces.add(1);
        nbPlaces.add(2);
        nbPlaces.add(3);
        nbPlaces.add(4);
        nbPlaces.add(5);
        return nbPlaces;
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
