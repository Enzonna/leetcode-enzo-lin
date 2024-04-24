package lessoncode.reflecttest;

import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectTest {
    /*
        通过反射获取属性 - 获取所有属性
     */
    @Test
    public void test(){
        //获取Class对象
        Class clazz = Student.class;
        //获取属性---获取的是本类及父类中所有public修饰的属性
        Field[] fields = clazz.getFields();
        //遍历
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("===============================================");

        //获取本类中所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        //遍历
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    /*
        通过反射获取属性 - 获取指定的属性
     */
    @Test
    public void test2() throws Exception {
        Student s = new Student();

        //1.获取Class对象
        Class clazz = Student.class;
        //2.获取指定属性 - public修饰的
        Field sidPublic = clazz.getField("sidPublic");
        //给属性赋值
        /*
        set(Object obj, Object value)
        obj : 给哪个对象中的该属性赋值
        value : 赋值的内容
         */
        sidPublic.set(s,20);//给s对象中的sidPublic赋值

        //s.studentShow();
    }

    /*
     通过反射获取属性 - 获取指定的属性
  */
    @Test
    public void test3() throws Exception {
        Student s = new Student();

        //1.获取Class对象
        Class clazz = Student.class;
        //2.获取指定属性 - 可以获取任意权限修饰符修饰的属性
        Field sidPrivate = clazz.getDeclaredField("sidPrivate");
        //授权 - 允许访问
        sidPrivate.setAccessible(true);
        //给属性赋值
        /*
        set(Object obj, Object value)
        obj : 给哪个对象中的该属性赋值
        value : 赋值的内容
         */
        sidPrivate.set(s,30);//给s对象中的sidPrivate赋值

        //s.studentShow();
    }


}
