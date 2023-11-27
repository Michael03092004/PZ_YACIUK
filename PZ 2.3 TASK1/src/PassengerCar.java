class PassengerCar extends Car {//легковий авто
    public PassengerCar(String model, double price, int fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }

    public void specialMethod(){
        System.out.println("Це легкове авто");
    }

}