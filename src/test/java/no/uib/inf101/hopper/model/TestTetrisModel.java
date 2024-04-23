package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTetrisModel {
    HopperModel model = new HopperModel();

    @Test
    public void checkIfPlayerUnderScreenTest(){
        new HoppingPlayerBox(100,700, 40, 40, 'L', 0);
        model.checkIfPlayerUnderScreen();

        deepEquals(model.getGameState(), GameState.GAME_OVER);
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
}
