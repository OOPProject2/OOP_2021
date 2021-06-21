public class FarmAnimal extends Animal {
    private final String PRODUCED_PRODUCT;
    private final int TIME_PER_PRODUCT;
    private int life = 100;
    private boolean isBusy;
    private static final int FARM_ANIMALS_MOVE_PER_TIME_UNIT = 1;

    public FarmAnimal(String PRODUCED_PRODUCT, int TIME_PER_PRODUCT, int price) {
        super(price, FARM_ANIMALS_MOVE_PER_TIME_UNIT);
        this.PRODUCED_PRODUCT = PRODUCED_PRODUCT;
        this.TIME_PER_PRODUCT = TIME_PER_PRODUCT;
        start();
    }

    @Override
    public int getXLoc() {
        return super.getXLoc();
    }

    @Override
    public int getYLoc() {
        return super.getYLoc();
    }

    @Override
    public void showAnimal() {
        System.out.print(getAnimalName() + " " + this.life + " ");
        super.showAnimal();
    }

    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }

    @Override
    public void movement() {
        if (life > 50) {
            super.movement(FARM_ANIMALS_MOVE_PER_TIME_UNIT);
        } else {
            char movementDirection = GameField.closestGrass(this.getXLoc(), this.getYLoc());
            switch (movementDirection) {
                case 'O': {
                    break;
                }
                case 'N': {
                    move('N', FARM_ANIMALS_MOVE_PER_TIME_UNIT);
                }
                case 'E': {
                    move('E', FARM_ANIMALS_MOVE_PER_TIME_UNIT);
                }
                case 'W': {
                    move('W', FARM_ANIMALS_MOVE_PER_TIME_UNIT);
                }
                case 'S': {
                    move('S', FARM_ANIMALS_MOVE_PER_TIME_UNIT);
                }
            }
        }
    }

    public void start() {
        if (life > 0) {
            Event.addWorkingEvent(TIME_PER_PRODUCT, PRODUCED_PRODUCT, 1);
            isBusy = true;
        }
    }

    public void produceDone() {
        isBusy = false;
    }

    public int getLife() {
        return life;
    }

    public void lifeLoss(){
        this.life -= 10;
    }

    public void eat(){
        life = 100;
    }
}
