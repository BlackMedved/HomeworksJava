package alfa.homework15;

import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GameRentalTest {
    private GameRental gameRental;
    private String randomName;

    @BeforeEach
    public void generateGameRental() {
        Random random = new Random();
        Faker faker = new Faker();
        int index = random.nextInt(0, 5);
        gameRental = new GameRental();
        for (int i = 0; i < 5; i++) {
            String name = faker.boardgame().name();
            while (gameRental.getBoardGame(name) != null) {
                name = faker.boardgame().name();
            }
            if (i == index) {
                randomName = name;
            }
            int age = random.nextInt(0, 21);
            double rent = random.nextInt(1, 5000) + Double.parseDouble(String.format("%.2f",
                    random.nextDouble()).replace(',', '.'));
            gameRental.addBoardGame(new BoardGame(name, age, rent));
        }
    }

    @Test
    public void throwExceptionWhenGameNotExistsInRentMethod() {
        assertThrows(
                IllegalArgumentException.class,
                () -> gameRental.rentGame("без названия", 6),
                "Не отрабатывает исключение при не существующей игре в списке"
        );
    }

    @ParameterizedTest
    @MethodSource("parametersToRentMethod")
    public void returnCorrectBoolValueFromRentMethod(BoardGame boardGame, int age, boolean expectedBool) {
        gameRental.addBoardGame(boardGame);
        assertEquals(expectedBool, gameRental.rentGame(boardGame.getName(), age), "Возвращается некорректное" +
                " значение в методе аренды");
    }

    @Test
    public void reallyRentedGameInRentMethod() {
        gameRental.rentGame(randomName, gameRental.getBoardGame(randomName).getMinimalPlayerAge() + 1);
        assertTrue(gameRental.getBoardGame(randomName).isRented(), "Некотрректное значение поля 'арендовано'");
    }

    static Stream<Arguments> parametersToRentMethod() {
        return Stream.of(
                Arguments.arguments( new BoardGame("Heroes", 12, 200), 10, false),
                Arguments.arguments( new BoardGame("Racing", 14, 300) {{
                    setRented(true);
                }}, 16, false),
                Arguments.arguments( new BoardGame("Mutants", 18, 500), 21, true)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Game does not exist, false, false",
            "random, false, false",
            "random, true, true",
    })
    public void returnCorrectBoolValueFromReturnGameMethod(String name, boolean isRented, boolean expectedBool) {
        if (name.equals("random")) name = randomName;
        if (isRented) gameRental.rentGame(name, gameRental.getBoardGame(name).getMinimalPlayerAge() + 1);
        assertEquals(expectedBool, gameRental.returnGame(name), "Возвращается некорректное значение в методе" +
                " возврата игры");
    }

    @Test
    public void reallyReturnedGameInReturnGameMethod() {
        gameRental.rentGame(randomName, gameRental.getBoardGame(randomName).getMinimalPlayerAge() + 1);
        gameRental.returnGame(randomName);
        assertFalse(gameRental.getBoardGame(randomName).isRented(), "Некотрректное значение поля 'арендовано'");
    }
}
