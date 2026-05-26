package alfa.homework7.arena.heroes;

public class Knight extends Hero {
    private int armor;

    public Knight() {
        super();
    }

    public Knight(String name, int level, int health, int armor) {
        super(name, level, health);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void attack() {
        System.out.println("Рыцарь бьёт мечом!");
    }

    @Override
    public String toString() {
        return super.toString() + "Броня: " + armor + "\n";
    }

    @Override
    public void takeDamage(int damage) {
        int diffDamageToArmor = armor - damage;
        if (diffDamageToArmor >= 0) {
            armor = armor - damage;
        }
        else {
            armor = 0;
            setHealth(getHealth() + diffDamageToArmor);
        }
    }

//    @Override
//    public final void rest() {
//        System.out.println("Рыцарь отдыхает и восстанавливает силы.");
//    }
}
