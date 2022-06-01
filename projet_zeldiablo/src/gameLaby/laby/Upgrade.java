package gameLaby.laby;

import java.util.ArrayList;

public interface Upgrade {

    public void ajouterUpgrade(Position p);

    public void activerUpgrade(Position p);

    public ArrayList<Position> getTab();
}
