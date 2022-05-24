package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public LabyJeu(String nomFichier) throws IOException {
        this.laby = new Labyrinthe(nomFichier);
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE);
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT);
        }

        if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS);
        }
    }

    @Override
    public void init() {
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLaby(){
        return laby;
    }
}


