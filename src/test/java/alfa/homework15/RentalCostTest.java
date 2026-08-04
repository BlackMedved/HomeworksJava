package alfa.homework15;

import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RentalCostTest {
    @Test
    public void throwExceptionWhenBoardGameIsNullInCalculateCostMethod() {
        GameRental gameRental = new GameRental();
        assertThrows(
                IllegalArgumentException.class,
                () -> gameRental.calculateCost("Some game", 5),
                "Не отрабатывает исключение при не существующей игре в методе рассчета стоимости аренды"
        );
    }

    @ParameterizedTest
    @CsvSource({
            "-350",
            "-1",
            "0"
    })
    public void throwExceptionWhenDaysIsNegativeOrZeroInCalculateCostMethod(int days) {
        GameRental gameRental = new GameRental();
        BoardGame boardGame = new BoardGame();
        gameRental.addBoardGame(boardGame);
        assertAll(
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> gameRental.calculateCost(boardGame.getName(), days),
                        "Не отрабатывает исключение при передаче отрицательных дней или нуля в методе " +
                                "рассчета стоимости аренды")
        );
    }

    @ParameterizedTest
    @MethodSource("parametersToCalculateCostMethod")
    public void returnCorrectValueFromCalculateCostMethod(BoardGame boardGame, int days, double expectedCost) {
        GameRental gameRental = new GameRental();
        gameRental.addBoardGame(boardGame);
        assertEquals(expectedCost, gameRental.calculateCost(boardGame.getName(), days), "Некорректно " +
                "считается цена аренды");
    }

    static Stream<Arguments> parametersToCalculateCostMethod() {
        return Stream.of(
                Arguments.arguments(new BoardGame("Heroes", 14, 400.33), 21, 8406.93),
                Arguments.arguments(new BoardGame("Monsters", 16, 150), 99, 14850),
                Arguments.arguments(new BoardGame("Dolls", 0, 1), 1, 1),
                Arguments.arguments(new BoardGame("Rally", 7, 123.23), 7, 862.61)
        );
    }

    @Test
    public void returnsNoErrorWhenGameRentalIsEmptyInResetMethod() {
        GameRental gameRental = new GameRental();
        try {
            gameRental.reset();
        }
        catch (Exception exception) {
            Assertions.fail("Возникла ошибка в методе сброса состояния при пустом списке");
        }
        assertEquals(0, gameRental.size(), "Некорректная работа метода сброса состояния " +
                "при пустом списке");
    }

    @Test
    public void correctWorkOfResetMethod() {
        Faker faker = new Faker();
        Random random = new Random();
        GameRental gameRental = new GameRental();
        for (int i = 0; i < 5; i++) {
            String name = faker.boardgame().name();
            while (gameRental.getBoardGame(name) != null) {
                name = faker.boardgame().name();
            }
            int age = random.nextInt(0, 21);
            double rent = random.nextInt(1, 5000) + Double.parseDouble(String.format("%.2f",
                    random.nextDouble()).replace(',', '.'));

            gameRental.addBoardGame(new BoardGame(name, age, rent) {{ setRented(true); }});
        }
        gameRental.reset();
        BoardGame rentedBoardGame = gameRental.getBoardGameList().stream().filter(BoardGame::isRented)
                .findFirst().orElse(null);
        assertNull(rentedBoardGame, "Метод сброса состояния работает не для всех элементов");
    }
}
