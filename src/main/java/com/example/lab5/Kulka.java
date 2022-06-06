package com.example.lab5;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

import java.util.function.DoubleToIntFunction;

public class Kulka {
    private static final double R = 10;
//    private double ySpeed;
//    private double xSpeed;
//    private double xPos;
//    private double yPos;
//    private Color color;
    
    protected double ySpeed;
    protected double xSpeed;
    protected double xPos;
    protected double yPos;
    protected Color color;
    protected double rx;
    protected double ry;
    protected double omega;
    protected double rot;
    
    

    public Color getColor(){
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected Kulka(double xPos, double yPos, double xSpeed, double ySpeed){
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        color = Color.WHITESMOKE;
    }

    public void checkBoundaryCollision(double xLeft, double yTop, double xRight, double yBottom){
        if ((xPos - R <= xLeft) || ((xPos + R >= xRight))){
            xSpeed=-xSpeed;
        }
        if ((yPos - R <= yTop) || ((yPos + R >= yBottom))){
            ySpeed=-ySpeed;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.save();
        gc.setFill(color);
        gc.transform(new Affine(new Rotate(rot, xPos, yPos)));
        gc.fillOval(xPos - rx, yPos - ry, 2*rx,2*ry);
        gc.restore();
    }

    public void update() {
        super.update();
        rot += omega;
        System.out.println("rotation: %f\n", rot);
    }
}
