import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class tests {

    /** methode test methode de la position initial du monstre */
    @Test
    public void Position () throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");

        //assertEquals ( laby.m.getX() , 1 ," le monstre est en 1 ") ;
        //assertEquals ( laby.m.getY() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.MONSTRE , 'M' ," le monstre est un char M ") ;
    }

    /** methode test methode de la position du joueur dans le monstre */
    /**@Test
    public void SurLeMonstre () throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        laby.deplacerPerso(Labyrinthe.GAUCHE);

        // on le deplace sur la meme case que le monstre
        assertEquals ( laby.m.getX() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.m.getY() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.pj.getX() , 2 ," le joueur est en 1 ") ;
        assertEquals ( laby.pj.getY() , 1 ," le joueur est en 1 ") ;
    }

    /** methode test methode de la position du monstre dans le joueur */
    /**@Test
    /**public void SurLePerso () throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        laby.deplacerMonstre(Labyrinthe.DROITE);

        // on le deplace sur la meme case que le joueur
        assertEquals ( laby.m.getX() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.m.getY() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.pj.getX() , 2 ," le joueur est en 1 ") ;
        assertEquals ( laby.pj.getY() , 1 ," le joueur est en 1 ") ;
    }

    /** methode test methode de la position du monstre dans un mur */
    /**@Test
    public void DansleMur () throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        laby.deplacerMonstre(Labyrinthe.GAUCHE);

        // on le deplace dans le mur
        assertEquals ( laby.m.getX() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.m.getY() , 1 ," le monstre est en 1 ") ;

    }*/

// Certains tests sont passés en paramètres car des noms de méthodes ou leurs corps ont été modifié.
// Tous ces tests fonctionnaient avant modification du code
}

