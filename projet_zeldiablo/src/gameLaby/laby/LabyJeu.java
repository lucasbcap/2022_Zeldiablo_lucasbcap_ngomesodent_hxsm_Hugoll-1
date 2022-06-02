package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LabyJeu implements Jeu {

    public int temps = 0;
    private final Labyrinthe laby;

    public LabyJeu(String nomFichier) throws IOException {
        this.laby = new Labyrinthe(nomFichier);
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        temps++;
        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE,this.laby.pj,this.laby.monstre);
            Images.Perso=LabyDessin.img.getImgPersoDroit();
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE,this.laby.pj,this.laby.monstre);
            Images.Perso=LabyDessin.img.getImgPersoGauche();
        }

        if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT,this.laby.pj,this.laby.monstre);
        }

        if (clavier.e) {
            this.laby.recupererObjet();
        }

        if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS,this.laby.pj,this.laby.monstre);
        }

        if (clavier.espace) {
            this.laby.pj.DepotBombe(this.laby.pj.getX(),this.laby.pj.getY());
        }



        for(int i=0;i<this.laby.pj.getSacBombes().size();i++){
            this.laby.pj.getSacBombes().get(i).setTemps( this.laby.pj.getSacBombes().get(i).getTemps()-1);
            if(this.laby.pj.getSacBombes().get(i).getTemps()==0){
                this.laby.pj.getSacBombes().get(i).DegatBombe(Bombe.range,laby);
                //this.laby.pj.getSacBombes().remove(i);
            }
            if(this.laby.pj.getSacBombes().get(i).getTemps()<-5){
                this.laby.pj.getSacBombes().remove(i);
            }
        }

        if(temps%3==0) {
            for (int i = 0; i < this.laby.monstre.size(); i++) {
                this.MonstreDeplacement(this.laby.monstre.get(i));
                Random rd = new Random();
                if (rd.nextInt(20) == 4){
                    this.laby.monstre.get(i).DepotBombe(this.laby.monstre.get(i).getX(), this.laby.monstre.get(i).getY());
                }
            }
        }
    }

    @Override
    public void init() {
    }



    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLaby(){
        return laby;
    }

    public void MonstreDeplacement(Perso p){
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
        ArrayList<Perso> perso = new ArrayList<Perso>();
        perso.add(this.laby.pj);
        this.laby.deplacerPerso(pos,p,perso );
    }
}


