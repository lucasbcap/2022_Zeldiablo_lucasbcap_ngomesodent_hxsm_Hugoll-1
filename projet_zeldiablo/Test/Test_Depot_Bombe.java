import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Depot_Bombe {

    @Test
    public void testNbBombe(){
        Perso p = new Perso(5,5);

        p.DepotBombe(p.getX(), p.getY());

        assertEquals(p.getSacBombes().size(), 1, "Le personnage doit avoir posé bombe");
    }

    @Test
    public void testNbMaxBombe(){
        Perso p = new Perso(5,5);

        p.DepotBombe(p.getX(), p.getY());
        p.DepotBombe(p.getX()+1, p.getY());
        p.DepotBombe(p.getX(), p.getY()+1);
        p.DepotBombe(p.getX()+1, p.getY()+1);

        assertEquals(p.getSacBombes().size(), 3, "Le personnage doit avoir posé bombe");
    }

    /*@Test
    public void testRecupererBombe() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");
        laby.pj.DepotBombe(laby.pj.getX(), laby.pj.getY());

        laby.pj.getSacBombes().get(0).setTemps(0);

        LabyJeu lj = new LabyJeu("labySimple/laby0.txt");
        lj.update(0, );

        assertEquals(laby.pj.getSacBombes().size(), 0, "Il ne doit avoir aucune bombe de posé");
    }*/


    /**@Test
    public void testAllerSurBombe() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");

        laby.pj.DepotBombe(laby.pj.getX(), laby.pj.getY());
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Bas");

        assertEquals(laby.pj.getX(), 17, "Le x du personnage est de 17");
        assertEquals(laby.pj.getY(), 11, "Le y du personnage est de 11");
    }*/

    //Idem pour cette classe de test

}
