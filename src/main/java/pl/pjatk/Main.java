package pl.pjatk;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidAgeException {
        Person person1 = new Person("Krzysztof", 12);
        Person person2 = new Person("Marek", 49);
        Person person3 = new Person("Joanna", 77);

        List<Person> listOfPeople = List.of(person1, person2, person3);
        Set<Person> setOfPeople = Set.of(person1, person2, person3);
        Map<String, Integer> mapOfPeople = Map.of(person1.getName(), person1.getAge(),
                person2.getName(), person2.getAge(),
                person3.getName(), person3.getAge());

        System.out.println("List:");
        Person.printPeople(listOfPeople);
        System.out.println("\nSet:");
        Person.printPeople(setOfPeople);
        System.out.println("\nMap:");
        Person.printPeople(mapOfPeople);

        int meanAge = listOfPeople.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum) / listOfPeople.size();
        List<String> names = listOfPeople.stream().map(Person::getName).toList();
        List<Person> peopleAbove25 = listOfPeople.stream().filter(person -> person.getAge() > 25).toList();
        List<Person> sorted = listOfPeople.stream().sorted(Comparator.comparing(Person::getName)).toList();
        Optional<Person> maxAge = listOfPeople.stream().max(Comparator.comparing(Person::getAge));
        Optional<Person> minAge = listOfPeople.stream().min(Comparator.comparing(Person::getAge));


        System.out.println("\nMean age: " + meanAge);
        System.out.println("\nList of names: ");
        names.forEach(System.out::println);
        System.out.println("\nPeople above 25: ");
        Person.printPeople(peopleAbove25);
        System.out.println("\nSorted by name: ");
        Person.printPeople(sorted);
        System.out.println("\nPerson with max age: " + maxAge.get());
        System.out.println("Person with min age: " + minAge.get());
    }
}