package net.stri.m2.appbookingmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class StartActivity extends AppCompatActivity {

    private ProgressBar pBar         = null ;
    private Button buttonSidentifier = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //********************************************//

        this.pBar = (ProgressBar) findViewById(R.id.AppBarProgressBar);
        // button
        this.buttonSidentifier = (Button) findViewById(R.id.buttonConnexion);
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

    public void sIndentifier(View v) {

        this.buttonSidentifier.setEnabled(false);

        // on change le fragment d'affichage (marche pas)
/*
        ViewStub stub = (ViewStub) findViewById(R.id.contentIncluder);
        stub.setLayoutResource(R.layout.fragment_connexion);
        View inflated = stub.inflate();
*/
    }

}
