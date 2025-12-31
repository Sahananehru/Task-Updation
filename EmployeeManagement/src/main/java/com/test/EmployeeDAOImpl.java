package com.test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class EmployeeDAOImpl implements EmployeeDAO {
 
    // This list acts like a database
    private List<Employee> employeeList = new ArrayList<>();
 
    @Override
    public Employee addEmployee(Employee emp) {
        employeeList.add(emp);
        return emp;
    }
 
    @Override
    public Employee updateEmployee(Employee emp) {
        for (Employee e : employeeList) {
            if (e.getId() == emp.getId()) {
                e.setName(emp.getName());
                e.setSalary(emp.getSalary());
                return e;
            }
        }
        return null; // employee not found
    }
 
    @Override
    public void deleteEmployee(int id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
 
    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}