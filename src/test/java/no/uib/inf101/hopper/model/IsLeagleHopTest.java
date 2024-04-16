package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsLeagleHopTest {

    @Test
    public void testIsLegalHopWhenNextPlatformIsOnTheSameSide() {
        HoppingPlayerBox hopper = new HoppingPlayerBox(1, 1, 1, 1, 'L', 1);
        char sideToJump = 'L';
        
        boolean isLegal = hopper.isLeagleHop(sideToJump);

        assertTrue(isLegal);
    }

}