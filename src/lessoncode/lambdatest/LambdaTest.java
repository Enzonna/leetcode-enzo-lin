package lessoncode.lambdatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
    案例：演示
 */
public class LambdaTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(20);
        list.add(30);
        list.add(18);
        list.add(56);

        /*
        //需求：获取集合中大于等于20的值  并排序
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next < 20){
                iterator.remove();//要用迭代器去删除
            }
        }

        Collections.sort(list);
        System.out.println(list);
*/

        //StreamAPI结合Lambda表达式
        list.stream().filter(x -> x >= 20).sorted().map(x -> x + " ").forEach(System.out::print);
    }
}
