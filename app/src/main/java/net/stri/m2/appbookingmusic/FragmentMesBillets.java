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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMesBillets.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMesBillets#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMesBillets extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static Concert concert;

    private OnFragmentInteractionListener mListener;

    ListView ListViewConcerts;

    public FragmentMesBillets() {
        // Required empty public constructor
    }

    public static FragmentMesBillets newInstance(Concert concertP) {
        FragmentMesBillets fragment = new FragmentMesBillets();
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

    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListViewConcerts = (ListView) view.findViewById(R.id.ListViewConcerts);
        afficherListeConcert();
    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mes_billets, container, false);
    }

    private List<Concert> genererTopConcert(){
        List<Concert> concert = new ArrayList<Concert>();
        concert.add(new Concert("MICHAEL CALFAN",R.drawable.michaelcalfan,"Le Bikini", "RAMONVILLE","21-12-2016 20:00:00",20,300,0,"House","Michael Calfan, né en 1989 à Paris, est un disc jockey et producteur de musique français."));
        concert.add(new Concert("AFROJACK",R.drawable.afrojack,"Le Rex", "TOULOUSE","23-12-2017 22:00:00",22,300,0,"House","Afrojack, de son vrai nom Nick Leonardus van de Wall, né le 9 septembre 1987 à Spijkenisse, est un producteur et disc jockey néerlandais de musique house. Après une 19e place en 2010, et une 7e place en 2011, il est classé 9e au classement des meilleurs disc-jockeys mondiaux du DJ Magazine en 2012 et 2013 ; il recule de trois places en 2014. Il est classé 8e en 2015."));
        return concert;
    }

    private void afficherListeConcert(){
        List<Concert> concert = genererTopConcert();
        ConcertAdapter adapter = new ConcertAdapter(getView().getContext(), concert);
        ListViewConcerts.setAdapter(adapter);
        ListViewConcerts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragmentMaReservation = null;
                Concert choixConcert = (Concert) parent.getItemAtPosition(position);
                fragmentMaReservation = FragmentMaReservation.newInstance(choixConcert);
                if (fragmentMaReservation != null)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment,fragmentMaReservation);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
