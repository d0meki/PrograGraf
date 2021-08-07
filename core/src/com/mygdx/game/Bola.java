package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bola {
    private int x,y,width,height;
    private int xDir,yDir = 5;
    private boolean start = true;
    private Texture img;
    public static Sprite spriteBola;
    private SpriteBatch batch;

    public Bola(int x ,int y){
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        img = new Texture("esfera.png");
        spriteBola = new Sprite(img);
        batch = new SpriteBatch();
    }

    public void render(int x , int y){
        batch.begin();
        spriteBola.setPosition(x, y);
        spriteBola.draw(batch);
        batch.end();
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void move(){

        if (start) {
            render( 315, Paleta.getY() + Paleta.height -18);                                                                //UtilMouse.mouseX() - 35             //   x = UtilMouse.mouseX() - 5;
            x = 315;
            y = Paleta.getY() + Paleta.height;
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                start = false;
            }
        }if(!start){
            x += xDir;
            y += yDir;
            render(x,y);
        }

    }

    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }

    public int getXDir() {
        return this.xDir;
    }

    public int getYDir() {
        return this.yDir;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
}
