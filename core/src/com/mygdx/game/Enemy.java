package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy extends Entity {

    Sound sound;


    public Enemy() {
        super("enemyBlue1.png");
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * (Gdx.graphics.getWidth() - texture.getWidth()));
        sound = AssetTool.getInstance().load("sfx_laser1.ogg", Sound.class);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y -= 3;

        if (Math.random() > 0.98f) {
            sound.play();
            game.entities.add(new EnemyLaser(this));
        }

    }

}
