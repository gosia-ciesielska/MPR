package pl.pjatk;

import lombok.Getter;

import java.util.Collection;
import java.util.Map;

@Getter
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {
        this.name = name;
        setAge(age);
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 1 || age > 100) {
            throw new InvalidAgeException("Age must be between 1 and 100 years");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "[Name: " + name + ", age: " + age + "]";
    }

    public static void printPeople(Collection<Person> collection) {
        collection.forEach(System.out::println);
    }

    public static void printPeople(Map<String, Integer> map) {
        map.forEach((name, age) -> System.out.println("[Name: " + name + ", age: " + age + "]"));
    }
}
