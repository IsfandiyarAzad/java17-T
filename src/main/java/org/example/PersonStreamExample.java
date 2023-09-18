package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonStreamExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(


        new Person(1, "Alice", "Smith", 25, "Female", "New York", "alice@example.com", "Engineer", 750000, 1),
        new Person(2, "Bob", "Johnson", 30, "Male", "London", "bob@example.com", "Accountant", 600000, 1),
        new Person(3, "Charlie", "Doe", 35, "Male", "San Francisco", "charlie@example.com", "Doctor", 850000, 1),
        new Person(4, "David", "Smith", 40, "Male", "Paris", "david@example.com", "Lawyer", 900000, 1),
        new Person(5, "Eve", "Johnson", 45, "Female", "Tokyo", "eve@example.com", "Architect", 820000, 1),
        new Person(6, "Frank", "Doe", 28, "Male", "London", "frank@example.com", "Teacher", 500000, 1),
        new Person(7, "Grace", "Smith", 38, "Female", "New York", "grace@example.com", "Data Scientist", 950000, 1),
        new Person(8, "Henry", "Johnson", 32, "Male", "San Francisco", "henry@example.com", "Engineer", 780000, 1),
        new Person(9, "Ivy", "Doe", 42, "Female", "Paris", "ivy@example.com", "Artist", 700000, 1),
        new Person(10, "Jack", "Smith", 50, "Male", "Tokyo", "jack@example.com", "Businessman", 1200000, 1)

        );

        List<String> females = people.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("Female"))
                .map(Person::getFirstName)
                .collect(Collectors.toList());

        System.out.println("Names of all female individuals: " + females);

        double averageAgeInLondon = people.stream()
                .filter(person -> person.getGeography().equalsIgnoreCase("London"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age of people in London: " + averageAgeInLondon);

        List<String> occupationsOlderThan35 = people.stream()
                .filter(person -> person.getAge() > 35)
                .map(Person::getProfession)
                .collect(Collectors.toList());

        System.out.println("Occupations of people older than 35: " + occupationsOlderThan35);

        List<String> firstTwoNames = people.stream()
                .limit(2)
                .map(Person::getFirstName)
                .collect(Collectors.toList());

        System.out.println("Names of the first two people: " + firstTwoNames);

        int maxAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        System.out.println("Oldest person's age: " + maxAge);

        boolean isTeacher = people.stream()
                .anyMatch(person -> person.getProfession().equalsIgnoreCase("Teacher"));

        System.out.println("Is there a person with occupation 'Teacher'? " + isTeacher);

        List<String> parisSortedNames = people.stream()
                .filter(person -> person.getGeography().equalsIgnoreCase("Paris"))
                .map(Person::getFirstName)
                .sorted((a, b) -> b.compareToIgnoreCase(a))
                .collect(Collectors.toList());

        System.out.println("Names of people in Paris (reverse alphabetical order): " + parisSortedNames);

        long numberOfMales = people.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("Male"))
                .count();

        System.out.println("Number of males: " + numberOfMales);

        double avgAgeInLondon = people.stream()
                .filter(person -> person.getGeography().equalsIgnoreCase("London"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age of people in London: " + avgAgeInLondon);

        List<String> namesBetween30And40 = people.stream()
                .filter(person -> person.getAge() >= 30 && person.getAge() <= 40)
                .map(Person::getFirstName)
                .collect(Collectors.toList());

        System.out.println("Names of people between 30 and 40 years old: " + namesBetween30And40);

        boolean allHaveCity = people.stream()
                .allMatch(person -> person.getGeography() != null && !person.getGeography().isEmpty());

        System.out.println("Do all people have a city value assigned? " + allHaveCity);

        boolean hasNameEndingWithY = people.stream()
                .anyMatch(person -> person.getFirstName().toLowerCase().endsWith("y"));

        System.out.println("Is there a person with a name ending with 'y'? " + hasNameEndingWithY);

        int maxAgeYoungerThan40 = people.stream()
                .filter(person -> person.getAge() < 40)
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        System.out.println("Maximum age among people younger than 40: " + maxAgeYoungerThan40);

        List<String> occupationsWithA = people.stream()
                .filter(person -> person.getFirstName().toUpperCase().startsWith("A"))
                .map(Person::getProfession)
                .collect(Collectors.toList());

        System.out.println("Occupations of people with names starting with 'A': " + occupationsWithA);

        String uniqueCities = people.stream()
                .map(Person::getGeography)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Unique cities: " + uniqueCities);
    }
}