package collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee {
    private String firstName;

    private String lastName;
    private int age;
    private String department;

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Employee(String firstName, String lastName, int age, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", "Doe", 28, "QA"),
                new Employee("Alice", "Smith", 35, "Development"),
                new Employee("Bob", "Johnson", 42, "QA"),
                new Employee("Carol", "White", 29, "HR"),
                new Employee("David", "Black", 31, "Development")
        );

        employees.stream().filter(e -> e.getAge() > 30)
                .forEach(e -> System.out.println((e.firstName + " " + e.lastName + " " + e.age)));

        System.out.println("Grouped by department");
        Map<String, List<String>> groupedByDep = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(e->e.firstName + " " + e.lastName, Collectors.toList())));
        System.out.println(groupedByDep);
        
        //        Map<String, List<String>> gropedByDepartment = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.mapping(e -> e.getFirstName() + " " + e.getLastName(), Collectors.toList())));
//        System.out.println(gropedByDepartment);
//        //  employees.stream().map(e-> e.firstName + " "+ e.lastName, )
//        //Задача 3: Знайти найстаршого працівника в кожному відділі
//
//        Map<String, Optional<Employee>> gropedByDepartment2 = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.maxBy(Comparator.comparing(Employee::getAge))));
//        Predicate<Employee> predicate = employee -> employee.getDepartment().equals("QA");
//        System.out.println(employees.stream().filter(predicate).collect(Collectors.toList()));
//
//        Map<String, List<String>> gropedByDepEmpLastNames = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.mapping(Employee::getLastName, Collectors.toList())));
//
//        employees.stream().filter(e -> e.getDepartment().equals("Development")).max(Comparator.comparing(Employee::getAge));
//        System.out.println(employees.stream().filter(e -> e.getDepartment().equals("QA")).toList());
//        //Get average age of Development employees?
//        System.out.println(employees.stream().filter(e -> e.getDepartment().equals("Development")).mapToInt(Employee::getAge).average());
//        System.out.println(employees.stream().max(Comparator.comparing(Employee::getAge)));
//        //Group employees by department?
//        Map<String, List<Employee>> gropedByDepartment3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println(gropedByDepartment3);
//        //find the oldest employee in the QA department.
//        System.out.println(employees.stream()
//                .filter(e -> e.getDepartment()
//                        .equals("QA")).max(Comparator.comparing(Employee::getAge))
//                .stream().toList());
//
//        //Task: Get a comma-separated string
//        // of all last names of employees in the Development department, sorted alphabetically.
//
//        System.out.println(employees.stream().filter(e -> e.getDepartment().equals("Development")).map(Employee::getLastName).sorted().toList());
//        //Count how many employees are above the age of 30, grouped by department.
//        Map<String, Long> depCount = employees.stream()
//                .filter(e -> e.getAge() > 30).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        depCount.forEach((d, co) ->
//                System.out.println("Department: " + d + " count: " + co));
    }

}
