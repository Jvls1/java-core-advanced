package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CodeExampleReflection {

    public static void customAnnotationTest() throws InvocationTargetException, IllegalAccessException {

        reflection.Cat myCat = new Cat("Saint Peter", 1);

        //getClass open the door to the reflection world

        Field[] catFields = myCat.getClass().getDeclaredFields();

        System.out.println("cat name before the magic: " + myCat.getName());
        for (Field field : catFields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(myCat, "Mey");
            }
        }
        System.out.println("cat name after the magic: " + myCat.getName());

        Method[] catMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : catMethods) {
            if (method.getName().equals("heyThisIsPrivate")) {
                method.setAccessible(true);
                method.invoke(myCat);
            }
            if (method.getName().equals("thisIsAPublicStaticMethod")) {
                //invoke with null as parameter because static methods don`t need an instance
                method.invoke(null);
            }
            if (method.getName().equals("thisIsAPrivateStaticMethod")) {
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}
