package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Meteor extends Entity {

    private static final int SPEED = 5;
    private static final int OFFSET = 5;
    private float xOffset;

    private static String[] textures = new String[]{
            "meteorBrown_tiny1.png",
            "meteorBrown_tiny2.png",
            "meteorBrown_small1.png",
            "meteorBrown_small2.png",
            "meteorBrown_med1.png",
            "meteorBrown_med2.png",
            "meteorBrown_big1.png",
            "meteorBrown_big2.png",
            "meteorBrown_big3.png",
            "meteorBrown_big4.png",
            "meteorGrey_tiny1.png",
            "meteorGrey_tiny2.png",
            "meteorGrey_small1.png",
            "meteorGrey_small2.png",
            "meteorGrey_med1.png",
            "meteorGrey_med2.png",
            "meteorGrey_big1.png",
            "meteorGrey_big2.png",
            "meteorGrey_big3.png",
            "meteorGrey_big4.png",
    };


    public Meteor() {
        super(getMeteorPath());
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * (Gdx.graphics.getWidth() - texture.getWidth()));
        xOffset = (float) ((Math.random() * OFFSET * 2) - OFFSET);
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y -= SPEED;
        x += xOffset;
        if (y < -500) {
            game.entities.remove(this);
        }
    }

    private static String getMeteorPath() {
        int index = (int) (Math.random() * textures.length);
        System.out.println("Index: " + index);
        return "meteor/" + textures[index];
    }

}
