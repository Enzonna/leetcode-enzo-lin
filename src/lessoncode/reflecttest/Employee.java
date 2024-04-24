package lessoncode.reflecttest;

interface MyInterface{

}

public class Employee extends Person implements MyInterface{
    public Employee(){
        System.out.println("Employee()");
    }
    //私有化的构造器
    private Employee(int a){
        System.out.println("private Employee(int a)" + a);
    }
}
