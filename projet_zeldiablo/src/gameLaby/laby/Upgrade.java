package gameLaby.laby;

import java.util.ArrayList;

// Interface regroupant toutes les upgrades
public interface Upgrade {

    /**
     * permet d ajouter une upgrade au tableau courant
     * @param p postion de l upgrade
     */
    public void ajouterUpgrade(Position p);

    /**
     * permet d activer une upgrade
     * @param p postion de l upgrade
     */
    public void activerUpgrade(Position p);

    /**
     * retourne le tableau d upgrade
     * @return le tableau d upgrade
     */
    public ArrayList<Position> getTab();
}
