package gameLaby.laby;

public class Bombe {

    private int x;
    private int y;

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
}
