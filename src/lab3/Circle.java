package lab3;
import java.util.Scanner;

public class Circle {
    public int R;
    public Circle(){

    }
    public void get() {
        System.out.println("Введите параметры: ");
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
    }

}
class CircleTest{
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.get();
    }
}