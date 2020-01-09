package racegame;

/**
 *
 * @author rimid
 */
public class SportCar extends Car {
    
    public SportCar (String name) {
        super(name);
    }
    //Acceleration method for sport car
    @Override
    public void speedUp(int kiek){
        this.speed += kiek * 2;
        if(this.speed > 400){
            this.speed = 400;
        }
    }
    //Deacceleration method for sport car
    @Override
    public void speedDown(int kiek){
        this.speed -= kiek * 2;
        if(this.speed <= 0){
            this.speed = 0;
        }
    }
}
