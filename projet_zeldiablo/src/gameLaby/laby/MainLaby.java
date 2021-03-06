package gameLaby.laby;

import gameArkanoid.ArkanoidDessin;
import gameArkanoid.ArkanoidJeu;
import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int width = 900;
        int height = 700;
        int pFPS = 7;
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
