public class Main {
    public static void main(String[] args) {
        Car car1 = new PassengerCar("Toyota Camry", 12000, 6, 280);
        Car car2 = new Truck("Volvo FH16", 8000, 15, 180, 25000);
        Car car3 = new PassengerMicrobus("Mercedes Sprinter", 25000, 13, 250);

        Car[] cars = {car1, car2, car3};

        TaxiPark taxiPark = new TaxiPark(cars);

        System.out.println("Сумарна вартість автомобілів в автопарку: " + taxiPark.calculateTotalPrice() + " грн\n");

        taxiPark.sortByFuelConsumption();
        System.out.println("***********************************************************************");
        System.out.println("Автомобілі відсортовані за витратою пального:");
        for (Car car : cars) {
            car.displayInfo();
            System.out.print("\n");
        }
        System.out.println("***************************************************************************");
        int maxSpeed = 180;
        Car[] carsWithMaxSpeed = taxiPark.findCarsByMaxSpeed(maxSpeed);
        System.out.println("___________________________________________________________________________");
        System.out.println("Автомобілі з максимальною швидкістю " + maxSpeed + " км/год:");
        for (Car car : carsWithMaxSpeed) {
            car.displayInfo();
            System.out.println("___________________________________________________________________________");
        }

        // Виклик методу specialMethod() для легкового автомобіля
        if (car1 instanceof PassengerCar) {
            PassengerCar passengerCar = (PassengerCar) car1;
            passengerCar.specialMethod();
        }
        System.out.println("---------------------------------------------------------------------------");
        Car searchCar = new PassengerCar("Toyota Camry", 1200, 6, 280);
        int hashCode = searchCar.hashCode();
        Car foundCar = taxiPark.findCarByParameters(hashCode, searchCar);
        if (foundCar != null) {
            System.out.println("Знайдено авто із зазначеними параметрами: " + foundCar.getMaxSpeed());
        } else {

            System.out.println("Автомобіль із зазначеними параметрами не знайдено");
        }
    }
}