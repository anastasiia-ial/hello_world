package com.company;

import java.util.*;

/*
class Employee {
    String name;
    Integer salary;
}
2.1
создать TreeSet из обектов Employee таким образом что они были отсортированы по зарплате если зарплата обинаковая то по имени
        SortedSet<Employee> set = new TreeSet<>();
        set.add(new Employee("Name1", 34));
        set.add(new Employee("Name5", 12));
        set.add(new Employee("Name4", 11));
        set.add(new Employee("Name3", 22));

2.2 создать список из таких элементов и отсортировать по зарплате.
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name - " + name + " : salary - " + salary;
    }

    @Override
    public int compareTo(Employee employee) {
        if (getSalary() > employee.getSalary()) {
            return -1;
        }
        if (getSalary() < employee.getSalary()) {
            return 1;
        }
        return getName().compareTo(employee.getName());
    }

    public static void main(String[] args) {

        List<Employee> list = getList();

        System.out.println("TreeSet:");
        Set<Employee> set = new TreeSet<>(list);
        for (Employee employee : set) {
            System.out.println(employee);
        }

        System.out.println("Initial list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        sortList(list);
        System.out.println("Sorted list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Employee> getList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Саша", 1));
        employees.add(new Employee("Паша", 9));
        employees.add(new Employee("Ваня", 9));
        employees.add(new Employee("Женя", 2));
        employees.add(new Employee("Вова", 4));
        employees.add(new Employee("Рома", 2));
        employees.add(new Employee("Сиду", 9));
        employees.add(new Employee("Марк", 5));
        return employees;
    }

    public static void sortList(List<Employee> list) {
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() > o2.getSalary() ? -1 :
                        o1.getSalary() < o2.getSalary() ? 1 :
                                o1.getName().compareTo(o2.getName());
            }
        });
    }
}

