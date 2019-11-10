package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {

    int x;
    int y;
    Texture texture;


    public Entity(String texturePath) {
        texture = new Texture(texturePath);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }

    public void update(MyGdxGame game, float delta) {
        // todo implement
    }

}
