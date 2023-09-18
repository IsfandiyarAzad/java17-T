package filesAndstream;


import org.example.Person;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String filePath="/home/isfandiyar/Downloads/StreamPracticeWithCSVFile.csv";
        try(BufferedReader reader= new BufferedReader(new FileReader(filePath))){
            List<Person> people=reader.lines().skip(1).map(line->{
                String [] parts=line.split(",");
                return new Person(Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        parts[4],
                        parts[5],
                        parts[6],
                        parts[7],
                        Integer.parseInt((parts[8])),
                        Integer.parseInt(parts[9]));
            }).collect(Collectors.toList());

            List<Person> filteredByAge =people.stream()
                    .filter(person -> person.getAge()>=25 && person.getAge()<=32)
                    .collect(Collectors.toList());

            List<Object> emailAddresses = filteredByAge.stream()
                    .map(Person::getEmail)
                    .sorted()
                    .collect(Collectors.<Object>toList());


            filteredByAge.stream()
                    .map(Person::getEmail)
                    .sorted()
                    .collect(Collectors.toList());


            try(FileWriter writer= new FileWriter("PersonsEmailAddresses.txt")){
                for(Object email :emailAddresses){
                    writer.write(email+"\n");
                }

            }
            Double averageSalary=people.stream()
                    .mapToDouble(Person::getSalary)
                    .average()
                    .orElse(0.0);
            System.out.println("Average Salary: " + averageSalary);

            Person highestSalary=people.stream()
                    .max(Comparator.comparingDouble(Person::getSalary))
                    .orElse(null);
            System.out.println("Perron With Highest salary: " + highestSalary);

            Map<String,Long> geographyCounts =people.stream()
                    .collect(Collectors.groupingBy(Person::getGeography,Collectors.counting()));
            System.out.println("Geography counts : " + geographyCounts);

            Long malesCount=people.stream()
                    .filter(Person->"Males".equals(Person.getGender())).count();
            Long femalesCounts=people.size()-malesCount;
            System.out.println("Number of Females : "+femalesCounts);
            System.out.println("Number of Males: " + malesCount);

            Double totalSalaryOfAlivePerson=people.stream()
//                    .filter(Person::getIsAlive)
                    .mapToDouble(Person::getSalary).sum();
            System.out.println("Total salary of alive person : " + totalSalaryOfAlivePerson);

            Map<String ,Double> professionTotalSalary=people.stream()
                    .collect(Collectors.groupingBy(Person::getProfession,Collectors.summingDouble(Person::getSalary)));
            System.out.println("Total Salary by Profession : " + professionTotalSalary);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}