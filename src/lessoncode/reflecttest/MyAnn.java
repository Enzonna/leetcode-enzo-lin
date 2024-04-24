package lessoncode.reflecttest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //必须是RUNTIME
public @interface MyAnn {
    String value() default "";
}
