package lessoncode.streamtest;

import java.util.Objects;

public class Person implements Comparable<Person> {
    String name;
    int id;
    int score;

    public Person(String name, int id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + score;
    }

    /*
        没有重写equals比的是对象的地址值
        重写equals比的是内容
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && score == person.score && Objects.equals(name, person.name);
    }

    /*
        没有重写hashCode 获取的是对象的地址值
        重写hashCode 按照内容获取对应的哈希值（如果内容一样获取的哈希值是一样的）
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id, score);
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }
}
