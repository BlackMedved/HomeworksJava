package alfa.homework16.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.List;
import java.util.Map;

public class BookingSteps {
    @Дано("Получить информацию по столикам")
    public void getTableInformation() {
        System.out.println("Информация по столикам получена");
    }

    @И("Есть свободный столик на {int} человек")
    public void setFreeTable(int count) {
        System.out.println("Свободный столик на " + count + " человек доступен");
    }

    @Когда("Клиент {word} бронирует столик на {int} человек")
    public void bookTable(String client, int count) {
        System.out.println("Бронирование столика на имя " + client + " на " + count + " человек");
    }

    @Тогда("Бронирование столика {word}")
    public void bookingTableSuccess(String status) {
        if (status.equals("успешно")) {
            System.out.println("Столик успешно забронирован");
        }
        if (status.equals("невозможно")) {
            System.out.println("Бронирование столика невозможно");
        }
    }

    @И("Клиент {word} ранее бронировал столик на {int} человек")
    public void setBookedTable(String client, int count) {
        System.out.println("У пользователя " + client + " есть бронирование столика на " + count + " человек");
    }

    @Когда("Клиент {word} отменяет бронирование")
    public void rejectBookingTable(String client) {
        System.out.println("Бронирование на клиента " + client + " отменяется");
    }

    @Тогда("Бронирование столика успешно отменено")
    public void rejectBookingTableSuccess() {
        System.out.println("Бронирование успешно отменено");
    }

    @Дано("В ресторан добавлены столики:")
    public void addTables(DataTable dataTable) {
        List<Map<String, String>> tables = dataTable.asMaps(String.class, String.class);

        System.out.println("Добавлены следующие столики:\n");

        for (Map<String, String> row : tables) {
            int number = Integer.parseInt(row.get("number"));
            int capacity = Integer.parseInt(row.get("capacity"));
            boolean booked = Boolean.parseBoolean(row.get("booked"));

            System.out.println("Столик номер " + number + " на " + capacity + " человек: " +
                    (booked ? "Забронирован" : "Свободен"));
        }
    }

    @И("Гость оставляет пожелание к брони:")
    public void setBookingMessage(String message) {
        System.out.println("Пожелание: " + message);
    }

    @Тогда("Пожелание успешно добавляется к брони")
    public void setBookingMessageSuccess() {
        System.out.println("Пожелание успешно добавлено");
    }

    @Когда("^Клиент (уменьшает|увеличивает) бронь на (\\d+) человека$")
    public void changeBookTableCapacity(String action, int count) {
        switch (action) {
            case "уменьшает": {
                System.out.println("Количество человек в брони уменьшено на " + count);
                break;
            }
            case "увеличивает": {
                System.out.println("Количество человек в брони увеличено на " + count);
                break;
            }
        }
    }

    @Тогда("Изменение количества человек в брони выполнено успешно")
    public void changeBookTableCapacitySuccess() {
        System.out.println("Успешное изменение количества человек в брони");
    }
}
