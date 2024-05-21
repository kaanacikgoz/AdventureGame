import java.util.Random;

public class Snake extends Obstacle {

    Snake() {
        super(4, "Snake",randomDamage(), 12, 0);
    }


    static int randomDamage() {
        Random random = new Random();
        return random.nextInt(3,7);
    }

}
