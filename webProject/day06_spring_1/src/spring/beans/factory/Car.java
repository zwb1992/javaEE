package spring.beans.factory;

/**
 * Created by zwb on 17/3/27.
 */
public class Car {
    private String name;
    private double price;
    private String color;

    public Car() {
    }

    public Car(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", price=" + price +
                ", color=" + color +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
