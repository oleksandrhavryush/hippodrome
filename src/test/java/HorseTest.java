import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class HorseTest {

    @Test
    public void testConstructorWithNullName() {
        String name = null;
        double speed = 10.0;
        double distance = 0.0;

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

    }

    @Test
    public void testNullNameErrorMessage() {
        String name = null;
        double speed = 10.0;
        double distance = 0.0;
        String expectedMessage = "Name cannot be null.";


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "''",
            "' '",
            "'\t'",
            "'\n'"
    })
    void testInvalidNameWithWhitespaceErrorMessage(String name) {
        double speed = 10.0;
        double distance = 0.0;
        String expectedMessage = "Name cannot be blank.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "''",
            "' '",
            "'\t'",
            "'\n'"
    })
    void testConstructorWithEmptyOrWhitespaceName(String name) {
        double speed = 10.0;
        double distance = 0.0;
        String expectedMessage = "Name cannot be blank.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    public void testConstructorWithNegativeSpeed() {
        String name = "Pferd";
        double speed = -10.0;
        double distance = 0.0;

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

    }

    @Test
    public void testMessageWithNegativeSpeed() {
        String name = "Pferd";
        double speed = -10.0;
        double distance = 0.0;
        String expectedMessage = "Speed cannot be negative.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testConstructorWithNegativeDistance() {
        String name = "Pferd";
        double speed = 10.0;
        double distance = -1.0;

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

    }

    @Test
    public void testMessageWithNegativeDistance() {
        String name = "Pferd";
        double speed = 10.0;
        double distance = -1.0;
        String expectedMessage = "Distance cannot be negative.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getNameTest() {
        String name = "Pferd";
        double speed = 10.0;
        double distance = 1.0;

        Horse horse = new Horse(name, speed, distance);

        assertEquals(name, horse.getName());
    }

    @Test
    void getSpeedTest() {
        String name = "Pferd";
        double speed = 10.0;
        double distance = 1.0;

        Horse horse = new Horse(name, speed, distance);

        assertEquals(speed, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        String name = "Pferd";
        double speed = 10.0;
        double distance = 1.0;

        Horse horse = new Horse(name, speed, distance);

        assertEquals(distance, horse.getDistance());
    }

    @Test
    void getDistanceReturnZeroTest() {
        String name = "Pferd";
        double speed = 10.0;

        double expectedDistance = 0.0;

        Horse horse = new Horse(name, speed);

        assertEquals(expectedDistance, horse.getDistance());
    }

    @Test
    void testMoveCallsGetRandomDouble() {

        try (MockedStatic<Horse> horseMock = mockStatic(Horse.class)) {
            String name = "Pferd";
            double speed = 10.0;
            double distance = 1.0;

            Horse horse = new Horse(name, speed, distance);

            double expectedMin = 0.2;
            double expectedMax = 0.9;
            horseMock.when(() -> Horse.getRandomDouble(expectedMin, expectedMax)).thenReturn(0.5); // Приклад значення для тесту

            horse.move();

            horseMock.verify(() -> Horse.getRandomDouble(expectedMin, expectedMax));
        }
    }

    @Test
    void testMoveCalculatesDistance() {
        String name = "Pferd";
        double speed = 10.0;
        double initialDistance = 1.0;


        try (MockedStatic<Horse> horseMock = mockStatic(Horse.class)) {
            double expectedRandomValue = 0.5;

            horseMock.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(expectedRandomValue);

            Horse horse = new Horse(name, speed, initialDistance);

            horse.move();

            double expectedDistance = initialDistance + speed * expectedRandomValue;

            assertEquals(expectedDistance, horse.getDistance());
        }
    }
}