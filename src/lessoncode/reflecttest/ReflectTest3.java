package lessoncode.reflecttest;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ReflectTest3 {
     /*
        通过反射获取构造器
     */
    @Test
    public void test() throws Exception {
        Class clazz = Employee.class;
        //获取构造器
        /*
        getDeclaredConstructor(Class<?>... parameterTypes) ：获取指定构造器（任意权限修饰符修饰的）
        parameterTypes : 形参的类型
         */
        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);
        //授权
        declaredConstructor.setAccessible(true);
        //创建对象
        /*
        newInstance(Object ... initargs) : 创建对象
        initargs ：实参
         */
        Employee e = (Employee) declaredConstructor.newInstance(20);
    }



    /*
        通过反射创建对象 ：没有获取构造器直接造对象
     */
    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        Class clazz = Employee.class;
        //直接通过空参构造器造对象 --- 如果该类没有空参构造器就不能这样子造对象（需要先获取构造器再造对象）
        clazz.newInstance();
    }


    /*
        通过反射获取父类，接口
     */
    @Test
    public void test3(){
        Class clazz = Employee.class;

        //获取父类 -- 有了父类就可以获取父类中的方法 属性 构造器 父类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

        //获取接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

    }
}
