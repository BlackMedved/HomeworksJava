package alfa.homework15;

public class BoardGame {
    private String name;
    private int minimalPlayerAge;
    private double dayRentCost;
    private boolean isRented;

    public BoardGame() {
        this.name = "без названия";
        this.minimalPlayerAge = 0;
        this.dayRentCost = 100;
        this.isRented = false;
    }

    public BoardGame(String name, int minimalPlayerAge, double dayRentCost) {
        if (name == null || name.isEmpty() || minimalPlayerAge < 0 || dayRentCost <=0)
            throw new IllegalArgumentException();
        this.name = name;
        this.minimalPlayerAge = minimalPlayerAge;
        this.dayRentCost = dayRentCost;
        this.isRented = false;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name=" + name +
                ", minimalPlayerAge='" + minimalPlayerAge + '\'' +
                ", dayRentCost=" + dayRentCost +
                ", isRented=" + isRented +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
    }

    public int getMinimalPlayerAge() {
        return minimalPlayerAge;
    }

    public void setMinimalPlayerAge(int minimalPlayerAge) {
        if (minimalPlayerAge < 0) throw new IllegalArgumentException();
        this.minimalPlayerAge = minimalPlayerAge;
    }

    public double getDayRentCost() {
        return dayRentCost;
    }

    public void setDayRentCost(double dayRentCost) {
        if (dayRentCost <= 0) throw new IllegalArgumentException();
        this.dayRentCost = dayRentCost;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean canBeRentedBy(int age) {
        return age >= minimalPlayerAge;
    }
}
