package lessoncode.reflecttest;

/*
哪些情况会导致类的初始化
（1）运行主方法所在的类，要先完成类初始化，再执行main方法
（2）第一次使用某个类型就是在new它的对象，此时这个类没有初始化的话，先完成类初始化再做实例初始化
（3）调用某个类的静态成员（类变量和类方法），此时这个类没有初始化的话，先完成类初始化
（4）子类初始化时，发现它的父类还没有初始化的话，那么先初始化父类
（5）通过反射操作某个类时，如果这个类没有初始化，也会导致该类先初始化
        Class.forName("com.atguigu.java6.SupA");


4、哪些使用类的操作不会导致类的初始化？
（1）使用某个类的静态的常量（static  final）
（2）通过子类调用父类的静态变量，静态方法，只会导致父类初始化，不会导致子类初始化，即只有声明静态成员的类才会初始化
（3）用某个类型声明数组并创建数组对象时，不会导致这个类初始化
 */

class SupA{
    static {
        System.out.println("SupA类初始化");
    }

    static int id = 10;

    public static final int AGE = 20;
}
class SubA extends SupA{
    static {
        System.out.println("SubA类初始化");
    }
}
public class ClassInitTest {
    static {
        System.out.println("main方法所在的类");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("aa");

        System.out.println("=================");
//        new SupA();
//        new SupA();

        System.out.println("==============");
        //System.out.println(SupA.id);

        System.out.println("===============");

//        new SubA();

        System.out.println("==================");

        //Class clazz = SupA.class;
       // Class.forName("com.atguigu.java6.SupA");
        //对象名.getClass()

        System.out.println("==================");
        //System.out.println(SupA.AGE);

        System.out.println("====================");
//        System.out.println(SubA.id);

        System.out.println("====================");

        SupA[] s = new SupA[5];
    }
}
