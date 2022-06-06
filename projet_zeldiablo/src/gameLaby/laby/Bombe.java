package gameLaby.laby;

import java.util.ArrayList;
import java.util.Random;

public class Bombe extends Position {

    /**
     * Variables
     */
    private int temps = 15;
    private ArrayList<Position> caseExplosion;

    public static int range = 1;

    /**
     * Constructeur de la bombe
     * @param x position x de la bombe
     * @param y position y de la bombe
     */
    public Bombe(int x,int y){
        super(x,y);
        this.caseExplosion = new ArrayList<>();
    }

    /**
     * La bombe explose en forme de croix  et cree une explosion qui s arrete contre un mur et casse les murs friables
     * @param range longueur d'explosion de la bombe
     * @param laby l'endroit où elle explose
     */
    public void DegatBombe(int range,Labyrinthe laby){

        for(int i = 0; i<4 ; i++){
            boolean finis = false;
            int j = 1;
            while(!finis && j!=range+1){
                int X=this.getX();
                int Y = this.getY();

                //On choisit la direction
                switch (i) {
                    case 0:
                        X = X + j;
                        break;
                    case 1:
                        X = X - j;
                        break;
                    case 2:
                        Y = Y + j;
                        break;
                    case 3:
                        Y = Y - j;
                        break;
                    default:
                        break;
                }

                if(laby.getMur(X,Y)){
                    if(laby.getMurF(X,Y)){
                        // si oui on change de direction
                        laby.casserMurF(X,Y);
                        Random rd = new Random();
                        int random = rd.nextInt(3);
                        if(random!=2){
                            laby.getTabUpgrade().get(random).ajouterUpgrade(new Position(X,Y));
                        }
                    }
                    // si oui on change de direction
                    finis = true;
                }
                else {
                    // sinon on fais exploser la case et on continue
                    caseExplosion.add(new Position(X, Y));
                }
                j++;


            }
        }
    }



    // ############################################
    // GETTER
    // ############################################


    /**
     * @return le temps avant explosion de la bombe
     */
    public int getTemps() {
        //getter
        return this.temps;
    }

    /**
     * @return les cases où il y a des explosions
     */
    public ArrayList<Position> getCaseExplosion() {
        return caseExplosion;
    }

    /**
     * permet de set le temps avant explosion de la bombe
     */
    public void setTemps(int t) {
        //getter
       this.temps=t;
    }


}
