package alfa.homework12.exceptions;

public class OverweightBaggageException extends AirportServiceException {
    public OverweightBaggageException() {
        super("Багаж слишком тяжелый!\nНеобходимо доплатить за перевес!\n");
    }
}
