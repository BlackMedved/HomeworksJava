package alfa.homework2;

import java.util.Random;

public class BusinessCoach {
    public static void main(String[] args) {
        Random random = new Random();

        // Возраст посетителя от 0 до 100 лет
        int visitorAge = random.nextInt(101);
        // Множитель для большего разброса значений;
        int multiplyHelper = random.nextInt(2);
        // Рассчет количества денег в котором для большего разброса значений берется или первое или второе слогаемое
        // и добавляется вещественная часть с округлением до 2-х знаков после запятой
        double money = multiplyHelper * random.nextInt(100_000)
                + (1 - multiplyHelper) * random.nextInt(10_000_000)
                + Double.parseDouble(String.format("%.2f", random.nextDouble()).replace(',', '.'));

        boolean isVisitorInvited = false;
        boolean isVisitorInBlackList = false;
        double feeMultiplier = 0.075;

        boolean isAdult = visitorAge >= 18;
        boolean isVisitorInvitedOrSolvent = isVisitorInvited || (money > 50_000);

        boolean isVisitorPassesThrough = isAdult && !isVisitorInBlackList && isVisitorInvitedOrSolvent;

        // Обязательный взнос округляется до 2 знаков после запятой
        double entranceFee = Double.parseDouble(String.format("%.2f", money * feeMultiplier).replace(',', '.'));

        System.out.println("Возраст посетителя: " + visitorAge);
        System.out.println("Количество денег: " + money);
        System.out.println("Посетитель проходит: " + isVisitorPassesThrough);
        System.out.println("Обязательный добровольный взнос: " + entranceFee);
    }
}
