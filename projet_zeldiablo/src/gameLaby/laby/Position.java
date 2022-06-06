package gameLaby.laby;

public class Position {

    // Variables
    private int x,y;

    /**
     * Converstioon de x et y en une position
     * @param x
     * @param y
     */
    public Position(int x,int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * un toString classique
     * @return un string avec les coords
     */
    public String toString(){
        return x+" "+y;
    }

    /**
     * Redefinition de la fonction equals
     * @param p la positon a comparer
     * @return true si c est egale sinon false
     */
    public boolean equals(Position p){return this.x==p.x && this.y ==p.y;}


    // Getters

    /**
     * position x
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * position y
     * @return Y
     */
    public int getY() {
        return y;
    }


    // Setters

    /**
     * change le x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * change le y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
