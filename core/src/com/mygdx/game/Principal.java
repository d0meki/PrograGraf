package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Principal extends ApplicationAdapter{
	SpriteBatch batch;
	Sprite fon;
	Bola bal;
	Paleta pal;
	Texture fondo;
	boolean start;
	int xSpeed;
	int width;
	int movX = 275;

	@Override
	public void create () {
		start = false;
		width = Gdx.graphics.getWidth();
		fondo = new Texture("space.png");
		fon = new Sprite(fondo);
		batch = new SpriteBatch();

		bal = new Bola(200, Paleta.getY() - Paleta.height);                                            //UtilMouse.mouseX() - 5
		pal = new Paleta(0,80);
		fon.setPosition(0,0);

	}

	@Override
	public void render () {
		xSpeed = 5;
		int x1 = bal.getX();
		int y1 = bal.getY() + bal.getHeight();
	                                                                                                         //	int mouseX = UtilMouse.mouseX();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		fon.draw(batch);
		batch.end();

		pal.render(movX, Paleta.getY());
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			start = true;
		}
		moverPaleta(start);
		verificarColicionConPaleta();
		verificarColicionConPared(x1, y1);
		bal.move();
	}

	private void moverPaleta(boolean estado){
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		} else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && estado) {
			if (movX <= width && movX >=5){
				movX = movX - 10;
			}
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && estado) {
			if (movX >= -5 && movX <= 530){
				movX = movX + 10;
			}
		}
	}

	public void verificarColicionConPaleta() {
		if (pal.colicionPaleta() && bal.getXDir() <= 0) {
			bal.setYDir(5);
			xSpeed = -5;
			bal.setXDir(xSpeed);
		}
		if (pal.colicionPaleta() && bal.getXDir() > 0) {
			bal.setYDir(5);
			xSpeed = 5;
			bal.setXDir(xSpeed);
		}
	}

	public void verificarColicionConPared(int x1, int y1) {
		if (x1 >= Gdx.graphics.getWidth() - bal.getWidth()) {
			xSpeed = -Math.abs(xSpeed);
			bal.setXDir(xSpeed);
		}
		if (x1 <= 0) {
			xSpeed = Math.abs(xSpeed);
			bal.setXDir(xSpeed);
		}
		if (y1 <= 0) {
			Gdx.app.exit();
		}
		if (y1 >= Gdx.graphics.getHeight()) {
			bal.setYDir(-5);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
