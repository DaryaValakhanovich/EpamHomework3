import task1.entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.DataBinder;
import task1.validators.EmployeeValidator;

public class ValidationTest {

    @Test
    void testEmployeeValidation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Context1.xml");
        Employee employee = (Employee) context.getBean("testEmployee");
        DataBinder binder = new DataBinder(employee);
        binder.setValidator(new EmployeeValidator());
        binder.validate();
        Assertions.assertEquals(binder.getBindingResult().getErrorCount(), 2);
    }
}
