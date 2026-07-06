package alfa.homework11;

public class CoffeeMachine {
    public void makeCoffee(int waterAmount) throws NotEnoughWaterException {
        if (waterAmount > 200) {
            System.out.println("Кофе приготовлен!");
        }
        else throw new NotEnoughWaterException("Ошибка: недостаточное количество воды (Должно быть больше 200 мл.)");
    }

    public int calculateCups(int waterAmount, int cupCapacity) {
        return waterAmount/cupCapacity;
    }

    public void printCoffeeName(String coffeeName) throws NullPointerException {
        if (coffeeName == null) throw new NullPointerException();
        System.out.println(coffeeName.toUpperCase());
    }
}
