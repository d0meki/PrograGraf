package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Paleta {
    private static int x;
    private static int y;
    public static int width;
    static int height;
    private Texture img;
    private Sprite spritePaleta;
    private SpriteBatch batch;

    public Paleta(int x ,int y){
        Paleta.x = x;
        Paleta.y = y;
        Paleta.width = 150;
        Paleta.height = 40;
        img = new Texture("paleta.png");
        spritePaleta = new Sprite(img);
        batch = new SpriteBatch();

    }

    public void render(int x , int y){
        batch.begin();
        spritePaleta.setPosition(x,y);
        spritePaleta.draw(batch);
        batch.end();
    }

    public static int getY(){
        return y;
    }

    public static int getX(){
        return x;
    }

    public boolean colicionPaleta() {
        if(spritePaleta.getBoundingRectangle().overlaps(Bola.spriteBola.getBoundingRectangle())){

            return true;
        }
        return false;
    }

    public void setX(int x) {
        Paleta.x = x;
    }

    public int getWidth() {
        return Paleta.width;
    }


}
