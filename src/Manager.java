import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class Manager {
    private final ArrayList<User> users;
    File userFile;
    User user;
    private final ArrayList<FarmAnimal> farmAnimals;
    private final ArrayList<WildAnimal> wildAnimals;
    private final ArrayList<Cat> cats;
    private final ArrayList<Dog> dogs;
    private final ArrayList<Task> tasks = new ArrayList<>();
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final ArrayList<WorkShop> workShops = new ArrayList<>();
    private int coins;
    private static String playerName;

    public Manager(String playerName) {
        users = new ArrayList<>();
        userFile = new File("Users.txt");
        User.readUsers(userFile, users);
        this.farmAnimals = new ArrayList<>();
        this.wildAnimals = new ArrayList<>();
        this.dogs = new ArrayList<>();
        this.cats = new ArrayList<>();
        this.coins = 0;
        this.playerName = playerName;
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

    public boolean foundPassword(String password, String userName) {
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
        for (WildAnimal wildAnimal : wildAnimals) {
            if (wildAnimal.getAnimalName().equalsIgnoreCase(workShopName)) {
                System.out.println("WorkShop already exist");
                Log.Build(workShopName,1);
                return;
            }
        }
        switch (workShopName.toLowerCase(Locale.ROOT)) {
            case "bakery": {
                if (coins >= Bakery.BAKERY_BUILD_COST) {
                    workShops.add(new Bakery());
                    coins -= Bakery.BAKERY_BUILD_COST;
                    System.out.println("Bakery built successfully");
                    Log.Build(workShopName,4);
                } else {
                    System.out.println("not enough coins");
                    Log.Build(workShopName,2);
                }
            }
            case "ice" + "cream" + "shop": {
                if (coins >= IceCreamShop.ICE_CREAM_SHOP_BUILD_COST) {
                    workShops.add(new IceCreamShop());
                    coins -= IceCreamShop.ICE_CREAM_SHOP_BUILD_COST;
                    System.out.println("IceCreamShop built successfully");
                    Log.Build(workShopName,4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "milk" + "packing": {
                if (coins >= MilkPacking.MILK_PACKING_BUILD_COST) {
                    workShops.add(new MilkPacking());
                    coins -= MilkPacking.MILK_PACKING_BUILD_COST;
                    System.out.println("MilkPacking built successfully");
                    Log.Build(workShopName,4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "mill": {
                if (coins >= Mill.MILL_BUILD_COST) {
                    workShops.add(new Mill());
                    coins -= Mill.MILL_BUILD_COST;
                    System.out.println("Mill built successfully");
                    Log.Build(workShopName,4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "tailor": {
                if (coins >= Tailor.TAILOR_BUILD_COST) {
                    workShops.add(new Tailor());
                    coins -= Tailor.TAILOR_BUILD_COST;
                    System.out.println("Tailor built successfully");
                    Log.Build(workShopName,4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "weaver": {
                if (coins >= Weaver.WEAVER_BUILD_COST) {
                    workShops.add(new Weaver());
                    coins -= Weaver.WEAVER_BUILD_COST;
                    System.out.println("Weaver built successfully");
                    Log.Build(workShopName,4);
                } else {
                    System.out.println("not enough coins");
                }
            }
            default: {
                System.out.println("workshop not found");
                Log.Build(workShopName,3);
            }
        }
    }

    public void work(String workShopName) {
        //TODO
    }

    public void turn(int numberOfTimeUnit) {
        Event.turnTime(numberOfTimeUnit);
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
        //TODO
    }

    public void truckUnload(String itemName) {
        //TODO
    }

    public void truckGO() {
        //TODO
    }

    public void buy(String animalName) {
        switch (animalName.toLowerCase(Locale.ROOT)) {
            case "chicken": {
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
            case "turkey": {
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
            case "buffalo": {
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
            case "dog": {
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
            case "cat": {
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
            default: {
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
}
