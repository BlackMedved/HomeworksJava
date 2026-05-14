package alfa.homework6.delivery.service;

import alfa.homework6.delivery.model.Parcel;

public class ParcelService {
    public void printParcelsReport(Parcel[] parcels) {
        for(int i = 0; i < parcels.length; i++) {
            System.out.printf("Посылка №%d:\n", i + 1);
            parcels[i].printInfo();
            System.out.printf("Стоимость доставки: %.2f руб.\n\n", parcels[i].calculateDeliveryPrice());
        }
    }
}
