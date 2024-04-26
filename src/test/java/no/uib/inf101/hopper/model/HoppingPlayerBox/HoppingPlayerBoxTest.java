package no.uib.inf101.hopper.model.HoppingPlayerBox;

import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import org.junit.jupiter.api.Test;

import static java.util.Objects.deepEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoppingPlayerBoxTest {
    @Test
    public void TestHopLeft(){
        HoppingPlayerBox playerBox1 = new  HoppingPlayerBox(345, 100, 50, 50, 'R', 0);
        HoppingPlayerBox playerBox2 = new  HoppingPlayerBox(195, 0, 50, 50, 'L', 1);

        deepEquals(playerBox2, playerBox1.playerHopToLeft(100));
    }

    @Test
    public void TestHopRight(){
        HoppingPlayerBox playerBox1 = new  HoppingPlayerBox(195, 100, 50, 50, 'L', 0);
        HoppingPlayerBox playerBox2 = new  HoppingPlayerBox(345, 0, 50, 50, 'R', 1);

        deepEquals(playerBox2, playerBox1.playerHopToLeft(100));
    }
}