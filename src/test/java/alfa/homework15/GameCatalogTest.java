package alfa.homework15;

import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GameCatalogTest {

    @Test
    public void correctAddingBoardGameToGameRental() {
        GameRental gameRental = new GameRental();
        BoardGame boardGame = new BoardGame();
        gameRental.addBoardGame(boardGame);
        assertEquals(1, gameRental.size(), "Некорректное добавление элемента");
    }

    @Test
    public void correctGettingBoardGameFromGameRentalWhenBoardGameExists() {
        GameRental gameRental = new GameRental();
        BoardGame boardGame = new BoardGame();
        gameRental.addBoardGame(boardGame);
        assertEquals(boardGame, gameRental.getBoardGame(boardGame.getName()), "Некорректный поиск элемента");
    }

    @Test
    public void correctGettingNullFromGameRentalWhenBoardGameDoesNotExists() {
        GameRental gameRental = new GameRental();
        BoardGame boardGame = new BoardGame();
        gameRental.addBoardGame(boardGame);
        assertNull(gameRental.getBoardGame("пустое"), "Некорректный поиск элемента");
    }

    @Test
    public void throwsExceptionWhenTryingToAddDuplicateOrNull() {
        GameRental gameRental = new GameRental();
        BoardGame boardGame1 = new BoardGame();
        gameRental.addBoardGame(boardGame1);
        BoardGame boardGame2 = new BoardGame();
        assertAll("Проверка на возникающее исключение при добавлении дубликата или пустого значения",
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> gameRental.addBoardGame(boardGame2),
                        "Не отрабатывает исключение при добавлении дубля"
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> gameRental.addBoardGame(null),
                        "Не отрабатывает исключение при добавлении пустого значения"
                )
        );

    }
}
