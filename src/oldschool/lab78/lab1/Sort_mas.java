package oldschool.lab78.lab1;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class Sort_mas {
    public static void main(String[] args) {
        int n,mas[],mas2[];
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();

        Random rand = new Random();
        rand.nextInt(10);

        mas = new int[n];
        mas2 = new int[n];
            for(int i = 0; i < mas.length; ++i)
            mas[i] = (int) (Math.random() * n);
                for(int i = 0; i < mas2.length; ++i)
                    mas2[i] =rand.nextInt(10);

                    for(int i:mas)
                        System.out.print(i + " ");

            System.out.println();

        for(int i:mas2)
            System.out.print(i + " ");

        System.out.println();

        Arrays.sort(mas);
        System.out.println(System.lineSeparator());
            for(int i:mas)
            System.out.print( i + " ");

        Arrays.sort(mas2);
        System.out.println(System.lineSeparator());
        for(int i:mas2)
            System.out.print( i + " ");
    }
}
