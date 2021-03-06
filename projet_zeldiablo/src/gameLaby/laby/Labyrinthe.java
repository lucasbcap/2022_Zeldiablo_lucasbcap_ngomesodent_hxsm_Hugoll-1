package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char MURF = 'F';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char MONSTRE = 'M';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    public Perso pj;

    /**
     * attribut des Monstres
     */
    public ArrayList<Perso> monstre;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * les murs friables du labyrinthe
     */
    public boolean[][] mursF;

    /**
     * retourne la case suivante selon une actions
     *
     * @param pos position de depart
     * @param action action effectuee
     * @return case suivante
     */

    private ArrayList<Upgrade> tabUpgrade;

    /**
     *  Permet d avoir les coordonnees de la prochaine action du joueur
     * @param pos la position du perso
     * @param action la direction voulut
     * @return la position apres action
     */
    static Position getSuivant(Position pos, String action) {
        int x = pos.getX();
        int y = pos.getY();
        switch (action) {
            case HAUT:
                // on monte une ligne
                y = pos.getY()-1;
                break;
            case BAS:
                // on descend une ligne
                y= pos.getY()+1;
                break;
            case DROITE:
                // on augmente colonne
                x = pos.getX()+1;
                break;
            case GAUCHE:
                // on augmente colonne
                x = pos.getX()-1;
                break;
            default:
                throw new Error("action inconnue");
        }
        return new Position(x,y);
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.mursF = new boolean[nbColonnes][nbLignes];
        this.pj = null;
        this.monstre = new ArrayList<Perso>();
        this.tabUpgrade = new ArrayList<Upgrade>();
        this.tabUpgrade.add(new UpgradeBombe());
        this.tabUpgrade.add(new UpgradeRange());

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        this.mursF[colonne][numeroLigne] = false;
                        break;
                    case MURF:
                        this.murs[colonne][numeroLigne] = true;
                        this.mursF[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        this.mursF[colonne][numeroLigne] = false;
                        Random random = new Random();
                        if(random.nextInt(20)==4){
                            this.monstre.add(new Perso(colonne,numeroLigne));
                        }
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        this.mursF[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;
                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }
        for(int i = 0;i<this.monstre.size();i++) {
            if (this.monstre.get(i).equals(pj)) {
                throw new Error("Monstres et Personnage confondus");
            }
        }
        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     * @param p1 personnage a deplacer
     * @param p2 personnages sur le quelles ne doit pas etre p1
     */
    public void deplacerPerso(String action,Perso p1 , ArrayList<Perso> p2) {
        // case courante
        Position courante = new Position(p1.getX(), p1.getY());

        ArrayList<Bombe> Bombes = this.pj.getSacBombes();
        boolean bouger = true;

        // calcule case suivante
        Position suivante = getSuivant(courante, action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante.getX()][suivante.getY()]) {
            for(int i = 0 ; i<Bombes.size();i++){
                if(Bombes.get(i).equals(suivante)){
                    bouger = false;
                }
            }
            if(bouger) {
                for (int i = 0; i < p2.size(); i++) {
                    if (p2.get(i).equals(suivante)) {
                        bouger = false;
                    }
                }
                if(bouger) {
                    // on met a jour personnage
                    p1.setX(suivante.getX());
                    p1.setY(suivante.getY());
                }
            }

        }
    }

    /**
     * Permet de supprimer un mur a la postion x et y
     * @param x la coord x du mur
     * @param y la coord y du mur
     */
    public void casserMurF(int x,int y){
        this.murs[x][y]=false;
        this.mursF[x][y]=false;
    }

    /**
     *  Permet d activer une upgrade si on est dessus
     * @return true si il y a une upgrade sinon false
     */
    public boolean recupererObjet(){
        boolean trouve = false;
        int j = 0;
        while(!trouve && j!=2){
            int i = 0;
            while(!trouve && i<this.tabUpgrade.get(j).getTab().size()){
                // La boucle pour avoir tout les element d un tableau de position donc upgradeBombe ou range
                if(this.pj.equals(this.tabUpgrade.get(j).getTab().get(i))){
                    // si le personnage est sur une upgrade alors il l active
                    this.tabUpgrade.get(j).activerUpgrade(new Position(this.pj.getX(),this.pj.getY()));
                    trouve = true;
                }
                i++;
            }
            j++;
        }
        return trouve;
    }

    /**
     * Detecte si le perso se trouve dans l'explosion d une bombe
     * @param p le perso
     * @return true si il est mort sinon false
     */
    public boolean etreMort(Perso p){
        ArrayList<Perso> global = this.monstre;
        boolean retour = false;
        int i =0;
        // on cherche dans les explosions de toutes les bombes de tout les monstres
        while(i<global.size() && !retour){
            int j=0;
            while(j<global.get(i).getSacBombes().size() && !retour){
                int a=0;
                while(a<global.get(i).getSacBombes().get(j).getCaseExplosion().size() && !retour){
                    if(p.equals(global.get(i).getSacBombes().get(j).getCaseExplosion().get(a))){
                        retour = true;
                    }
                    a++;
                }
                j++;
            }
            i++;
        }

        int j =0;
        // on cherche dans les explosions de toutes les bombes de perso
        while(j<this.pj.getSacBombes().size() && !retour) {
            int a = 0;
            while (a < this.pj.getSacBombes().get(j).getCaseExplosion().size() && !retour) {
                if (p.equals(this.pj.getSacBombes().get(j).getCaseExplosion().get(a))) {
                    retour = true;
                }
                a++;
            }
            j++;
        }
       return retour;
    }

    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    public ArrayList<Upgrade> getTabUpgrade() {
        return tabUpgrade;
    }

    /**
     * return murF en (i,j)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean getMurF(int x, int y) {
        // utilise le tableau de boolean
        return this.mursF[x][y];
    }
}
