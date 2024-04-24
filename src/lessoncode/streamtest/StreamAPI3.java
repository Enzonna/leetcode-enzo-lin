package lessoncode.streamtest;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    终结操作API
 */
public class StreamAPI3 {
    static List<String> list = new ArrayList<>();
    static {
        list.add("aaa");
        list.add("eee");
        list.add("ddd");
        list.add("ccc");
        list.add("bbb");
    }

    /*
    boolean**allMatch(Predicate p)**检查是否匹配所有元素
     */
    @Test
    public void test(){
        boolean b = list.stream().allMatch(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("aaa");
            }
        });
        System.out.println(b);


        System.out.println( list.stream().allMatch(s -> s.equals("aaa")));
    }
    /*
           | boolean                     | **anyMatch**(**Predicate p**) | 检查是否至少匹配一个元素    |
| ------- | ----------------------------- | --------------------------- | ---------------------- |
| 3       | boolean                       | **noneMatch(Predicate  p)** | 检查是否没有匹配所有元素 |
| 4       | Optional<T>                   | **findFirst()**             | 返回第一个元素         |
| 5       | Optional<T>                   | **findAny()**               | 返回当前流中的任意元素 |
| 6       | long                          | **count()**                 | 返回流中元素总数       |
     */
    @Test
    public void test2(){
        System.out.println(list.stream().noneMatch(p -> p.equals("longge")));
        System.out.println(list.stream().anyMatch(p -> p.equals("ccc")));

        System.out.println("=============");

        Optional<String> first = list.stream().findFirst();
        System.out.println(first.get());//first.get() : 获取Optional中的值

        Optional<String> any = list.stream().findAny();
        System.out.println(any.get());

        System.out.println(list.stream().count());
    }

    /*
    |      | Optional<T> | **max(Comparator c)**                | 返回流中最大值                                               |
| ---- | ----------- | ------------------------------------ | ------------------------------------------------------------ |
| 8    | Optional<T> | **min(Comparator c)**                | 返回流中最小值                                               |
| 9    | void        | **forEach(Consumer c)**              | 迭代                                                         |

     */
    @Test
    public void test3(){
        Optional<String> max = list.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println(max.get());

        Optional<String> min = list.stream().min(String::compareTo);
        System.out.println(min.get());

    }

    /*
    | 10   | T           | **reduce(T iden, BinaryOperator b)** | 可以将流中元素反复结合起来，得到一个值。返回 T               |
| 11   | U           | **reduce(BinaryOperator b)**         | 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>     |

     */
    @Test
    public void test4(){
        int[] ns = {1,2,3,4,5};

        //有初始值
        int reduce = Arrays.stream(ns).reduce(0, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                System.out.println("left:" + left + "====right:" + right);
                return left + right;
            }
        });

        System.out.println(reduce);

        System.out.println("===========================================================");

        //没有初始值
        OptionalInt reduce1 = Arrays.stream(ns).reduce(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        System.out.println(reduce1.getAsInt());
    }

    /*、
    collect(Collector c)** | 将流转换为其他形式。接收一个 Collector接口的实现，
            用于给Stream中元素做汇总的方法 |
     */
    @Test
    public void test5(){
        int[] ns = {1,2,3,4,5};

       // List<Integer> list = Arrays.stream(ns).collect(Collectors.toList());

        List<String> list = StreamAPI3.list.stream().collect(Collectors.toList());
        System.out.println(list);
    }
}
