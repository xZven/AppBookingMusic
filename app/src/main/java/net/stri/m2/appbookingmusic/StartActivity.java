package net.stri.m2.appbookingmusic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class StartActivity extends AppCompatActivity
        implements FragmentTopConcert.OnFragmentInteractionListener,
        FragmentRechercheAvancee.OnFragmentInteractionListener,
        FragmentConnexion.OnFragmentInteractionListener,
        FragmentInscription.OnFragmentInteractionListener{

    private ProgressBar pBar         = null;
    private Button buttonSidentifier = null;
    private Button buttonSinscrire   = null;
    private Button buttonAcceuil   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //********************************************//

        this.pBar = (ProgressBar) findViewById(R.id.AppBarProgressBar);
        // Recensement des buttons
        this.buttonSidentifier = (Button) findViewById(R.id.buttonConnexion);
        this.buttonSinscrire   = (Button) findViewById(R.id.buttonConnexion);
        //menu
        this.buttonAcceuil     = (Button) findViewById(R.id.buttonAccueil);

        // Fragment de départ de l'activité
        Fragment fragmentTopConcert = null;
        fragmentTopConcert = new FragmentTopConcert();
        if (fragmentTopConcert != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentTopConcert);
            ft.commit();
        }
     }


    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
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

    /**
     * Utilisé par le bouton "Acceuil" du menu qui permet d'afficher
     * le top_concert_fragment.
     * @param v
     */
    public void acceuil(View v){
        // TODO code for button buttonAcceuil

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

    /**
     * Utilisé par le bouton "Mes Billets" du menu qui permet d'afficher
     * les billets réservés.
     * @param v
     */
    public void mesBillets(View v){
        // TODO code for button buttonMesBillets
    }

    /**
     * Utilisé par le bouton "Mon Profil" du menu qui permet d'afficher
     * le profil de l'utilisateur.
     * @param v
     */
    public void monProfil(View v){
        // TODO code for button buttonMonProfil
    }

    //
    public void connexion(View v){

        this.pBar.setVisibility(View.VISIBLE);
        //
        ConnectionManagerFragmentEC CMF_EC = null;
        CMF_EC = new ConnectionManagerFragmentEC();

        //
        if (CMF_EC != null)
        {
            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentCM,CMF_EC);
            ft.commit();
        }
        //
        this.pBar.setVisibility(View.INVISIBLE);

        // on bascule ensuite sur l'acceuil.

        this.acceuil(findViewById(R.id.buttonAccueil));

    }




}
