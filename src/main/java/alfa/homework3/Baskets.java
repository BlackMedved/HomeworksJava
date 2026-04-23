package alfa.homework3;

import java.util.*;
import java.util.stream.Stream;

// Перечисление опций для метода TranscriptionOfCompare
enum OptionsOfCompareTranscription {
    LENGTH,
    COMPOSITION
}

class Baskets {
    static void main() {
        String[] productBasketPetya = new String[] {"курица","бананы","творог"};
        String[] productBasketKolya = new String[] {"курица","бананы","творог"};
        String[] productBasketTerenty = new String[] {"пиво","пельмени","ласка магия черного"};

        // Сравниваю количество элементов массивов
        int compareLengthOfPetyaAndKolyaProductBaskets = Integer.compare(productBasketPetya.length, productBasketKolya.length);
        int compareLengthOfPetyaAndTerentyProductBaskets = Integer.compare(productBasketPetya.length, productBasketTerenty.length);

        // Написал отдельный метод TranscriptionOfCompare, который по значению сравнения возвращает строковую расшифровку
        System.out.printf("""
        --- Сравнение продуктовых корзин ---
        Продуктовая корзина Пети %s продуктовой корзине(ы) Коли по количеству товаров.
        Продуктовая корзина Пети %s продуктовой корзине(ы) Терентия по количеству товаров.
        """,
                TranscriptionOfCompare(compareLengthOfPetyaAndKolyaProductBaskets, OptionsOfCompareTranscription.LENGTH),
                TranscriptionOfCompare(compareLengthOfPetyaAndTerentyProductBaskets, OptionsOfCompareTranscription.LENGTH));

        // Сравниваю сами массивы
        int compareCompositionOfPetyaAndKolyaProductBaskets = Arrays.compare(productBasketPetya, productBasketKolya);
        int compareCompositionOfPetyaAndTerentyProductBaskets = Arrays.compare(productBasketPetya, productBasketTerenty);

        System.out.printf("""
        Продуктовая корзина Пети %s продуктовой корзине(ы) Коли по составу.
        Продуктовая корзина Пети %s продуктовой корзине(ы) Терентия по составу.
        """,
                TranscriptionOfCompare(compareCompositionOfPetyaAndKolyaProductBaskets, OptionsOfCompareTranscription.COMPOSITION),
                TranscriptionOfCompare(compareCompositionOfPetyaAndTerentyProductBaskets, OptionsOfCompareTranscription.COMPOSITION));

        // Создал Хэшсет - это коллекция типа массива строк, но только с уникальными значениями
        // и запихиваю туда все три массива строк с преобразованием.
        // В итоге получается список уникальных значений из трех массивов.
        HashSet<String> productNames = new HashSet<>(
                Stream.of(productBasketPetya, productBasketKolya, productBasketTerenty).flatMap(Stream::of).toList());

        // Создал компаратор, который будет сравнивать длины строк.
        Comparator<String> stringByLengthComparator = Comparator.comparing(String::length);

        // Тоже отдельные методы, в которые передаю мой список уникальных продуктов и компаратор, сравнивающий длины.
        String longestProductName = GetLongestProductName(productNames, stringByLengthComparator);
        String shortestProductName = GetShortestProductName(productNames, stringByLengthComparator);
        double averageLengthOfProductName = GetAverageProductsName(productNames);

        System.out.printf("""
        
        --- Исследование длины названий продуктов ---
        Самое длинное название из продуктов: %s.
        Самое короткое название из продуктов: %s.
        Средняя длина всех названий продуктов: %.2f
        """,
                longestProductName,
                shortestProductName,
                averageLengthOfProductName);

    }

    // В параметры метода добавил ещё опцию длина или состав (Потому что для сравнения корзин продуктов по составу нет
    // смысла в больше и меньше)
    public static String TranscriptionOfCompare(int compareValue, OptionsOfCompareTranscription option) {
        switch (option) {
            case LENGTH:
                if (compareValue > 0) return "больше";
                else if (compareValue < 0) return "меньше";
                else return "равна";
            case COMPOSITION:
                if (compareValue != 0) return "отличается от";
                else return "равна";
            default:
                return "Неверное значение";
        }
    }

    // Получаю максимальную длину названия продукта передавая компаратор в функцию max
    static String GetLongestProductName(HashSet<String> productBasket, Comparator<String> stringByLengthComparator) {
        return productBasket.stream().max(stringByLengthComparator).orElse("");
    }

    // Получаю максимальную длину названия продукта передавая компаратор в функцию min
    static String GetShortestProductName(HashSet<String> productBasket, Comparator<String> stringByLengthComparator) {
        return productBasket.stream().min(stringByLengthComparator).orElse("");
    }

    // Преобразую коллекцию строк в инты, где элеметами становятся длины названий продуктов
    // и считаю их среднее значение.
    static double GetAverageProductsName(HashSet<String> productBasket) {
        return productBasket.stream().mapToInt(String::length).average().orElse(0.0);
    }
}