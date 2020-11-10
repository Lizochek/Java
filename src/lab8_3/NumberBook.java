package lab8_3;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberBook {
    private Map<String,String> numbers;
    public NumberBook(){

       numbers = new HashMap<String, String>();

    }
    public void list(){
        numbers.forEach( (key,value) -> System.out.println(key+": +7 ("+
                value.substring(0,3)+") " + value.substring(3,6) + "-" +
                value.substring(6,8) +"-" +value.substring(8,10)) );

    }
    public void add(String name,String phone) throws IllegalArgumentException{
        if(isNewName(name) && isNewPhone(phone))
            numbers.put(name,getUnformattedPhone(phone));
        else{
            if(!isNewName(name)  )
                throw new IllegalArgumentException("Name is not unique or does not match format");
            else
                throw  new IllegalArgumentException("Phone is not unique or does not match format");
        }

    }
    public boolean isNewName(String s){
       return isValid(s,PATTERN_NAME) && !numbers.containsKey(s) ;
    }
    public boolean isNewPhone(String s){
        return isValid(s,PATTERN_PHONE) && !numbers.containsValue(getUnformattedPhone(s)) ;
    }

    public static final String PATTERN_NAME = "^[A-ZА-Я]{1}([a-zа-я]+)*([-]{1}[A-ZА-Я]{1})?([a-zа-я]+)*$";
    public static final String PATTERN_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?(\\d{3})\\)?[\\- ]?)?([\\d]{3})[\\- ]?([\\d]{2})[\\- ]?([\\d]{2})$";
    //public static final String PATTERN_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    //public static final String PATTERN_PHONE = "^(\\+7|8){1}([0-9]+){10}$";

    static boolean isValid(String s,String PATTERN) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }
    private String getUnformattedPhone(String s){
        Pattern pattern = Pattern.compile(PATTERN_PHONE);
        Matcher matcher = pattern.matcher(s);
       // MatchResult mach = matcher.toMatchResult();
        matcher.find();
        return matcher.group(4)+matcher.group(5)+matcher.group(6)+matcher.group(7);

    }


}
