package inf112.skeleton.app;//Created by ingridjohansen on 04/02/2019.

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import static inf112.skeleton.app.Game.playGame;

public class MapGUI extends ApplicationAdapter {

    private Texture robotImage, voidImage, yellowImage, blueImage, laserImage, screwImage, hammer_ScrewImage, gearImmage, flagImage, nothingImage;

    private Sound dropSound;
    private Music rainMusic;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Rectangle[][] bucket;
    private Rectangle robot;

    private Map map;

    @Override
    public void create() {


        map = playGame();

        // load the images for the objects on the map, 64x64 pixels each
        robotImage = getImage("wall_e.png");
        voidImage = getImage("void.png");
        yellowImage = getImage("yellow_arrow.png");
        blueImage = getImage("blue_arrow.png");
        laserImage = getImage("laser.png");
        screwImage = getImage("screw.png");
        hammer_ScrewImage = getImage("hammer_screw.png");
        gearImmage = getImage("gear.png");
        flagImage = getImage("flag.png");
        nothingImage = getImage("nothing.png");

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 640);
        batch = new SpriteBatch();


        // create a list of Rectangles to logically represent the objects
        bucket = new Rectangle[10][10];

        //make the moving robot
        robot = new Rectangle();
        robot.x = 0;
        robot.y = 0;
        robot.height = 64;
        robot.width = 64;


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j ++) {
                bucket[i][j] = new Rectangle();
                bucket[i][j].x = i*64;
                bucket[i][j].y = j*64;
                bucket[i][j].width = 64;
                bucket[i][j].height = 64;
            }
        }
    }

    public Texture getImage(String s) {
        return new Texture(Gdx.files.internal(s));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the board
        batch.begin();

        //TODO: make switch
        for (int i = 0,x = 0; i < 10; i++, x++) {
            for (int j = 0, y = 9; j < 10; j++, y--) {
                if (map.getBoardObject(y, x) instanceof Robot){
                    batch.draw(robotImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Void){
                    batch.draw(voidImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Laser){
                    batch.draw(laserImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Conveyor_belt){
                    batch.draw(blueImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Wrench){
                    batch.draw(screwImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Wrench_hammer){
                    batch.draw(hammer_ScrewImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Flag){
                    batch.draw(flagImage, bucket[i][j].x, bucket[i][j].y);
                } else if (map.getBoardObject(y, x) instanceof Rotating_belt){
                    batch.draw(gearImmage, bucket[i][j].x, bucket[i][j].y);
                } else {
                    batch.draw(nothingImage, bucket[i][j].x, bucket[i][j].y);
                }
            }
        }

        batch.draw(robotImage, robot.x, robot.y);

        batch.end();


        //stuff for mooving
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) robot.y += 64;
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) robot.y -= 64;
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) robot.x -= 64;
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) robot.x += 64;

    }

    @Override
    public void dispose() {
        // dispose of all the native resources
        robotImage.dispose();
        voidImage.dispose();
        blueImage.dispose();
        yellowImage.dispose();
        laserImage.dispose();
        nothingImage.dispose();
        gearImmage.dispose();
        hammer_ScrewImage.dispose();
        screwImage.dispose();
        flagImage.dispose();
        batch.dispose();
    }
}
