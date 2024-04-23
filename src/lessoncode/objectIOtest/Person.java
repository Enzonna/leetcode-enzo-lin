package lessoncode.objectIOtest;

import java.io.Serializable;

/*
    序列化：将内存中的对象写到磁盘中
        如果对象要序列化或通过网络传输
    反序列化：将磁盘中对象恢复到内存中
        如果要读取磁盘上的对象或者通过网络接收对象那么就需要反序列化

    注意：如果对象要序列化那么对象所属性的类及类中的属性都必须实现Serializable接口。基本数据类型除外。
 */

public class Person implements Serializable {

    //当前类只要实现了Serializable接口 那么就算不声明serialVersionUID 会有一个默认的
    //自己指定的
    //private static final long serialVersionUID = 213211122221L;

    int age;
    transient String name;//该属性就不可以序列化 - 类变量不可以序列化
    Address address;


    public Person(int age, String name,Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + address.toString();
    }
}

class Address implements Serializable{
    String phoneNumber;

    public Address(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
