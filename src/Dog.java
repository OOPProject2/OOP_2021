public class Dog extends Animal{
    private static final int DOG_PRICE = 100;
    private static final int DOG_MOVE_PER_TIME_UNIT = 1;

    public Dog() {
        super(DOG_PRICE, DOG_MOVE_PER_TIME_UNIT);
    }

    public static int getDogPrice() {
        return DOG_PRICE;
    }
}
