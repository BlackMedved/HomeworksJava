package alfa.homework7.arena;

import alfa.homework7.arena.heroes.*;

public class App {
    static void main() {
        Hero[] heroes = {
                new Knight("Арториас Путник Бездны", 100, 1000, 1000),
                new Archer("Серебряный рыцарь", 34, 345, 43),
                new Mage("Знаток кристальных чар", 54, 202, 950)
        };

        for(Hero hero: heroes) {
            hero.printInfo();
            hero.attack();
        }

        final Knight knight = new Knight("Сигвард из Катарины", 100, 420, 300);
        System.out.println(knight);

        knight.levelUp();
        knight.takeDamage(34);
        knight.attack("Гигант Йорм", 3);
        knight.takeDamage(500);
        knight.setHealth(knight.getHealth() + 20);

        System.out.println(knight);

        knight.rest();

        Hero.printHeroesCreated();
    }
}
