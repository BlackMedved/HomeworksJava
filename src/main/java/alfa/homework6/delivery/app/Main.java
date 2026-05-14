package alfa.homework6.delivery.app;

import alfa.homework6.delivery.model.*;
import alfa.homework6.delivery.service.ParcelService;

public class Main {
    static void main() {
        Parcel parcel = new Parcel("Арнольд Шварценеггер", "г. Москва, ул. Арбат, д. 1",
                150.6, "112314112");
        FragileParcel fragileParcel = new FragileParcel("Надежда Кадышева",
                "г. Нижний Новгород, ул. Бориса Панина, д. 2", 2, "112314113",
                true);
        ExpressParcel expressParcel = new ExpressParcel("Клим Саныч",
                "г. Санкт-Петербург, ул. Адмиралтейская, д. 1", 0.25, "112314113",
                4);
        Parcel emptyParcel = new Parcel();

        Parcel[] parcels = new Parcel[] {parcel, fragileParcel, expressParcel, emptyParcel};

        ParcelService parcelService = new ParcelService();
        parcelService.printParcelsReport(parcels);
    }
}
