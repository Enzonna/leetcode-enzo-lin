package lessoncode.fileIOtest;

import org.testng.annotations.Test;

import java.io.*;

/*
    一边读一边写
 */
public class IOTest3 {
    @Test
    public void test() throws IOException {

        //1.创建File类的对象
        File readFile = new File("a.txt");
        File writeFile = new File("c.txt");

        //2.创建流的对象
        FileInputStream fis = new FileInputStream(readFile);
        FileOutputStream fos = new FileOutputStream(writeFile);

        //3.一边读一边写
        byte[] b = new byte[1024];//数组中存放的是读取的数据
        int len = -1;
        while ((len = fis.read(b)) != -1){//读
            //写
            fos.write(b,0,len);
        }

        //4.关流
        fis.close();
        fos.close();

    }

    @Test
    public void test2() throws IOException {

        copy("C:\\Users\\wangfeilong\\Desktop\\a.wmv",
                "C:\\Users\\wangfeilong\\Desktop\\aaaa.wmv");
    }

    public void copy(String readPath,String writePath){
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.创建File类的对象
            File readFile = new File(readPath);
            File writeFile = new File(writePath);

            //2.创建流的对象
            fis = new FileInputStream(readFile);
            fos = new FileOutputStream(writeFile);

            //3.一边读一边写
            byte[] b = new byte[1024];//数组中存放的是读取的数据
            int len = -1;
            while ((len = fis.read(b)) != -1) {//读
                //写
                fos.write(b, 0, len);
            }

        }catch (Exception e){

        }finally {
            //4.关流
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("time=" + (end -  start));


    }
}
