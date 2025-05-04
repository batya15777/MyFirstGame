package org.example;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
//import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Mermaid extends GameObject{
    private int score = 0;
    private int lives = 3;
    private int dx, dy;
    private boolean facingLeft = false;



    Mermaid(int x, int y )
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(100);
        this.setHeight(100);
        this.setImage(new ImageIcon(getClass().getResource("/mermaid.png")).getImage());
    }

    void setDirection(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;

        if (dx != 0){
            facingLeft = dx < 0;
        }
    }
    @Override
    void update() {
        if (getX() +dx>= 0 && (getX() +dx  <= 900)) {this.setX(this.getX() + dx);}
        if (getY() +dy >= 0 && (getY()+dy  <= 700)) {  this.setY(this.getY() + dy);}
    }

    @Override
    void draw(Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        Image image = this.getImage();
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
        if (facingLeft){
          g2d.translate(x + width , y);
          g2d.scale(-1 ,1);
          g2d.drawImage(image , 0 ,0 , width ,height,null);
          g2d.scale(-1 ,1);
          g2d.translate(-(x + width) , -y);


        }else {
            g2d.drawImage(image , x ,y , width ,height,null);


        }





    }






    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

}
