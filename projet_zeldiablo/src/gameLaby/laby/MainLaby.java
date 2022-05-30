package gameLaby.laby;

import gameArkanoid.ArkanoidDessin;
import gameArkanoid.ArkanoidJeu;
import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {


    public static void main(String[] args) throws IOException {
        int width = 800;
        int height = 600;
        int pFPS = 5;
        // creation des objets
        LabyJeu jeu= new LabyJeu("labySimple/laby2.txt");
        LabyDessin dessins = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width, height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeu, dessins);
    }

}
