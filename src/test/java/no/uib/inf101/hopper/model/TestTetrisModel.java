package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestTetrisModel {
    HopperModel model = new HopperModel();

    @Test
    public void checkIfPlayerUnderScreenTest(){
        model.getHoppingPlayerBox().setPlayerY(700);
        model.checkIfPlayerUnderScreen();
        assertEquals(GameState.GAME_OVER, model.getGameState());
    }


    @Test
    public void testIsLegalHopWhenNextPlatformIsOnTheSameSide() {
        ArrayList<Platform> platforms = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            platforms.add(new Platform(150, 'L', 600 - i * 100, 125,
                    25, i, 'R'));
        }

        for (int n = 0; n < 4; n++){
            platforms.get(n).setPlatformSide('L');
        }

        HoppingPlayerBox hopper = new HoppingPlayerBox(195, 560, 40, 40, 'L', 0);
        char sideToJump = 'L';

        boolean isLegal = model.isLeagleHop(sideToJump, hopper, platforms);

        assertTrue(isLegal);
    }

    @Test
    public void testIsLegalHopWhenNextPlatformIsOnDifferentSide() {
        ArrayList<Platform> platforms = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            platforms.add(new Platform(150, 'L', 600 - i * 100, 125,
                    25, i, 'R'));
        }
        for (int n = 0; n < 4; n++){
            if (n % 2 == 0){
                platforms.get(n).setPlatformSide('L');
            }else {
                platforms.get(n).setPlatformSide('R');
            }
        }
        HoppingPlayerBox hopper = new HoppingPlayerBox(195, 560, 40, 40, 'L', 0);
        char sideToJump = 'R';

        boolean isLegal = model.isLeagleHop(sideToJump, hopper, platforms);

        assertTrue(isLegal);
    }

    @Test
    public void testGetNextPlatform(){
        HoppingPlayerBox player1 = new HoppingPlayerBox(195, 560, 40, 40, 'L', 0);
        ArrayList<Platform> platforms = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            platforms.add(new Platform(150, 'L', 600 - i * 100, 125,
                    25, i, 'R'));
        }
        assertSame(model.getNextPlatform(player1, platforms), platforms.get(1));

        HoppingPlayerBox player2 = new HoppingPlayerBox(195, 560, 40, 40, 'L', 7);
        assertSame(model.getNextPlatform(player2, platforms), platforms.get(0));
    }

    @Test
    public void testIncreaseVelocityByScore() {
        HopperModel model1 = new HopperModel();
        assertTrue(model1.getVelocity() == 2.0);

        model1.setGameScore(11);
        model1.increaseVelocity();
        assertTrue(model1.getVelocity() == 2.2);

    }

    @Test
    public void testIncreaseVelocityWhenPlayerUnderY75() {
        HopperModel model1 = new HopperModel();
        model1.getHoppingPlayerBox().setPlayerY(-500);
        model1.increaseVelocity();
        assertEquals(2.05, model1.getVelocity());
    }

    @Test
    public void testIncreaseVelocityWhenPlayerUnderY50() {
        HopperModel model1 = new HopperModel();
        model1.getHoppingPlayerBox().setPlayerY(-525);
        model1.increaseVelocity();
        assertEquals(2.125, model1.getVelocity());
    }

    @Test
    public void testIncreaseVelocityWhenPlayerUnderY25() {
        HopperModel model1 = new HopperModel();
        model1.getHoppingPlayerBox().setPlayerY(-550);
        model1.increaseVelocity();
        assertEquals(2.225, model1.getVelocity());
    }

}
