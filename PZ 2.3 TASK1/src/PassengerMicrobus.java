public class PassengerMicrobus extends PassengerCar{
    public PassengerMicrobus(String model, double price, int fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
    // Метод для пасажирських мікроавтобусів
    public void specialMethod() {
        System.out.println("Це пасажирський мікроавтобус");
    }
}