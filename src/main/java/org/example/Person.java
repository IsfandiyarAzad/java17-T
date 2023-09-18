package org.example;

public class Person {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final String geography;
    private final String email;
    private final String profession;
    private final Integer salary;
    private final Integer isAlive;


    public Person(Integer id ,String firstName,String lastName, Integer age, String gender, String geography, String email, String profession, Integer salary, Integer isAlive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName=lastName;
        this.age = age;
        this.gender = gender;
        this.geography = geography;
        this.email = email;
        this.profession = profession;
        this.salary = salary;
        this.isAlive = isAlive;

    }

    // Getters for the Person class

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){return lastName;}
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getGeography() {
        return geography;
    }

    public Object getEmail() {
        return email;
    }

    public String getProfession() {
        return profession;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getIsAlive() {
        return isAlive;
    }
}
