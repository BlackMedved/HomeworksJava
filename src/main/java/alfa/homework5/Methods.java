package alfa.homework5;

import java.time.LocalDate;
import java.util.Random;

public class Methods {

    static void main() {
        String accessCode = generateAccessCode();
        System.out.printf("Код прошел проверку: %s\n", isValidCode(accessCode, 8) ? "Да" : "Нет");
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        String firstAgentId = generateAgentId("AGENT", 42);
        String secondAgentId = generateAgentId("AGENT", 77);
        String thirdAgentId = generateAgentId("AGENT", 13);
        System.out.printf("ID сгенерированных агентов:\n%s\n%s\n%s", firstAgentId, secondAgentId, thirdAgentId);
    }

    public static String generateAccessCode() {
        int todayYear = LocalDate.now().getYear();
        int powResult = (int) Math.pow(3, 7);
        return todayYear + "-" + powResult;
    }

    private static boolean isValidCode(String code, int minLength) {
        if (code != null) {
            boolean isCodeLengthGraterOrEqualsMinLength = code.length() >= minLength;
            boolean isCodeContainsMinus = code.contains("-");
            return isCodeLengthGraterOrEqualsMinLength && isCodeContainsMinus;
        }
        else return false;
    }

    public static void logEvent(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.println("[CRITICAL] " + message);
        }
        else logEvent(message);
    }

    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);
        int randomPositiveInt = Math.abs(random.nextInt(1000, 10000));
        return "{" + prefix.toUpperCase() + "}-" + "{" + randomPositiveInt + "}";
    }
}