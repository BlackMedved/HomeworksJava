package alfa.homework7.arena.heroes;

public class Mage extends Hero {
    public int mana;
    public final int FIREBALL_MANA_COST = 10;

    public Mage() {
        super();
    }

    public Mage(String name, int level, int health, int mana) {
        super(name, level, health);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack() {
        if (mana - FIREBALL_MANA_COST >= 0) {
            System.out.println("Маг запускает огненный шар!");
            mana = mana - FIREBALL_MANA_COST;
        }
        else {
            System.out.println("Маг ничего не запускает, у него недостаточно маны!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Мана: " + mana + "\n";
    }
}
