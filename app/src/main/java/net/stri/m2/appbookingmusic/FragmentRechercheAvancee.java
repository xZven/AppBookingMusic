package net.stri.m2.appbookingmusic;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRechercheAvancee.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRechercheAvancee#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRechercheAvancee extends Fragment
        implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText editTextDateDu;
    EditText editTextDateAu;

    public FragmentRechercheAvancee() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRechercheAvancee.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRechercheAvancee newInstance(String param1, String param2) {
        FragmentRechercheAvancee fragment = new FragmentRechercheAvancee();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        //Choix genre musical
        Spinner spinnerGenre = (Spinner) view.findViewById(R.id.spinnerGenre);
        ArrayAdapter<String> dataSpinnerGenreAdapter = new ArrayAdapter<String>(super.getContext(), android.R.layout.simple_spinner_item, genererListeGenre());
        dataSpinnerGenreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenre.setAdapter(dataSpinnerGenreAdapter);
        spinnerGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Choix région
        Spinner spinnerRegion = (Spinner) view.findViewById(R.id.spinnerRegion);
        ArrayAdapter<String> dataSpinnerRegionAdapter = new ArrayAdapter<String>(super.getContext(), android.R.layout.simple_spinner_item, genererListeRegions());
        dataSpinnerRegionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(dataSpinnerRegionAdapter);
        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
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
        genre.add("Hip Hop");
        genre.add("Rap");
        genre.add("Reggae");
        genre.add("Jazz");
        genre.add("House");
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
