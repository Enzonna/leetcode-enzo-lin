package lessoncode.fileIOtest;


import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest2 {
    /*
        字节流的输出流（节点流）
            FileOutputStream
     */
    @Test
    public void test() throws Exception {
        //1.创建File类的对象
        File file = new File("a.txt");//写的这个文件可以不存在 -- 在执行写操作时该文件不存在会自动创建
        //2.创建流的对象
        /*
        FileOutputStream(File file, boolean append)
        append : 如果为false表示覆盖(这一次 覆盖 上一次)。如果为true表示追加
            默认是false
         */
        FileOutputStream fos = new FileOutputStream(file,false);
        //3.写数据
        fos.write("111".getBytes());//getBytes() : 将字符串转成byte[]
        fos.write("222".getBytes());//getBytes() : 将字符串转成byte[]
        //4.关资源
        fos.close();
    }

    @Test
    public void test2() {
        FileOutputStream fos = null;
        try {
            //1.创建File类的对象
            File file = new File("a.txt");//写的这个文件可以不存在 -- 在执行写操作时该文件不存在会自动创建
            //2.创建流的对象
            /*
            FileOutputStream(File file, boolean append)
            append : 如果为false表示覆盖(这一次 覆盖 上一次)。如果为true表示追加
                默认是false
             */
            fos = new FileOutputStream(file, false);
            //3.写数据
            fos.write("111".getBytes());//getBytes() : 将字符串转成byte[]
            fos.write("222".getBytes());//getBytes() : 将字符串转成byte[]
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //4.关资源
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
