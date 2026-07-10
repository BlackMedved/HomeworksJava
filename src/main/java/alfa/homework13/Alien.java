package alfa.homework13;

import java.util.Objects;

public class Alien {
    private String name;
    private String planet;
    private int dangerLevel;

    public Alien() {}

    public Alien(String name, String planet, int dangerLevel) {
        this.name = name;
        this.planet = planet;
        if (dangerLevel > 10) this.dangerLevel = 10;
        else this.dangerLevel = Math.max(dangerLevel, 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        if (dangerLevel > 10) this.dangerLevel = 10;
        else this.dangerLevel = Math.max(dangerLevel, 1);
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Alien alien = (Alien) object;
        return name.equals(alien.getName()) && planet.equals(alien.getPlanet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet);
    }

    @Override
    public String toString() {
        return String.format("""
                Имя пришельца: %s
                Планета происхождения: %s
                Уровень опасности: %d
                """, name, planet, dangerLevel);
    }
}
