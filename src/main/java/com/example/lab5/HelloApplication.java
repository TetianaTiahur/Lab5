package com.example.lab5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

import static jdk.tools.jmod.Main.run;

public class HelloApplication extends Application {
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double MARGIN = 50;
    private static final double ARENAWIDTH = WIDTH - 2*MARGIN;
    private static final double ARENAHEIGHT = HEIGHT - 2*MARGIN;
    private static final double ARENAX1 = MARGIN;
    private static final double ARENAY1 = MARGIN;
    private static final double ARENAX2 = ARENAX1 + ARENAWIDTH;
    private static final double ARENAY2 = ARENAY1 + ARENAHEIGHT;
    private static final double R = 10;
//    private double x = ARENAX1+ARENAWIDTH/2;
//    private double y = ARENAY1+ARENAHEIGHT/2;
//    private double vx = 5;
//    private double vy = 2;
    private static final int LICZBAKULEK = 10;
    private Kulka[] kulki = new Kulka[LICZBAKULEK];
    private double[] x = new double[LICZBAKULEK];
    private double[] y = new double[LICZBAKULEK];
    private double[] vx = new double[LICZBAKULEK];
    private double[] vy = new double[LICZBAKULEK];


    @Override
    public void start(Stage stage){
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);
        stage.setTitle("Kulki");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();

//        gc.setFill(Color.WHITESMOKE);
//        gc.fillOval(ARENAX1+ARENAWIDTH/2,ARENAY1+ARENAHEIGHT/2,2*R,2*R);
//        gc.fillRect(ARENAX1,ARENAY1,ARENAWIDTH,ARENAHEIGHT);

        t.play();
    }


    private void initKule(){
        Random lott = new Random();
        for (int i = 0; i < LICZBAKULEK; i++)
            kulki[i] = new Rugby(
                    lott.nextDouble()*ARENAWIDTH+ARENAX1,
                    lott.nextDouble()*ARENAHEIGHT+ARENAY1,
                    5+lott.nextDouble()*20,
                    5+lott.nextDouble()*20,
                    10,
                    15);
//        {
//
//            x[i] = lott.nextDouble() * ARENAWIDTH + ARENAX1;
//            y[i] = lott.nextDouble() * ARENAHEIGHT + ARENAY1;
//            vx[i] = 5 + lott.nextDouble() * 20;
//            vy[i] = 5 + lott.nextDouble() * 20;
//        }
    }


    private void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1,ARENAY1,ARENAWIDTH,ARENAHEIGHT);
        for (int i = 0; i < LICZBAKULEK; i++){
            kulki[i].checkBoundaryCollision(ARENAX1,ARENAY1,ARENAX2,ARENAY2);
            kulki[i].update();
            kulki[i].draw(gc);
        }


//        {
//            if ((x[i] - R <= ARENAX1) || ((x[i] + R >= ARENAX2))) vx[i] = -vx[i];
//            if ((y[i] - R <= ARENAY1) || ((y[i] + R >= ARENAY2))) vy[i] = -vy[i];
//        }
//
//        for (int i = 0; i < LICZBAKULEK; i++)
//        {
//            x[i] += vx[i];
//            y[i] += vy[i];
//        }
//
//        for (int i = 0; i<LICZBAKULEK; i++)
//        {
//            gc.setFill(Color.WHITESMOKE);
//            gc.fillOval(x[i] - R, y[i] - R, 2 * R, 2 * R);
//        }


    }




    public static void main(String[] args) {
        launch();
    }
}