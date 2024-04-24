package lessoncode.reflecttest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //必须是RUNTIME
public @interface MyAnn2 {
    String value() default "";
}
