package gameLaby.laby;

import javafx.scene.image.Image;

public class Images {
    private Image imgBombes;
    private Image imgPersoGauche;
    private Image imgPersoDroit;
    private Image imgMurs;
    private Image imgMursFriables;
    private Image imgMonstre;
    public static Image Perso = new Image("file:images/PersoGauche.png");
    public static boolean chargerDessin = true ;

    public Images(){
        this.imgBombes= new Image("file:images/bombe.png");
        this.imgMonstre=new Image("file:images/monstre.png");
        this.imgMurs = new Image("file:images/murs.png");
        this.imgMursFriables = new Image("file:images/mursF.png");
        this.imgPersoDroit = new Image("file:images/PersoDroite.png");
        this.imgPersoGauche = new Image("file:images/PersoGauche.png");
        Images.chargerDessin = false;
    }

    public Image getImgBombes() {
        return imgBombes;
    }

    public Image getImgPersoGauche() {
        return imgPersoGauche;
    }

    public Image getImgPersoDroit() {
        return imgPersoDroit;
    }

    public Image getImgMurs() {
        return imgMurs;
    }

    public Image getImgMursFriables() {
        return imgMursFriables;
    }

    public Image getImgMonstre() {
        return imgMonstre;
    }

    public static boolean isChargerDessin() {
        return chargerDessin;
    }
}
