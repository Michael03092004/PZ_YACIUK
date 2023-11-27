public class Truck extends Car{//  Клас для вантажних автомобілів
    private  int cargoCapacity;

    public Truck(String model, double price, int fuelConsumption, int maxSpeed, int cargoCapacity) {
        super(model, price, fuelConsumption, maxSpeed);
        this.cargoCapacity = cargoCapacity;
    }
    // Метод для вантажних автомобілів
    public void specialMethod() {
        System.out.println("Вантажопідйомність: " + cargoCapacity + " кг");
    }

}