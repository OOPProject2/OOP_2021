public class OtherAnimals extends Animal {
    protected static final int MOVE_PER_TIME_UNIT = 1;

    public OtherAnimals(int price) {
        super(price, MOVE_PER_TIME_UNIT);
    }

    @Override
    public void showAnimal() {
        System.out.print(getAnimalName() + " ");
        super.showAnimal();
    }
}
