package alfa.homework12;

import alfa.homework12.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        String[] flights = {"SU-123", "TK-777", "KC-909", "AE-404"};
        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(new ArrayList<>(List.of(flights)));

        String[] arrayBaggage = new String[] {"Ivanov Ivan, KC-909, 22", "Semenov Igor, MA-111, 11",
                "Kim Chi, TK-777, 40", "Meladze Iakov, AE-404, 7", ", SU-123, 0", "Kovaleva Anna, TK-777, -5"};

        for (String baggage: arrayBaggage) {
            String[] splitArray = baggage.split(", ");
            try {
                BaggageTicket baggageTicket = baggageDropDesk.CheckInBaggage(splitArray[0], splitArray[1],
                        Integer.parseInt(splitArray[2]));
                System.out.println(baggageTicket);
            }
            catch (NumberFormatException exception) {
                System.out.println("[ОШИБКА] В процессе конвертации String в int произошла ошибка!\n");
            }
            catch (InvalidPassengerNameException | InvalidBaggageWeightException | AirportServiceException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }
}
