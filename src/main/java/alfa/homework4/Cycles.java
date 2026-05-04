package alfa.homework4;

import java.util.HashMap;
import java.util.Map;

public class Cycles {
    static void main() {
        int countOfTests = 100;
        boolean showOnlyIssues = false;
        boolean showCriticalTestBreakOption = false;

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Flaky", 0);
        hashMap.put("Bug", 0);
        hashMap.put("Critical!", 0);
        if (!showOnlyIssues) {
            hashMap.put("Pass", 0);
        }

        for (int i = 1; i <= countOfTests; i++) {
            boolean multipleOf3 = i % 3 == 0;
            boolean multipleOf5 = i % 5 == 0;

            if (multipleOf3 && multipleOf5) {
                TestStatusCounter(i,"Critical!", hashMap);

                boolean hasThreeCriticalTests = hashMap.get("Critical!") == 3;
                if (showCriticalTestBreakOption && hasThreeCriticalTests) {
                    System.out.println("🚨 Слишком много критических багов — будим тимлида!");
                    return;
                }
            }
            else if (multipleOf3) {
                TestStatusCounter(i,"Flaky", hashMap);
            }
            else if (multipleOf5) {
                TestStatusCounter(i,"Bug", hashMap);
            }
            else if (!showOnlyIssues) {
                TestStatusCounter(i,"Pass", hashMap);
            }
        }

        System.out.println("===== ИТОГИ НОЧНОЙ СМЕНЫ =====\n" +
                "Всего тестов: " + countOfTests);
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            String status = entry.getKey();
            int count = entry.getValue();

            System.out.printf("%-10s: %d\n", status, count);
        }
    }
    static void TestStatusCounter (int test,String status, HashMap<String, Integer> hashMapCount) {
        hashMapCount.put(status, hashMapCount.get(status) + 1);
        System.out.printf("Тест #%d: %s\n", test, status);
    }
}
