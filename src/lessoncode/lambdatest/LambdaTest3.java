package lessoncode.lambdatest;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaTest3 {
    /*
     * 当{Lambda体}中只有一句语句时，可以省略{}和{;}
     * 当{Lambda体}中只有一句语句时，并且这个语句还是一个return语句，那么{、return、;}三者可以省略。它们三要么一起省略，要么都不省略。
     * 当Lambda表达式(形参列表)的类型已知，获取根据泛型规则可以自动推断，那么(形参列表)的数据类型可以省略。
     * 当Lambda表达式(形参列表)的形参个数只有一个，并且类型已知或可以自动推断，则形参的数据类型和()可以一起省略，但是形参名不能省略。
     * 当Lambda表达式(形参列表)是空参时，()不能省略
     */
    //如果lambda体只有一条执行语句 那么大括号和return都可以省略不写
    @Test
    public void test() {
        //匿名内部类的对象
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        System.out.println("====================lamdba==================");

        //如果lambda体只有一条执行语句 那么大括号和return都可以省略不写
        Comparator<Integer> c2 = (Integer o1, Integer o2) -> o1 - o2;

    }

    /*
    如果lambda体中只有一条执行语句那么大括号可以省略不写
     */
    @Test
    public void test2() {
        //匿名内部类的对象
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        System.out.println("====================lamdba==================");

        //如果lambda体中只有一条执行语句那么大括号可以省略不写
        Consumer<String> c2 = (String s) -> System.out.println(s);

    }

    /*
    当Lambda表达式(形参列表)的类型已知，获取根据泛型规则可以自动推断，那么(形参列表)的数据类型可以省略。
     */
    @Test
    public void test3() {
        /*
        方法的形参是泛型的类型
        public interface Consumer<T> {
            void accept(T t);
         }
         */
        //匿名内部类的对象
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        //当Lambda表达式(形参列表)的类型已知，获取根据泛型规则可以自动推断，那么(形参列表)的数据类型可以省略。
        //lambda表达式
        Consumer<String> c2 = (s) -> System.out.println(s);


        System.out.println("=================================");

        Comparator<Integer> c3 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        //当Lambda表达式(形参列表)的类型已知，获取根据泛型规则可以自动推断，那么(形参列表)的数据类型可以省略。
        //lambda
        Comparator<Integer> c4 = (o1, o2) -> o1 - o2;

    }

    /*
    当Lambda表达式(形参列表)的形参个数只有一个，并且类型已知或可以自动推断，则形参的数据类型和()可以一起省略，但是形参名不能省略。
     */
    @Test
    public void test4() {
        //匿名内部类的对象
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        //lambda
        //当Lambda表达式(形参列表)的形参个数只有一个，并且类型已知或可以自动推断，则形参的数据类型和()可以一起省略，但是形参名不能省略。
        Consumer<String> c2 = s -> System.out.println(s);

    }

    /*
    当Lambda表达式(形参列表)是空参时，()不能省略
     */
    @Test
    public void test5() {
        //创建匿名内部类的对象
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "a";
            }
        };

        //lambda表达式
        //当Lambda表达式(形参列表)是空参时，()不能省略
        Supplier<String> s2 = () -> "a";

    }
}
