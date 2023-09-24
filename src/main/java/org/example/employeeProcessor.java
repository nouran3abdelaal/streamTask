package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class employeeProcessor {
    List<employee> employeeList;

    public employeeProcessor() {
        this.employeeList = List.of(
                new employee(1, "name1", "D1", 12),
                new employee(2, "name2", "D1", 13),
                new employee(3, "name3", "D1", 14),
                new employee(4, "name4", "D1", 22),
                new employee(5, "name5", "D1", 33),
                new employee(6, "name6", "D1", 124),
                new employee(7, "name7", "D1", 44)
        );
    }

    public List<employee> getEmployeeDepartment(List<employee> employeeList, String department) {
        return employeeList.stream().filter(e -> e.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public List<String> getEmployeesNames(List<employee> employeeList) {
        return employeeList.stream().map(employee::getName).collect(Collectors.toList());

    }
    public double getSalarySum(List<employee> employeeList) {
        return employeeList.stream().mapToDouble(employee::getSalary).sum();

    }
    public List<employee> getIncrementedEmployeeSalary(List<employee> employeeList, double increase) {
        return employeeList.stream().map(e->{
           double newSalary= e.getSalary()+increase;
           e.setSalary(newSalary);
           return e;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        employeeProcessor e1 = new employeeProcessor();
        System.out.println(e1.getEmployeesNames(e1.employeeList));
        System.out.println(e1.getSalarySum(e1.employeeList));

       e1.getEmployeeDepartment(e1.employeeList,"D1").forEach(System.out::println);
        System.out.println();
        e1.getIncrementedEmployeeSalary(e1.employeeList,2500).forEach(System.out::println);

    }
}
