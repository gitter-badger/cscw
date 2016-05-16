package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kingkostas on 15/3/2016.
 */
public class GameScreen implements Screen,InputProcessor {

    Game gameGS;
    private Music helicopterMusic, streetSound;
  public boolean touchingScreen,touchBarrier1,touchHelicopter,barrier1touched,barrier2touched,barrier3touched,barrier4touched,barrier5touched,barrier6touched,barrier7touched,barrier8touched,barrier9touched,barrier10touched;
    public int currentstate;
    public int numberOfLives;
    public float helicopterSizeX, helicopterSizeY,barrierSizeX,barrierSizeY;
    Vector3 touchPos;
    public int intBarrier1,intBarrier2,intBarrier3,intBarrier4,intBarrier5,intBarrier6,intBarrier7,intBarrier8,intBarrier9,intBarrier10;
    public int B1,B2,B3,B4,B5,B6,B7,B8,B9,B10;


    private int score;
    private String yourScoreName;
    BitmapFont yourBitmapFontName;

    SpriteBatch batch;
    BitmapFont font;
    String str;
    Texture img, playerImage, obstacleImage, scoreImage, fulllivesImage, threelivesImage, twolivesImage, oneliveImage, emptylifeImage, rightArrowImage, leftArrowImage;
    Sprite playerSprite, scoreSprite, fulllivesSprite, threelivesSprite, twolivesSprite, oneliveSprite, emptylifeSprite, rightArrowSprite, leftArrowSprite;
    Player myPlayer;
    Barrier barrier1, barrier2, barrier3, barrier4, barrier5,barrier6,barrier7,barrier8,barrier9,barrier10;
    BackBarrier bBarrier1, bBarrier2, bBarrier3, bBarrier4, bBarrier5,bBarrier6,bBarrier7,bBarrier8,bBarrier9,bBarrier10;
    OrthographicCamera gameCamera;
    OrthographicCamera hudCamera;
    float cameraWidth = Gdx.graphics.getWidth();
    float cameraHeight = Gdx.graphics.getHeight();
    float deltaTime = Gdx.graphics.getDeltaTime();
    Rectangle testRect, testRect2, leftArrowRectangle, rightArrowRectangle;


    public GameScreen(Game game) {

        this.gameGS = game;

    }


