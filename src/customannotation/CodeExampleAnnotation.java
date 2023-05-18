package customannotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CodeExampleAnnotation {

    public static void customAnnotationTest() throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("Saint Peter");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("this is really important");
        } else {
            System.out.println("this is not really important");
        }

        for (Method method : myCat.getClass().getMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);

                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(myCat);
                }
            }
        }

        for (Field field : myCat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportString.class)) {
                Object objectValue = field.get(myCat);

                if (objectValue instanceof String stringValue) {
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
