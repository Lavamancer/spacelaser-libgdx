package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch spriteBatch;
	Texture backgroundTexture;
	List<Entity> entities = new ArrayList<>();


	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		backgroundTexture = new Texture("darkPurple.png");
		entities.add(new Player());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		for (Entity entity : entities) {
			entity.update(Gdx.graphics.getDeltaTime());
		}

		spriteBatch.begin();
		spriteBatch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (Entity entity : entities) {
			entity.draw(spriteBatch);
		}
		spriteBatch.end();
	}

}
