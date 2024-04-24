package lessoncode.reflecttest;

import org.junit.Test;

/*
    类加载器


    双亲委派 ：当类加载时应用程序类加载器先调用父类-扩展类加载器进行调用
        扩展类加载器再调用父类-引导类加载器加载
        引导类加载器只加载核心类库的类，如果该类是核心类库的类则加载否则不加载由儿子加载。
        扩展类加载器只加载jre/lib/ext中的类。如果该类是jre/lib/ext中的类则加载否则由儿子加载。
        应用程序类加载器直接加载。
 */
public class ClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException {

        //获取类的运行时类的对象（Class对象）
        //自定义的类用的类加载器 - AppClassLoader（应用程序类加载器）
        Class clazz = Class.forName("com.atguigu.java6.A");
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);


        classLoader = classLoader.getParent();//ExtClassLoader（扩展类加载器）
        System.out.println(classLoader);


        classLoader = classLoader.getParent();
        System.out.println(classLoader);//null -- 引导类加载器（不是Java语言实现的）
    }

    @Test
    public void test2() throws ClassNotFoundException {

        //获取类的运行时类的对象（Class对象）
        //null -- 引导类加载器（不是Java语言实现的）
        Class clazz = Class.forName("java.lang.String");
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);
    }
}
