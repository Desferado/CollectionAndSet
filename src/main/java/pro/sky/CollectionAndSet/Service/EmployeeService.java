package pro.sky.CollectionAndSet.Service;

import org.springframework.stereotype.Service;
import pro.sky.CollectionAndSet.EmployeeData.Employee;
import pro.sky.CollectionAndSet.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.CollectionAndSet.Exceptions.EmployeeNotFoundException;

import java.util.Collections;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeesService {


    private final Map<String,Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
    employees.put(employee.getFullName(), employee);
    return employee;
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(employee.getFullName())) {
                return employees.remove(employee.getFullName());
            }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(employee.getFullName())) {
                return employees.get(employee.getFullName());
            }

        throw new EmployeeNotFoundException("No matches");
    }

    @Override
    public Collection <Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


}
