package gameLaby.laby;

import javafx.scene.image.Image;

public class Images {
    public Image imgBombes;
    public Image imgPersoGauche;
    public Image imgPersoDroit;
    public Image imgMurs;
    public Image imgMursFriables;
    public Image imgMonstre;

    public Images(){
        this.imgBombes= new Image("file:images/bombe.png");
        this.imgMonstre=new Image("file:images/monstre.png");
        this.imgMurs = new Image("file:images/murs.png");
        this.imgMursFriables = new Image("file:images/mursF.png");
        this.imgPersoDroit = new Image("file:images/PersoDroite.png");
        this.imgPersoGauche = new Image("file:images/PersoGauche.png");
    }
}
