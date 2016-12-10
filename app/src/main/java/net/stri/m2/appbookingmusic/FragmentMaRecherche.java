package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMaRecherche.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMaRecherche#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMaRecherche extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ListView ListViewConcerts;

    public FragmentMaRecherche() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMaRecherche.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMaRecherche newInstance(String param1, String param2) {
        FragmentMaRecherche fragment = new FragmentMaRecherche();
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
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        afficherListeConcert();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ma_recherche, container, false);
        ListViewConcerts = (ListView) view.findViewById(R.id.ListViewConcerts);
        return view;
    }

    private List<Concert> genererTopConcert(){
        List<Concert> concert = new ArrayList<Concert>();
        concert.add(new Concert("MICHAEL CALFAN",R.drawable.michaelcalfan,"Le Bikini", "RAMONVILLE","01-12-2016 20:00:00",20,300,0,"Michael Calfan, né en 1989 à Paris, est un disc jockey et producteur de musique français."));
        concert.add(new Concert("HARDWELL",R.drawable.hardwell,"Zénith de Toulouse", "TOULOUSE","12-01-2017 21:00:00",21,300,300,"Hardwell, de son vrai nom Robbert van de Corput, né le 7 janvier 1988 à Bréda, est un disc jockey et producteur de musique house et électronique néerlandais. Il s'illustre dans les genres electro house, EDM et big room. En 2008, il se fait connaître grâce à son bootleg Show Me Love vs. Be de Robin S., devenu un hit dans les clubs à travers le monde, puis repris par Michael Mind."));
        concert.add(new Concert("AFROJACK",R.drawable.afrojack,"Le Rex", "TOULOUSE","16-12-2017 22:00:00",22,300,0,"Afrojack, de son vrai nom Nick Leonardus van de Wall, né le 9 septembre 1987 à Spijkenisse, est un producteur et disc jockey néerlandais de musique house. Après une 19e place en 2010, et une 7e place en 2011, il est classé 9e au classement des meilleurs disc-jockeys mondiaux du DJ Magazine en 2012 et 2013 ; il recule de trois places en 2014. Il est classé 8e en 2015."));
        concert.add(new Concert("LOST FREQUENCIES",R.drawable.lostfrequencies,"Le Métronum", "TOULOUSE","20-12-2016 23:00:00",23,300,0,"Lost Frequencies, né Felix De Laet le 30 novembre 1993 à Bruxelles (Belgique), est un DJ, musicien et producteur belge."));
        concert.add(new Concert("BROKEN BACK",R.drawable.brokenback,"Le Bikini", "Ramonville","15-12-2016 20:00:00",24,300,0,"Si sur le moment, ce jeune malouin ne devait pas se réjouir, il peut maintenant remercier cette vertèbre qui l'a cloué chez lui et l'a incité à s'investir pleinement dans ce qui n'était jusqu'à présent qu'une passion, la musique. C'est d'ailleurs comme clin d'oeil à cette mésaventure qu'il a nommé son projet Broken Back."));
        return concert;
    }

    private void afficherListeConcert(){
        List<Concert> concert = genererTopConcert();

        ConcertAdapter adapter = new ConcertAdapter(getView().getContext(), concert);
        ListViewConcerts.setAdapter(adapter);
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
