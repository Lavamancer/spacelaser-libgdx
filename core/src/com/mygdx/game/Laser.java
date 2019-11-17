package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Laser extends Entity {

    private static final int SPEED = 10;
    Sound sound;


    public Laser(Player player) {
        super("laserBlue01.png");
        x = player.x + player.texture.getWidth() / 2f - texture.getWidth() / 2f;
        y = player.y;
        sound = AssetTool.getInstance().load("explosion1.ogg", Sound.class);
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y += SPEED;
        if (y > Gdx.graphics.getHeight() + 1000) {
            game.entities.remove(this);
        }

        for (Entity e : game.entitiesAux) {
            if (e instanceof Meteor || e instanceof Enemy) {
                if (overlaps(this, e)) {
                    game.entities.remove(e);
                    game.entities.remove(this);
                    sound.setPitch(sound.play(), 0.6f);
                }
            }
        }
    }

}
