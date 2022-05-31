package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char MONSTRE = 'M';
    public static final char BOMBE = 'B';

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
     * attribut du Monstre
     */
    public Perso m;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param pos position de depart
     * @param action action effectuee
     * @return case suivante
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
        this.pj = null;
        this.m = null;

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
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;
                    case MONSTRE:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        this.m = new Perso(colonne, numeroLigne);
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }
        if((this.m.getX()==this.pj.getX() && this.m.getY()==this.pj.getY())){
            throw new Error("Monstre et Personnage confondus");
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
     * @param p2 personnage sur lequelle ne doit pas etre p1 (si il y en a plein faire une liste)
     */
    public void deplacerPerso(String action,Perso p1 , Perso p2) {
        // case courante
        Position courante = new Position(p1.getX(), p1.getY());

        Position p2Pos = new Position(p2.getX(), p2.getY());

        ArrayList<Bombe> Bombes = this.pj.getSacBombes();
        boolean bouger = true;

        // calcule case suivante
        Position suivante = getSuivant(courante, action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante.getX()][suivante.getY()] && !(p2Pos.equals(suivante))) {
            for(int i = 0 ; i<Bombes.size();i++){
                if(Bombes.get(i).equals(suivante)){
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
}
