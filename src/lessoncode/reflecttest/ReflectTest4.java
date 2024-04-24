package lessoncode.reflecttest;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest4 {
    /*
        获取属性的详细信息
     */
    @Test
    public void test(){
        Class clazz = Dog.class;
        //获取所有的属性- 本类中所有的
        Field[] declaredFields = clazz.getDeclaredFields();
        //遍历
        for (Field f : declaredFields) {
            //获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            //获取类型
            Class type = f.getType();
            System.out.print(type + " ");

            //获取名字
            String name = f.getName();
            System.out.print(name);

            System.out.println();
        }
    }
}
