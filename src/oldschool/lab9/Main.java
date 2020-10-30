package oldschool.lab9;

/*public class Main {
    public static void main(String[] args) {
        Company city = new Company();

        System.out.println("Самые высокие запрлаты в компании:");
        List<Employee> list = city.getTopSalaryStaff(10);
        for (int i = 0; i < list.size(); i++)
            System.out.println(i+1 +" "+ list.get(i));
        System.out.println();

        list = city.getLowestSalary(30);
        System.out.println("Самые низкие запрлаты в компании:");
        for (int i = 0; i < 30; i++)
            System.out.println(i+1 +" "+list.get(i));
        System.out.println();

        System.out.println("произошло увольнение сотрудников... ");
        for (int i = (city.getAllEmployeesSize() - 1); i >= 0; i-=2){
            city.fire(i);
        }

        System.out.println("Самые высокие запрлаты в компании:");
        list = city.getTopSalaryStaff(10);
        for (int i = 0; i < 10; i++)
            System.out.println(i+1 +" "+list.get(i));
        System.out.println();

        System.out.println("Самые низкие запрлаты в компании:");
        list = city.getLowestSalary(30);
        for (int i = 0; i < 30; i++)
            System.out.println(i+1 +" "+list.get(i));
    }
}

abstract class Employee implements Comparable<Employee> {
    protected String name;
    protected String surname;
    protected int birthday;
    protected String placeOfLive;
    protected int number;
    protected double salary;

    public String toString() {
        return name + " " + surname + " " + birthday + " " + placeOfLive + " " + number + " " + (int) salary;
    }
   /*public void HandleEmployees(){

   }

}

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

}
*/