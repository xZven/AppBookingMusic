package net.stri.m2.appbookingmusic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class StartActivity extends AppCompatActivity {

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

        this.buttonSidentifier.setEnabled(false);
        this.buttonSinscrire.setEnabled(true);
        //
        RelativeLayout mainContent = (RelativeLayout) findViewById(R.id.fragment);
        LayoutInflater inflater    = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView              = inflater.inflate(R.layout.fragment_start, mainContent, false);
        // création de la vue qui sera ajouté
        View           layout      = inflater.inflate(R.layout.fragment_connexion, null);
        //
        mainContent.removeAllViews();
        mainContent.addView(layout);
    }

    public void sInscrire(View v){

        this.buttonSidentifier.setEnabled(true);
        this.buttonSinscrire.setEnabled(false);
        //
        RelativeLayout mainContent = (RelativeLayout) findViewById(R.id.fragment);
        LayoutInflater inflater    = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView              = inflater.inflate(R.layout.fragment_start, mainContent, false);
        // création de la vue qui sera ajouté
        View           layout      = inflater.inflate(R.layout.fragment_inscription, null);
        //
        mainContent.removeAllViews();
        mainContent.addView(layout);
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
}
