package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentTopConcert.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentTopConcert#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTopConcert extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView textViewChoixRegion;
    ListView ListViewConcerts;

    public FragmentTopConcert() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTopConcert.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTopConcert newInstance(String param1, String param2) {
        FragmentTopConcert fragment = new FragmentTopConcert();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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

    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        // Spinner element
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerRegion);

        // Creating adapter for spinner
        ArrayAdapter<String> dataSpinnerAdapter = new ArrayAdapter<String>(super.getContext(), android.R.layout.simple_spinner_item, genererListeRegions());

        // Drop down layout style - list view with radio button
        dataSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataSpinnerAdapter);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                textViewChoixRegion.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        afficherListeConcert();
        android.support.design.widget.FloatingActionButton buttonSearchAdvanced = (android.support.design.widget.FloatingActionButton) view.findViewById(R.id.ButtonSearchAdvanced);
        buttonSearchAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentRechercheAvancee = null;
                fragmentRechercheAvancee = new FragmentRechercheAvancee();
                if (fragmentRechercheAvancee != null)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment,fragmentRechercheAvancee);
                    ft.commit();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_top_concert,container,false);
        textViewChoixRegion = (TextView) view.findViewById(R.id.textViewChoixRegion);
        ListViewConcerts = (ListView) view.findViewById(R.id.ListViewConcerts);
        return view;
    }

    private List<String> genererListeRegions(){
        // Spinner Drop down elements
        List<String> regions = new ArrayList<String>();
        regions.add("Toute la France");
        regions.add("Auvergne-Rhône-Alpes");
        regions.add("Bourgogne-Franche-Comté");
        regions.add("Bretagne");
        regions.add("Centre-Val de Loire");
        regions.add("Corse");
        regions.add("Grand Est");
        regions.add("Guadeloupe");
        regions.add("Guyane");
        regions.add("Hauts-de-France");
        regions.add("Ile-de-France");
        regions.add("La Réunion");
        regions.add("Martinique");
        regions.add("Mayotte");
        regions.add("Normandie");
        regions.add("Nouvelle-Aquitaine");
        regions.add("Occitanie");
        regions.add("Pays de la Loire");
        regions.add("Provence-Alpes-Côte d'Azur");
        return regions;
    }

    private List<Concert> genererTopConcert(){
        List<Concert> concert = new ArrayList<Concert>();
        concert.add(new Concert("MICHAEL CALFAN",R.drawable.michaelcalfan,"Le Bikini", "RAMONVILLE","01-12-2016 20:00:00",300,0));
        concert.add(new Concert("HARDWELL",R.drawable.hardwell,"Zénith de Toulouse", "TOULOUSE","12-01-2017 21:00:00",300,300));
        concert.add(new Concert("AFROJACK",R.drawable.afrojack,"Le Rex", "TOULOUSE","16-12-2017 22:00:00",300,0));
        concert.add(new Concert("LOST FREQUENCIES",R.drawable.lostfrequencies,"Le Métronum", "TOULOUSE","20-12-2016 23:00:00",300,0));
        concert.add(new Concert("BROKEN BACK",R.drawable.brokenback,"Le Bikini", "Ramonville","15-12-2016 20:00:00",300,0));
        return concert;
    }

    private void afficherListeConcert(){
        List<Concert> concert = genererTopConcert();

        ConcertAdapter adapter = new ConcertAdapter(getView().getContext(), concert);
        ListViewConcerts.setAdapter(adapter);
        ListViewConcerts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragmentBillet = null;
                fragmentBillet = new FragmentBillet();
                if (fragmentBillet != null)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment,fragmentBillet);
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
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
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
