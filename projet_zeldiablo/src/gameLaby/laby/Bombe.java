package gameLaby.laby;

import java.util.ArrayList;

public class Bombe {

    private int x;
    private int y;
    private int temps = 15;
    private ArrayList<Position> caseExplosion;

    public Bombe(int x,int y){
        this.x = x ;
        this.y = y;
        this.caseExplosion = new ArrayList<>();
    }

    public void DegatBombe(int range,Labyrinthe laby){

        for(int i = 0; i<4 ; i++){
            boolean finis = false;
            int X=this.x;
            int Y = this.y;
            int j = 1;
            while(!finis && j!=range+1){
                if(i==0){
                    if(laby.getMur(X+j,Y)){
                        finis = true;
                    }
                    else{
                        caseExplosion.add(new Position(X+j,Y));
                    }
                }

                if(i==1){
                    if(laby.getMur(X-j,Y)){
                        finis = true;
                    }
                    else{
                        caseExplosion.add(new Position(X-j,Y));
                    }
                }

                if(i==2){
                    if(laby.getMur(X,Y+j)){
                        finis = true;
                    }
                    else{
                        caseExplosion.add(new Position(X,Y+j));
                    }
                }

                if(i==3){
                    if(laby.getMur(X,Y-j)){
                        finis = true;
                    }
                    else{
                        caseExplosion.add(new Position(X,Y-j));
                    }
                }


                j++;


            }
        }
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
