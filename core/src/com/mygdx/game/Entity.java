package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {

    float x;
    float y;
    Texture texture;


    public Entity() {

    }

    public Entity(String texturePath) {
        texture = AssetTool.getInstance().load(texturePath, Texture.class);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }

    public void update(MyGdxGame game, float delta) {
        // todo implement
    }


    public static boolean overlaps(Entity entityA, Entity entityB) {
        if (entityA.x + entityA.texture.getWidth() < entityB.x || entityA.x > entityB.x + entityB.texture.getWidth()) {
            return false;
        }
        if (entityA.y > entityB.y + entityB.texture.getHeight() || entityA.y + entityA.texture.getHeight() < entityB.y) {
            return false;
        }
        return true;
    }

}
