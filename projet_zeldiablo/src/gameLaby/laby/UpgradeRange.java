package gameLaby.laby;

import java.util.ArrayList;

public class UpgradeRange implements Upgrade{
    private ArrayList<Position> tab;

    /**
     * Cree le tableau d upgrade
     */
    public UpgradeRange (){
        this.tab = new ArrayList<Position>();
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
     * permet d activer une upgrade ici augmente de la range
     * @param p postion de l upgrade
     */
    @Override
    public void activerUpgrade(Position p) {
        Bombe.range ++;
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
        return this.tab;
    }
}
