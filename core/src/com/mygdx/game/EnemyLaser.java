package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyLaser extends Entity {

    private static final int SPEED = -10;
    Sound sound;
    Sprite sprite;


    public EnemyLaser(Enemy enemy) {
        super("laserRed01.png");
        x = enemy.x + enemy.texture.getWidth() / 2 - texture.getWidth() / 2;
        y = enemy.y;
        sound = AssetTool.getInstance().load("explosion1.ogg", Sound.class);

        sprite = new Sprite(texture);
        sprite.flip(false, true);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(x, y);
        sprite.draw(spriteBatch);
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y += SPEED;
        if (y < -1000) {
            game.entities.remove(this);
        }

//        for (Entity e : game.entitiesAux) {
//            if (e instanceof Meteor || e instanceof Enemy) {
//                if (overlaps(this, e)) {
//                    game.entities.remove(e);
//                    game.entities.remove(this);
//                    sound.setPitch(sound.play(), 0.6f);
//                }
//            }
//        }
    }
}
