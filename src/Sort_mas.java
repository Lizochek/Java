import java.util.Scanner;
import java.util.Arrays;
public class Sort_mas {
    public static void main(String[] args) {
        int n,mas[];
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        mas = new int[n];
        for(int i = 0; i < mas.length; ++i)
        mas[i] = (int) (Math.random() * n);
        for(int i:mas)
            System.out.print(i + " ");
        Arrays.sort(mas);
        System.out.println(System.lineSeparator());
        for(int i:mas)
        System.out.print( i + " ");
    }
}
