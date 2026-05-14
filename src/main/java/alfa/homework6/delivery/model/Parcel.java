package alfa.homework6.delivery.model;

public class Parcel {
    private String receiverName;
    private String address;
    protected double parcelWeight;
    String trackNumber;

    public Parcel() {}

    public Parcel(String receiverName, String address, double parcelWeight, String trackNumber) {
        this.receiverName = receiverName;
        this.address = address;
        this.parcelWeight = parcelWeight;
        this.trackNumber = trackNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(double parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public double calculateDeliveryPrice() {
        return 100 + parcelWeight * 30;
    }

    public void printInfo() {
        System.out.printf("""
                Имя получателя: %s
                Адрес доставки: %s
                Вес посылки: %.3f кг.
                Трек-номер: %s
                """, getReceiverName(), getAddress(), getParcelWeight(), trackNumber);
    }
}
