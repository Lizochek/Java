public class Animal {
    int number = 4;
    double num = 3.14;
    String text = "hello";
    char symbol;
    String name;
    boolean flag = true;
    int Sum(int a, int b){
        return a + b;
    }
    void Mes(String message){
        System.out.println(message);
    }
void Animal(String _name, int _age){
       this.name = _name;
}

}
class App{
    public static void main(String[] args) {

        Animal animal = new Animal();
        Mammals mammals= new Mammals();

        mammals.Mes2();
    }
}
class Mammals extends Animal{
    void Mes2(){
        System.out.println("This is mammal");
    }
}
