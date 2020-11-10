package lab8_3;

import java.util.Scanner;
import java.util.Map;

public class DemoClass {

    public static void main(String[] args) {
        NumberBook number = new NumberBook();
        Scanner sc = new Scanner(System.in);


        for(;;)
        {
            try {
                String arg2;
                String arg1 = sc.nextLine();
                if (number.isNewName(arg1)) {
                    System.out.print("Ведите номер телефона: ");
                    arg2 = sc.nextLine();
                    number.add(arg1, arg2);
                } else if (number.isNewPhone(arg1)) {
                    System.out.print("Ведите имя: ");
                    arg2 = sc.nextLine();
                    number.add(arg2, arg1);
                } else if (arg1.equals("LIST") ) {
                    number.list();
                } else {
                    System.out.println("It is Invalid instruction");

                }
            }
            catch (IllegalArgumentException ex){
                System.err.println(ex.getMessage());
            }

            }




    }
}
