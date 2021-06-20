import java.util.ArrayList;

public class WareHouse {
    private static final int CAPACITY = 30;
    private static int currentLoad;
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final ArrayList<WildAnimal> wildAnimals = new ArrayList<>();

    public WareHouse() {
        this.currentLoad = 0;
    }

    public static <E> boolean addItem(E e) {
        if (e instanceof Product) {
            if (currentLoad + ((Product) e).getREQUIRED_SPACE() > CAPACITY) {
                System.out.println();
                Log.moveToWareHouse(((Product) e).getName(), 2);
                return false;
            } else {
                products.add((Product) e);
                currentLoad += ((Product) e).getREQUIRED_SPACE();
                System.out.println(((Product) e).getName() + " moved to warehouse successfully");
                Log.moveToWareHouse(((Product) e).getName(), 1);
                return true;
            }
        }
        if (e instanceof WildAnimal) {
            if (currentLoad + WildAnimal.getSpaceRequired() > CAPACITY) {
                System.out.println("not enough capacity");
                Log.moveToWareHouse(((WildAnimal) e).getAnimalName(), 2);
                return false;
            } else {
                if (((WildAnimal) e).isFullyCaged()) {
                    wildAnimals.add((WildAnimal) e);
                    currentLoad += WildAnimal.getSpaceRequired();
                    System.out.println(((WildAnimal) e).getAnimalName() + " moved to warehouse successfully");
                    Log.moveToWareHouse(((WildAnimal) e).getAnimalName(), 1);
                    return true;
                } else {
                    System.out.println("cannot move wild animal to ware house because its not in max cage level");
                    Log.moveToWareHouse(((WildAnimal) e).getAnimalName(), 3);
                    return false;
                }
            }
        }
        System.out.println("cannot store this item");
        return false;
    }
}
