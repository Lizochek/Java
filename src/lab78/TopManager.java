package lab78;

import java.util.Random;

class TopManager extends Employee implements EmployeePosition {

    Company comp;

    public TopManager(String name, String lastName, Company comp) {
        this.name = name;
        this.surname = lastName;
        this.jobTitle = "TopManager";
        this.comp = comp;

        Random random = new Random();
        employeeIncome = 0;
        fixSalary = random.nextInt(140000 - 115000) + 150000;

    }

    //public void setIncome(double income) {
     //   this.income = income;
   // }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary() {
        //найти прибыль компании
        if (comp.getIncome()> 10000000)
            return 2.5 * fixSalary;
        return fixSalary;
    }

    @Override
    public int compareTo(Employee emp) {
        return (int) (emp.calcSalary() - this.calcSalary());
    }
}
