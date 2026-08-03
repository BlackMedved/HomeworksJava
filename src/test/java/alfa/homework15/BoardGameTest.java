package alfa.homework15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameTest {
    @Test
    public void boardGameClassIsCorrect() {
        BoardGame boardGame = new BoardGame();
        String boardGameClass = boardGame.getClass().getSimpleName();
        assertEquals("BoardGame", boardGameClass, "Создан экземпляр с некорректным классом");
    }

    @Test
    public void boardGamePropertiesCorrectlyAddedInConstructor() {
        String name = "Подземелья и драконы";
        int minimalPlayerAge = 14;
        double dayRentCost = 300;
        BoardGame boardGame = new BoardGame(name, minimalPlayerAge, dayRentCost);
        assertAll("Проверка добавления параметров через конструктор",
                () -> assertEquals(name, boardGame.getName(), "Некорректное название игры"),
                () -> assertEquals(minimalPlayerAge, boardGame.getMinimalPlayerAge(), "Некорректный возраст"),
                () -> assertEquals(dayRentCost, boardGame.getDayRentCost(), "Некорректное название игры"),
                () -> assertEquals(false, boardGame.getIsRented(), "Некорректное значение брони")
                );
    }

    @ParameterizedTest
    @CsvSource({
            "null, 3, 200",
            ", 5, 300",
            "Уно, -2, 500",
            "Манчкин, 14, 0",
            "Ведьмак, 16, -100"
    })
    public void errorWhileAddingIncorrectPropertiesInConstructor(String name, int minimalPlayerAge, double dayRentCost) {
        assertThrows(
                IllegalArgumentException.class,
                () -> { new BoardGame(name, minimalPlayerAge, dayRentCost); },
                "Не отрабатывает исключение при вводе некорректных данных в конструктор"
        );
    }


}
