package racegame;

/**
 *
 * @author rimid
 */
public class Car {
    //Car attributes

    private String name;
    public int speed;
    private int dist;

    //Car constructor
    public Car(String n) {
        this.name = n;
        this.speed = 0;
        this.dist = 0;
    }

    //Acceleration method
    public void speedUp(int kiek) {
        this.speed += kiek;
        if (this.speed > 100) {
            this.speed = 100;
        }
    }

    //Deacceleration method
    public void speedDown(int kiek) {
        this.speed -= kiek;
        if (this.speed <= 0) {
            this.speed = 0;
        }
    }

    public void drive() {
        this.dist += this.speed;
    }

    //Get Set------------------------
    public String getName() {
        return this.name;
    }

    public int getDist() {
        return this.dist;
    }

    //To string method
    public String toString() {
        return "" + this.name + ", distance " + this.dist + ", speed " + this.speed + "";
    }

}
