public class Dog extends OtherAnimals {
    private static final int DOG_PRICE = 100;

    public Dog() {
        super(DOG_PRICE);
    }

    public static int getDogPrice() {
        return DOG_PRICE;
    }

    @Override
    public String getAnimalName() {
        return "Dog";
    }

    @Override
    protected void movement() {
        super.movement(MOVE_PER_TIME_UNIT);
    }
}
