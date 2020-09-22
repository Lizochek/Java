package урок19092020;

public class Main2 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.MakeSound();
        dog.MakeSound();
    }
}
interface Animal{

    void MakeSound();
}
class Dog implements Animal{

    @Override
    public void MakeSound() {
        System.out.println("Wof-Wof");
    }
}
class Cat implements Animal{

    @Override
    public void MakeSound() {
        System.out.println("Meow-Meow");

    }
}