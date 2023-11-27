import java.util.Arrays;
import java.util.Comparator;

public class TaxiPark {
    private Car[] cars;

    public TaxiPark(Car[] cars) {
        this.cars = cars;
    }

    public double calculateTotalPrice() { // Сумарна вартість автомобілів в автопарку
        double totalPrice = 0;
        for (Car car : cars) {
            totalPrice += car.getPrice();
        }
        return totalPrice;
    }

    public void sortByFuelConsumption() {// Сортування автомобілів за витратою пального
        Arrays.sort(cars, Comparator.comparingInt(Car::getFuelConsumption));
    }

    public Car[] findCarsByMaxSpeed(int maxSpeed) {// Пошук автомобіля за максимальною швидкістю
        return Arrays.stream(cars)
                .filter(car -> car.getMaxSpeed() == maxSpeed)
                .toArray(Car[]::new);
    }

    public Car findCarByParameters(int hashCode, Car searchCar) {
        for (Car car : cars) {
            // Спочатку перевіряємо за значенням хеш-коду
            if (car.hashCode() == hashCode) {
                // Якщо хеш-коди рівні, перевіряємо метод equals()
                if (car.equals(searchCar)) {
                    return car; // Знайдено авто із заданими параметрами
                }
            }
        }
        return null; // Авто із заданими параметрами не знайдено
    }
}