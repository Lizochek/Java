package lab78;

abstract class Employee implements Comparable<Employee> ,EmployeePosition{
    protected String name;
    protected String surname;
    protected double fixSalary;
    protected String jobTitle;
    protected double employeeIncome;

    public double getHisIncome() {
        return employeeIncome;
    }
@Override
    public String toString() {
        return name + " " + surname + " " + (int) calcSalary();
    }

}
