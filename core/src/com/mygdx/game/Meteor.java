package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Meteor extends Entity {

    private static final int SPEED = 5;


    public Meteor() {
        super("meteorBrown_med1.png");
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * (Gdx.graphics.getWidth() - texture.getWidth()));
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y -= SPEED;

        if (y < -500) {
            game.entities.remove(this);
        }
    }

}
