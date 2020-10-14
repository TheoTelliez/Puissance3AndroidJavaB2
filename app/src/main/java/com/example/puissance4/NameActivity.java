//################################################################################################//
//                    PROJET PUISSANCE 3 ANDROID STUDIO - JAVA
//                THÉO TELLIEZ - RENDU LE MERCREDI 14 OCTOBRE 2020
//              PROJET DEMANDÉ, SOUTENU ET ÉVALUÉ PAR JULIEN LENGLET
//################################################################################################//

//Début des imports et définition du package de notre app
package com.example.puissance4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

//Au cas ou je garde ça sous la main :
import android.content.Intent;
import android.widget.Toast;

//Définition de notre classe principale
public class NameActivity extends AppCompatActivity {

    //Déclaration des variables pour les deux joueurs
    TextView textViewJoueurUn;
    TextView textViewJoueurDeux;

    //Variables pour la fonction aGagne()
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button btmenu;
    TableLayout tableLayout;
    TextView nomJoueurEnCours;
    TextView joueurGagnant;
    TextView quiWin;

    //Je crée le tableau1
    ImageView[][] tableau;

    //Je récupère les ID
    ImageView L1C1;
    ImageView L1C2;
    ImageView L1C3;
    ImageView L1C4;
    ImageView L1C5;

    ImageView L2C1;
    ImageView L2C2;
    ImageView L2C3;
    ImageView L2C4;
    ImageView L2C5;

    ImageView L3C1;
    ImageView L3C2;
    ImageView L3C3;
    ImageView L3C4;
    ImageView L3C5;

    ImageView L4C1;
    ImageView L4C2;
    ImageView L4C3;
    ImageView L4C4;
    ImageView L4C5;

    ImageView L5C1;
    ImageView L5C2;
    ImageView L5C3;
    ImageView L5C4;
    ImageView L5C5;

    //Je crée le tableau 2
    int[][] tableau2;

    //Je défini le boolean pour l'alternance des deux joueurs
    boolean Joueur = true;


//################################################################################################//
//                    FONCTION PRINCIPALE DÉFINISSANT LES ÉLÉMENTS DU JEU
//################################################################################################//
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        //On récupère les id des textView des joueurs
        textViewJoueurUn = findViewById(R.id.textViewJoueurUn);
        textViewJoueurDeux = findViewById(R.id.textViewJoueurDeux);

        //On récupère les id pour la fonction aGagne()
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        btmenu = findViewById(R.id.btmenu);
        tableLayout = findViewById(R.id.tableLayout);
        nomJoueurEnCours = findViewById(R.id.nomJoueurEnCours);
        quiWin = findViewById(R.id.quiWin);
        joueurGagnant = findViewById(R.id.joueurGagnant);

        //On récupère les textes des "inputs" de MainActivity et on set les textView de NameActivity (Joueur 1)
        String stringFromIntent = getIntent().getExtras().getString("name");
        textViewJoueurUn.setText(stringFromIntent);

        //On récupère les textes des "inputs" de MainActivity et on set les textView de NameActivity (Joueur 2)
        String stringFromIntent2 = getIntent().getExtras().getString("name2");
        textViewJoueurDeux.setText(stringFromIntent2);

        //On défini nos tableaux (un pour le visuel et l'autre pour les valeurs -comparaisons 0 1 2-)
        tableau = new ImageView[5][5];
        tableau2 = new int[5][5];

        //On défini la visibilité de chaque élément en début de jeu
        btmenu.setVisibility(View.INVISIBLE); //Au début on set le bouton menu (retour) invisible
        tableLayout.setVisibility(View.VISIBLE); //Au début on set la table visible
        quiWin.setVisibility(View.INVISIBLE); //Au début quiwin n'est pas visible
        joueurGagnant.setVisibility(View.INVISIBLE); //Au début on ne connait pas le joueur gagnant

        //On défini l'alternance de nos joueurs (caché / visible / caché / etc) en fonction du boolean
        if (Joueur){
            textViewJoueurUn.setVisibility(View.VISIBLE);
            textViewJoueurDeux.setVisibility(View.INVISIBLE);
        }
        else{
            textViewJoueurUn.setVisibility(View.INVISIBLE);
            textViewJoueurDeux.setVisibility(View.VISIBLE);
        }

