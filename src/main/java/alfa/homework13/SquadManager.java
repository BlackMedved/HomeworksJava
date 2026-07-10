package alfa.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {
    public static String demonstrateListCreations() {
        List<String> mainSquad = new ArrayList<>() {{
            add("John");
            add("Smithy");
            add("Hellen");
            add("Vladimir");
        }};
        List<String> supportSquad = Arrays.asList("Karen", "Sam", "Malcolm");
        List<String> eliteSquad = List.of("Abigail", "William");

        try {
            mainSquad.add("Oliver");
            supportSquad.add("Aurora");
            eliteSquad.add("Anthony");

            mainSquad.removeFirst();
            supportSquad.removeFirst();
            eliteSquad.removeFirst();
        }
        catch (Exception exception) {
            return exception.getClass().getSimpleName();
        }
        return "Успех";
    }

    public static void filterOutCowards(List<String> squad) {
        System.out.println(squad.toString());
        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.startsWith("Трус")) {
                iterator.remove();
            }
        }
        //squad.removeIf(element -> element.startsWith("Трус"));
        System.out.println(squad.toString());
    }
}
