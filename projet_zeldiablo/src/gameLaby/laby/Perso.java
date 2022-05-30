package gameLaby.laby;


import java.util.ArrayList;

/**
 * gere un personnage situe en x,y
 */
public class Perso {

    /**
     * position du personnage
     */
    int x, y;
    private ArrayList<Bombe> SacBombes;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
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

        return (this.x == dx && this.y == dy);
    }

    public void DepotBombe(int x , int y){
        if(this.SacBombes.size()<3) {
            Bombe b = new Bombe(x, y);
            this.SacBombes.add(b);
        }
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }

    /**
     * @return le sac de bombe du personnage
     */
    public ArrayList<Bombe> getSacBombes(){
        return this.SacBombes;
    }
}
