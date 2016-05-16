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
 * Created by Kingkostas on 26/4/2016.
 */
public class MenuScreen implements Screen {
    SpriteBatch batch;
    OrthographicCamera menuCamera;

    private Music menuMusic;

    float cameraWidth = Gdx.graphics.getWidth();
    float cameraHeight = Gdx.graphics.getHeight();



    boolean playButtonIsPressed,exitButtonIsPressed,infoButtonIsPressed;
    Texture playButtonTexture,exitButtonTexture,infoButtonTexture,helicopterPilotHeaderTexture;
    Sprite playButtonSprite,exitButtonSprite,infoButtonSprite,helicopterPilotHeaderSprite;
    Rectangle playButtonRect,exitButtonRect,infoButtonRect;
    float deltaTime = Gdx.graphics.getDeltaTime();
    Game game;

    public MenuScreen(Game game){

        this.game = game;

    }

    @Override
    public void show() {

        batch = new SpriteBatch();









        playButtonTexture = new Texture ("playButton.png");
        playButtonSprite= new Sprite(playButtonTexture);

        exitButtonTexture = new Texture("exitButton.png");
        exitButtonSprite = new Sprite(exitButtonTexture);

        infoButtonTexture = new Texture ("infoButton.png");
        infoButtonSprite = new Sprite (infoButtonTexture);

        helicopterPilotHeaderTexture = new Texture ("helicopterPilotHeader.png");
        helicopterPilotHeaderSprite = new Sprite (helicopterPilotHeaderTexture);
        menuCamera = new OrthographicCamera(cameraWidth,cameraHeight);

        playButtonRect = new Rectangle(playButtonSprite.getX(),playButtonSprite.getY(),playButtonSprite.getWidth(),playButtonSprite.getHeight());
        exitButtonRect = new Rectangle(exitButtonSprite.getX(),exitButtonSprite.getY(),exitButtonSprite.getWidth(),exitButtonSprite.getHeight());
        infoButtonRect = new Rectangle(infoButtonSprite.getX(),infoButtonSprite.getY(),infoButtonSprite.getWidth(),infoButtonSprite.getHeight());

        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("mathGrantSound.mp3"));

        if(!menuMusic.isPlaying()){
            menuMusic.play();

        }


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(menuCamera.combined);

        batch.begin();

        helicopterPilotHeaderSprite.draw(batch);
        playButtonSprite.draw(batch);
        infoButtonSprite.draw(batch);
        exitButtonSprite.draw(batch);

        helicopterPilotHeaderSprite.setPosition(-320,200);
        playButtonSprite.setPosition(-120, 0);
        playButtonRect.setPosition(playButtonSprite.getX(),playButtonSprite.getY());
        infoButtonSprite.setPosition(-120,-90);
        infoButtonRect.setPosition(infoButtonSprite.getX(),infoButtonSprite.getY());
        exitButtonSprite.setPosition(-120,-180);
        exitButtonRect.setPosition(exitButtonSprite.getX(),exitButtonSprite.getY());
        batch.end();

        menuCamera.update();
        //buttonPressed(playButtonRect);
        playButtonIsPressed = playButtonPressed(playButtonRect);
        exitButtonIsPressed = exitButtonPressed(exitButtonRect);
        infoButtonIsPressed = infoButtonPressed(infoButtonRect);



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

      public boolean playButtonPressed(Rectangle playButtonRect) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        menuCamera.unproject(touchPos);

        if (playButtonRect.contains(touchPos.x, touchPos.y)) {
            System.out.println("Play Button Pressed!!!");
            menuMusic.stop();
            game.setScreen(new GameScreen(game));
            return true;
        } else {
            System.out.println("its false!!!");
            return false;
        }
    }
    public boolean exitButtonPressed(Rectangle exitButtonRect) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        menuCamera.unproject(touchPos);

        if (exitButtonRect.contains(touchPos.x, touchPos.y)) {
            System.out.println("Exit Button Pressed!!!");
            Gdx.app.exit();
            return true;
        } else {
            System.out.println("its false!!!");
            return false;
        }
    }
    public boolean infoButtonPressed(Rectangle infoButtonRect) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        menuCamera.unproject(touchPos);

        if (infoButtonRect.contains(touchPos.x, touchPos.y)) {
            System.out.println("Info Button Pressed!!!");
            game.setScreen(new InfoScreen(game));
           menuMusic.stop();
            return true;
        } else {
            System.out.println("its false!!!");
            return false;
        }
    }




}
