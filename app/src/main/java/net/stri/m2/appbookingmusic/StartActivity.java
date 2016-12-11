package net.stri.m2.appbookingmusic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity
        implements FragmentTopConcert.OnFragmentInteractionListener,
        ConnectionManagerFragmentEC.OnFragmentInteractionListener,
        ConnectionManagerFragmentENC.OnFragmentInteractionListener,
        FragmentRechercheAvancee.OnFragmentInteractionListener,
        FragmentConnexion.OnFragmentInteractionListener,
        FragmentInscription.OnFragmentInteractionListener,
        FragmentMaRecherche.OnFragmentInteractionListener,
        FragmentBillet.OnFragmentInteractionListener,
        FragmentPaiement.OnFragmentInteractionListener,
        FragmentPaiementAccepte.OnFragmentInteractionListener,
        FragmentMaReservation.OnFragmentInteractionListener,
        FragmentMesBillets.OnFragmentInteractionListener,
        FragmentMonProfil.OnFragmentInteractionListener{

    private ProgressBar pBar = null;
    private Button buttonSidentifier = null;
    private Button buttonSinscrire = null;
    private Button buttonAcceuil = null;
    private Button buttonMesBillets = null;
    private Button buttonMonProfil = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //********************************************//

        //Initialisation des éléments du layout
        this.pBar = (ProgressBar) findViewById(R.id.AppBarProgressBar);
        this.buttonSidentifier = (Button) findViewById(R.id.buttonConnexion);
        this.buttonSinscrire   = (Button) findViewById(R.id.buttonConnexion);
        this.buttonAcceuil     = (Button) findViewById(R.id.buttonAccueil);
        this.buttonMesBillets     = (Button) findViewById(R.id.buttonMesBillets);
        this.buttonMonProfil     = (Button) findViewById(R.id.buttonMonProfil);

        // Par défaut on lance le fragment TopConcert
        Fragment fragmentTopConcert = null;
        fragmentTopConcert = new FragmentTopConcert();
        if (fragmentTopConcert != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentTopConcert);
            ft.commit();
        }

        //Par défaut on lance le fragment de connexion en état non connecté
        ConnectionManagerFragmentENC CMF_ENC = null;
        CMF_ENC = new ConnectionManagerFragmentENC();
        if (CMF_ENC != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentCM,CMF_ENC);
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
        FragmentManager fm = getSupportFragmentManager();
        try{
            ConnectionManagerFragmentENC etat = (ConnectionManagerFragmentENC) fm.findFragmentById(R.id.fragmentCM);
            //L'utilisateur n'est pas connecté
            if(etat==null|| !etat.isInLayout())
            {
                Toast.makeText(getApplicationContext(), "Veuillez vous connecter pour voir vos billets. ", Toast.LENGTH_LONG).show();
                Fragment fragmentConnexion = null;
                //On lance le fragment de connexion
                fragmentConnexion = new FragmentConnexion();
                if (fragmentConnexion != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment, fragmentConnexion);
                    ft.commit();
                }
            }
        }catch(Exception e){
            ConnectionManagerFragmentEC etat = (ConnectionManagerFragmentEC) fm.findFragmentById(R.id.fragmentCM);
            //On vérifie que l'utilisateur est connecté
            if(etat==null|| !etat.isInLayout()) {
                Fragment fragmentMesBillets = null;
                //On lance le fragment MesBillets
                fragmentMesBillets = new FragmentMesBillets();
                if (fragmentMesBillets != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment, fragmentMesBillets);
                    ft.commit();
                }
            }
        }
    }

    /**
     * Utilisé par le bouton "Mon Profil" du menu qui permet d'afficher
     * le profil de l'utilisateur.
     * @param v
     */
    public void monProfil(View v){
        FragmentManager fm = getSupportFragmentManager();
        try {
            ConnectionManagerFragmentENC etat = (ConnectionManagerFragmentENC) fm.findFragmentById(R.id.fragmentCM);
            //L'utilisateur n'est pas connecté
            if (etat == null || !etat.isInLayout()) {
                Toast.makeText(getApplicationContext(), "Veuillez vous connecter pour voir votre profil. ", Toast.LENGTH_LONG).show();
                Fragment fragmentConnexion = null;
                //On lance le fragment de connexion
                fragmentConnexion = new FragmentConnexion();
                if (fragmentConnexion != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment, fragmentConnexion);
                    ft.commit();
                }
            }
        } catch (Exception e) {
            ConnectionManagerFragmentEC etat = (ConnectionManagerFragmentEC) fm.findFragmentById(R.id.fragmentCM);
            //On vérifie que l'utilisateur est connecté
            if (etat == null || !etat.isInLayout()) {
                Fragment fragmentMonProfil = null;
                //On lance le fragment MesBillets
                fragmentMonProfil = new FragmentMonProfil();
                if (fragmentMonProfil != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment, fragmentMonProfil);
                    ft.commit();
                }
            }
        }
    }

    // Dans s'Identifier
    public void connexion(View v){

        this.pBar.setVisibility(View.VISIBLE);
        //
        ConnectionManagerFragmentEC CMF_EC = null;
        CMF_EC = new ConnectionManagerFragmentEC();

        //
        if (CMF_EC != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentCM,CMF_EC);
            ft.commit();
        }
        //
        this.pBar.setVisibility(View.INVISIBLE);

        // on bascule ensuite sur l'acceuil.

        this.acceuil(findViewById(R.id.buttonAccueil));

    }




}
