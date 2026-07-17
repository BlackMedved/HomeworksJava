package alfa.homework14;

public class Animal {
    public String name;
    private int age;
    protected double height;
    protected double weight;
    Boolean isMammal;

    public Animal() {}

    Animal(String name, int age, double height, double weight, boolean isMammal) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.isMammal = isMammal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double getAverageWeightByOneMeter() {
        return weight / height;
    }

    boolean hasNormalAverageWeight() {
        double averageWeight = getAverageWeightByOneMeter();
        if (age > 10 || isMammal) {
            return averageWeight > 30 && averageWeight < 50;
        }
        else return averageWeight > 20 && averageWeight < 40;
    }
}
