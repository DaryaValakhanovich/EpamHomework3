package task1.services;

import task1.entities.Employee;

import java.util.Set;

public class EmployeeService {
    private Set<Employee> employees;

    public EmployeeService() {
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeService(Set<Employee> employees) {
        this.employees = employees;
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "employees=" + employees +
                '}';
    }
}
