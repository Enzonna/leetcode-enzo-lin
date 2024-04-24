package lessoncode.reflecttest;

import org.junit.Test;

/*
    获取Class对象的四种方式
 */
public class ClassTest {

    @Test
    public void test() throws ClassNotFoundException {
        Person p = new Person();

        //方式一：类名.class
        Class clazz = Person.class;

        //方式二：对象名.getClass();
        Class clazz2 = p.getClass();

        //方式三 ：Class.forName("全类名") - 最多 - 更灵活
        Class clazz3 = Class.forName("com.atguigu.java4.Person");

        //方式四 ：类加载器.loadClass("全类名") - 了解
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java4.Person");


        System.out.println(clazz == clazz2 && clazz3 == clazz4);
    }

    @Test
    public void test2() throws ClassNotFoundException {
        //在调用方法时一定传一个必须存在的类
        //通过流读取配置文件 --- 配置文件中的内容修改是不会影响代码本身
        String s = "读取配置文件";
        set(s);
    }

    /*
        通用模板 ： 要求设计一个方法给某一个类创建对象并给所有属性赋值
     */
    public void set(String s) throws ClassNotFoundException {
        //创建对象并给所有属性赋值
        Class clazz = Class.forName(s);
        //创建对象
    }

}
