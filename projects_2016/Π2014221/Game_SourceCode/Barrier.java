package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Kingkostas on 22/3/2016.
 */
public class Barrier {

    Texture barrierImage=new Texture ("barrierFront.png");
    Sprite barrierSprite=new Sprite (barrierImage);

    Rectangle upperRect;
    Rectangle lowerRect;
    Rectangle verticalRect;
    //Barrier object constructor | so that we can instantiate it properly
    Barrier(float positionX,float positionY){

        barrierSprite.setX(positionX);
        barrierSprite.setY(positionY);
       // barrierImage = new Texture ("obstacleScreen.png");
       // barrierSprite = new Sprite (barrierImage);
        barrierSprite.setPosition(barrierSprite.getX(),barrierSprite.getY());
        upperRect = new Rectangle(barrierSprite.getX(),barrierSprite.getY()+200,barrierSprite.getWidth()/50,barrierSprite.getHeight()/50);
        lowerRect = new Rectangle(barrierSprite.getX(),barrierSprite.getY(),barrierSprite.getWidth()/50,barrierSprite.getHeight()/50);
        verticalRect = new Rectangle(barrierSprite.getX()+100,barrierSprite.getY()+100,barrierSprite.getWidth()/500,barrierSprite.getHeight()/9);    //  /200   /9




    }

}
