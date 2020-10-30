package oldschool.lab78.lab1;

import java.util.Scanner;
public class Сycles {
    public static void main(String[] args) {
        int n, arr[];
        int sum1=0,sum2=0,sum3=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        int j=0, k=0;
        arr = new int [n];
        for (int i = 0; i < arr.length;i++)
            arr[i] = (int) ( Math.random() * n);

        for (int i : arr)
            System.out.print(i + " ");
        for (int i=0;i< arr.length;++i)
            sum1+=arr[i];

        System.out.println(System.lineSeparator());

        while(j != arr.length){
            sum2+=arr[j];
            j++;
        }
        System.out.println(System.lineSeparator());
        do{
            sum3+=arr[k];
            k++;
        }while(k < arr.length);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }


}


