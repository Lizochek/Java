package lab8_2;

import java.util.TreeSet;


public class EmailBase {
    private TreeSet<String> emailBase;

    public EmailBase(){
        emailBase = new TreeSet<>();

    }
    public void list(){
        for (String i : emailBase)
            System.out.println(i);

    }
    public void add (String val) throws IllegalArgumentException{

        if(Check.isEmail(val))
        emailBase.add(val);
      else
          throw new IllegalArgumentException("It's invalid email");
    }



}
