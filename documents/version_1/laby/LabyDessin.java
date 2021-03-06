package gameLaby.laby;

import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu)jeu;

        final GraphicsContext gc = canvas.getGraphicsContext2D();


        for(int i =0;i<laby.getLaby().getLength();i++){
            for(int j = 0;j< laby.getLaby().getLengthY();j++){
                if(laby.getLaby().getMur(i,j)){
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i*40, j*40, 40, 40);
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



    }
}