    @Override
    public void show() {

                B1 = 0;
                B2 = 0;
                B3 = 0;
                B4 = 0;
                B5 = 0;
                B6 = 0;
                B7 = 0;
                B8 = 0;
                B9 = 0;
                B10 = 0;



        numberOfLives = 4;
        currentstate = 4;
        //ta sprites gia tis zwes
        fulllivesImage = new Texture("fourlives.png");
        fulllivesSprite = new Sprite(fulllivesImage);

        threelivesImage = new Texture("threelives.png");
        threelivesSprite = new Sprite(threelivesImage);

        twolivesImage = new Texture("twolives.png");
        twolivesSprite = new Sprite(twolivesImage);

        oneliveImage = new Texture("onelive.png");
        oneliveSprite = new Sprite(oneliveImage);

        emptylifeImage = new Texture("emptyLife.png");
        emptylifeSprite = new Sprite(emptylifeImage);


        rightArrowImage = new Texture("rightArrow.png");
        rightArrowSprite = new Sprite(rightArrowImage);

        leftArrowImage = new Texture("leftArrow.png");
        leftArrowSprite = new Sprite(leftArrowImage);

        helicopterMusic = Gdx.audio.newMusic(Gdx.files.internal("HSound.wav"));
        helicopterMusic.setLooping(true);
        helicopterMusic.setVolume(2);
        // helicopterMusic.play();
        streetSound = Gdx.audio.newMusic(Gdx.files.internal("streetSound.mp3"));
        streetSound.setVolume(2000);
        streetSound.setLooping(true);

        streetSound.play();
        score = 0;
        yourScoreName = "score: 0";
        yourBitmapFontName = new BitmapFont();
        yourBitmapFontName.setColor(Color.BLACK);
        gameCamera = new OrthographicCamera(cameraWidth, cameraHeight);
        hudCamera = new OrthographicCamera(cameraWidth, cameraHeight);
        batch = new SpriteBatch();
        // myPlayer = new Player(550,450);
        myPlayer = new Player(665, 400);
        bBarrier1 = new BackBarrier(265, 150);
        barrier1 = new Barrier(300, 150);
        bBarrier2 = new BackBarrier(515, 250);
        barrier2 = new Barrier(550, 250);
        bBarrier3 = new BackBarrier(665, 400);
        barrier3 = new Barrier(700, 400);
        bBarrier4 = new BackBarrier(865, 380);
        barrier4 = new Barrier(900, 380);
        bBarrier5 = new BackBarrier(1015, 200);
        barrier5 = new Barrier(1050, 200);
        bBarrier6 = new BackBarrier(1200,400);
        barrier6 = new Barrier(1235,400);
        bBarrier7 = new BackBarrier(1300,500);
        barrier7 = new Barrier(1335,500);
        bBarrier8 = new BackBarrier(1500,350);
        barrier8 = new Barrier(1535,350);
        bBarrier9 = new BackBarrier(1650,250);
        barrier9 = new Barrier(1685,250);
        bBarrier10 = new BackBarrier(1850,550);
        barrier10 = new Barrier(1885,550);

        testRect = new Rectangle(300, 150, barrier1.barrierSprite.getWidth(), barrier1.barrierSprite.getHeight());
        testRect2 = new Rectangle(0, 0, myPlayer.playerSprite.getWidth(), myPlayer.playerSprite.getHeight());
        leftArrowRectangle = new Rectangle(-400, -300, leftArrowSprite.getWidth(), leftArrowSprite.getHeight());
        rightArrowRectangle = new Rectangle(200, -300, rightArrowSprite.getWidth(), rightArrowSprite.getHeight());
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        helicopterSizeX = myPlayer.playerSprite.getScaleX();
        helicopterSizeY = myPlayer.playerSprite.getScaleY();
        barrierSizeX =barrier1.barrierSprite.getScaleX();
        barrierSizeY = barrier1.barrierSprite.getScaleY();
        //arxikopoihsh


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

      touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

        // gameCamera.setToOrtho(false,cameraWidth,cameraHeight);
        float yAxis = Gdx.input.getAccelerometerX();
        float xAxis = Gdx.input.getAccelerometerY();
        float zAxis = Gdx.input.getAccelerometerZ();

        numberOfLives = 4;
        currentstate = numberOfLives;
        // System.out.println(numberOfLives);
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
        bBarrier6.bBarrierSprite.draw(batch);
        bBarrier7.bBarrierSprite.draw(batch);
        bBarrier8.bBarrierSprite.draw(batch);
        bBarrier9.bBarrierSprite.draw(batch);
        bBarrier10.bBarrierSprite.draw(batch);

        myPlayer.playerSprite.draw(batch);
        myPlayer.playerSprite.translateY(-1 * yAxis);
        myPlayer.playerSprite.translateX(xAxis);

        barrier1.barrierSprite.draw(batch);
        barrier2.barrierSprite.draw(batch);
        barrier3.barrierSprite.draw(batch);
        barrier4.barrierSprite.draw(batch);
        barrier5.barrierSprite.draw(batch);
        barrier6.barrierSprite.draw(batch);
        barrier7.barrierSprite.draw(batch);
        barrier8.barrierSprite.draw(batch);
        barrier9.barrierSprite.draw(batch);
        barrier10.barrierSprite.draw(batch);
        //myPlayer.playerSprite.draw(batch);
        // batch.draw(obstacleImage,300,150);
        // batch.draw(obstacleImage, 550, 250);


        batch.end();
       /* if(barrier1.barrierSprite.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
            System.out.println("i am touching barrier 1");
            touchBarrier1 = true;
            touchHelicopter = false;
        }
        if(myPlayer.playerSprite.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
            System.out.println("i am touching helicopter");
            touchHelicopter = true;
            touchBarrier1 = false;
        }
        if(touchBarrier1 && leftButtonPressed(leftArrowRectangle)){

            barrierSizeX = barrierSizeX-0.05f;
            barrierSizeY = barrierSizeY-0.05f;
           barrier1.barrierSprite.setScale(barrierSizeX, barrierSizeY);
        }
        if(touchBarrier1 && rightButtonPressed(rightArrowRectangle)){

            barrierSizeX = barrierSizeX+0.05f;
            barrierSizeY = barrierSizeY+0.05f;
            barrier1.barrierSprite.setScale(barrierSizeX, barrierSizeY);
        }
*/
        gameCamera.update();

        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        rightArrowSprite.draw(batch);
        rightArrowSprite.setPosition(200, -300);
        leftArrowSprite.draw(batch);
        leftArrowSprite.setPosition(-400, -300);

        font.draw(batch, "CITY-SCAPE level 1-1", -200, 310);

        scoreSprite.draw(batch);
        scoreSprite.setColor(Color.DARK_GRAY);
        scoreSprite.setPosition(-600, 290);
        yourBitmapFontName.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        yourBitmapFontName.draw(batch, yourScoreName, -600, 290);

        fulllivesSprite.draw(batch);
        if (myPlayer.isOverlapping == true & currentstate == 4) {
            fulllivesSprite.draw(batch);
            fulllivesSprite.setPosition(70, 270);
          //  System.out.println("currentstate 4 called");
            numberOfLives--;
            myPlayer.isOverlapping = false;


        } else if (myPlayer.isOverlapping == true & currentstate == 3) {
            threelivesSprite.draw(batch);
            threelivesSprite.setPosition(70, 270);
           // System.out.println("currentstate 3 called");
            numberOfLives--;
            myPlayer.isOverlapping = false;
        } else if (myPlayer.isOverlapping == true & currentstate == 2) {

            twolivesSprite.draw(batch);
            twolivesSprite.setPosition(70, 270);
           // System.out.println("currentstate 2 called");
            numberOfLives--;
            myPlayer.isOverlapping = false;
        } else if (myPlayer.isOverlapping == true & currentstate == 1) {

            oneliveSprite.draw(batch);
            oneliveSprite.setPosition(70, 270);
           // System.out.println("currentstate 1 called");
            numberOfLives--;
            myPlayer.isOverlapping = false;
        } else if (myPlayer.isOverlapping == true & currentstate == 0) {

            emptylifeSprite.draw(batch);
            emptylifeSprite.setPosition(70, 270);
           // System.out.println("currentstate 0 called");
            numberOfLives--;
            myPlayer.isOverlapping = false;
        }


        batch.end();

        testRect2.setPosition(myPlayer.playerSprite.getX(), myPlayer.playerSprite.getY());
        //its working!!! [prepei na peraseis apo anamesa]
        if (testRect2.overlaps(barrier1.upperRect) || testRect2.overlaps(barrier1.lowerRect) || testRect2.overlaps(barrier2.upperRect) || testRect2.overlaps(barrier2.lowerRect) || testRect2.overlaps(barrier3.upperRect) || testRect2.overlaps(barrier3.lowerRect) || testRect2.overlaps(barrier4.upperRect) || testRect2.overlaps(barrier4.lowerRect) || testRect2.overlaps(barrier5.upperRect) || testRect2.overlaps(barrier5.lowerRect) || testRect2.overlaps(barrier6.upperRect)||testRect2.overlaps(barrier6.lowerRect)||testRect2.overlaps(barrier7.upperRect)||testRect2.overlaps(barrier7.lowerRect)
                ||testRect2.overlaps(barrier8.upperRect) || testRect2.overlaps(barrier8.lowerRect) || testRect2.overlaps(barrier9.upperRect) || testRect2.overlaps(barrier9.lowerRect)|| testRect2.overlaps(barrier10.upperRect) || testRect2.overlaps(barrier10.lowerRect)) {
            myPlayer.playerSprite.setColor(Color.DARK_GRAY);
            myPlayer.isOverlapping = true;
            numberOfLives--;
           // System.out.println("collided");
            // System.out.println(numberOfLives);
            currentstate = numberOfLives;
            System.out.println(currentstate);
        }
        if (testRect2.overlaps(barrier1.verticalRect) || testRect2.overlaps(barrier2.verticalRect) || testRect2.overlaps(barrier3.verticalRect) || testRect2.overlaps(barrier4.verticalRect) || testRect2.overlaps(barrier5.verticalRect)|| testRect2.overlaps(barrier6.verticalRect)||testRect2.overlaps(barrier7.verticalRect)
                ||testRect2.overlaps(barrier8.verticalRect) || testRect2.overlaps(barrier9.verticalRect) || testRect2.overlaps(barrier10.verticalRect)) {
            myPlayer.playerSprite.setColor(Color.LIGHT_GRAY);
            score++;
            yourScoreName = "score: " + score;
            // System.out.println(score);


        }

        if(testRect2.overlaps(barrier1.verticalRect)){
            barrier1touched = true;
            intBarrier1 = 1;
            B1 = intBarrier1;
        }
        if(testRect2.overlaps(barrier2.verticalRect)){
            barrier1touched = true;
            intBarrier2 = 1;
            B2 = intBarrier2;
        }
        if(testRect2.overlaps(barrier3.verticalRect)){
            barrier1touched = true;
            intBarrier3 = 1;
            B3 = intBarrier3;
        }
        if(testRect2.overlaps(barrier4.verticalRect)){
            barrier1touched = true;
            intBarrier4 = 1;
            B4 = intBarrier4;
        }
        if(testRect2.overlaps(barrier5.verticalRect)){
            barrier1touched = true;
            intBarrier5 = 1;
            B5 = intBarrier5;
        }
        if(testRect2.overlaps(barrier6.verticalRect)){
            barrier1touched = true;
            intBarrier6 = 1;
            B6 = intBarrier6;
        }
        if(testRect2.overlaps(barrier7.verticalRect)){
            barrier1touched = true;
            intBarrier7 = 1;
            B7 = intBarrier7;
        }
        if(testRect2.overlaps(barrier8.verticalRect)){
            barrier1touched = true;
            intBarrier8 = 1;
            B8 = intBarrier8;
        }
        if(testRect2.overlaps(barrier9.verticalRect)){
            barrier1touched = true;
            intBarrier9 = 1;
            B9 = intBarrier9;
        }
        if(testRect2.overlaps(barrier10.verticalRect)){
            barrier1touched = true;
            intBarrier10 = 1;
            B10 = intBarrier10;
        }


        if(B1 == 1 && B2 ==1 && B3 ==1
                && B4 == 1 && B5 == 1 && B6 == 1
                && B7 == 1 && B8 ==1 && B9 ==1 && B10 ==1){
            System.out.println("you finished the LEVEL!!!");
            gameGS.setScreen(new MenuScreen(gameGS));
            dispose();
        }

        System.out.println(B1);
        System.out.println(B2);
        System.out.println(B3);
        System.out.println(B4);
        System.out.println(B5);
        System.out.println(B6);
        System.out.println(B7);
        System.out.println(B8);
        System.out.println(B9);
        System.out.println(B10);



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
touchingScreen = Gdx.input.isTouched();
        if(leftButtonPressed(leftArrowRectangle) && touchingScreen){
            leftButtonPressed(leftArrowRectangle);
        }
        if(rightButtonPressed(rightArrowRectangle) && touchingScreen){
            rightButtonPressed(rightArrowRectangle);
        }


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
        streetSound.dispose();
        helicopterMusic.dispose();
    }


    public boolean leftButtonPressed(Rectangle leftArrowRectangle) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        hudCamera.unproject(touchPos);

        if (leftArrowRectangle.contains(touchPos.x, touchPos.y)) {
            System.out.println("leftArrow Clicked");
            helicopterSizeX = helicopterSizeX-0.05f;
            helicopterSizeY = helicopterSizeY-0.05f;
            myPlayer.playerSprite.setScale(helicopterSizeX, helicopterSizeY);
            return true;

        }else {return false;}
    }
    public boolean rightButtonPressed(Rectangle rightArrowRectangle) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        hudCamera.unproject(touchPos);

        if (rightArrowRectangle.contains(touchPos.x, touchPos.y)) {
            System.out.println("rightArrow Clicked");
            helicopterSizeX = helicopterSizeX+0.05f;
            helicopterSizeY = helicopterSizeY+0.05f;
            myPlayer.playerSprite.setScale(helicopterSizeX, helicopterSizeY);
            return true;

        }else {return false;}
    }




    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}