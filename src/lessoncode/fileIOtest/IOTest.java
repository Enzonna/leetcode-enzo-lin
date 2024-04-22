package lessoncode.fileIOtest;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;

/*
    IO流：
    流的分类：
        流的流向 ：输入流，输出流
        数据的类型 ：字节流和字符流。
        根据IO流的角色不同分为：节点流和处理流。

    四个基础的流的抽象类：
        字节流： InputStream,OutputStream
        字符流： Reader,Writer

   =========================节点流==========================
    字节流（节点流）：
          输入流：FileInputStream
          输出流：FileOutputStream

    字符流（节点流）：
          输入流：FileReader
          输出流：FileWriter
 */
public class IOTest {

    /*
     字节流（节点流）：
          输入流：FileInputStream
          输出流：FileOutputStream
     */
    @Test
    public void test() throws Exception {
        //1.创建File类的对象
        File file = new File("longge.txt");
        //2.创建流的对象--读数据
        FileInputStream fis = new FileInputStream(file);
        //3.读数据
        /*
            read() : 返回读取的数据 如果读到文件的最后返回-1
         */
        /*
        int read = fis.read();
        while (read != -1){
            System.out.println((char)(read));
            read = fis.read();
        }
         */
        int read = -1;
        while ((read  = fis.read()) != -1){
            System.out.println((char)(read));
        }

        //4.关流
        fis.close();
    }

    @Test
    public void test2() throws Exception {
        //1.创建File类的对象
        File file = new File("longge.txt");
        //2.创建流的对象--读数据
        FileInputStream fis = new FileInputStream(file);
        //3.读数据
        /*
            read(byte[] b) : 返回读取的数据的长度 如果读到文件的最后返回-1
                将数据读取到数组中
         */
        byte[] bytes = new byte[5];
        int len = -1;
        while ((len = fis.read(bytes)) != -1){
            System.out.println(len);
            System.out.println(new String(bytes,0,len));
        }

        //4.关流
        fis.close();
    }

    @Test
    public void test3() {
        FileInputStream fis = null;//局部变量没有默认值

        try {
            //1.创建File类的对象
            File file = new File("longge.txt");
            //2.创建流的对象--读数据
            fis = new FileInputStream(file);
            //3.读数据
            /*
                read(byte[] b) : 返回读取的数据的长度 如果读到文件的最后返回-1
                    将数据读取到数组中
             */
            byte[] bytes = new byte[1024];//一般就是1024 （到底多大？要看文件大小  和  内存大小）
            int len = -1;
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(len);
                System.out.println(new String(bytes, 0, len));
            }

        }catch (Exception e){
            e.printStackTrace();//打印异常信息到控制台
        }finally {
            //4.关流
            try {
                if (fis != null) {//因为有可能对象就没有创建成功就发生了异常 直接close会发生NullPointerException
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