        //Récupération des id depuis le dossier res pour les associer aux cases correspondantes
        L1C1 = findViewById(R.id.L1C1);
        L1C2 = findViewById(R.id.L1C2);
        L1C3 = findViewById(R.id.L1C3);
        L1C4 = findViewById(R.id.L1C4);
        L1C5 = findViewById(R.id.L1C5);

        L2C1 = findViewById(R.id.L2C1);
        L2C2 = findViewById(R.id.L2C2);
        L2C3 = findViewById(R.id.L2C3);
        L2C4 = findViewById(R.id.L2C4);
        L2C5 = findViewById(R.id.L2C5);

        L3C1 = findViewById(R.id.L3C1);
        L3C2 = findViewById(R.id.L3C2);
        L3C3 = findViewById(R.id.L3C3);
        L3C4 = findViewById(R.id.L3C4);
        L3C5 = findViewById(R.id.L3C5);

        L4C1 = findViewById(R.id.L4C1);
        L4C2 = findViewById(R.id.L4C2);
        L4C3 = findViewById(R.id.L4C3);
        L4C4 = findViewById(R.id.L4C4);
        L4C5 = findViewById(R.id.L4C5);

        L5C1 = findViewById(R.id.L5C1);
        L5C2 = findViewById(R.id.L5C2);
        L5C3 = findViewById(R.id.L5C3);
        L5C4 = findViewById(R.id.L5C4);
        L5C5 = findViewById(R.id.L5C5);

        //Définition des cases du tableau correspondantes aux images
        //Ex : L1C1 = Ligne 1 Colonne 1
        tableau[0][0] = L1C1;
        tableau[0][1] = L2C1;
        tableau[0][2] = L3C1;
        tableau[0][3] = L4C1;
        tableau[0][4] = L5C1;

        tableau[1][0] = L1C2;
        tableau[1][1] = L2C2;
        tableau[1][2] = L3C2;
        tableau[1][3] = L4C2;
        tableau[1][4] = L5C2;

        tableau[2][0] = L1C3;
        tableau[2][1] = L2C3;
        tableau[2][2] = L3C3;
        tableau[2][3] = L4C3;
        tableau[2][4] = L5C3;

        tableau[3][0] = L1C4;
        tableau[3][1] = L2C4;
        tableau[3][2] = L3C4;
        tableau[3][3] = L4C4;
        tableau[3][4] = L5C4;

        tableau[4][0] = L1C5;
        tableau[4][1] = L2C5;
        tableau[4][2] = L3C5;
        tableau[4][3] = L4C5;
        tableau[4][4] = L5C5;

        //Remplissage de 0 du tableau 2 :
       for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                tableau2[i][j]=0;
            }
        }

    }

