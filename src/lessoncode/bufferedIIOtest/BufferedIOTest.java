package lessoncode.bufferedIIOtest;



import org.testng.annotations.Test;

import java.io.*;

/*
    流的重点 ：
        四个节点流（FileInputStream FileOutputStream    FileReader FileWriter）
        四个个缓冲流（BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter）
        两个转换流 : InputStreamReader OutputStreamWriter

    重点中的重点 ： FileInputStream FileOutputStream  BufferedReader(可以一行一行读数据)
            InputStreamReader
            对象流的序列化和反序列化概念（Serializable）重要 - 对象流本身不重要
 */

/*
    字节流 - 处理流（缓冲流 - 作用：提高读写速度）
        输入流：
        输出流：
 */
public class BufferedIOTest {
    /*
        BufferedInputStream
     */
    @Test
    public void test() throws Exception {
        //1.创建File类的对象
        File file = new File("a.txt");

        //2.创建流的对象
        //2.1创建节点流的对象
        FileInputStream fis = new FileInputStream(file);
        //2.2创建处理流的对象
        BufferedInputStream bis = new BufferedInputStream(fis);

        //3.读取数据
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = bis.read(b)) != -1){
            System.out.println(new String(b,0,len));
        }

        //4.关流 :如果有处理流的情况下记住先关外面的再关里面的
        bis.close();
        fis.close();
    }

    @Test
    public void test2() throws Exception {
        //1.创建File类的对象
        File file = new File("b2.txt");
        //2.创建流的对象
        //2.1创建节点流的对象
        FileOutputStream fos = new FileOutputStream(file);
        //2.2创建处理流的对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //3.写数据
        bos.write("aaa".getBytes());

        bos.flush();//刷新 -- 将内存中的数据写到磁盘中（就相当于 ctrl+s）

        //4.关流 :如果有处理流的情况下记住先关外面的再关里面的
        bos.close();//关流中会flush
        fos.close();
    }
}

class A{
//    public static void main(String[] args) {
//        int n = get();
//        n = n * n;
//        printNumber(n);
//    }

    /*
        获取1到100的和
     */
    public static int get(){
        return 1;
    }

    public static int printNumber(int n){
        return 0;
    }
}
