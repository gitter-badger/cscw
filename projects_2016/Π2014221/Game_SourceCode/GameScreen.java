package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Kingkostas on 15/3/2016.
 */
public class GameScreen implements Screen {

    private Music helicopterMusic,streetSound;



    private int score;
    private String yourScoreName;
    BitmapFont yourBitmapFontName;

    SpriteBatch batch;
    BitmapFont font;
    String str;
    Texture img,playerImage,obstacleImage,scoreImage;
    Sprite playerSprite,scoreSprite;
    Player myPlayer;
    Barrier barrier1,barrier2,barrier3,barrier4,barrier5;
    BackBarrier bBarrier1,bBarrier2,bBarrier3,bBarrier4,bBarrier5;
    OrthographicCamera gameCamera;
    OrthographicCamera hudCamera;
    float cameraWidth = Gdx.graphics.getWidth();
    float cameraHeight = Gdx.graphics.getHeight();
    float deltaTime = Gdx.graphics.getDeltaTime();
    Rectangle testRect,testRect2;




    @Override
    public void show() {
        helicopterMusic = Gdx.audio.newMusic(Gdx.files.internal("HSound.wav"));
        helicopterMusic.setLooping(true);
        helicopterMusic.setVolume(2);
       helicopterMusic.play();
        streetSound = Gdx.audio.newMusic(Gdx.files.internal("streetSound.mp3"));
        streetSound.setVolume(2000);
        streetSound.setLooping(true);

        streetSound.play();
        score = 0;
        yourScoreName = "score: 0";
        yourBitmapFontName = new BitmapFont();
        yourBitmapFontName.setColor(Color.BLACK);
        gameCamera = new OrthographicCamera(cameraWidth,cameraHeight);
        hudCamera = new OrthographicCamera(cameraWidth,cameraHeight);
        batch = new SpriteBatch();
       // myPlayer = new Player(550,450);
        myPlayer = new Player(665,400);
        bBarrier1 = new BackBarrier(265,150);
        barrier1 = new Barrier(300,150);
        bBarrier2 = new BackBarrier(515,250);
        barrier2 = new Barrier(550,250);
        bBarrier3 = new BackBarrier(665,400);
        barrier3 = new Barrier(700,400);
        bBarrier4 = new BackBarrier(865,380);
        barrier4 = new Barrier (900,380);
        bBarrier5 = new BackBarrier(1015,200);
        barrier5 = new Barrier(1050,200);
        testRect = new Rectangle(300,150, barrier1.barrierSprite.getWidth(),barrier1.barrierSprite.getHeight());
        testRect2 = new Rectangle(0,0,myPlayer.playerSprite.getWidth(),myPlayer.playerSprite.getHeight());
        font = new BitmapFont();
        font.setColor(Color.BLACK);

        img = new Texture("fullScreenPrototypev2.png");
        scoreImage = new Texture("score.png");
        scoreSprite = new Sprite(scoreImage);
        //playerImage = new Texture ("playerScreen.png");
        //obstacleImage = new Texture ("obstacleScreen.png");
            //playerSprite = new Sprite(playerImage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

       // gameCamera.setToOrtho(false,cameraWidth,cameraHeight);
        float yAxis = Gdx.input.getAccelerometerX();
        float xAxis = Gdx.input.getAccelerometerY();
        float zAxis = Gdx.input.getAccelerometerZ();

       // System.out.println(xAxis);
       // System.out.println(xAxis);

        batch.setProjectionMatrix(gameCamera.combined);



        batch.begin();
        batch.draw(img, 0, 0);
       //batch.draw(playerImage,0,0);
        bBarrier1.bBarrierSprite.draw(batch);
        bBarrier2.bBarrierSprite.draw(batch);
        bBarrier3.bBarrierSprite.draw(batch);
        bBarrier4.bBarrierSprite.draw(batch);
        bBarrier5.bBarrierSprite.draw(batch);
        myPlayer.playerSprite.draw(batch);
        myPlayer.playerSprite.translateY(-1 * yAxis);
        myPlayer.playerSprite.translateX(xAxis);

        barrier1.barrierSprite.draw(batch);
        barrier2.barrierSprite.draw(batch);
        barrier3.barrierSprite.draw(batch);
        barrier4.barrierSprite.draw(batch);
        barrier5.barrierSprite.draw(batch);
      //myPlayer.playerSprite.draw(batch);
       // batch.draw(obstacleImage,300,150);
       // batch.draw(obstacleImage, 550, 250);


        batch.end();

        gameCamera.update();

        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();

        font.draw(batch, "CITY-SCAPE level 1-1", -50, 310);

        scoreSprite.draw(batch);
        scoreSprite.setColor(Color.DARK_GRAY);
        scoreSprite.setPosition(-600, 290);
        yourBitmapFontName.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        yourBitmapFontName.draw(batch, yourScoreName, -600, 290);
        batch.end();

        testRect2.setPosition(myPlayer.playerSprite.getX(), myPlayer.playerSprite.getY());
        //its working!!! [prepei na peraseis apo anamesa]
        if(testRect2.overlaps(barrier1.upperRect)|| testRect2.overlaps(barrier1.lowerRect)||testRect2.overlaps(barrier2.upperRect)||testRect2.overlaps(barrier2.lowerRect)|| testRect2.overlaps(barrier3.upperRect)|| testRect2.overlaps(barrier3.lowerRect) || testRect2.overlaps(barrier4.upperRect)||testRect2.overlaps(barrier4.lowerRect)||testRect2.overlaps(barrier5.upperRect)||testRect2.overlaps(barrier5.lowerRect)){
            myPlayer.playerSprite.setColor(Color.DARK_GRAY);

        }
        if(testRect2.overlaps(barrier1.verticalRect) || testRect2.overlaps(barrier2.verticalRect)||testRect2.overlaps(barrier3.verticalRect)||testRect2.overlaps(barrier4.verticalRect)|| testRect2.overlaps(barrier5.verticalRect)){
            myPlayer.playerSprite.setColor(Color.LIGHT_GRAY);
            score++;
            yourScoreName = "score: " + score;
            System.out.println(score);

        }


       // myPlayer.isOverlapping = myPlayer.playerRect.overlaps(testRect);
       // if(myPlayer.isOverlapping){

           // myPlayer.playerSprite.setColor(150,110,210,1);

       //}




/*
        batch.begin();
        batch.draw(img, 0, 0);
       // batch.draw(playerImage,0,0);
        playerSprite.draw(batch);
        playerSprite.translateY(-1 * yAxis);
        playerSprite.translateX(xAxis);
        //myPlayer.playerSprite.draw(batch);
        batch.draw(obstacleImage,300,150);
        batch.draw(obstacleImage, 550, 250);
        batch.end();
        */
            //na dokimasw na balw mia metablhth taxuthtas kserw gw pou otan ftanei to shmeio na ginetai 0 kai otan feugei na ginetai normal

            gameCamera.position.set(myPlayer.playerSprite.getX(), myPlayer.playerSprite.getY(), 0);


        gameCamera.translate(myPlayer.playerSprite.getX() * 0.2f, myPlayer.playerSprite.getY() * 0.2f);



        hudCamera.update();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
batch.dispose();
    }
}
