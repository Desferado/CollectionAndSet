package pro.sky.CollectionAndSet.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CollectionAndSet.EmployeeData.Employee;
import pro.sky.CollectionAndSet.Service.EmployeesService;

import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
       private EmployeesService employees;

    public EmployeeController(EmployeesService employees) {

        this.employees = employees;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        return employees.addEmployee(name, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        return employees.removeEmployee(name, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        return employees.findEmployee(name, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return employees.findAll();
    }

}