//################################################################################################//
//           FONCTION PERMETTANT LA VÉRIFICATION DES CONDITIONS DE VICTOIRE
//################################################################################################//
    private void verifs(){

        //Vérification des lignes
        for(int i=4; i>=0; i--){ //On parcourt le tableau horizontalement
            for(int j=2; j>=0; j--) { //On parcourt le tableau verticalement
                if (tableau2[j][i] != 0) { //Si le tableau est à 0 alors ça veut dire qu'il n'y a pas de pion dans la cellule donc on stop la boucle
                    if (tableau2[j][i] == tableau2[j + 1][i] && tableau2[j][i] == tableau2[j + 2][i]) { //On dit que si la position du pion est la même que celle à i+1 et i+1, alors quelqu'un gagne
                        aGagne(); //Fonction de gagne présente si les conditions du if sont validées
                        break; //On stop tout
                    }
                }
            }
        }
        //Vérification des colonnes
        for(int i = 2; i >= 0; i--){ //On parcourt le tableau horizontalement
            for(int j = 4; j >= 0; j--) { //On parcourt le tableau verticalement
                if (tableau2[j][i] != 0) { //Si le tableau est à 0 alors ça veut dire qu'il n'y a pas de pion dans la cellule donc on stop la boucle
                    if (tableau2[j][i] == tableau2[j][i + 1] && tableau2[j][i] == tableau2[j][i + 2]) { //On dit que si la position du pion est la même que celle à j+1 et j+1, alors quelqu'un gagne
                        aGagne(); //Fonction de gagne présente si les conditions du if sont validées
                        break; //On stop tout
                    }
                }
            }
        }

        //Vérification des diagonales dans le sens -j +i
        for(int i = 0; i <= 2; i++) { //On parcourt le tableau horizontalement
            for (int j = 2; j <= 4; j++) {  //On parcourt le tableau verticalement
                //Si j=2 et j>=0 alors ça crash quand le 3è pion sur la col 1 à cause de la recherche de vide (case nulle) / donc en mettant j=4 et j>=2 on recherche que 0 1 2 3 4 et pas -1 et -2
                if (tableau2[j][i] != 0) { //Si le tableau est à 0 alors ça veut dire qu'il n'y a pas de pion dans la cellule donc on stop la boucle
                    if (tableau2[j][i] == tableau2[j - 1][i + 1] && tableau2[j][i] == tableau2[j - 2][i + 2]) { //On parcourt les cases dans le sens vectoriel -j +i
                        aGagne(); //Fonction de gagne présente si les conditions du if sont validées
                        break; //On stop tout
                    }
                }
            }
        }

        //Vérification des diagonales dans le sens +i +j
        for(int i = 0; i <= 2; i++) { //On parcourt le tableau horizontalement
            for (int j = 0; j <= 2; j++) {  //On parcourt le tableau verticalement
                if (tableau2[j][i] != 0) { //Si le tableau est à 0 alors ça veut dire qu'il n'y a pas de pion dans la cellule donc on stop la boucle
                    if (tableau2[j][i] == tableau2[j + 1][i + 1] && tableau2[j][i] == tableau2[j + 2][i + 2]) { //On parcourt les cases dans le sens vectoriel +i +j
                        aGagne(); //Fonction de gagne présente si les conditions du if sont validées
                        break; //On stop tout
                    }
                }
            }
        }

        //Inspiration du code d'un TicTacToe pour la vérification diagonale : en aucun cas j'ai copié-collé, j'ai essayé grâce à ce code de comprendre la logique - je peux l'expliquer si besoin
        //Lien du fichier : https://github.com/zizoh/TicTacToe-3x3-5x5-java/blob/master/app/src/main/java/com/example/android/tictactoe/MainActivity.java
        //tableau[hauteur][largeur] - peu importe le nom de la variable qui est dedans on suit toujours cette logique la
        //Aide pour la boucle for : https://www.tutoderien.com/la-boucle-for-dans-java/
        //Aide pour la boucle if : https://www.w3schools.com/java/java_conditions.asp
        //Aide pour les intents / int : https://mathias-seguy.developpez.com/tutoriels/android/intent-filter/
        //Aide pour les tableaux en java : http://www-inf.telecom-sudparis.eu/COURS/CSC3101/Supports/cours/tableaux.pptx.pdf
        //Aide non utilisée dans ce projet' pour les listes en java : https://riptutorial.com/fr/java/example/10149/creer-une-liste

    }

//################################################################################################//
//       FONCTION PERMETTANT LE RETOUR AU MENU PRINCIPAL S'IL N'Y A PAS DE VICTOIRE
//################################################################################################//
    public void retourSiNonWin() {
        //Retour au menu sans gagner
        for(int i = 0; i < 5; i++){ //On parcourt le tableau horizontalement
            for (int j = 0; j < 5; j++){ //On parcourt le tableau verticalement
                if ((tableau2[0][0] != 0) && (tableau2[1][0] != 0) && (tableau2[2][0] != 0) && (tableau2[3][0] != 0) && (tableau2[4][0] != 0)) { //Si la ligne du haut (L1CX) est remplie mais que les conditions de victoire ne sont pas validées, alors on stop tout et on affiche que personne ne gagne.
                    // Toast.makeText(this, "Personne ne gagne ! :(", Toast.LENGTH_SHORT).show(); //On affiche un message pour dire que personne ne gagne // TROP DE TEMPS D'AFFICHAGE
                    this.finish(); //On revient au menu principal
                }
            }
        }

        //J'en profite pour faire dépop les boutons des cases remplies ici
        for(int i = 0; i < 5; i++){ //On parcourt le tableau horizontalement
            for (int j = 0; j < 5; j++){ //On parcourt le tableau verticalement
                if ((tableau2[0][0] != 0)) { //On check si la première colonne est remplie
                    button.setVisibility(View.INVISIBLE); //bouton col 1 qui de-pop
                }
                if ((tableau2[1][0] != 0)) { //On check si la deuxième colonne est remplie
                    button2.setVisibility(View.INVISIBLE); //bouton col 2 qui de-pop
                }
                if ((tableau2[2][0] != 0)) { //On check si la troixième colonne est remplie
                    button3.setVisibility(View.INVISIBLE); //bouton col 3 qui de-pop
                }
                if ((tableau2[3][0] != 0)) { //On check si la quatrième colonne est remplie
                    button4.setVisibility(View.INVISIBLE); //bouton col 4 qui de-pop
                }
                if ((tableau2[4][0] != 0)) { //On check si la cinquième colonne est remplie
                    button5.setVisibility(View.INVISIBLE); //bouton col 5 qui de-pop
                }
            }
        }


    }

