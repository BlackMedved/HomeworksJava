package alfa.homework6.delivery.model;

public class ExpressParcel extends Parcel {
    private int deliveryHours;

    public ExpressParcel() {
        super();
    }

    public ExpressParcel(String receiverName, String address, double parcelWeight, String trackNumber,
                         int deliveryHours) {
        super(receiverName, address, parcelWeight, trackNumber);
        this.deliveryHours = deliveryHours;
    }

    public int getDeliveryHours() {
        return deliveryHours;
    }

    public void setDeliveryHours(int deliveryHours) {
        this.deliveryHours = deliveryHours;
    }

    @Override
    public double calculateDeliveryPrice() {
        double markup = 0;
        if (deliveryHours < 24) {
            markup = 500;
        }
        return super.calculateDeliveryPrice() + markup;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Deadline доставки: %d ч.\n", getDeliveryHours());
    }
}
