package alfa.homework12;

public class BaggageTicket {
    private String passengerName;
    private String flightNumber;
    private int baggageWeight;

    public BaggageTicket() {}

    public BaggageTicket(String passengerName, String flightNumber, int baggageWeight){
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.baggageWeight = baggageWeight;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return String.format("""
                --- Багажная бирка ---
                Имя пассажира: %s
                Номер рейса: %s
                Вес багажа: %d
                """, passengerName, flightNumber, baggageWeight);
    }
}
