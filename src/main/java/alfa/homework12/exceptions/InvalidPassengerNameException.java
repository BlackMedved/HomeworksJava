package alfa.homework12.exceptions;

public class InvalidPassengerNameException extends RuntimeException {
    public InvalidPassengerNameException() {
        super("[ОШИБКА] Имя пасажира null или пустое!\n");
    }
}
