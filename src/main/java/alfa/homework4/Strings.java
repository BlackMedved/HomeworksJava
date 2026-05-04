package alfa.homework4;

import java.util.Scanner;

public class Strings {
    static void main() {
        int countOfFragments = 5;

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите %d частей закондированного сообщения:\n", countOfFragments);
        for (int i = 0; i < countOfFragments; i++) {
            String fragment = scanner.nextLine();
            if (fragment.isBlank() || fragment.equalsIgnoreCase("null")) {
                System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...\n" +
                        ((i + 1 == countOfFragments) ? "" : "Продолжайте ввод фрагметов..."));
                stringBuilder.append("XX");
            } else {
                stringBuilder.append(fragment);
            }
            if (i + 1 != countOfFragments) {
                stringBuilder.append("#");
            }
        }

        System.out.printf("Расшифрованное послание: " + stringBuilder);
        scanner.close();
    }
}
