package lab78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {
    private ArrayList<Employee> allEmployees = new ArrayList<>();

    List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count < allEmployees.size()) {
            ArrayList<Employee> list1 = allEmployees;
            Collections.sort(list1);
            ArrayList<Employee> list2 = new ArrayList<>();
            for (int i = 0; i < count; i++)
                list2.add(list1.get(i));
            return list2;
        }
        return null;
    }

    List<Employee> getLowestSalary(int count) {
        if (count > 0 && count < allEmployees.size()) {
            ArrayList<Employee> list1 = allEmployees;
            Collections.sort(list1, Collections.reverseOrder());
            ArrayList<Employee> list2 = new ArrayList<>();
            for (int i = 0; i < count; i++)
                list2.add(list1.get(i));
            return list2;
        }
        return null;
    }

    void hire(Employee man) {
        allEmployees.add(man);
    }

    void hireAll(List<Employee> emplo) {
        for (Employee empl : emplo)
            allEmployees.add(empl);
    }

    void fire(int emp) {
        for (int i = 0; i < allEmployees.size(); i++) {
            if (i == emp)
                allEmployees.remove(i);
        }
    }

    int getAllEmployeesSize() {
        return allEmployees.size();
    }

    List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public double getIncome() {
        int income = 0;
        for (Employee man : getAllEmployees())
            income += man.getHisIncome();
        return income;
    }
}
