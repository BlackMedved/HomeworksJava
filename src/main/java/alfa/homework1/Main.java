package alfa.homework1;

public class Main {
    public static void main(String[] args) {
        String employeeName = "Глеб";
        String position = "Старший шаурма-инженер";
        double moneyForOneShift = 16000;
        int shiftsAmount = 7;
        double bonus = 3000;
        double fineForBurntBread = 500;
        double oneShawarmaPrice = 1000;
        int soldShawarmaAmount = 30;

        double moneyForAllShifts = moneyForOneShift * shiftsAmount;
        double salary = moneyForAllShifts + bonus - fineForBurntBread;
        double shawarmaRevenue = oneShawarmaPrice * soldShawarmaAmount;


        System.out.println("Сотрудник: " + employeeName);
        System.out.println("Должность: " + position);
        System.out.println("Оплата за смены: " + moneyForAllShifts);
        System.out.println("Премия: " + bonus);
        System.out.println("Штраф: " + fineForBurntBread);
        System.out.println("Итоговая зарплата: " + salary);
        System.out.println("Шаур-выручка: " + shawarmaRevenue);
    }
}
