package gameLaby.laby;

import java.util.ArrayList;

public class UpgradeRange implements Upgrade{

    private ArrayList<Position> tab;

    public UpgradeRange (){
        this.tab = new ArrayList<Position>();
    }

    @Override
    public void ajouterUpgrade(Position p) {
        this.tab.add(p);
    }

    @Override
    public void activerUpgrade(Position p) {
        Bombe.range ++;
        tab.remove(p);
    }

    @Override
    public ArrayList<Position> getTab() {
        return this.tab;
    }
}
