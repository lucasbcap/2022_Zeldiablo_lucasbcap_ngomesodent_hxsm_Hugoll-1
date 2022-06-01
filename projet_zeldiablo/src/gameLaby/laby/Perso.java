package gameLaby.laby;


import java.util.ArrayList;

/**
 * gere un personnage situe en x,y
 */
public class Perso extends Position{

    /**
     * Bombes posee sur le terrain
     */
    private ArrayList<Bombe> SacBombes;

    public static int nbBombe = 1;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        super(dx,dy);
        this.SacBombes = new ArrayList<Bombe>();
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.getX() == dx && this.getY() == dy);
    }

    public void DepotBombe(int x , int y){
        if(this.SacBombes.size()<=nbBombe) {
            Bombe b = new Bombe(x, y);
            this.SacBombes.add(b);
        }
    }

    // ############################################
    // GETTER
    // ############################################


    /**
     * @return le sac de bombe du personnage
     */
    public ArrayList<Bombe> getSacBombes(){
        return this.SacBombes;
    }
}
