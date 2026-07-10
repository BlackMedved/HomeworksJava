package alfa.homework13;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void main() {
        // Вывод для части 1: База данных пришельцев
        ArrayList<Alien> aliens = new ArrayList<>(Arrays.asList(
                new Alien("Evgeniy","Jupiter",10),
                new Alien("Chupacabra","Alpha Centauri",7),
                new Alien("Caucasian","Kepler-452b",1),
                new Alien("Evgeniy","Jupiter",4),
                new Alien("Twin","HD 63433d",6)
        ));

        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            for (int j = i + 1; j <= aliens.size() - 1; j++) {
                Alien otherAlien = aliens.get(j);
                if (alien.equals(otherAlien)) {
                    System.out.printf("Пришелец -\n%sДубликат пришельца -\n%s\n",alien, otherAlien);
                }
            }
        }

        // Вывод для части 2: Формирование отрядов
        System.out.println("Формирование отряда: " + SquadManager.demonstrateListCreations() + "\n");

        // Вывод для части 3: Отсеивание трусов
        ArrayList<String> squad = new ArrayList<>(Arrays.asList("Sam", "Трус Smithy", "Tom", "Clementine",
                "Трус Boris"));
        SquadManager.filterOutCowards(squad);
        System.out.println();

        // Вывод для части 4: Очередь на вход
        AssaultQueue assaultQueue = new AssaultQueue() {{
            addRecruit("Adam");
            addRecruit("Ava");
            addRecruit("Liam");
            addRecruit("Lucas");
            addRecruit("Amelia");
        }};
        System.out.println("Из очереди уходят два человека:\n" + assaultQueue.retreatCoward() + "\n" +
                assaultQueue.retreatCoward());
        assaultQueue.addRecruit("John");
        assaultQueue.addRecruit("Jim");
        assaultQueue.addRecruit("Mickael");
        assaultQueue.printQueue();
        System.out.println();

        // Вывод для части 5: Отчёт командованию
        aliens.remove(1);
        aliens.remove(3);
        MissionReport missionReport1 = new MissionReport("Штурм зоны 51", aliens, 50);
        System.out.println(missionReport1);
        MissionReport missionReport2 = new MissionReport("Штурм зоны 51", aliens, 50);
        System.out.printf("Результат сравнения через == : %b\n", missionReport1 == missionReport2);
        System.out.printf("Результат сравнения через equals : %b", missionReport1.equals(missionReport2));
    }
}
