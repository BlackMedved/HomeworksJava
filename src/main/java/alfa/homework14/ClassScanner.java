package alfa.homework14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassScanner {
    public static void scan(Object object) {
        Class<?> objectClass = object.getClass();
        System.out.println("Поля:");
        //Field[] fields = objectClass.getFields();
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("\nМетоды:");
        //Method[] methods = objectClass.getMethods();
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("\nКонструкторы:");
        //Constructor[] constructors = objectClass.getConstructors();
        Constructor[] constructors = objectClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
