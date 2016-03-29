package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**
 * Created by Kingkostas on 28/3/2016.
 */
public class BackBarrier {

    Texture bBarrierImage=new Texture ("barrierBack.png");
    Sprite bBarrierSprite= new Sprite(bBarrierImage);


    BackBarrier(float positionX,float positionY){

        bBarrierSprite.setX(positionX);
        bBarrierSprite.setY(positionY);

        bBarrierSprite.setPosition(bBarrierSprite.getX(),bBarrierSprite.getY());



    }
}
