package lessoncode.lambdatest;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Package: lessoncode.lambdatest
 * Description:
 *
 * @Author ENZO
 * @Create 2024年4月24日 10:39
 */
public class MyTest {
    @Test
    public void test1() {
        Consumer<String> c1 = (s) -> System.out.println(s);
        Comparator<Integer> c2 = (a, b) -> a - b;
    }

}
