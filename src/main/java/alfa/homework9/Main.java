package alfa.homework9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import net.datafaker.Faker;
import com.github.lalyos.jfiglet.FigletFont;

public class Main {
    static void main() throws IOException {
        String firstPart = getRandomLastName();
        String secondPart = "&";
        Faker faker = new Faker();
        String thirdPart = faker.name().lastName();

        System.out.println(FigletFont.convertOneLine(firstPart));
        System.out.println(FigletFont.convertOneLine(secondPart));
        System.out.println(FigletFont.convertOneLine(thirdPart));

        System.out.println(faker.name().fullName());
        System.out.println(faker.phoneNumber().phoneNumberInternational());
        System.out.println(faker.address().fullAddress());
    }

    public static String getRandomLastName() {
        ArrayList<String> lastNamesList = new ArrayList<>();
        Collections.addAll(lastNamesList, "Gogdan", "Baskov", "White", "Sidorov", "Karamislov");
        Random random = new Random();
        return lastNamesList.get(random.nextInt(lastNamesList.size()));
    }
}
