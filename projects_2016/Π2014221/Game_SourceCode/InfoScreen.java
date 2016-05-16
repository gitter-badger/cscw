package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kingkostas on 1/5/2016.
 */
public class InfoScreen implements Screen {

    Game gameIS;
    SpriteBatch batch;

    OrthographicCamera infoScreenCamera;

    private Music infoMusic;

    float cameraWidth = Gdx.graphics.getWidth();
    float cameraHeight = Gdx.graphics.getHeight();

    Texture infoBackgroundTexture;
    Sprite infoBackgroundSprite;
 Rectangle infoScreenRect;
   public boolean infoScreenPressed;
    public int A1;


    public InfoScreen(Game game) {

        this.gameIS = game;

    }

    @Override
    public void show() {



        batch = new SpriteBatch();

        infoScreenCamera = new OrthographicCamera(cameraWidth,cameraHeight);

        infoBackgroundTexture = new Texture ("infoBackground.png");
       infoBackgroundSprite= new Sprite(infoBackgroundTexture);

        infoScreenRect = new Rectangle(infoBackgroundSprite.getX(),infoBackgroundSprite.getY(),infoBackgroundSprite.getWidth(),infoBackgroundSprite.getHeight());

        infoMusic = Gdx.audio.newMusic(Gdx.files.internal("mathGrantSound.mp3"));

        if(!infoMusic.isPlaying()){
            infoMusic.play();

        }

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.setProjectionMatrix(infoScreenCamera.combined);

        batch.begin();

        infoBackgroundSprite.draw(batch);
        infoBackgroundSprite.setPosition(-639, -359);

        batch.end();

        infoScreenCamera.update();
        infoScreenPressed = Gdx.input.isTouched();

        if (infoScreenPressed){
            infoMusic.dispose();
            gameIS.setScreen(new MenuScreen(gameIS));

            dispose();


        }
       // infoScreenPressed = infoScreenPressed(infoScreenRect);
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



   /* public boolean infoScreenPressed(Rectangle infoButtonRect) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        infoScreenCamera.unproject(touchPos);

        if (infoButtonRect.contains(touchPos.x, touchPos.y)) {
            System.out.println("Info Button Pressed!!!");
            gameIS.setScreen(new MenuScreen(gameIS));
            return true;
        } else {
            System.out.println("its false!!!");
            return false;
        }
    }
    */


}



