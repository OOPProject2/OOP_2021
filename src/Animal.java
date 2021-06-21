import java.util.Random;

public class Animal {
    private int Price;//for now sell price equals buy price
    private int XLoc;
    private int YLoc;
    private final int MOVE_PER_TIME_UNIT;

    public Animal(int price, int MOVE_PER_TIME_UNIT) {
        Price = price;
        Random random = new Random();
        this.XLoc = random.nextInt(6);
        this.YLoc = random.nextInt(6);
        this.MOVE_PER_TIME_UNIT = MOVE_PER_TIME_UNIT;
    }

    protected void movement() {
    }

    protected int movement(int length) {
        boolean exit = false;
        int movementDirection = 0;
        while (!exit) {
            Random rand = new Random();
            movementDirection = rand.nextInt(4);
            switch (movementDirection) {
                case 0: {
                    if (move('N', length))
                        exit = true;
                }
                case 1: {
                    if (move('E', length))
                        exit = true;
                }
                case 2: {
                    if (move('S', length))
                        exit = true;
                }
                case 3: {
                    if (move('W', length))
                        exit = true;
                }
            }
        }
        return movementDirection;
    }

    protected boolean move(char direction, int length) {
        switch (direction) {
            case 'W':
                if (XLoc > length) {
                    this.moveLeft(length);
                    return true;
                }
            case 'E':
                if (XLoc < 7 - length) {
                    this.moveRight(length);
                    return true;
                }
            case 'N':
                if (YLoc > length) {
                    this.moveUp(length);
                    return true;
                }
            case 'S':
                if (YLoc < 7 - length) {
                    this.moveDown(length);
                    return true;
                }
        }
        return false;
    }

    public void showAnimal() {
        System.out.println("[" + getXLoc() + " " + getXLoc() + "]");
    }

    public String getAnimalName() {
        return "Animal";
    }

    public int getXLoc() {
        return XLoc;
    }

    public int getYLoc() {
        return YLoc;
    }

    private void moveLeft(int length) {
        this.XLoc -= length;
        Log.animalMove(getAnimalName(), XLoc + length, YLoc, XLoc, YLoc);
    }

    private void moveRight(int length) {
        this.XLoc += length;
        Log.animalMove(getAnimalName(), XLoc - length, YLoc, XLoc, YLoc);
    }

    private void moveUp(int length) {
        this.YLoc -= length;
        Log.animalMove(getAnimalName(), XLoc, YLoc + length, XLoc, YLoc);
    }

    private void moveDown(int length) {
        this.YLoc += length;
        Log.animalMove(getAnimalName(), XLoc, YLoc - length, XLoc, YLoc);
    }

    protected void setXLoc(int XLoc) {
        this.XLoc = XLoc;
    }

    protected void setYLoc(int YLoc) {
        this.YLoc = YLoc;
    }

    public int getPrice() {
        return Price;
    }
}
