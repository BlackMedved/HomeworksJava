package alfa.homework12.exceptions;

public class InvalidBaggageWeightException extends RuntimeException {
    public InvalidBaggageWeightException() {
        super("[ОШИБКА] Вес багажа меньше нуля!\n");
    }
}
