import java.util.ArrayList;

public class Truck {
    private static final int CAPACITY = 15;
    private static int currentLoad;
    public static final int TIME_UNIT_TO_WORK = 10;
    private static boolean isBusy;
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final ArrayList<WildAnimal> wildAnimals = new ArrayList<>();

    public Truck() {
        currentLoad = 0;
        isBusy = false;
    }

    public static void loadItemFromWareHouse(String name) {
        if (isBusy) {
            System.out.println("truck is busy");
            Log.loadToTruck(name,3);
            return;
        }
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

    public static void unload(String name) {
        if (isBusy) {
            System.out.println("truck is busy");
            Log.unloadFromTruck(name,4);
            return;
        }
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                if (WareHouse.addItem(product)) {
                    System.out.println("item unloaded from truck and moved to warehouse");
                    products.remove(product);
                    Log.unloadFromTruck(name, 1);
                    return;
                }
                Log.unloadFromTruck(name, 2);
                return;
            }
        }
        for (WildAnimal wildAnimal : wildAnimals) {
            if (wildAnimal.getAnimalName().equalsIgnoreCase(name)) {
                if (WareHouse.addItem(wildAnimal)) {
                    System.out.println("item unloaded from truck and moved to warehouse");
                    wildAnimals.remove(wildAnimal);
                    Log.unloadFromTruck(name, 1);
                    return;
                }
                Log.unloadFromTruck(name, 2);
                return;
            }
        }
        Log.unloadFromTruck(name, 3);
    }

    public void go(){
        if (isBusy){
            System.out.println("truck is busy");
            Log.truckGo(2);
            return;
        }
        isBusy = true;
        Log.truckGo(1);
        Event.addEvent(Event.TRUCK_GO);
    }

    public static void returned(){
        isBusy = false;
        for (Product product : products) {
            Manager.addCoins(product.getPRICE());
            System.out.println(product.getPRICE() + " coins added");
            Log.addCoins(product.getPRICE());
        }
        for (WildAnimal wildAnimal : wildAnimals) {
            Manager.addCoins(wildAnimal.getPrice());
            System.out.println(wildAnimal.getPrice() + " coins added");
            Log.addCoins(wildAnimal.getPrice());
        }
    }
}
