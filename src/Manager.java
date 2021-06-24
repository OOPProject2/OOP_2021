import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class Manager {
    private final ArrayList<User> users;
    String  userFile;
    private static User user;
    private static final ArrayList<FarmAnimal> farmAnimals = new ArrayList<>();
    private static final ArrayList<WildAnimal> wildAnimals = new ArrayList<>();
    private static final ArrayList<Cat> cats = new ArrayList<>();
    private static final ArrayList<Dog> dogs = new ArrayList<>();
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final ArrayList<WorkShop> workShops = new ArrayList<>();
    private static int coins = 0;

    private static String playerName;

    public Manager() {
        users = new ArrayList<>();
        userFile =  "Users.txt";
        User.readUsers(userFile, users);
        this.coins = 0;
        new Log(this);
        new Mission();
    }

    public void planting(int x, int y) {
        Well.planting(x, y);
    }

    public void fillingBucket() {
        if (Well.getCurrentLevel() == 0) {
            Event.addEvent(Event.FILLING_BUCKET);
            Log.fillingBucket(true);
        } else {
            System.out.println("bucket still has water");
            Log.fillingBucket(false);
        }
    }

    public static String getPlayerName() {
        return playerName;
    }

    public void creatAccountForUser(String userName, String password) {
        User user = new User(userName, password, 0, 200);
        users.add(user);
        user.appendToFile(userFile);
    }

    public boolean foundUsername(String userName) {
        for (User user : users) {
            if (userName.equals(user.getUsername()))
                return true;
        }
        return false;
    }

    public boolean foundPassword(String userName, String password) {
        for (User user : users) {
            if (userName.equals(user.getUsername())) {
                if (password.equals(user.getPassword())) {
                    this.user = user;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean start(int level) {
        if (user.getMissionsPassed() + 1 >= level) {
            Mission.Level(level);
            coins += Mission.getInitialCoins();
            return true;
        }
        return false;
    }

    public void pickup(int x, int y) {
        boolean found = false;
        if (x < 1 || x > 6 || y < 1 || y > 6) {
            System.out.println("incorrect coordinates");
            return;
        }
        for (Product product : products) {
            if (product.getProductXLocInGameField() == x && product.getProductYLocInGameField() == y) {
                found = true;
                if (WareHouse.addItem(product)) {
                    product.collect();
                    Log.pickup(product.getName(), x, y, true);
                    System.out.println(product.getName() + " collected and moved to warehouse");
                }
            }
        }
        for (WildAnimal wildAnimal : wildAnimals) {
            if (wildAnimal.getXLoc() == x && wildAnimal.getYLoc() == y) {
                found = true;
                if (WareHouse.addItem(wildAnimal)) {
                    wildAnimal.store();
                    Log.pickup(wildAnimal.getAnimalName(), x, y, true);
                    System.out.println(wildAnimal.getAnimalName() + " collected and moved to warehouse");
                }
            }
        }
        if (!found) {
            System.out.println("there is no products  or fully caged wild animals at this location");
            Log.pickup("", x, y, false);
        }
    }

    public void build(String workShopName) {
        for (WorkShop workShop : workShops) {
            if (workShop.getWorkShopName().equalsIgnoreCase(workShopName)) {
                System.out.println("WorkShop already exist");
                Log.Build(workShopName, 1);
                return;
            }
        }
        switch (workShopName.toLowerCase(Locale.ROOT)) {
            case "bakery" -> {
                if (coins >= Bakery.BAKERY_BUILD_COST) {
                    workShops.add(new Bakery());
                    coins -= Bakery.BAKERY_BUILD_COST;
                    System.out.println("Bakery built successfully");
                    Log.Build(workShopName, 4);
                } else {
                    System.out.println("not enough coins");
                    Log.Build(workShopName, 2);
                }
            }
            case "ice" + "cream" + "shop" -> {
                if (coins >= IceCreamShop.ICE_CREAM_SHOP_BUILD_COST) {
                    workShops.add(new IceCreamShop());
                    coins -= IceCreamShop.ICE_CREAM_SHOP_BUILD_COST;
                    System.out.println("IceCreamShop built successfully");
                    Log.Build(workShopName, 4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "milk" + "packing" -> {
                if (coins >= MilkPacking.MILK_PACKING_BUILD_COST) {
                    workShops.add(new MilkPacking());
                    coins -= MilkPacking.MILK_PACKING_BUILD_COST;
                    System.out.println("MilkPacking built successfully");
                    Log.Build(workShopName, 4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "mill" -> {
                if (coins >= Mill.MILL_BUILD_COST) {
                    workShops.add(new Mill());
                    coins -= Mill.MILL_BUILD_COST;
                    System.out.println("Mill built successfully");
                    Log.Build(workShopName, 4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "tailor" -> {
                if (coins >= Tailor.TAILOR_BUILD_COST) {
                    workShops.add(new Tailor());
                    coins -= Tailor.TAILOR_BUILD_COST;
                    System.out.println("Tailor built successfully");
                    Log.Build(workShopName, 4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "weaver" -> {
                if (coins >= Weaver.WEAVER_BUILD_COST) {
                    workShops.add(new Weaver());
                    coins -= Weaver.WEAVER_BUILD_COST;
                    System.out.println("Weaver built successfully");
                    Log.Build(workShopName, 4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            default -> {
                System.out.println("workshop not found");
                Log.Build(workShopName, 3);
            }
        }
    }

    public void work(String workShopName) {
        for (WorkShop workShop : workShops) {
            if (workShop.getWorkShopName().equalsIgnoreCase(workShopName)) {
                workShop.work();
                Log.work(workShopName, 2);
                return;
            }
        }
        System.out.println("workshop doesnt exist");
        Log.work(workShopName, 1);
    }

    public void turn(int numberOfTimeUnit) {
        Event.turnTime(numberOfTimeUnit);
        showGame();
    }

    public void cage(int x, int y) {
        boolean found = false;
        for (WildAnimal wildAnimal : wildAnimals) {
            if (wildAnimal.getXLoc() == x && wildAnimal.getYLoc() == y) {
                found = true;
                wildAnimal.cage();
            }
        }
        if (!found) {
            System.out.println("there is no wildAnimal at this coordinates");
            Log.cage("WildAnimal", x, y, 3);
        }
    }

    public void truckLoad(String itemName) {
        Truck.loadItemFromWareHouse(itemName);
    }

    public void truckUnload(String itemName) {
        Truck.unload(itemName);
    }

    public void truckGO() {
        Truck.go();
    }

    public void buy(String animalName) {
        switch (animalName.toLowerCase(Locale.ROOT)) {
            case "chicken" -> {
                if (coins >= Chicken.getChickensPrice()) {
                    Chicken chicken = new Chicken();
                    coins -= Chicken.getChickensPrice();
                    farmAnimals.add(chicken);
                    System.out.println("Chicken added successfully at point x = " + chicken.getXLoc()
                            + " y = " + chicken.getYLoc());
                    Log.buyAnimalLog("chicken", true, "");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("chicken", false, "not enough coins");
                }
            }
            case "turkey" -> {
                if (coins >= Turkey.getTurkeyPrice()) {
                    Turkey turkey = new Turkey();
                    coins -= Turkey.getTurkeyPrice();
                    farmAnimals.add(turkey);
                    System.out.println("Turkey added successfully at point x = " + turkey.getXLoc()
                            + " y = " + turkey.getYLoc());
                    Log.buyAnimalLog("turkey", true, "");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("turkey", false, "not enough coins");
                }
            }
            case "buffalo" -> {
                if (coins >= Buffalo.getBuffaloPrice()) {
                    Buffalo buffalo = new Buffalo();
                    coins -= Buffalo.getBuffaloPrice();
                    farmAnimals.add(buffalo);
                    System.out.println("Buffalo added successfully at point x = " + buffalo.getXLoc()
                            + " y = " + buffalo.getYLoc());
                    Log.buyAnimalLog("buffalo", true, "");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("buffalo", false, "not enough coins");
                }
            }
            case "dog" -> {
                if (coins >= Dog.getDogPrice()) {
                    Dog dog = new Dog();
                    coins -= Dog.getDogPrice();
                    dogs.add(dog);
                    System.out.println("Dog added successfully at point x = " + dog.getXLoc()
                            + " y = " + dog.getYLoc());
                    Log.buyAnimalLog("dog", true, "");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("dog", false, "not enough coins");
                }
            }
            case "cat" -> {
                if (coins >= Cat.getCatPrice()) {
                    Cat cat = new Cat();
                    coins -= Cat.getCatPrice();
                    cats.add(cat);
                    System.out.println("Cat added successfully at point x = " + cat.getXLoc()
                            + " y = " + cat.getYLoc());
                    Log.buyAnimalLog("cat", true, "");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("cat", false, "not enough coins");
                }
            }
            default -> {
                System.out.println("animal not found");
                Log.buyAnimalLog(animalName, false, "animal not found");
            }
        }
    }

    public void showGame() {
        System.out.println("Time : " + Event.getCurrentTime());
        GameField.showGameField();
        System.out.println("Farm Animals :::::");
        for (FarmAnimal farmAnimal : farmAnimals) {
            farmAnimal.showAnimal();
        }
        System.out.println("Wild Animals :::::");
        for (WildAnimal wildAnimal : wildAnimals) {
            wildAnimal.showAnimal();
        }
        System.out.println("Other Animals :::::");
        for (Dog dog : dogs) {
            dog.showAnimal();
        }
        for (Cat cat : cats) {
            cat.showAnimal();
        }
        System.out.println("Tasks :::::");
        for (Task task : tasks) {
            task.showTask();
        }
    }

    public static char closestProduct(int x, int y) {
        double distance = 10000;
        int closestProductX = x;
        int closestProductY = y;
        for (Product product : products) {
            if (!product.isCollected()) {
                int dist = (x - product.getProductXLocInGameField()) * (x - product.getProductXLocInGameField())
                        + (y - product.getProductYLocInGameField()) * (y - product.getProductYLocInGameField());
                if (dist < distance * distance) {
                    distance = Math.sqrt(dist);
                    closestProductX = product.getProductXLocInGameField();
                    closestProductY = product.getProductYLocInGameField();
                }
            }
        }

        if (Math.abs(x - closestProductX) > Math.abs(y - closestProductY)) {
            if (x < closestProductX)
                return 'E';
            if (x > closestProductX)
                return 'W';
        } else if (Math.abs(x - closestProductX) < Math.abs(y - closestProductY)) {
            if (y < closestProductY)
                return 'S';
            if (y > closestProductY)
                return 'N';
        } else if (Math.abs(x - closestProductX) == 0 && Math.abs(y - closestProductY) == 0)
            return 'O';
        return 'O';
    }

    public static void addCoins(int amount) {
        coins += amount;
    }

    public static void addProduct(Product product) {
        for (Task task : tasks) {
            if (task.getTaskProduct().equalsIgnoreCase(product.getName())) {
                task.completeTask();
            }
        }
        products.add(product);
    }

    public static WorkShop getWorkShopByName(String workShopName) {
        for (WorkShop workShop : workShops) {
            if (workShop.getWorkShopName().equalsIgnoreCase(workShopName.toLowerCase(Locale.ROOT))) {
                return workShop;
            }
        }
        System.out.println("workshop doesnt exist");
        return null;
    }

    public static void moveAllAnimals() {
        for (WildAnimal wildAnimal : wildAnimals) {
            wildAnimal.movement();
        }
        for (Dog dog : dogs) {
            dog.movement();
        }
        for (Cat cat : cats) {
            cat.movement();
        }
        for (FarmAnimal farmAnimal : farmAnimals) {
            farmAnimal.movement();
        }
    }

    public static void farmAnimalsLifeLoss() {
        for (FarmAnimal farmAnimal : farmAnimals) {
            farmAnimal.lifeLoss();
        }
    }

    public static void check() {
        for (FarmAnimal farmAnimal : farmAnimals) {
            if (farmAnimal.getLife() <= 50 && farmAnimal.getLife() > 0) {
                if (GameField.getGrassCount(farmAnimal.getXLoc(), farmAnimal.getYLoc()) > 0) {
                    farmAnimal.eat();
                    GameField.eatGrass(farmAnimal.getXLoc(), farmAnimal.getYLoc());
                }
            }
        }

        for (Cat cat : cats) {
            for (Product product : products) {
                if (!product.isCollected() && product.getProductXLocInGameField() == cat.getXLoc()
                        && product.getProductYLocInGameField() == cat.getYLoc()) {
                    WareHouse.addItem(product);
                }
            }
        }

        for (WildAnimal wildAnimal : wildAnimals) {
            if (wildAnimal.getXLoc() != 0 && wildAnimal.getYLoc() != 0 && !wildAnimal.isFullyCaged()) {
                boolean flag = true;
                for (Dog dog : dogs) {
                    if (wildAnimal.getXLoc() == dog.getXLoc() && wildAnimal.getYLoc() == dog.getYLoc()) {
                        dogs.remove(dog);
                        wildAnimals.remove(wildAnimal);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (wildAnimal instanceof Tiger) {
                        int x = wildAnimal.getXLoc();
                        int y = wildAnimal.getYLoc();
                        switch (((Tiger) wildAnimal).lastMoveDirection) {
                            case 0 -> y++;
                            case 1 -> x--;
                            case 2 -> y--;
                            case 3 -> x++;
                        }
                        int finalX = x;
                        int finalY = y;
                        farmAnimals.removeIf(farmAnimal -> farmAnimal.getXLoc() == finalX
                                && farmAnimal.getYLoc() == finalY);
                        cats.removeIf(cat -> cat.getXLoc() == finalX
                                && cat.getYLoc() == finalY);
                        products.removeIf(product -> product.getProductXLocInGameField() == finalX
                                && product.getProductYLocInGameField() == finalY);
                    }
                    farmAnimals.removeIf(farmAnimal -> farmAnimal.getXLoc() == wildAnimal.getXLoc()
                            && farmAnimal.getYLoc() == wildAnimal.getYLoc());
                    cats.removeIf(cat -> cat.getXLoc() == wildAnimal.getXLoc()
                            && cat.getYLoc() == wildAnimal.getYLoc());
                    products.removeIf(product -> product.getProductXLocInGameField() == wildAnimal.getXLoc()
                            && product.getProductYLocInGameField() == wildAnimal.getYLoc());
                }
            }
        }
    }

    public static void checkTasks() {
        boolean fullyDone = true;
        for (Task task : tasks) {
            if (!task.isDone())
                fullyDone = false;
        }
        if (fullyDone) {
            System.out.println("!!!LEVEL COMPLETED!!!");
            if (Event.getCurrentTime() <= Mission.getTimeToGetPrize())
                coins += Mission.getPrize();
            user.setMissionsPassed(user.getMissionsPassed() + 1);
        }
    }

    public static void removeProduct(Product product) {
        for (Product product1 : products) {
            if (product1.equals(product)) {
                products.remove(product1);
                return;
            }

        }
    }

    public static void removeWildAnimal(WildAnimal wildAnimal) {
        wildAnimals.removeIf(animal -> animal.equals(wildAnimal));
    }

    public static void addWildAnimal(WildAnimal wildAnimal) {
        wildAnimals.add(wildAnimal);
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }
}
