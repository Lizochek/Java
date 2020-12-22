package lab78;

import java.util.Random;

class Operator extends Employee implements EmployeePosition {
    public Operator(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = "Operator";

        Random random = new Random();
        employeeIncome = 0;
        fixSalary = random.nextInt(120000 - 100000) + 100000;

    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary() {
        return fixSalary;
    }

    @Override
    public int compareTo(Employee emp) {
        return (int) (emp.calcSalary() - this.calcSalary());
    }
}
