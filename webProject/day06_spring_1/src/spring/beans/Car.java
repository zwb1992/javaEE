package spring.beans;

/**
 * Created by zwb on 17/3/27.
 */
public class Car {
    private int brand;
    private double price;
    private String color;

    public Car() {
    }

    public Car(int brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", price=" + price +
                ", color=" + color +
                '}';
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
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