//################################################################################################//
//             FONCTION PERMETTANT LE RETOUR AU MENU PRINCIPAL LORS D'UNE VICTOIRE
//################################################################################################//
    public void navigationToMainActivity(View v){
        this.finish(); //On revient au menu principal
        //Pas besoin de refaire un nouveau Intent nameActivityIntent = new Intent(this, MainActivity.class); et startActivity(nameActivityIntent);
        //Car avec le finish ça ferme directement l'intent alors qu'avec l'autre commande on recrée un Intent inutilement

    }

//################################################################################################//
//           FONCTION PERMETTANT L'AFFICHAGE DES ÉLÉMENTS LORS DE LA GAGNE D'UN JOUEUR
//################################################################################################//
    public void aGagne() {
        //On défini ici la visibilité de chaque élément lors d'un cas de gagne
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        btmenu.setVisibility(View.VISIBLE);
        tableLayout.setVisibility(View.INVISIBLE);
        textViewJoueurDeux.setVisibility(View.INVISIBLE);
        textViewJoueurUn.setVisibility(View.INVISIBLE);
        nomJoueurEnCours.setVisibility(View.INVISIBLE);
        quiWin.setVisibility(View.VISIBLE);
        joueurGagnant.setVisibility(View.VISIBLE);

        //On récupère le joueur en cours et on affiche son nom après le quiWin --> "Le gagnant qui remporte la partie est :"
        if (Joueur){
            joueurGagnant.setText(textViewJoueurDeux.getText()); //On récupére le nom du gagnant (en tant que Joueur 2)
        }
        else{
            joueurGagnant.setText(textViewJoueurUn.getText()); //On récupére le nom du gagnant (en tant que Joueur 1)
        }
    }

//################################################################################################//
//                                    ACTIONS DU BOUTON 1
//################################################################################################//
    public void bouton1(View v){
        for(int i = 4; i >= 0; i--) { //On parcourt le tableau horizontalement
            if (Joueur) { //On défini l'alternance de nos joueurs (caché / visible / caché / etc) en fonction du boolean
                if (tableau2[0][i] == 0) { //On regarde si la case est bien vide avant de remplir
                    tableau2[0][i] = 1; //On met pour le pion rouge un 1 dans le tableau
                    tableau[0][i].setImageResource(R.drawable.cellj1); //On remplace la case vide par l'image / la ressource cellj1 (pion rouge)
                    Joueur = false; //On remet l'alternance du boolean à false pour re-alterner
                    break; //Have a break have a kit kat
                }
            }
            if (!Joueur) { //On défini l'alternance de nos joueurs (caché / visible / caché / etc) en fonction du boolean
                if (tableau2[0][i] == 0) { //On regarde si la case est bien vide avant de remplir
                    tableau2[0][i] = 2; //On met pour le pion jaune un 2 dans le tableau
                    tableau[0][i].setImageResource(R.drawable.cellj2); //On remplace la case vide par l'image / la ressource cellj2 (pion jaune)
                    Joueur = true; //On remet l'alternance du boolean à true pour re-alterner
                    break; //Have a break have a kit kat
                }
            }
        }
        if (Joueur){
            textViewJoueurUn.setVisibility(View.VISIBLE); //Si le joueur 1 joue on affiche son pseudo...
            textViewJoueurDeux.setVisibility(View.INVISIBLE); //... et on cache celui du joueur 2
        }
        else{
            textViewJoueurDeux.setVisibility(View.VISIBLE); //Si le joueur 2 joue on affiche son pseudo...
            textViewJoueurUn.setVisibility(View.INVISIBLE); //... et on cache celui du joueur 1
        }
        verifs(); //On appelle la fonction de vérification des pions à chaque pion mis dans la colonne
        retourSiNonWin(); //On appelle la fonction de vérification en cas de "non victoire" à chaque pion mis dans la colonne
    }

