package lab2;
import java.util.Scanner;

public class Dog {
    public  String nickname;
    public  int age;
    public int chel_age ;
    public Dog(String nickname,int age){
        this.nickname = nickname;
        this.age = age;
    }
    public void get(String nickname, int age){
        Scanner in = new Scanner(System.in);
        nickname = in.nextLine();
        age = in.nextInt();
    }
    /*public void show(String nickname, int age){
        System.out.println(get(nickname , age));
    }*/
    public void transfer(int age){

        chel_age = age*7;
        System.out.println(chel_age);
    }
    public void ToString() {
        String ageS = String.valueOf(age);
        String chel_ageS = String.valueOf(chel_age);
        System.out.println();
    }

    }
class KennelDog{
    public static int age;
    public static String nick;
    public static void main(String[] args){
        Dog dog = new Dog(nick, age);
        dog.toString();
    }
}
