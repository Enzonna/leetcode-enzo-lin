package lessoncode;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Package: lessontest
 * Description:
 *
 * @Author ENZO
 * @Create 2024年4月22日 12:50
 */
public class TestTryCatch {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int m;
        while(true) {
            try {
                System.out.print("请输入一个正整数：");
                m = input.nextInt();

                if (m < 0) {
                    System.out.println("输入有误，" + m + "不是正整数！");
                }else{
                    break;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                input.nextLine();
                //String result = input.nextLine();
                //System.out.println("输入有误，" + result + "不是整数");
            }
        }

        System.out.println("m = " + m);
    }
}