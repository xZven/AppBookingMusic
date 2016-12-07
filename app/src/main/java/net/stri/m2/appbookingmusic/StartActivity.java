package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class StartActivity extends AppCompatActivity
        implements FragmentTopConcert.OnFragmentInteractionListener,
        FragmentRechercheAvancee.OnFragmentInteractionListener,
        FragmentConnexion.OnFragmentInteractionListener,
        FragmentInscription.OnFragmentInteractionListener{

    private ProgressBar pBar         = null;
    private Button buttonSidentifier = null;
    private Button buttonSinscrire   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //********************************************//

        this.pBar = (ProgressBar) findViewById(R.id.AppBarProgressBar);
        // Recensement des buttons
        this.buttonSidentifier = (Button) findViewById(R.id.buttonConnexion);
        this.buttonSinscrire   = (Button) findViewById(R.id.buttonConnexion);
        Fragment fragmentTopConcert = null;
        fragmentTopConcert = new FragmentTopConcert();
        if (fragmentTopConcert != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentTopConcert);
            ft.commit();
        }
     }


    /* les méthodes ci-dessous sont les méthodes qui permettent
     * de définir les actions des boutons de cette activité.
     *
     * Pour cela, une fois la méthode défini ci-dessous,
     * il faut, dans le layout du bouton faire référence
     * à la méthode créé dans l'attribut android:Onclick="ma méthode".
     *
     * une méthode est de la forme suivante:
     *
     * public void ma_méthode(View v){
     *  // code
     * }
     */


    // Connection Manager Fragment methods
    public void sIndentifier(View v) {

    //    this.buttonSidentifier.setEnabled(false)
    //    this.buttonSinscrire.setEnabled(true);

        this.pBar.setVisibility(View.VISIBLE);
        //
        FragmentConnexion fragmentConnexion = null;
        fragmentConnexion = new FragmentConnexion();
        //
        if (fragmentConnexion != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentConnexion);
            ft.commit();
        }
        //
        this.pBar.setVisibility(View.INVISIBLE);

    }

    public void sInscrire(View v){

    //    this.buttonSidentifier.setEnabled(true);
    //    this.buttonSinscrire.setEnabled(false);
        //
        this.pBar.setVisibility(View.VISIBLE);
        //
        FragmentInscription fragmentInscription = null;
        fragmentInscription = new FragmentInscription();
        //
        if (fragmentInscription != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentInscription);
            ft.commit();
        }
        //
        this.pBar.setVisibility(View.INVISIBLE);
    }

    // boutons menu

    public void acceuil(View v){

        this.pBar.setVisibility(View.VISIBLE);
        //
        Fragment fragmentTopConcert = null;
        fragmentTopConcert = new FragmentTopConcert();
        if (fragmentTopConcert != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentTopConcert);
            ft.commit();
        }
        //
        this.pBar.setVisibility(View.INVISIBLE);
    }

    //


    public void connexion(View v){
        this.buttonSidentifier.setEnabled(false);
        this.buttonSinscrire.setEnabled(false);
        //
        RelativeLayout mainContent = (RelativeLayout) findViewById(R.id.CMFECRelativeLayout);
        LayoutInflater inflater    = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView              = inflater.inflate(R.layout.fragment_start, mainContent, false);
        // création de la vue qui sera ajouté
        View           layout      = inflater.inflate(R.layout.fragment_connexion, null);
        //
        mainContent.removeAllViews();
        mainContent.addView(layout);
    }

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }


}
