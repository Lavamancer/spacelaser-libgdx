package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Laser extends Entity {

    private static final int SPEED = 10;
    Sound sound;


    public Laser(Player player) {
        super("laserBlue01.png");
        x = player.x + player.texture.getWidth() / 2 - texture.getWidth() / 2;
        y = player.y;
        sound = Gdx.audio.newSound(Gdx.files.internal("sfx_lose.ogg"));
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y += SPEED;
        if (y > Gdx.graphics.getHeight() + 1000) {
            game.entities.remove(this);
        }

        for (Entity meteor : game.entitiesAux) {
            if (meteor instanceof Meteor) {
                if (overlaps(this, meteor)) {
                    game.entities.remove(meteor);
                    game.entities.remove(this);
                    sound.setPitch(sound.play(), 0.7f);
                }
            }
        }
    }

}
