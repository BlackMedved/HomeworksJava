package alfa.homework15;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

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
                () -> assertFalse(boardGame.isRented(), "Некорректное значение брони")
                );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "null, 3, 200",
            ", 5, 300",
            "Уно, -2, 500",
            "Манчкин, 14, 0",
            "Ведьмак, 16, -100" },
            nullValues = {"null"})
    public void errorWhileAddingIncorrectPropertiesInConstructor(String name, int minimalPlayerAge, double dayRentCost) {
        assertThrows(
                IllegalArgumentException.class,
                () -> { new BoardGame(name, minimalPlayerAge, dayRentCost); },
                "Не отрабатывает исключение при вводе некорректных данных в конструктор"
        );
    }

    @Test
    public void boardGamePropertiesCorrectlyChangingWithGettersAndSetters() {
        Faker faker = new Faker();
        Random random = new Random();
        BoardGame boardGame = new BoardGame();
        String name = faker.boardgame().name();
        int age = random.nextInt(0, 100);
        double rent = random.nextInt(1, 5000) + Double.parseDouble(String.format("%.2f",
                random.nextDouble()).replace(',', '.'));
        boardGame.setName(name);
        boardGame.setMinimalPlayerAge(age);
        boardGame.setDayRentCost(rent);
        assertAll("Проверка изменения параметров через геттеры и сеттеры",
                () -> assertEquals(name, boardGame.getName(), "Некорректное название игры"),
                () -> assertEquals(age, boardGame.getMinimalPlayerAge(), "Некорректный возраст"),
                () -> assertEquals(rent, boardGame.getDayRentCost(), "Некорректное название игры"),
                () -> assertFalse(boardGame.isRented(), "Некорректное значение брони")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "16, 16, true",
            "12, 25, true",
            "0, 0, true",
            "18, 17, false",
            "6, 2, false"
    })
    public void canBeRentedByWorksCorrectAccordingToAgeChanging(int minimalPlayerAge, int age, boolean expectedResult) {
        BoardGame boardGame = new BoardGame();
        boardGame.setMinimalPlayerAge(minimalPlayerAge);
        boolean canBeRantedByAge = boardGame.canBeRentedBy(age);
        assertEquals(expectedResult, canBeRantedByAge, "Метод возвращает некорректное значение");
    }
}
