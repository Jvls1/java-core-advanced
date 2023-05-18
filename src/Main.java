import customannotation.CodeExampleAnnotation;
import reflection.CodeExampleReflection;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws Exception {
        //customAnnotationExample();
        reflectionExample();
    }

    private static void customAnnotationExample() throws InvocationTargetException, IllegalAccessException {
        CodeExampleAnnotation.customAnnotationTest();
    }

    private static void reflectionExample() throws InvocationTargetException, IllegalAccessException {
        CodeExampleReflection.customAnnotationTest();
    }
}