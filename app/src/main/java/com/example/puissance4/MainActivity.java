package com.example.puissance4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //On défini les input texte pour les deux joueurs sur la page d'accueil
    EditText nomJoueur1;
    EditText nomJoueur2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On récupère les id pour les deux joueurs
        nomJoueur1 = findViewById(R.id.nomJoueur1);
        nomJoueur2 = findViewById(R.id.nomJoueur2);
    }



    public void navigationToNameActivity(View v){
        //On récupère les noms des joueurs, on les transforme en string et on les mets en minuscule
        String string1 = nomJoueur1.getText().toString().trim().toLowerCase();
        String string2 = nomJoueur2.getText().toString().trim().toLowerCase();


        //Vérification des noms "vides" & "nulls"
        if (string1.equals("") || string2.equals("")) {
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show(); //Affichage du message pour dire de remplir les cases vides
            return;
        }

        else { //Si les noms sont != null, alors on envoi vers la page de jeu avec un new Intent qui prend les deux noms de joueurs en paramètres
            Intent nameActivityIntent = new Intent(this, NameActivity.class);
            String s = nomJoueur1.getText().toString().trim().toLowerCase();
            String e = nomJoueur2.getText().toString().trim().toLowerCase();

            //Ici c'est le putExtra pour les deux noms de joueurs
            nameActivityIntent.putExtra("name", s);
            nameActivityIntent.putExtra("name2", e);

            //Et tac on démarre l'activity
            startActivity(nameActivityIntent);
        }



    }



}


