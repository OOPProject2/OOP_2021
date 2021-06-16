import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class Manager {
    private final ArrayList<User> users;
    File userFile;
    private final ArrayList<FarmAnimal> farmAnimals;
    private final ArrayList<WildAnimal> wildAnimals;
    private final ArrayList<Cat> cats;
    private final ArrayList<Dog> dogs;
    private int coins;
    private static String playerName;

    public Manager(String playerName) {
        users=new ArrayList<>();
        userFile=new File("Users.txt");
        User.readUsers(userFile,users);
        this.farmAnimals = new ArrayList<>();
        this.wildAnimals = new ArrayList<>();
        this.dogs = new ArrayList<>();
        this.cats = new ArrayList<>();
        this.coins = 0;
        this.playerName = playerName;
    }

    public void planting(int x , int y){
         Well.planting(x,y);
    }

    public static String getPlayerName() {
        return playerName;
    }
    public void creatAccountForUser(String userName,String password){
        User user=new User(userName,password,0,200);
        users.add(user);
        user.appendToFile(userFile);
    }
    public boolean foundUsername(String userName){
        for (User user : users) {
            if(userName.equals(user.getUsername()))
                return true;
        }
        return false;
    }
    public boolean foundPassword(String password,String userName){
        for (User user : users) {
            if(userName.equals(user.getUsername())){
                if(password.equals(user.getPassword())){
                    return true;
                }
            }
        }
        return false;
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
                    Log.buyAnimalLog("chicken", true,"");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("chicken", false,"not enough coins");
                }
            }
            case "turkey": {
                if (coins >= Turkey.getTurkeyPrice()) {
                    Turkey turkey = new Turkey();
                    coins -= Turkey.getTurkeyPrice();
                    farmAnimals.add(turkey);
                    System.out.println("Turkey added successfully at point x = " + turkey.getXLoc()
                            + " y = " + turkey.getYLoc());
                    Log.buyAnimalLog("turkey",true,"");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("turkey",false,"not enough coins");
                }
            }
            case "buffalo": {
                if (coins >= Buffalo.getBuffaloPrice()) {
                    Buffalo buffalo = new Buffalo();
                    coins -= Buffalo.getBuffaloPrice();
                    farmAnimals.add(buffalo);
                    System.out.println("Buffalo added successfully at point x = " + buffalo.getXLoc()
                            + " y = " + buffalo.getYLoc());
                    Log.buyAnimalLog("buffalo",true,"");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("buffalo",false,"not enough coins");
                }
            }
            case "dog": {
                if (coins >= Dog.getDogPrice()) {
                    Dog dog = new Dog();
                    coins -= Dog.getDogPrice();
                    dogs.add(dog);
                    System.out.println("Dog added successfully at point x = " + dog.getXLoc()
                            + " y = " + dog.getYLoc());
                    Log.buyAnimalLog("dog",true,"");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("dog",false,"not enough coins");
                }
            }
            case "cat": {
                if (coins >= Cat.getCatPrice()) {
                    Cat cat = new Cat();
                    coins -= Cat.getCatPrice();
                    cats.add(cat);
                    System.out.println("Cat added successfully at point x = " + cat.getXLoc()
                            + " y = " + cat.getYLoc());
                    Log.buyAnimalLog("cat",true,"");
                } else {
                    System.out.println("not enough coins");
                    Log.buyAnimalLog("cat",false,"not enough coins");
                }
            }
            default: {
                System.out.println("animal not found");
                Log.buyAnimalLog(animalName,false,"animal not found");
            }
        }
    }
}
