import java.util.ArrayList;

public class Manager {
    private final ArrayList<FarmAnimal> farmAnimals;
    private final ArrayList<WildAnimal> wildAnimals;
    private final ArrayList<Dog> dogs;
    private final ArrayList<Cat> cats;
    private int coins;

    public Manager(ArrayList<FarmAnimal> farmAnimals, ArrayList<WildAnimal> wildAnimals, ArrayList<Dog> dogs, ArrayList<Cat> cats, int coins) {
        this.farmAnimals = farmAnimals;
        this.wildAnimals = wildAnimals;
        this.dogs = dogs;
        this.cats = cats;
        this.coins = coins;
    }

    public void buy(String animalName) {
        switch (animalName) {
            case "Chicken": {
                if (coins >= Chicken.getChickensPrice()) {
                    Chicken chicken = new Chicken();
                    coins -= Chicken.getChickensPrice();
                    farmAnimals.add(chicken);
                    System.out.println("Chicken added successfully at point x = " + chicken.getxLoc()
                            + " y = " + chicken.getYLoc());
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "Turkey": {
                if (coins >= Turkey.getTurkeyPrice()) {
                    Turkey turkey = new Turkey();
                    coins -= Turkey.getTurkeyPrice();
                    farmAnimals.add(turkey);
                    System.out.println("Turkey added successfully at point x = " + turkey.getxLoc()
                            + " y = " + turkey.getYLoc());
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "Buffalo": {
                if (coins >= Buffalo.getBuffaloPrice()) {
                    Buffalo buffalo = new Buffalo();
                    coins -= Buffalo.getBuffaloPrice();
                    farmAnimals.add(buffalo);
                    System.out.println("Buffalo added successfully at point x = " + buffalo.getxLoc()
                            + " y = " + buffalo.getYLoc());
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "Dog": {
                if (coins >= Dog.getDogPrice()) {
                    Dog dog = new Dog();
                    coins -= Dog.getDogPrice();
                    dogs.add(dog);
                    System.out.println("Dog added successfully at point x = " + dog.getxLoc()
                            + " y = " + dog.getYLoc());
                } else {
                    System.out.println("not enough coins");
                }
            }
            case "Cat": {
                if (coins >= Cat.getCatPrice()) {
                    Cat cat = new Cat();
                    coins -= Cat.getCatPrice();
                    cats.add(cat);
                    System.out.println("Cat added successfully at point x = " + cat.getxLoc()
                            + " y = " + cat.getYLoc());
                } else {
                    System.out.println("not enough coins");
                }
            }
            default: {
                System.out.println("animal not found");
            }
        }
    }
}
