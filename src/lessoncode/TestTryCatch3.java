package lessoncode;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Package: lessontest
 * Description:
 *
 * @Author ENZO
 * @Create 2024年4月22日 12:47
 */
public class TestTryCatch3 {
    public static void main(String[] args) {
        //聚会惩罚游戏
        String[] arr = {"atguigu","java",null,"hello",""};

        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("请输入下标：");
                int index = input.nextInt();

                if (index < 0 || index >= arr.length) {
                    System.out.println("选择范围是[0," + (arr.length-1) + "]");
                } else {
                    //取出每一个字符串的首字母
                    System.out.println(arr[index] + "的首字母：" + arr[index].charAt(0));
                    System.out.println("过关！");
                    break;
                }
            } catch (StringIndexOutOfBoundsException | NullPointerException e) {
                System.out.println("接受惩罚");
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("输入有误，重新选择！");
            }
        }
    }
}