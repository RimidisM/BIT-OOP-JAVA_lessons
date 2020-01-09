package racegame;

/**
 *
 * @author rimid
 */
public class RaceGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Car[] cars = {
            new Car("Jeep"),
            new Car("Toyota"),
            new Car("Tesla"),
            new Car("Suzuki"),
            new SportCar("SportFerrari"),
            new SportCar("SportPorsche")
        };

        boolean end = true;

        while (end == true) {

            for (int i = 0; i < cars.length; i++) {
                if (Math.random() > 0.6) {
                    int kiek = (int) (Math.random() * ((20 - 5) + 1)) + 5;
                    cars[i].speedUp(kiek);
                    cars[i].drive();
                } else if (Math.random() <= 0.1) {
                    int kiek = (int) (Math.random() * ((10 - 1) + 1)) + 1;
                    cars[i].speedDown(kiek);
                    cars[i].drive();
                } else {
                    cars[i].drive();
                }
                if (cars[i].getDist() >= 1000) {
                    System.out.println("!!!!!!!!!Laimejo automobilis " + cars[i].getName());
                    end = false;
                }
            }
            sort(cars);
            print(cars);
        }
    }

    public static void print(Car[] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i].toString());
        }
        System.out.println("/==============================================/");
    }

    public static void sort(Car[] n) {
        for (int i = 0; i < n.length - 1; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[j].getDist() > n[i].getDist()) {
                    Car temp = n[i];
                    n[i] = n[j];
                    n[j] = temp;
                }
            }
        }
    }
}
