package alfa.homework11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static void main() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество воды в мл:");
        int waterAmount = 0;
        try {
            waterAmount = scanner.nextInt();
        }
        catch(InputMismatchException exception) {
            System.out.println("Ошибка: нужно было ввести число.");
        }
        scanner.close();

        try {
            coffeeMachine.makeCoffee(100);
        }
        catch (NotEnoughWaterException exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Проверка кофемашины завершена.");
        }

        try {
            coffeeMachine.calculateCups(1000, 0);
        }
        catch (ArithmeticException exception) {
            System.out.println("Ошибка: размер чашки не может быть 0.");
        }

        String coffeeName = null;
        try {
            coffeeMachine.printCoffeeName(coffeeName);
        }
        catch (NullPointerException exception) {
            System.out.println("Ошибка: название кофе отсутствует.");
        }

        System.out.println("\n------\n");

        if (waterAmount > 200) {
            try {
                coffeeMachine.makeCoffee(waterAmount);
                System.out.println(coffeeMachine.calculateCups(waterAmount, 200));
                coffeeMachine.printCoffeeName("Капучино");
            }
            catch (NotEnoughWaterException exception) {
                System.out.println(exception.getMessage());
            }
            catch (ArithmeticException exception) {
                System.out.println("Ошибка: размер чашки не может быть 0.");
            }
            catch (NullPointerException exception) {
                System.out.println("Ошибка: название кофе отсутствует.");
            }
        }
    }
}
