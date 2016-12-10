package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentRechercheAvancee extends Fragment
        implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static String motsCles;

    private OnFragmentInteractionListener mListener;

    EditText editTextDateDu;
    EditText editTextDateAu;
    EditText editFieldSearch;
    Button buttonRechercheAvance;

    public FragmentRechercheAvancee() {
        // Required empty public constructor
    }

    public static FragmentRechercheAvancee newInstance(String motsClesP) {
        FragmentRechercheAvancee fragment = new FragmentRechercheAvancee();
        motsCles=motsClesP;
        return fragment;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        Bundle bundle=getArguments();
        super.onViewCreated(view, savedInstanceState);

        //Initialisations des éléments du layout
        final Spinner spinnerGenre = (Spinner) view.findViewById(R.id.spinnerGenre);
        final Spinner spinnerRegion = (Spinner) view.findViewById(R.id.spinnerRegion);
        Button buttonRechercheAvance = (Button) view.findViewById(R.id.buttonRechercheAvance);
        EditText editFieldSearchAdvanced = (EditText) view.findViewById(R.id.editFieldSearchAdvanced);

        //On recupere les mots cles du fragment précedent
        editFieldSearchAdvanced.setText(motsCles);

        //Choix genre musical
        ArrayAdapter<String> dataSpinnerGenreAdapter = new ArrayAdapter<String>(super.getContext(), android.R.layout.simple_spinner_item, genererListeGenre());
        dataSpinnerGenreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenre.setAdapter(dataSpinnerGenreAdapter);
        spinnerGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String genre = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Choix région
        ArrayAdapter<String> dataSpinnerRegionAdapter = new ArrayAdapter<String>(super.getContext(), android.R.layout.simple_spinner_item, genererListeRegions());
        dataSpinnerRegionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(dataSpinnerRegionAdapter);
        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String region = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Action du bouton recherche avance
        buttonRechercheAvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentMaRecherche = null;
                fragmentMaRecherche = FragmentMaRecherche.newInstance(motsCles,spinnerGenre.getSelectedItem().toString(),editTextDateDu.getText().toString(),editTextDateAu.getText().toString(),spinnerRegion.getSelectedItem().toString());
                if (fragmentMaRecherche != null)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment,fragmentMaRecherche);
                    ft.commit();
                }
            }
        });

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
        View view=inflater.inflate(R.layout.fragment_recherche_avancee,container,false);
        editTextDateDu = (EditText) view.findViewById(R.id.editTextDateDu);
        //On masque le clavier pour editTextDateDu
        editTextDateDu.setInputType(InputType.TYPE_NULL);
        editTextDateDu.setOnClickListener(this);
        editTextDateAu = (EditText) view.findViewById(R.id.editTextDateAu);
        //On masque le clavier pour editTextDateAu
        editTextDateAu.setInputType(InputType.TYPE_NULL);
        editTextDateAu.setOnClickListener(this);
        editFieldSearch = (EditText) view.findViewById(R.id.editFieldSearch);
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

    private List<String> genererListeGenre(){
        // Spinner Drop down elements
        List<String> genre = new ArrayList<String>();
        genre.add("Techno");
        genre.add("House");
        genre.add("Electro");
        genre.add("Hip Hop");
        genre.add("Rap");
        genre.add("Reggae");
        genre.add("Jazz");
        genre.add("Dance");
        genre.add("Dub");
        genre.add("Metal");
        genre.add("Rock");
        genre.add("Pop");
        genre.add("Folk");
        return genre;
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

    public void onClick(View v) {
        //do what you want to do when button is clicked
        switch (v.getId()) {
            case R.id.editTextDateDu:{
                DialogFragment picker = new DatePickerFragment();
                picker.show(getFragmentManager(), "datePicker");
                break;
            }
            case R.id.editTextDateAu:{
                DialogFragment picker = new DatePickerFragment();
                picker.show(getFragmentManager(), "datePicker");
                break;
            }
        }
    }

}
