package gameLaby.laby;

import java.util.ArrayList;

public class UpgradeBombe implements Upgrade{
    private ArrayList<Position> tab;

    @Override
    public void ajouterUpgrade(Position p) {
        this.tab.add(p);
    }

    @Override
    public void activerUpgrade(Position p) {
        Perso.nbBombe+=1;
        this.tab.remove(p);
    }

    @Override
    public ArrayList<Position> getTab() {
        return(this.tab);
    }
}
