package gameLaby.laby;

public class Monstre {

    /**
     * position du Monstre
     */
    int x, y;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Monstre(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si le Monstre est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le Monstre est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du Monstre
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du Monstre
     */
    public int getY() {
        //getter
        return this.y;
    }



}
