package alfa.homework12.exceptions;

public class BaggageTagPrintException extends AirportServiceException {
    public BaggageTagPrintException() {
        super("Не получилось напечатать багажную бирку!\nПроверьте состояние принтера и повторите попытку!\n");
    }
}
