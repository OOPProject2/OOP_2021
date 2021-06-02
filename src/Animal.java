import java.util.Random;

public class Animal {
    private int Price;//for now sell price equals buy price
    private int xLoc;
    private int YLoc;
    private final int MOVE_PER_TIME_UNIT;

    public Animal(int price, int MOVE_PER_TIME_UNIT) {
        Price = price;
        Random random = new Random();
        this.xLoc = random.nextInt(6);
        this.YLoc = random.nextInt(6);
        this.MOVE_PER_TIME_UNIT = MOVE_PER_TIME_UNIT;
    }

    private void Movement() {
        //Must be overridden
    }

    public int getxLoc() {
        return xLoc;
    }

    public int getYLoc() {
        return YLoc;
    }
}
