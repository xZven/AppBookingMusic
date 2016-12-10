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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

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

        //Initialisation des éléments du layout
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerRegion);
        ImageView buttonSearchAdvanced = (ImageView) view.findViewById(R.id.buttonSearchAdvanced);
        final EditText editFieldSearch = (EditText) view.findViewById(R.id.editFieldSearch);

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

        //Action du bouton de recherche avancee
        buttonSearchAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentRechercheAvancee = null;
                fragmentRechercheAvancee = FragmentRechercheAvancee.newInstance(editFieldSearch.getText().toString());
                if (fragmentRechercheAvancee != null)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment,fragmentRechercheAvancee);
                    ft.commit();
                }
            }
        });

        //Genration de la listView des concerts
        afficherListeConcert();
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
        concert.add(new Concert("MICHAEL CALFAN",R.drawable.michaelcalfan,"Le Bikini", "RAMONVILLE","21-12-2016 20:00:00",20,300,0,"House","Michael Calfan, né en 1989 à Paris, est un disc jockey et producteur de musique français."));
        concert.add(new Concert("HARDWELL",R.drawable.hardwell,"Zénith de Toulouse", "TOULOUSE","22-01-2017 21:00:00",21,300,300,"Techno","Hardwell, de son vrai nom Robbert van de Corput, né le 7 janvier 1988 à Bréda, est un disc jockey et producteur de musique house et électronique néerlandais. Il s'illustre dans les genres electro house, EDM et big room. En 2008, il se fait connaître grâce à son bootleg Show Me Love vs. Be de Robin S., devenu un hit dans les clubs à travers le monde, puis repris par Michael Mind."));
        concert.add(new Concert("AFROJACK",R.drawable.afrojack,"Le Rex", "TOULOUSE","23-12-2017 22:00:00",22,300,0,"House","Afrojack, de son vrai nom Nick Leonardus van de Wall, né le 9 septembre 1987 à Spijkenisse, est un producteur et disc jockey néerlandais de musique house. Après une 19e place en 2010, et une 7e place en 2011, il est classé 9e au classement des meilleurs disc-jockeys mondiaux du DJ Magazine en 2012 et 2013 ; il recule de trois places en 2014. Il est classé 8e en 2015."));
        concert.add(new Concert("LOST FREQUENCIES",R.drawable.lostfrequencies,"Le Métronum", "TOULOUSE","24-12-2016 23:00:00",23,300,0,"House","Lost Frequencies, né Felix De Laet le 30 novembre 1993 à Bruxelles (Belgique), est un DJ, musicien et producteur belge."));
        concert.add(new Concert("BROKEN BACK",R.drawable.brokenback,"Le Bikini", "Ramonville","25-12-2016 20:00:00",24,300,0,"Electro","Si sur le moment, ce jeune malouin ne devait pas se réjouir, il peut maintenant remercier cette vertèbre qui l'a cloué chez lui et l'a incité à s'investir pleinement dans ce qui n'était jusqu'à présent qu'une passion, la musique. C'est d'ailleurs comme clin d'oeil à cette mésaventure qu'il a nommé son projet Broken Back."));
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
                Concert choixConcert = (Concert) parent.getItemAtPosition(position);
                fragmentBillet = FragmentBillet.newInstance(choixConcert);
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
