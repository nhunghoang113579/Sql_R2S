package classObject.lab1;

public class Circle {
    double radius;
    double area;

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius,2) ;
    }
}
