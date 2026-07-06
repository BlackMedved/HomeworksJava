package alfa.homework12.exceptions;

public class FlightNotFoundException extends AirportServiceException {
    public FlightNotFoundException() {
        super("Указанного рейса нет в списке доступных рейсов!\nПроверьте номер рейса!\n");
    }
}
