package task1;

import task1.entities.Employee;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task1.services.EmployeeService;
import task1.services.PositionService;
import task1.services.SalaryService;
import task1.validators.EmployeeValidator;

public class Runner {
    private static final Logger log = Logger.getLogger(String.valueOf(Runner.class));

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Context1.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService1");
        PositionService positionService = (PositionService) context.getBean("positionService1");
        SalaryService salaryService = (SalaryService) context.getBean("salaryService1");
        Employee employee1 = (Employee) context.getBean("employee1");
        Employee employee2 = (Employee) context.getBean("employee2");
        Employee employee3 = (Employee) context.getBean("employee3");
        Employee employee4 = (Employee) context.getBean("employee4");

        System.out.println("Year 1:\n" + employeeService.getEmployees());
        log.info("Year 1:\n" + employeeService.getEmployees());

        employeeService.hireEmployee(employee2);
        employeeService.hireEmployee(employee3);
        yearSalaryChange(salaryService, positionService);
        System.out.println("Year 2:\n" + employeeService.getEmployees());
        log.info("Year 2:\n" + employeeService.getEmployees());

        employeeService.hireEmployee(employee4);
        employeeService.fireEmployee(employee2);
        yearSalaryChange(salaryService, positionService);
        System.out.println("Year 3:\n" + employeeService.getEmployees());
        log.info("Year 3:\n" + employeeService.getEmployees());

        employeeService.fireEmployee(employee1);
        yearSalaryChange(salaryService, positionService);
        System.out.println("Year 4:\n" + employeeService.getEmployees());
        log.info("Year 4:\n" + employeeService.getEmployees());

        EmployeeValidator validator = new EmployeeValidator();
        validator.supports(Employee.class);
    }

    private static void yearSalaryChange(SalaryService salaryService, PositionService positionService) {
        positionService.getPositions().forEach(position -> salaryService.change(position.getSalary()));
    }
}
