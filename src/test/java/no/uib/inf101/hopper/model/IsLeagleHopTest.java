package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsLeagleHopTest {

    private boolean isLeagleHop(char sideToJump, HoppingPlayerBox hopper, ArrayList<Platform> platforms){
        char nextPlatformSide = getNextPlatform(hopper, platforms).getPlatformSide();
        return (nextPlatformSide == sideToJump);
    }

    private Platform getNextPlatform(HoppingPlayerBox hopper, ArrayList<Platform> platforms){
        int currentPlatform = hopper.getCurrentPlatformNum() + 1;
        if (currentPlatform < 8){
            return platforms.get(currentPlatform);
        } else {
            return platforms.get(0);

        }

    }

    @Test
    public void testIsLegalHopWhenNextPlatformIsOnTheSameSide() {
        ArrayList<Platform> platforms = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            platforms.add(new Platform(150, 'L', 600 - i * 100, 125,
                    25, i));
        }
        HoppingPlayerBox hopper = new HoppingPlayerBox(195, 560, 40, 40, 'L', 0);
        char sideToJump = 'L';

        boolean isLegal = isLeagleHop(sideToJump, hopper, platforms);

        assertTrue(isLegal);
    }

    @Test
    public void testIsLegalHopWhenNextPlatformIsOnDifferentSide() {
        ArrayList<Platform> platforms = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            platforms.add(new Platform(150, 'R', 600 - i * 100, 125,
                    25, i));
        }
        HoppingPlayerBox hopper = new HoppingPlayerBox(195, 560, 40, 40, 'L', 0);
        char sideToJump = 'R';

        boolean isLegal = isLeagleHop(sideToJump, hopper, platforms);

        assertTrue(isLegal);
    }

}