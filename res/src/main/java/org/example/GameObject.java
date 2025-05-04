package org.example;

import java.awt.*;

public abstract class GameObject  {
    private int height;
    private int width;
    private int x;
    private  int y;
    private Image image;
    private int dx =0 ;
    private int dy = 0;
    abstract void update();
    abstract void draw(Graphics g);

    Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
