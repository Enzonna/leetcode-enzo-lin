package lessoncode.reflecttest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    自定义注解

    格式 ：
        权限修饰符 @interface 注解名{

        }

    元注解 ：注解上面使用的注解（用来描述注解的注解）
        @Target ：用来限制自定义的注解可以用在哪些结构上
        @Retention : 用来描述自定义类的注解的生命周期
                SOURCE ：该注解只能用在源码上---字节码文件中就没有该注解了
                CLASS ： 在编译阶段到运行阶段 --- 运行以后就没有该注解了（运行时拿不到此注解）
                RUNTIME ： 在运行阶段 （如果想要通过反射获取此注解的信息--该注解必须是RUNTIME）
                    注意：只要是自定义注解一定是RUNTIME
 */
@Target(value = {ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
@interface MyAnn{
    //属性 = 如果名字叫作value那么在给注解赋值时可以省略不写
    String name() default "longge";//default "longge" ： 设置默认值

}

class Emp{
    @MyAnn(name="xiaolongge")//name="xiaolongge" ：给注解中的属性赋值
    int id;

//    @Override
//    int age;

    @MyAnn //不用强制给注解中的name赋值了 - 因为name有默认值
    public void show(){

    }
}

public class AnnotationTest2 {
}
