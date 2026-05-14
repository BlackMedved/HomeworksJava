package alfa.homework6.delivery.model;

public class FragileParcel extends Parcel {
    private boolean requiresCarefulHandling;

    public FragileParcel() {
        super();
    }

    public FragileParcel (String receiverName, String address, double parcelWeight, String trackNumber,
                          boolean requiresCarefulHandling) {
        super(receiverName, address, parcelWeight, trackNumber);
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    public boolean isRequiresCarefulHandling() {
        return requiresCarefulHandling;
    }

    public void setRequiresCarefulHandling(boolean requiresCarefulHandling) {
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    @Override
    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + 200;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Аккуратная доставка: %s\n", isRequiresCarefulHandling() ? "Да" : "Нет");
    }
}
