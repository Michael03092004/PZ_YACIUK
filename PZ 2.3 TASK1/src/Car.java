import java.util.Objects;

public class Car {
    private String model;
    private double price;
    private int fuelConsumption;
    private int maxSpeed;


    public Car(String model, double price, int fuelConsumption, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public   double getPrice(){
        return price;
    }
    public int getFuelConsumption(){
        return fuelConsumption;
    }
    public  int getMaxSpeed(){
        return  maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && fuelConsumption == car.fuelConsumption && maxSpeed == car.maxSpeed && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, fuelConsumption, maxSpeed);
    }

    public void displayInfo(){
        System.out.println("Модель: " + model);
        System.out.println("Ціна: " + price + " грн");
        System.out.println("Витрати пального: " + fuelConsumption + " л/100 км");
        System.out.println("Максимальна швидкість: " + maxSpeed + " км/год");
    }
}