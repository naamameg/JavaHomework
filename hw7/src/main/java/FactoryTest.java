public class FactoryTest {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Drivalble myBMW = carFactory.getCar("BMW");
        myBMW.drive();

        Drivalble myFiat = carFactory.getCar("Fiat");
        myFiat.drive();

        Drivalble myPorsche = carFactory.getCar("Porsche");
        myPorsche.drive();
    }
}
