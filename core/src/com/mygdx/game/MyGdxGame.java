package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch spriteBatch;
	BitmapFont bitmapFont;
	String text = "";
	Texture backgroundTexture;
	List<Entity> entities = new ArrayList<>();
	List<Entity> entitiesAux = new ArrayList<>();


	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		bitmapFont.setColor(Color.WHITE);
		backgroundTexture = new Texture("darkPurple.png");
		entities.add(new Player());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		entitiesAux.clear();
		entitiesAux.addAll(entities);
		for (Entity entity : entitiesAux) {
			entity.update(this, Gdx.graphics.getDeltaTime());
		}

		spriteBatch.begin();

		spriteBatch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (Entity entity : entities) {
			entity.draw(spriteBatch);
		}

		text = "Entities: " + entities.size();
		bitmapFont.draw(spriteBatch, text, 10, Gdx.graphics.getHeight() - 10f);

		spriteBatch.end();


		if (Math.random() > 0.98f) {
			entities.add(new Meteor());
		}

		if (Math.random() > 0.98f) {
			entities.add(new Enemy());
		}

	}

}
