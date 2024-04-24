package lessoncode.reflecttest;


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest {

    @Test
    public void test() throws NoSuchFieldException, NoSuchMethodException {

        Class clazz = Student.class;

        //拿的是类上的注解
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        System.out.println("====================================");

        //拿属性上的注解
        //获取那个属性
        Field id = clazz.getField("id");
        //获取属性上的注解
        Annotation[] annotations1 = id.getAnnotations();
        System.out.println(Arrays.toString(annotations1));

        System.out.println("====================================");
        //获取方法上的注解
        //获取方法
        Method show = clazz.getMethod("show");
        //获取方法上的注解
        Annotation[] annotations2 = show.getAnnotations();
        System.out.println(Arrays.toString(annotations2));
    }
}
