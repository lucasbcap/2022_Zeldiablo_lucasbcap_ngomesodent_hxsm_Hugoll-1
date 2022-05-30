package gameLaby.laby;

public class Bombe {

    private int x;
    private int y;
    private int temps = 15;

    public Bombe(int x,int y){
        this.x = x ;
        this.y = y;
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x de la bombe
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y de la bombe
     */
    public int getY() {
        //getter
        return this.y;
    }

    /**
     * @return le temps avant explosion de la bombe
     */
    public int getTemps() {
        //getter
        return this.temps;
    }

    /**
     * permet de set le temps avant explosion de la bombe
     */
    public void setTemps(int t) {
        //getter
       this.temps=t;
    }
}
