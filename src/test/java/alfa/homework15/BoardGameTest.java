package alfa.homework15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameTest {
    @Test
    public void boardGameClassIsCorrect() {
        BoardGame boardGame = new BoardGame();
        String boardGameClass = String.valueOf(boardGame.getClass());
        assertEquals("BoardGame", boardGameClass, "Создан экземпляр с некорректным классом");
    }

    @Test
    public void boardGamePropertiesCorrectlyAddedInConstructor() {
        String name = "Подземелья и драконы";
        int minimalPlayerAge = 14;
        double rentCost = 300;
        BoardGame boardGame = new BoardGame(name, minimalPlayerAge, rentCost);
        String[] result = boardGame.toString().split("[,{}:]");
        assertAll("Проверка добавления параметров через конструктор",
                () -> assertEquals(name, result[2], "Некорректное название игры"),
                () -> assertEquals(minimalPlayerAge, result[5], "Некорректный возраст"),
                () -> assertEquals(rentCost, result[7], "Некорректное название игры"),
                () -> assertEquals(false, result[9], "Некорректное значение брони")
                );
    }
}
