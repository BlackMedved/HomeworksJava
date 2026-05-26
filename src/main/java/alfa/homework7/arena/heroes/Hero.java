package alfa.homework7.arena.heroes;

public class Hero {
    private String name;
    private int level;
    private int health;
    final static int MAX_LEVEL = 100;
    private static int heroesCreated;

    public Hero() {}

    public Hero(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;

        heroesCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("""
                ___
                Имя героя: %s
                Уровень: %d
                Текущее здоровье: %d
                """, name, level, health);
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public void levelUp() {
        if (level < MAX_LEVEL) {
            level++;
        }
    }

    public void attack() {
        System.out.println("Герой наносит обычный удар.");
    }

    public void attack(String target) {
        attack();
        System.out.println("Цель: " + target);
    }

    public void attack(String target, int times) {
        System.out.println("Герой атакует цель " + target + " " + times + " раза.");
    }

    public static void printHeroesCreated() {
        System.out.println("Всего создано героев: " + heroesCreated);
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }
}
