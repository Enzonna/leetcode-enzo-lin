package lessoncode.lambdatest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    lambda表达式 ：对匿名内部类的对象的一种简写

    lambda表达式的格式 : (形参列表) -> {方法体}

    说明 ：
        -> : lambda操作符

 */
interface MyInterface<T> {
    int test(T t1, T t2);
}

public class LambdaTest2 {


    @Test
    public void test3() {

        //创建匿名内部类的对象
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, c);//传了一个list集合和匿名内部类的对象


        //===================

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        System.out.println("=======================lambda==============================");

        //lambda表达式（本质就是匿名内部类的对象 - 只不过是对匿名内部类的对象的一种简写）
        Comparator<Integer> c2 = (Integer o1, Integer o2) -> {
            return 0;
        };

        Collections.sort(list, c2);

        //=====================

        Collections.sort(list, (Integer o1, Integer o2) -> {
            return 0;
        });

    }

    @Test
    public void test2() {
        //创建匿名内部类的对象
        MyInterface<Integer> mi = new MyInterface<Integer>() {
            @Override
            public int test(Integer t1, Integer t2) {
                return 0;
            }
        };

        //使用lambda表达式-创建匿名内部类的对象
        MyInterface<Integer> mi2 = (Integer t1, Integer t2) -> {
            return 0;
        };


        //=====================案例==================================
        demo((Integer t1, Integer t2) -> {
            return t1 - t2;
        });
    }

    /*
        演示 ：匿名内部类的对象和lambda表达式的比较
     */
    @Test
    public void test() {
        //调用方法demo
        demo(new MyInterface<Integer>() {
            @Override
            public int test(Integer t1, Integer t2) {
                return t1 - t2;
            }
        });

        //使用lambda表达式
        demo((t1, t2) -> t1 - t2);
    }


    public void demo(MyInterface<Integer> mi) {

    }
}


