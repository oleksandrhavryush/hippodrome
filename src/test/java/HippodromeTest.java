import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


class HippodromeTest {

    @Test
    public void testConstructorWithNullArray() {
        List<Horse> horses = null;

        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
    }

    @Test
    public void testNullNameErrorMessage() {
        List<Horse> horses = null;

        String expectedMessage = "Horses cannot be null.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithEmptyArray() {
        List<Horse> horses = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
    }

    @Test
    public void testEmptyNameErrorMessage() {
        List<Horse> horses = new ArrayList<>();

        String expectedMessage = "Horses cannot be empty.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getHorsesTest() {
        List<Horse> horses = new ArrayList<>();
        String name = "Pferd";
        double speed = 10.0;
        double distance = 1.0;

        for (int i = 1; i < 31; i++) {
            horses.add(new Horse(name + i, speed + i / 5, distance + i / 10));
        }

        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void testMove() {

        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);

        hippodrome.move();

        for (Horse horse : horses) {
            Mockito.verify(horse).move();
        }
    }

    @Test
    public void getWinnerTest(){
        List<Horse> horses = new ArrayList<>();
        String name = "Pferd";
        double speed = 10.0;
        double distance = 1.0;

        for (int i = 1; i < 31; i++) {
            horses.add(new Horse(name + i, speed + i / 5, distance + i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses.get(29), hippodrome.getWinner());
    }
}