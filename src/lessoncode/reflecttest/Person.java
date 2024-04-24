package lessoncode.reflecttest;


@MyAnn2("com.atguigu.java8.Person")
public class Person {
    String name;
    int id;

    @MyAnn2("com.atguigu.java8.Address")
    Address address;
}

class Address{

}
