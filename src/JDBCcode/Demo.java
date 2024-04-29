package JDBCcode;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {


        int size = 10;

        System.out.println("字体大小:" + size);

        Scanner s = new Scanner(System.in);
        System.out.println("请输入你想做的操作 1:改字体大小  2：修改背景颜色  3.修改编码集.....");
        int op = s.nextInt();

        if (op == 1){
            System.out.print("请输入字体大小:");
            size = s.nextInt();
            System.out.println("字体大小:" + size);
        }

    }
}
