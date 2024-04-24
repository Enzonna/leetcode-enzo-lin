package lessoncode.reflecttest;

import org.junit.Test;

import java.lang.reflect.Method;

public class ReflectTest2 {
     /*
        通过反射获取方法 - 获取所有的
     */
    @Test
    public void test(){
        //1.获取Class对象
        Class clazz = Student.class;
        //2.获取方法-获取本类及父类中所有public修饰的方法
        Method[] methods = clazz.getMethods();
        //3.遍历
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("======================================");
        //获取本类中所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //遍历
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
    /*
        通过反射获取方法 - 获取指定的方法
     */
    @Test
    public void test2() throws Exception {
        Student s = new Student();

        //1.获Class对象
        Class clazz = Student.class;
        //2.获取指定的方法 - public修饰的方法
        Method stestPublic = clazz.getMethod("stestPublic");
        //3.调用方法
        /*
            invoke(Object obj, Object... args)
            obj : 对象名-通过哪个对象调用该方法
            args : 实参
         */
        stestPublic.invoke(s);

        System.out.println("======================================");
        //获取指定的方法- public修饰的方法
        /*
        getMethod(String name, Class<?>... parameterTypes)
        name : 方法的名字
        parameterTypes : 形参类型的运行时类
         */
        Method sdemoPublic = clazz.getMethod("sdemoPublic", String.class,int.class);
        //调用方法
         /*
            invoke(Object obj, Object... args)
            obj : 对象名-通过哪个对象调用该方法
            args : 实参
         */
        sdemoPublic.invoke(s,"xiaolongge",30);

    }

    @Test
    public void test3() throws Exception {
        Student s = new Student();

        //1.获取Class对象
        Class clazz = Student.class;
        //2.获取指定的方法 - 任意权限修饰符修饰的方法
        Method declaredMethod = clazz.getDeclaredMethod("srunPrivate");
        //3.授权-允许访问
        declaredMethod.setAccessible(true);
        //4.调用方法
        declaredMethod.invoke(s);
    }



}
