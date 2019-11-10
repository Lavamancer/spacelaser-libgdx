package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;

public class Player extends Entity {

    private static final int SPEED = 10;
    private static final float LASER_TICK = 0.1f;

    float laserTick = LASER_TICK;
    Sound sound;


    public Player() {
        super("playerShip1_blue.png");
        sound = Gdx.audio.newSound(Gdx.files.internal("sfx_laser1.ogg"));
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= SPEED;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (laserTick > LASER_TICK) {
                laserTick = 0;
                sound.play();
                game.entities.add(new Laser(this));
            }
        }
        laserTick += delta;

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

    }
}
