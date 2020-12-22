package lab78;

import java.util.Random;

class Manager extends Employee implements EmployeePosition {
    public Manager(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = "Manager";

        Random random = new Random();
        employeeIncome = random.nextInt(180000 - 100000) + 100000;
        fixSalary = random.nextInt(180000 - 150000) + 150000;

    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary() {
        return fixSalary + 0.05 * employeeIncome;
    }

    @Override
    public int compareTo(Employee emp) {
        return (int) (emp.calcSalary() - this.calcSalary());
    }
}
