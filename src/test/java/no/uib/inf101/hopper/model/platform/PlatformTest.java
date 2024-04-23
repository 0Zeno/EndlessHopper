package no.uib.inf101.hopper.model.platform;

import org.junit.jupiter.api.Test;

import static java.util.Objects.deepEquals;

public class PlatformTest {
    @Test
    public void TestGetPlatformX(){
        Platform platform1 = new Platform(10, 'R', 10, 100, 25, 0, 'R');
        Platform platform2 = new Platform(20, 'R', 10, 100, 25, 0, 'R');

        platform1.getPlatformX();

        deepEquals(platform1, platform2);


    }
}
