package lab8.lab8_2;

import java.util.Scanner;

class Rectangle {
    double length;
    double width;

    public void getInformation() {
        Scanner sc = new Scanner(System.in);
        length = Double.parseDouble(sc.nextLine());
        width = Double.parseDouble(sc.nextLine());
    }

    public double getArea(){
        return length * width;
    }
    public double getPerimeter(){
        return (length + width) * 2;
    }
    public void display(){
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}

public class Lab8_2 {
    public static void main(String[]args) {
        Rectangle r = new Rectangle();
        r.getInformation();
        r.display();
    }
}
