package no.uib.inf101.hopper.model.platform;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatformTest {
    @Test
    public void TestSetPlatformSide(){
        Platform platform1 = new Platform(20, 'R', 10, 100, 25, 0, 'R');
        Platform platform2 = new Platform(10, 'L', 10, 100, 25, 0, 'R');
        platform2.setPlatformSide('R');
        assertEquals(platform1.getPlatformX(), platform2.getPlatformX());
    }

    @Test
    public void TestMovePlatformDownByFive(){
        Platform platform1 = new Platform(20, 'R', 10, 100, 25, 0, 'R');
        Platform platform2 = new Platform(20, 'R', 5, 100, 25, 0, 'R');
        platform2.movePlatformDown(5);


        assertEquals(platform1.getPlatformY(), platform2.getPlatformY());
    }

    @Test
    public void TestMovePlatformToTop(){
        Platform platform = new Platform(10, 'L', 800, 100, 25, 0, 'R');
        platform.movePlatformToTop();
        assertEquals(platform.getPlatformY(), 0);
    }
}
