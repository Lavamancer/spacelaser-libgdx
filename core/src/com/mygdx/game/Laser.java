package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Laser extends Entity {

    private static final int SPEED = 10;

    public Laser(Player player) {
        super("laserBlue01.png");
        x = player.x + player.texture.getWidth() / 2 - texture.getWidth() / 2;
        y = player.y;
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y += SPEED;
        if (y > Gdx.graphics.getHeight() + 1000) {
            game.entities.remove(this);
        }
    }
}
