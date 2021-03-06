package oldschool.lab6;

import oldschool.lab5.Shape;

import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        double a,b;
        int x1,x2;
        int y1,y2;
        int x3,y3;
        int x4,y4;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ширину прямоугольника ");
        a = sc.nextDouble();
        System.out.println("Введите длину прямоугольника ");
        b = sc.nextDouble();
        System.out.println("Введите координаты первой точки ");
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        System.out.println("Введите координаты второй точки ");
        x2 = sc.nextInt();
        y2 = sc.nextInt();

        System.out.println("Введите насколько подвинуть по оси X первую точку");
        x3 = sc.nextInt();
        System.out.println("Введите насколько подвинуть по оси Y первую точку ");
        y3 = sc.nextInt();
        System.out.println("Введите насколько подвинуть по оси X вторую точку");
        x4 = sc.nextInt();
        System.out.println("Введите насколько подвинуть по оси Y вторую точку ");
        y4 = sc.nextInt();

        MovablePoint p1 = new MovablePoint(x1,y1,x3,y3);
        MovablePoint p2 = new MovablePoint(x2,y2,x4,y4);
        MovableRectangle rectangle = new MovableRectangle(a,b,p1,p2);
        System.out.println(rectangle.toString());
        rectangle.checkSpeed();
        rectangle.moveUp();
        rectangle.moveDown();
        rectangle.moveRight();
        rectangle.moveLeft();
        System.out.println(rectangle.toString());
    }
}
interface Movable {
    void moveUp();
    void moveDown();
    void moveRight();
    void moveLeft();
}
class Rectangle extends Shape {
    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int a;
    int b;

    public void CalcArea() {
        System.out.println("Area of Rectangle = " + a * b);
    }

    public String toString() {
        return "Прямоугольник: " +
                "Ширина: " + a +
                "Длина: " + b;
    }
}
class MovablePoint implements Movable{

    int x;
    int y;
    int xSpeed;
    int ySpeed;
    public MovablePoint(int x,int y,int xSpeed,int ySpeed){
        this.x=x;
        this.y=y;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    @Override
    public void moveUp() {
        this.y += this.ySpeed;
    }
    public void moveDown() {
        this.y -= this.ySpeed;
    }
    public void moveRight() {
        this.x += this.xSpeed;
    }
    public void moveLeft() {
        this.x -= this.xSpeed;
    }

    @Override
    public String toString() {
        return
                "(" + x +
                        ", " + y +")"+
                        "\nПодвинули " + "("+xSpeed +", "+ ySpeed+")";
    }
}
class MovableRectangle implements Movable{
    protected double a,b;
    MovablePoint p1;
    MovablePoint p2;
    public MovableRectangle(double a,double b,MovablePoint p1,MovablePoint p2){
        this.a = a;
        this.b = b;
        this.p1 = p1;
        this.p2 = p2;

    }
        public void checkSpeed(){
            if(p1.xSpeed == p2.xSpeed && p1.ySpeed == p2.ySpeed) {
                System.out.println("Одинаковые скорости");
            }
            else {
                System.out.println("Скорости разные ... Приравниваем  ");
                p1.xSpeed = p1.xSpeed;
                p2.ySpeed = p2.ySpeed;
            }
        }
        @Override
        public void moveUp() {
            this.p1.y += this.p1.ySpeed;
            this.p2.y += this.p2.ySpeed;

        }
        @Override
        public void moveDown() {
            this.p1.y -= this.p1.ySpeed;
            this.p2.y -= this.p2.ySpeed;
        }
        @Override
        public void moveRight() {
            this.p1.x += this.p1.xSpeed;
            this.p2.x += this.p2.xSpeed;
        }
        @Override
        public void moveLeft() {
            this.p1.x -= this.p1.xSpeed;
            this.p2.x -= this.p2.xSpeed;
        }
        public String toString() {
            return "Движущийся прямоугольник: \n" +
                    "Длина:" + b +"\n"+
                    "Ширина: " + a +"\n"+
                    "Точка 1 =" + p1 +"\n"+
                    "Точка 2 =" + p2 +"\n";
        }
    }
