package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LabyJeu implements Jeu {

    public int temps = 0;
    private final Labyrinthe laby;

    /**
     *
     * @param nomFichier
     * @throws IOException
     */
    public LabyJeu(String nomFichier) throws IOException {
        this.laby = new Labyrinthe(nomFichier);
    }

    /**
     *
     * @param secondes temps ecoule depuis la derniere mise a jour
     * @param clavier  objet contenant l'état du clavier
     */
    @Override
    public void update(double secondes, Clavier clavier) {
        temps++;

        //Deplacement du perso
        if (clavier.droite) {
            this.laby.deplacerPerso(Labyrinthe.DROITE, this.laby.pj, this.laby.monstre);
            Images.Perso = LabyDessin.img.getImgPersoDroit();
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso(Labyrinthe.GAUCHE, this.laby.pj, this.laby.monstre);
            Images.Perso = LabyDessin.img.getImgPersoGauche();
        }

        if (clavier.haut) {
            this.laby.deplacerPerso(Labyrinthe.HAUT, this.laby.pj, this.laby.monstre);
        }

        if (clavier.bas) {
            this.laby.deplacerPerso(Labyrinthe.BAS, this.laby.pj, this.laby.monstre);
        }

        // Ramasse les Upgrades

        if (clavier.e) {
            this.laby.recupererObjet();
        }


        // pose une bombe
        if (clavier.espace) {
            this.laby.pj.DepotBombe(this.laby.pj.getX(), this.laby.pj.getY());
        }

        //Detection si la bombe posee par le perso doit exploser ou non
        for (int i = 0; i < this.laby.pj.getSacBombes().size(); i++) {
            this.laby.pj.getSacBombes().get(i).setTemps(this.laby.pj.getSacBombes().get(i).getTemps() - 1);
            if (this.laby.pj.getSacBombes().get(i).getTemps() == 0) {
                this.laby.pj.getSacBombes().get(i).DegatBombe(Bombe.range, laby);
            }
            if (this.laby.pj.getSacBombes().get(i).getTemps() < -5) {
                this.laby.pj.getSacBombes().remove(i);
            }
        }

        //Detection si la bombe posee par le monstre doit exploser ou non
        for (int i = 0; i < this.laby.monstre.size(); i++) {
            for (int j = 0; j < this.laby.monstre.get(i).getSacBombes().size(); j++) {
                this.laby.monstre.get(i).getSacBombes().get(j).setTemps(this.laby.monstre.get(i).getSacBombes().get(j).getTemps() - 1);
                if (this.laby.monstre.get(i).getSacBombes().get(j).getTemps() == 0) {
                    this.laby.monstre.get(i).getSacBombes().get(j).DegatBombe(1, laby);
                }
                if (this.laby.monstre.get(i).getSacBombes().get(j).getTemps() < -5) {
                    this.laby.monstre.get(i).getSacBombes().remove(j);
                }
            }
        }

        // Deplacement du monstre
        if (temps % 3 == 0) {
            for (int i = 0; i < this.laby.monstre.size(); i++) {
                this.MonstreDeplacement(this.laby.monstre.get(i));
                Random rd = new Random();
                if (rd.nextInt(20) == 4) {
                    this.laby.monstre.get(i).DepotBombe(this.laby.monstre.get(i).getX(), this.laby.monstre.get(i).getY());
                }

            }
        }

        // Gestion de la mort du perso
        if (laby.etreMort(laby.pj)) {
            System.out.println("Perdu");
        }

        // Gestion de la mort des monstres
        for (int i = 0; i < laby.monstre.size(); i++) {
            if (laby.etreMort(laby.monstre.get(i))) {
                laby.monstre.remove(i);
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

    /**
     *
     * @return le labyrinthe
     */
    public Labyrinthe getLaby(){
        return laby;
    }

    /**
     * La fonction choisit aléatoirement une direction et deplce la monstre dans celle si
     * @param p le perso à deplacer
     */
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


