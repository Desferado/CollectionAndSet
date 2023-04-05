package pro.sky.CollectionAndSet.Service;

import pro.sky.CollectionAndSet.EmployeeData.Employee;

import java.util.Collection;

public interface EmployeesService {

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}
