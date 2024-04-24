package lessoncode.streamtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
    中间操作
 */
public class StreamAPI2 {
    static List<Person> list = new ArrayList<>();
    static {
        list.add(new Person("aaa",2,100));
        list.add(new Person("longge",3,98));
        list.add(new Person("canglaoshi",9,60));
        list.add(new Person("hei",8,30));
        list.add(new Person("ha",6,59));
        list.add(new Person("hei",8,30));
        list.add(new Person("ha",6,59));
    }

    @Test
    public void test(){

        /*
        Stream<Person> stream = list.stream();

        //Stream filter(Predicate p)接收 Lambda ， 从流中排除某些元素
        Stream<Person> strem2 = stream.filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {//只要分数及格的
                return person.score >= 60;
            }
        });

        strem2.forEach(System.out::println);
         */

        list.stream().filter(p -> p.score >= 60).forEach(System.out::println);
    }

    /*
    Stream distinct()筛选，通过流所生成元素的equals() 去除重复元素
        注意：集合中的对象所属的类必须重写equasl和hashCode方法
     */
    @Test
    public void test2(){
        list.stream()
                .distinct() //重写equals和hashCode方法后是按照内容去重
                .forEach(System.out::println);
    }

    /*
    Stream limit(long maxSize)截断流，使其元素不超过给定数量
     */
    @Test
    public void test3(){
        list.stream()
                .distinct()
                .limit(2) //获取前2个元素
                .forEach(System.out::println);
    }

    /*
    Stream skip(long n)跳过元素，返回一个扔掉了前 n 个元素的流。
            若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     */
    @Test
    public void test4(){
        int[] numbers = {1,2,3,4,5,6};
        Arrays.stream(numbers)
                .skip(3)
                .forEach(System.out::println);
    }

    /*
    Stream peek(Consumer action)接收Lambda，对流中的每个数据执行Lambda体操作
     */
    @Test
    public void test5(){
        list.stream()
                .peek(new Consumer<Person>() {
                    @Override
                    public void accept(Person person) {
                        System.out.println("=======" + person.toString());
                    }
                })
                .forEach(System.out::println);


        list.stream()
                .peek(p -> System.out.println(p))
                .forEach(System.out::println);
    }

    /*
        Stream sorted()产生一个新流，其中按自然顺序排序
     */
    @Test
    public void test6(){
        /*
        list.stream()
                //.sorted()//自然排序
                .sorted(new Comparator<Person>() {//定制排序
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.score - o2.score;
                    }
                })
                .forEach(System.out::println);

         */

        list.stream()
                .sorted((o1,o2) -> o1.score - o2.score)
                .forEach(System.out::println);
    }

    /*
    Stream map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     */
    @Test
    public void test7(){
        /*
        list.stream()
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        return person.name.length() > 3;
                    }
                })
                .map(new Function<Person, Integer>() {
                    @Override
                    public Integer apply(Person person) {
                        return person.id;
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer > 5;
                    }
                })
                .forEach(System.out::println);

         */

        list.stream()
                .filter(p -> p.name.length() > 3)
                .map(p -> p.id)
                .filter(id -> id > 5)
                .forEach(System.out::println);
    }

    /*
    Stream flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test8(){
        list.stream()
                .map(p -> p.name)
                .flatMap(new Function<String, Stream<?>>() {
                    @Override
                    public Stream<?> apply(String s) {
                        //"xiaocang" -> {x,i,a,o,c,a,n,g}
                        String[] split = s.split("");
                        //数组转成流
                        return Arrays.stream(split);
                    }
                })
                .forEach(System.out::println);
    }
}
