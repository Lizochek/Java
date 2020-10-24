/*package lab12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class MyArrayList {
    public static ArrayList<String> toDoList = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String instruction= scanner.nextLine();
        for(;;)
        {
            if(instruction.contains("LIST") && instruction.indexOf("LIST")==0)
                toList();
            if(instruction.contains("ADD") && instruction.indexOf("ADD")==0)
               addList();
            if(instruction.contains("EDIT") && instruction.indexOf("EDIT")==0)
                editList();
            if(instruction.contains("DELETE") && instruction.indexOf("DELETE")==0)
                deleteList();

        }
        public void toList()
        {
            for(int i=0;i < toDoList.size();i++)
                System.out.println(i + "-" + toDoList.get(i));
        }



    }
}
*/