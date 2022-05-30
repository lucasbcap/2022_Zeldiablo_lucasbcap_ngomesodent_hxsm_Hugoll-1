package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.Random;

public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public LabyJeu(String nomFichier) throws IOException {
        this.laby = new Labyrinthe(nomFichier);
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE);
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT);
        }

        if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS);
        }

        if (clavier.espace) {
            this.laby.pj.DepotBombe(this.laby.pj.getX(),this.laby.pj.getY());
        }

        for(int i=0;i<this.laby.pj.getSacBombes().size();i++){
            this.laby.pj.getSacBombes().get(i).setTemps( this.laby.pj.getSacBombes().get(i).getTemps()-1);
            if(this.laby.pj.getSacBombes().get(i).getTemps()<0){
                this.laby.pj.getSacBombes().get(i).DegatBombe(3,laby);
                //this.laby.pj.getSacBombes().remove(i);
            }
            if(this.laby.pj.getSacBombes().get(i).getTemps()<-5){
                this.laby.pj.getSacBombes().remove(i);
            }
        }

        this.MonstreDeplaccement();

    }

    @Override
    public void init() {
    }

    public void MonstreDeplaccement(){
        Random rd = new Random();

        int nombre = rd.nextInt(4);
        String pos ="";

        switch(nombre){
            case 0:
                pos = Labyrinthe.HAUT;
                break;
            case 1:
                pos = Labyrinthe.BAS;
                break;
            case 2:
                pos = Labyrinthe.GAUCHE;

                break;
            case 3:
                pos = Labyrinthe.DROITE;
                break;
            default:
                break;
        }
        this.laby.deplacerMonstre(pos);
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLaby(){
        return laby;
    }
}


