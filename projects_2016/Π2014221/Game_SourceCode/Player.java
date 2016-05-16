package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by Kingkostas on 22/3/2016.
 */
public class Player {

   // public enum State {IDLE , FLYINGRIGHT , FLYINGLEFT};

   // public State currentState;
  //  public State previousState;
   // private Animation idle;
   // private Animation flyingRight;
   // private Animation flyingLeft;
   // private float stateTimer;

    Texture playerImage=new Texture ("HIdle1.png");
    Sprite playerSprite= new Sprite(playerImage);
    Rectangle playerRect;

    boolean isOverlapping;


//player constructor  | to be able to initialize the object  on a specific way
    Player(float positionX,float positionY){

        //currentState = State.IDLE;
        //previousState = State.IDLE;
       // stateTimer = 0;


        playerSprite.setX(positionX);
        playerSprite.setY(positionY);
       // playerImage = new Texture ("playerScreen.png");
      //  playerSprite = new Sprite(playerImage);
        playerSprite.setPosition(playerSprite.getX(),playerSprite.getY());
        playerRect = new Rectangle(playerSprite.getX(),playerSprite.getY(),playerSprite.getWidth(),playerSprite.getHeight());
        isOverlapping = false;

    }

}
