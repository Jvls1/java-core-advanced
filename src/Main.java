import reflection.Cat;
import customannotation.CodeExample;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        customAnnotationExample();
    }

    private static void customAnnotationExample() throws InvocationTargetException, IllegalAccessException {
        CodeExample.customAnnotationTest();
    }
}