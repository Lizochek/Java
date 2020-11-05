package lab8_2;

import java.util.Scanner;

public class DemoClass {

    public static void main(String[] args) {


        EmailBase emailBase = new EmailBase();
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {

            String instruction = scanner.next();
            try {
                switch (instruction) {
                    case "LIST":
                        emailBase.list();
                        break;
                    case "ADD":

                        String s= scanner.next();
                        scanner.nextLine();
                        try {
                            emailBase.add(s);
                        }catch (IllegalArgumentException exception){
                             System.out.println(exception.getMessage());
                        }
                        //emailBase.add(scanner.nextLine());

                        break;

                    default:
                        scanner.nextLine();
                        System.err.println("Error,undefined instruction");
                        break;
                }
            } catch (IndexOutOfBoundsException ex) {
                scanner.nextLine();
                System.err.println(" Index out of range");
            }


        }
    }
}