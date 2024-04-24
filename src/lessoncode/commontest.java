package lessoncode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Package: lessoncode
 * Description:
 *
 * @Author ENZO
 * @Create 2024年4月24日 21:00
 */
public class commontest {
    public static void main(String[] args) {
        int test = test(3, 5);
        System.out.println(test);
    }

    public static int test(int x, int y) {
        int result = x;
        try {
            if (x < 0 || y < 0) {
                return 0;
            }
            result = x + y;
            return result;
        } finally {
            result = x - y;
            return result;
        }
    }

    @Test
    public void test1(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
    }
}