//################################################################################################//
//                                    ACTIONS DU BOUTON 2
//################################################################################################//
    //COMMENTAIRES DE BOUTON SIMILAIRES AU BOUTON 1

    public void bouton2(View v){
        for(int i = 4; i >= 0; i--) {
            if (Joueur) {
                if (tableau2[1][i] == 0) {
                    tableau2[1][i] = 1;
                    tableau[1][i].setImageResource(R.drawable.cellj1);
                    Joueur = false;
                    break;
                }
            }
            if (!Joueur) {
                if (tableau2[1][i] == 0) {
                    tableau2[1][i] = 2;
                    tableau[1][i].setImageResource(R.drawable.cellj2);
                    Joueur = true;
                    break;
                }
            }
        }
        if (Joueur){
            textViewJoueurUn.setVisibility(View.VISIBLE);
            textViewJoueurDeux.setVisibility(View.INVISIBLE);
        }
        else{
            textViewJoueurUn.setVisibility(View.INVISIBLE);
            textViewJoueurDeux.setVisibility(View.VISIBLE);
        }
        verifs();
        retourSiNonWin();
    }

//################################################################################################//
//                                    ACTIONS DU BOUTON 3
//################################################################################################//
    //COMMENTAIRES DE BOUTON SIMILAIRES AU BOUTON 1

    public void bouton3(View v){
        for(int i = 4; i >= 0; i--) {
            if (Joueur) {
                if (tableau2[2][i] == 0) {
                    tableau2[2][i] = 1;
                    tableau[2][i].setImageResource(R.drawable.cellj1);
                    Joueur = false;
                    break;
                }
            }
            if (!Joueur) {
                if (tableau2[2][i] == 0) {
                    tableau2[2][i] = 2;
                    tableau[2][i].setImageResource(R.drawable.cellj2);
                    Joueur = true;
                    break;
                }
            }
        }
        if (Joueur){
            textViewJoueurUn.setVisibility(View.VISIBLE);
            textViewJoueurDeux.setVisibility(View.INVISIBLE);
        }
        else{
            textViewJoueurUn.setVisibility(View.INVISIBLE);
            textViewJoueurDeux.setVisibility(View.VISIBLE);
        }
        verifs();
        retourSiNonWin();
    }

//################################################################################################//
//                                    ACTIONS DU BOUTON 4
//################################################################################################//
    //COMMENTAIRES DE BOUTON SIMILAIRES AU BOUTON 1

    public void bouton4(View v){
        for(int i = 4; i >= 0; i--) {
            if (Joueur) {
                if (tableau2[3][i] == 0) {
                    tableau2[3][i] = 1;
                    tableau[3][i].setImageResource(R.drawable.cellj1);
                    Joueur = false;
                    break;
                }
            }
            if (!Joueur) {
                if (tableau2[3][i] == 0) {
                    tableau2[3][i] = 2;
                    tableau[3][i].setImageResource(R.drawable.cellj2);
                    Joueur = true;
                    break;
                }
            }
        }
        if (Joueur){
            textViewJoueurUn.setVisibility(View.VISIBLE);
            textViewJoueurDeux.setVisibility(View.INVISIBLE);
        }
        else{
            textViewJoueurUn.setVisibility(View.INVISIBLE);
            textViewJoueurDeux.setVisibility(View.VISIBLE);
        }
        verifs();
        retourSiNonWin();
    }

//################################################################################################//
//                                    ACTIONS DU BOUTON 5
//################################################################################################//
    //COMMENTAIRES DE BOUTON SIMILAIRES AU BOUTON 1

    public void bouton5(View v){
        for(int i = 4; i >= 0; i--) {
            if (Joueur) {
                if (tableau2[4][i] == 0) {
                    tableau2[4][i] = 1;
                    tableau[4][i].setImageResource(R.drawable.cellj1);
                    Joueur = false;
                    break;
                }
            }
            if (!Joueur) {
                if (tableau2[4][i] == 0) {
                    tableau2[4][i] = 2;
                    tableau[4][i].setImageResource(R.drawable.cellj2);
                    Joueur = true;
                    break;
                }
            }
        }
        if (Joueur){
            textViewJoueurUn.setVisibility(View.VISIBLE);
            textViewJoueurDeux.setVisibility(View.INVISIBLE);
        }
        else{
            textViewJoueurUn.setVisibility(View.INVISIBLE);
            textViewJoueurDeux.setVisibility(View.VISIBLE);
        }
        verifs();
        retourSiNonWin();
    }


} //Fin du public class NameActivity
