package alfa.homework12;

import alfa.homework12.exceptions.*;

import java.util.ArrayList;

public class BaggageDropDesk {
    private ArrayList<String> availableFlights;

    public BaggageDropDesk(ArrayList<String> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public BaggageTicket CheckInBaggage(String passengerName, String flightNumber, int baggageWeight) throws
            AirportServiceException {
        if (passengerName == null || passengerName.isEmpty()) throw new InvalidPassengerNameException();
        if (baggageWeight < 0) throw new InvalidBaggageWeightException();
        if (!availableFlights.contains(flightNumber)) throw new FlightNotFoundException();
        if (baggageWeight > 23) throw new OverweightBaggageException();
        if (flightNumber.equals("AE-404")) throw new BaggageTagPrintException();

        System.out.println("Необходимо уплатить налог за правильно введенные данные!");

        return new BaggageTicket(passengerName, flightNumber, baggageWeight);
    }
}
