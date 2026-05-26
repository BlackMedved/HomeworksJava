package alfa.homework7.arena.heroes;

public class Archer extends Hero {
    private int arrowsCount;

    public Archer() {
        super();
    }

    public Archer(String name, int level, int health, int arrowsCount) {
        super(name, level, health);
        this.arrowsCount = arrowsCount;
    }

    public int getArrowsCount() {
        return arrowsCount;
    }

    public void setArrowsCount(int arrowsCount) {
        this.arrowsCount = arrowsCount;
    }

    @Override
    public void attack() {
        if (arrowsCount - 1 >= 0) {
            System.out.println("Лучник выпускает стрелу!");
            arrowsCount--;
        }
        else {
            System.out.println("Лучник ничего не выпускает, у него недостаточно стрел!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Количество стрел: " + arrowsCount + "\n";
    }
}
