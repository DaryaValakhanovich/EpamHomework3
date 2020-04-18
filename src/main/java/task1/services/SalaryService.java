package task1.services;

import task1.entities.Salary;

public class SalaryService {
    public void change(Salary salary) {
        salary.setCount(salary.getCount() + (Math.random() - Math.random()) * 15);
    }
}
