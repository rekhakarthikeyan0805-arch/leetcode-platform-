import java.util.Scanner;

interface Shape {
    void area();
}

class Circle implements Shape {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public void area() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle = " + area);
    }
}

class Rectangle implements Shape {

    private double length;
    private double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void area() {
        double area = length * breadth;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        Shape shape;

        switch (choice) {

            case 1:
                System.out.print("Enter Radius: ");
                double r = sc.nextDouble();
                shape = new Circle(r);
                shape.area();
                break;

            case 2:
                System.out.print("Enter Length: ");
                double l = sc.nextDouble();

                System.out.print("Enter Breadth: ");
                double b = sc.nextDouble();

                shape = new Rectangle(l, b);
                shape.area();
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
