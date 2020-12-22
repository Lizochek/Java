package lab8_1;

import java.util.ArrayList;

public class MyArrayList {
    private ArrayList<String> toDoList ;
    public MyArrayList(){
       toDoList = new ArrayList();

    }
    public void list(){
        for (int i = 1; i <= toDoList.size(); i++)
            System.out.println(i + "-" + toDoList.get(i-1));

    }
    public void add(String val){
        toDoList.add(val);
    }
    public void add(int pos,String val) throws IndexOutOfBoundsException{
       // if(pos>=toDoList.size()) toDoList.add(val);
       // else
        toDoList.add( pos, val);
    }
    public void edit(int pos,String val) throws IndexOutOfBoundsException{
        toDoList.set(pos,val);
    }
    public void delete(int pos) throws IndexOutOfBoundsException  {

        toDoList.remove(pos);

    }



}
