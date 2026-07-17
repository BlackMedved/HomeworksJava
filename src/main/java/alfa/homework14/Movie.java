package alfa.homework14;

public class Movie {
    private String name;
    private double rate;

    public Movie() {}

    public Movie(String name, double rate) {
        this.name = name;
        if (rate < 1) {
            this.rate = 1;
        } else this.rate = Math.min(rate, 10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate < 1) {
            this.rate = 1;
        } else this.rate = Math.min(rate, 10);
    }

    @Override
    public String toString() {
        return name + ": " + rate;
    }
}
