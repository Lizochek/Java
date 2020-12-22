package lab78;
import java.util.*;
/*Задание на практическую работу №7-8
1.Создайте класс Employee, определяющий сотрудника. Необходимые поля
– Фамилия, Имя, фиксированная часть зарплаты(оклад), должность(см пункт 2).
2. Создайте интерфейс EmployeePosition, определяющий должность.
Определите в нем метод String getJobTitle(), возвращающий название занимаемой
должности, и double calcSalary(double baseSalary), возвращающий зарплату сотрудника,
в соответствии с фиксированным окладом.
3.Создайте классы, определяющие должности сотрудников. Все они должны реализовывать
интерфейс EmployeePosition
a. Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от
заработанных для компании денег. Количество заработанных денег для компании
генерируйте случайным образом от 115 000 до 140 000 рублей.
b. TopManager — зарплата складывается из фиксированной части и бонуса в виде 150%
от заработной платы, если доход компании более 10 млн рублей.
c. Operator — зарплата складывается только из фиксированной части.
4. Создайте класс компании Company, содержащий сотрудников и реализующей методы:
· найм одного сотрудника — hire(),
· найм списка сотрудников – hireAll(),
· увольнение сотрудника – fire(),
· получение значения дохода компании – getIncome().
Аргументы и возвращаемое значение методов выберите на основании логики работы
вашего приложения.
Создайте два метода, возвращающие список указанной длины (count). Они должны
содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
· List<Employee> getTopSalaryStaff(int count),
· List<Employee> getLowestSalaryStaff(int count).
Аргументы и возвращаемое значение метода выберите в соответствии с
логикой начисления зарплат.*/

public class main {
    public static void main(String[] args) {
        Company city = new Company();

        for (int i = 0; i < 180; i++){
            Operator operator = new Operator("Operator"," " + i);
            city.hire(operator);
        }

        for (int i = 0; i < 80; i++){
            Manager manager = new Manager("Manager", "    " + i);
            city.hire(manager);
        }

        for (int i = 0; i < 10; i++){
            TopManager topManager = new TopManager("TopManager", " "+i, city);
            city.hire(topManager);
        }

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


