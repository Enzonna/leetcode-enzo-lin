package lessoncode.objectIOtest;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
    对象流
 */
public class ObjectIOTest {
    /*
        ObjectOutputStream
     */
    @Test
    public void test() throws Exception {
        //1.创建流的对象
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("aa.txt"));
        //2.创建对象
        Person p = new Person(20, "longge",new Address("13333333333"));
        //3.写数据
        oos.writeObject(p);
        //4.关闭资源
        oos.close();
    }
    /*
        ObjectInputStream

        反序列化时的错误：
            stream classdesc serialVersionUID = -1159203326177187056,
                local class serialVersionUID = 4819562835854727119
        发生错误的原因 ：将对象序列化后存储的SUID值和反序列化后类中的SUID的值不匹配。
        如何解决此问题：
            1.SUID是如何变的 如何不让SUID的值发生变化？
                当自定义的类实现Serializable后会有默认SUID值这个值不会发生改变除非类发生改变。
                那么我们可以通过显示声明SUID的方式让SUID不变（本质上序列化对象所属性的类 在对象序列化后不要修改）。
            2.如何在反序列化时保证不失败（不发生上面的错误）？
                序列化时的SUID和反序列化时的SUID要保持一致
     */
    @Test
    public void test2() throws Exception {
        //1.创建流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aa.txt"));
        //2.读数据
        Person p = (Person)ois.readObject();
        System.out.println(p.toString());
        //3.关闭资源
        ois.close();
    }
}
