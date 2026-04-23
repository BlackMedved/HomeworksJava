package alfa.homework3;

class Passwords {
    static void main() {
        String[] passwords = {"QWERTY1235", "passwordz", "perfectPas194!"};

        // Цикл по каждому элементу из массива.
        for(String pas: passwords) {
            // Передаю значение каждого пароля в метод, проверяющий его безопасность.
            System.out.printf("Пароль %s прошел проверку: %b\n",
                    pas, IsPasswordProtected(pas));
        }
    }

    static boolean IsPasswordProtected(String password) {
        boolean isPasswordLengthGreaterThan8 = password.length() > 8;
        boolean isPasswordDoesNotStartsWith1 = !password.startsWith("1");
        boolean isPasswordDoesNotEndsWithZ = !password.endsWith("z");
        boolean isPasswordDoesNotContains1234 = !password.contains("1234");
        boolean isPasswordDoesNotContainsQwerty = !password.toLowerCase().contains("qwerty");

        return isPasswordLengthGreaterThan8 && isPasswordDoesNotStartsWith1 && isPasswordDoesNotEndsWithZ
                && isPasswordDoesNotContains1234 && isPasswordDoesNotContainsQwerty;
    }
}
