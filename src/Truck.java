import java.util.ArrayList;

public class Truck {
    private static final int CAPACITY = 15;
    private static int currentLoad;
    private final int TIME_UNIT_TO_WORK = 10;
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final ArrayList<WildAnimal> wildAnimals = new ArrayList<>();

    public Truck() {
        currentLoad = 0;
    }

    public static void loadItemFromWareHouse(String name) {
        if (WareHouse.findItem(name) != null) {
            load(WareHouse.findItem(name));
        } else {
            System.out.println("item doesnt exist in warehouse");
        }
    }

    private static <E> void load(E e) {
        if (e instanceof Product) {
            if (currentLoad + ((Product) e).getREQUIRED_SPACE() > CAPACITY) {
                System.out.println("not enough capacity");
                Log.loadToTruck(((Product) e).getName(), 2);
            } else {
                products.add((Product) e);
                currentLoad += ((Product) e).getREQUIRED_SPACE();
                System.out.println(((Product) e).getName() + " loaded to truck successfully");
                WareHouse.removeFromWarehouse(e);
                Log.loadToTruck(((Product) e).getName(), 1);
            }
            return;
        }
        if (e instanceof WildAnimal) {
            if (currentLoad + WildAnimal.getSpaceRequired() > CAPACITY) {
                System.out.println("not enough capacity");
                Log.loadToTruck(((WildAnimal) e).getAnimalName(), 2);
            } else {
                wildAnimals.add((WildAnimal) e);
                currentLoad += WildAnimal.getSpaceRequired();
                System.out.println(((WildAnimal) e).getAnimalName() + " loaded to truck successfully");
                WareHouse.removeFromWarehouse(e);
                Log.loadToTruck(((WildAnimal) e).getAnimalName(), 1);
            }
            return;
        }
        System.out.println("cannot store this item");
    }

}
