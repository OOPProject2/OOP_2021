import java.util.ArrayList;
import java.util.Locale;

public class Event {
    private static int currentTime = 1;
    private int eventTime;
    private int eventCode;
    private String product;
    private int productsCount;
    private FarmAnimal farmAnimal;
    private Product toDisappearProduct;
    private boolean statue = false;//indicates if the events is already done or not ,true for done
    public static final int FILLING_BUCKET = 1;
    public static final int TRUCK_GO = 2;
    public static final int WORK = 3;
    public static final int FARM_ANIMAL_PRODUCE = 4;
    public static final int PRODUCT_DISAPPEAR = 5;
    private static final ArrayList<Event> events = new ArrayList<>();

    public static void addEvent(int eventCode) {
        switch (eventCode) {
            case FILLING_BUCKET:
                events.add(new Event(currentTime + Well.REFILLING_TIME, FILLING_BUCKET));
            case TRUCK_GO:
                events.add(new Event(currentTime + Truck.TIME_UNIT_TO_WORK, TRUCK_GO));
        }
    }

    public static void addWorkingEvent(int produceTime, String product, int productsCount) {
        events.add(new Event(currentTime + produceTime, product, productsCount, WORK));
    }

    public static void addFarmAnimalProducingEvent(int produceTime, String product, int productCount, FarmAnimal farmAnimal) {
        events.add(new Event(produceTime, FARM_ANIMAL_PRODUCE, product, productCount, farmAnimal));
    }

    public static void addToDisappearProductEvent(int disappearTime,Product product){
        events.add(new Event(currentTime + disappearTime, product));
    }

    public static void turnTime(int turnAmount) {
        Log.turnTime(turnAmount);
        while (turnAmount > 0) {
            currentTime++;
            check();
            Manager.moveAllAnimals();
            Manager.farmAnimalsLifeLoss();
            Manager.check();
            turnAmount--;
        }

    }

    private static void check() {
        for (Event event : events) {
            if (!event.statue) {
                if (event.eventTime <= currentTime) {
                    doEvent(event);
                }
            }
        }
    }

    private static void doEvent(Event event) {
        switch (event.eventCode) {
            case FILLING_BUCKET: {
                Well.fillingBucket();
                event.statue = true;
                Log.bucketFilled();
            }
            case TRUCK_GO: {
                Log.truckGo(3);
                event.statue = true;
                Truck.returned();
            }
            case WORK: {
                event.statue = true;
                switch (event.product.toLowerCase(Locale.ROOT)) {
                    case "bread": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Bread());
                            Log.addProduct("bread");
                            event.productsCount--;
                        }
                        Manager.getWorkShopByName("Bakery").doneWorking();
                    }
                    case "fabric": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Fabric());
                            Log.addProduct("fabric");
                            event.productsCount--;
                        }
                        Manager.getWorkShopByName("Weaver").doneWorking();
                    }
                    case "flour": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Flour());
                            Log.addProduct("flour");
                            event.productsCount--;
                        }
                        Manager.getWorkShopByName("Mill").doneWorking();
                    }
                    case "ice" + "cream": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new IceCream());
                            Log.addProduct("ice" + "cream");
                            event.productsCount--;
                        }
                        Manager.getWorkShopByName("IceCreamShop").doneWorking();
                    }
                    case "packed" + "milk": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new PackedMilk());
                            Log.addProduct("packed" + "milk");
                            event.productsCount--;
                        }
                        Manager.getWorkShopByName("MilkPacking").doneWorking();
                    }
                    case "shirt": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Shirt());
                            Log.addProduct("shirt");
                            event.productsCount--;
                        }
                        Manager.getWorkShopByName("Tailor").doneWorking();
                    }
                }
            }
            case FARM_ANIMAL_PRODUCE: {
                event.statue = true;
                if (event.farmAnimal.getLife() <= 0)
                    return;
                switch (event.product.toLowerCase(Locale.ROOT)) {
                    case "egg": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Egg());
                            Log.addProduct("egg");
                            event.productsCount--;
                        }
                    }
                    case "feather": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Feather());
                            Log.addProduct("feather");
                            event.productsCount--;
                        }
                    }
                    case "milk": {
                        while (event.productsCount > 0) {
                            Manager.addProduct(new Milk());
                            Log.addProduct("milk");
                            event.productsCount--;
                        }
                    }
                }
                event.farmAnimal.start();
            }
            case PRODUCT_DISAPPEAR:{
                event.statue = true;
                if (!event.toDisappearProduct.isCollected()){
                    Manager.removeProduct(event.toDisappearProduct);
                    Log.disappearProduct(event.toDisappearProduct.getName());
                }
            }
        }

    }

    public Event(int eventTime, int eventCode) {
        this.eventTime = eventTime;
        this.eventCode = eventCode;
    }

    public Event(int eventTime, String product, int productsCount, int eventCode) {
        this.eventTime = eventTime;
        this.product = product;
        this.productsCount = productsCount;
        this.eventCode = eventCode;
    }

    public Event(int eventTime, int eventCode, String product, int productsCount, FarmAnimal farmAnimal) {
        this.eventTime = eventTime;
        this.eventCode = eventCode;
        this.product = product;
        this.productsCount = productsCount;
        this.farmAnimal = farmAnimal;
    }

    public Event(int eventTime, Product toDisappearProduct){
        this.eventTime = eventTime;
        this.toDisappearProduct = toDisappearProduct;
        this.eventCode = PRODUCT_DISAPPEAR;
    }

    public static int getCurrentTime() {
        return currentTime;
    }
}
