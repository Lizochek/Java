package lab8_1;

import java.util.Scanner;

public class DemoClass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MyArrayList toDo =new MyArrayList() ;
        for ( ; ; ) {

            //System.out.println(scanner.next() );
           String instruction = scanner.next();
           try {
               switch (instruction) {
                   case "LIST":
                       toDo.list();
                       break;
                   case "ADD":
                       if (scanner.hasNextInt()) {
                           toDo.add(scanner.nextInt()-1, scanner.nextLine());
                       } else {
                           toDo.add(scanner.nextLine());
                       }
                       break;
                   case "EDIT":
                       if(scanner.hasNextInt()){
                           toDo.edit(scanner.nextInt()-1, scanner.nextLine());
                       }
                       else {
                           scanner.nextLine();
                           System.err.println("Error,undefined instruction");
                       }
                       break;
                   case "DELETE":
                       if(scanner.hasNextInt())
                           toDo.delete(scanner.nextInt()-1);
                       else {
                           scanner.nextLine();
                           System.err.println("Error,undefined instruction");
                       }
                       break;
                   default:
                       scanner.nextLine();
                       System.err.println("Error,undefined instruction");
                       break;
               }
           }catch (IndexOutOfBoundsException ex) {
               scanner.nextLine();
               System.err.println(" Index out of range");
           }

        }

    }
    }
/*scanner.hasNext("regexp");*/