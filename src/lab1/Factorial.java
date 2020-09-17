package lab1;

public class Factorial {
    static int Fact(int n){
        int first = 1;
        for (int i = 1; i <=n; i ++){
            first = first*i;
        }
        return first;
    }

    public static void main(String[] args){
        System.out.println(Fact(5));
    }
}