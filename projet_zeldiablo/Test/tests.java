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

        assertEquals ( laby.m.getX() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.m.getY() , 1 ," le monstre est en 1 ") ;
        assertEquals ( laby.MONSTRE , 'M' ," le monstre est un char M ") ;

    }


    }

