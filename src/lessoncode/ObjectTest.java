package lessoncode;

/**
 * Package: lessontest
 * Description:
 *
 * @Author ENZO
 * @Create 2024年4月22日 11:31
 */
public class ObjectTest {
    public static void main(String[] args) {
        Father f = new Father();
        Father s = new Son();
        Father d = new Daughter();
        MyClass my = new MyClass();
        my.method(f);
        my.method(s);
        my.method(d);
    }
}

class Father{

}
class Son extends Father{

}
class Daughter extends Father{

}
class MyClass{
    public void method(Father f){
        System.out.println("father");
    }
    public void method(Son s){
        System.out.println("son");
    }
    public void method(Daughter d){
        System.out.println("daughter");
    }

}
