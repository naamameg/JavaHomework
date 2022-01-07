public class CarFactory {

    public static Drivalble getCar(String carType) {
        if (carType == null) {
            return null;
        }
            switch (carType){
                case "BMW":
                    return new BMW();
                case "Fiat":
                    return new Fiat();
                case "Porsche":
                    return new Porsche();
                default: throw new IllegalArgumentException();




            }

    }
    }


