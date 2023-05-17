package customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * On annotation with parameters, we can only use primitive types.
 *
 * If you don't put a default value, automatically become a required parameter
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {
    int times() default 1;
}
