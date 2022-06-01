import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Mur_Friable {

    @Test
    public void test_Destruction_Murs() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby2.txt");

        laby.pj.DepotBombe(laby.pj.getX(), laby.pj.getY());
        laby.pj.getSacBombes().get(0).DegatBombe(1, laby);

        assertEquals(laby.getMurF(laby.pj.getX()+1, laby.pj.getY()), false, "Le mur doit être détruit");
    }

    @Test
    public void test_Murs_Infranchissable() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby2.txt");

        laby.deplacerPerso("Droite", laby.pj, laby.m);

        assertEquals(laby.pj.getX(), 17, "Le X du personnage est de 17");
        assertEquals(laby.pj.getY(), 12, "Le y du perso est de 12");
    }

    @Test
    public void test_Passage_Perso_Apres_Destruction_Sur_Item() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby2.txt");

        laby.pj.DepotBombe(laby.pj.getX(), laby.pj.getY());
        laby.pj.getSacBombes().get(0).DegatBombe(1, laby);
        laby.deplacerPerso("Droite", laby.pj, laby.m);

        assertEquals(laby.pj.getX(), 18, "Le X du personnage est de 18");
        assertEquals(laby.pj.getY(), 12, "Le y du perso est de 12");
    }

}