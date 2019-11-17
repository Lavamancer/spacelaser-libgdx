package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Meteor extends Entity {

    private static final int OFFSET = 2;
    private static String[] textures = new String[]{
            "meteorBrown_tiny1.png",
            "meteorBrown_tiny2.png",
            "meteorGrey_tiny1.png",
            "meteorGrey_tiny2.png",
            "meteorBrown_small1.png",
            "meteorBrown_small2.png",
            "meteorGrey_small1.png",
            "meteorGrey_small2.png",
            "meteorBrown_med1.png",
            "meteorBrown_med2.png",
            "meteorGrey_med1.png",
            "meteorGrey_med2.png",
            "meteorBrown_big1.png",
            "meteorBrown_big2.png",
            "meteorBrown_big3.png",
            "meteorBrown_big4.png",
            "meteorGrey_big1.png",
            "meteorGrey_big2.png",
            "meteorGrey_big3.png",
            "meteorGrey_big4.png",
    };


    private float xOffset;
    private int type;
    private int speed;



    public Meteor() {
        type = getMeteorType();
        String texturePath = getMeteorPath(type);
        texture = AssetTool.getInstance().load(texturePath, Texture.class);
        speed = getSpeedByType(type);
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * (Gdx.graphics.getWidth() - texture.getWidth()));
        xOffset = (float) ((Math.random() * OFFSET * 2) - OFFSET);
    }

    @Override
    public void update(MyGdxGame game, float delta) {
        y -= speed;
        x += xOffset;
        if (y < -500) {
            game.entities.remove(this);
        }
    }

    private static int getSpeedByType(int type) {
        if (type <= 3) {
            return 7;
        } else if (type <= 7) {
            return 5;
        } else if (type <= 11) {
            return 3;
        } else {
            return 1;
        }
    }

    private static int getMeteorType() {
        return (int) (Math.random() * textures.length);
    }

    private static String getMeteorPath(int type) {
        return "meteor/" + textures[type];
    }

}
