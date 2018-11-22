import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcessor {
    public static void setField(Object object) throws IllegalAccessException {
        // 1. Получаем объекта класса Class
        // 2. Находим все его поля
        // 3. Находим аннтоции RandomInt
        // 4. Устанавливаем значение
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();

        for (Field field: fields) {
            System.out.println("Field: " + field.getName());
            System.out.println("Field type: " + field.getType());
            RandomInt annotation = field.getAnnotation(RandomInt.class);
            System.out.println("Is null: " + (annotation == null));
            if (annotation != null) {
                int number = new Random()
                        .nextInt(annotation.max() - annotation.min() + 1) + annotation.min();
                System.out.println("Number: " + number);
                field.setAccessible(true);
                field.set(object, number);
            }
        }

    }
}
