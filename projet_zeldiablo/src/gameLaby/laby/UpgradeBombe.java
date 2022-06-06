package gameLaby.laby;

import java.util.ArrayList;

public class UpgradeBombe implements Upgrade{
    private ArrayList<Position> tab;


    /**
     * Cree le tableau d upgrade
     */
    public UpgradeBombe(){
        this.tab= new ArrayList<Position>();
    }

    /**
     * permet d ajouter une upgrade au tableau courant
     * @param p postion de l upgrade
     */
    @Override
    public void ajouterUpgrade(Position p) {
        this.tab.add(p);
    }

    /**
     * permet d activer une upgrade ici aumentation du nombre de bombes posee
     * @param p postion de l upgrade
     */
    @Override
    public void activerUpgrade(Position p) {
        Perso.nbBombe+=1;
        boolean trouver = false;
        int i = 0;
        while(!trouver && i<this.tab.size()){
            if(this.tab.get(i).equals(p)){
                this.tab.remove(i);
                trouver = true;
            }
            i++;
        }
    }

    /**
     * retourne le tableau d upgrade
     * @return
     */
    @Override
    public ArrayList<Position> getTab() {
        return(this.tab);
    }
}
