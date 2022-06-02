package gameLaby.laby;

import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LabyDessin implements DessinJeu {



    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu)jeu;

        Image im = new Image("file:images/bombe.png");


        final GraphicsContext gc = canvas.getGraphicsContext2D();



        //Image img = new Image(getClass().getResourceAsStream("murs.png"));
        for(int i =0;i<laby.getLaby().getLength();i++){
            for(int j = 0;j< laby.getLaby().getLengthY();j++){
                if(laby.getLaby().getMur(i,j)){
                    if(laby.getLaby().getMurF(i,j)){
                        //gc.setFill(new ImagePattern(new Image(f)));
                        gc.setFill(Color.MAROON);
                        gc.fillRect(i*40, j*40, 40, 40);
                    }
                    else{
                        gc.setFill(Color.BLACK);
                        gc.fillRect(i*40, j*40, 40, 40);
                    }

                }
                else{
                    gc.setFill(Color.WHITE);
                    gc.fillRect(i*40, j*40, 40, 40);
                }
            }
        }

        gc.setFill(Color.RED);
        Perso p = laby.getLaby().pj;
        double x = p.getX();
        double y = p.getY();
        gc.fillOval(x*40, y*40, 40, 40);


        for(int i = 0;i<laby.getLaby().monstre.size();i++) {
            gc.setFill(Color.VIOLET);
            Perso monstre = laby.getLaby().monstre.get(i);
            x = monstre.getX();
            y = monstre.getY();
            gc.fillOval(x*40, y*40, 40, 40);
        }


        for(int i = 0;i<p.getSacBombes().size();i++) {
            gc.setFill(new ImagePattern(im));
            Bombe b = p.getSacBombes().get(i);
            x = b.getX();
            y = b.getY();
            gc.fillOval(x * 40, y * 40, 40, 40);
            for(int j = 0;j<p.getSacBombes().get(i).getCaseExplosion().size();j++) {
                gc.setFill(Color.YELLOW);
                Position pos = p.getSacBombes().get(i).getCaseExplosion().get(j);
                x = pos.getX();
                y = pos.getY();
                gc.fillOval(x * 40, y * 40, 40, 40);
            }
        }

        for(int i = 0;i<laby.getLaby().getTabUpgrade().get(0).getTab().size();i++) {
            gc.setFill(Color.BLUE);
            Position uB = laby.getLaby().getTabUpgrade().get(0).getTab().get(i);
            x = uB.getX();
            y = uB.getY();
            gc.fillOval(x * 40 +10 , y * 40+10, 20, 20);
        }

        for(int i = 0;i<laby.getLaby().getTabUpgrade().get(1).getTab().size();i++) {
            gc.setFill(Color.GREEN);
            Position uR = laby.getLaby().getTabUpgrade().get(1).getTab().get(i);
            x = uR.getX();
            y = uR.getY();
            gc.fillOval((x * 40)+10, (y * 40)+10, 20, 20);
        }

    }
}
