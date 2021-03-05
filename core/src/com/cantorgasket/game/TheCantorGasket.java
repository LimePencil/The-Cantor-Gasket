package com.cantorgasket.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TheCantorGasket extends ApplicationAdapter {
	ShapeRenderer rect;
	int recursion = 5;
	float sizes;
	
	@Override
	public void create () {
		rect = new ShapeRenderer();
		sizes = Gdx.graphics.getHeight();
	}
	@Override
	public void resize(int width, int height) {
		rect = new ShapeRenderer();
	}
	@Override
	public void render () {
		sizes = Gdx.graphics.getHeight();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		rect.begin(ShapeRenderer.ShapeType.Filled);
		rect.setColor(Color.WHITE);
		rect.rect(0,0, sizes, sizes);
		punchCantorGasket(0,0, sizes,recursion);
		rect.end();
	}
	private void punchCantorGasket(float x, float y, float size, int recursions){
		if(recursions == 0){
			return;
		}
		float newSize = size/ 3f;
		rect.end();
		// TODO: Draw a black square in the middle square
		rect.begin(ShapeRenderer.ShapeType.Filled);
		rect.setColor(Color.BLACK);
		rect.rect(x+newSize,y+newSize,newSize,newSize);
		int rec = recursions-1;
		for(int i = 0;i<9;i++){
			punchCantorGasket(i/3*newSize+x,i%3*newSize+y,newSize,rec);
		}

	}
	@Override
	public void dispose () {
		rect.dispose();
	}
}
