package gameLaby.laby;

import java.util.ArrayList;

public class UpgradeBombe implements Upgrade{
    private ArrayList<Position> tab;

    public UpgradeBombe(){
        this.tab= new ArrayList<Position>();
    }

    @Override
    public void ajouterUpgrade(Position p) {
        this.tab.add(p);
    }

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

    @Override
    public ArrayList<Position> getTab() {
        return(this.tab);
    }
}
