package lessoncode.streamtest;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*

    ①Stream 自己不会存储元素。
    ②Stream 不会改变源对象。每次处理都会返回一个持有结果的新Stream。
    ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

    说明：可以把Stream想象成一条流（流水线）在流的上面有很多操作（过滤，转换，排序,.....）
 */
public class StreamAPI {
    static List<Integer> list = new ArrayList<>();
    static {
        list.add(10);
        list.add(20);
        list.add(15);
        list.add(19);
        list.add(59);
    }
    /*
        通过集合创建Stream
        * public default Stream<E> stream() : 返回一个顺序流
        * public default Stream<E> parallelStream() : 返回一个并行流
     */
    @Test
    public void test(){


        Stream<Integer> stream = list.stream();
        /*
            forEach :遍历流中的元素
         */
        /*
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
         */

        //lambda表达式
        //stream.forEach(i -> System.out.println(i));

        //方法的引用
        //stream.forEach(System.out::println);


        list.stream().forEach(System.out::println);
    }

    @Test
    public void test2(){
        list.parallelStream().forEach(System.out::println);
    }


    /*
        通过数组创建Stream:
        public static <T> Stream<T> stream(T[] array): 返回一个流
     */
    @Test
    public void test3(){
        int[] numbers = {12,89,23,65,32};
        Arrays.stream(numbers).forEach(System.out::println);
    }
    /*
        创建 Stream方式三：通过Stream的of()
            public static<T> Stream<T> of(T... values) : 返回一个顺序流
     */
    @Test
    public void test4(){

       Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

    }

    /*
    创建 Stream方式四：创建无限流**
    可以使用静态方法 Stream.iterate() 和 Stream.generate(), 创建无限流。
    * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f):返回一个无限流
    *
     */
    @Test
    public void test5(){
        /*
        iterate(final T seed, final UnaryOperator<T> f)
        seed : 初始化
        f : 返回计算后的新值
         */
        /*
        Stream.iterate(2, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println("integer:" + integer);
                return integer + 1;
            }
        }).limit(20).forEach(System.out::println);

         */
        Stream.iterate(2,i -> i + 1).forEach(System.out::println);
    }
    /*
    public static<T> Stream<T> generate(Supplier<T> s) ：返回一个无限流
     */
    @Test
    public void test6(){
        /*
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {//不断的调用此方法 获取返回值并输出
                return Math.random();
            }
        }).forEach(System.out::println);
        */

        //Stream.generate(() -> Math.random()).forEach(System.out::println);

        Stream.generate(Math::random).forEach(System.out::println);


    }
}
