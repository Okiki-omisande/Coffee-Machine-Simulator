package machine;
import java.util.Scanner;
public class CoffeeMachine {
    static Scanner input = new Scanner(System.in);
    static String query;
    static int moneyMade = 550;
    static int disposableCup = 9;
    static int milkAvailable = 540;
    static int waterAvailable = 400;
    static int coffeeBeansAvailable = 120;


    public static void main(String[] args) {
       menu();
    }

    private static void menu() {
        do {
            System.out.println("write action (buy, fill, take, remaining, exit)");
            query = input.next();

            switch (query) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printAvailableResources();
            }
        }
        while (!(query.equals("exit")));
    }

    public static void buy(){
        System.out.println("what do you want to buy? 1- espresso, 2- latte, 3- cappuccino, back for main menu:");
        String coffeeType = input.next();

        switch (coffeeType){
            case "1":
                int waterRequired = 250;
                int coffeeBeansRequired = 16;

                if(waterAvailable >= waterRequired && coffeeBeansAvailable >= coffeeBeansRequired){
                    waterAvailable -= waterRequired;
                    coffeeBeansAvailable -= coffeeBeansRequired;
                    --disposableCup;
                    moneyMade += 4;
                    System.out.println("i have enough resources, making your coffee!" + "\n");
                }
                else
                    System.out.println("sorry, can't make a coffee \n" + "no enough ingredient" + "\n");
                break;

            case "2":
                int milkRequired = 75;
                waterRequired = 350;
                coffeeBeansRequired = 20;

                if (waterAvailable >= waterRequired && milkAvailable >= milkRequired && coffeeBeansAvailable >= coffeeBeansRequired) {
                    waterAvailable -= waterRequired;
                    milkAvailable -= milkRequired;
                    coffeeBeansAvailable -= coffeeBeansRequired;
                    --disposableCup;
                    moneyMade += 7;
                    System.out.println("i have enough resources, making your coffee!"+ "\n");
                }
                else
                    System.out.println("sorry, can't make a coffee \n" + "no enough ingredient" + "\n");
                break;

            case "3":
               waterRequired = 200;
               milkRequired = 100;
               coffeeBeansRequired = 12;

               if (waterAvailable >= waterRequired && milkAvailable >= milkRequired && coffeeBeansAvailable >= coffeeBeansRequired) {
                   waterAvailable -= waterRequired;
                   milkAvailable -= milkRequired;
                   coffeeBeansAvailable -= coffeeBeansRequired;
                   --disposableCup;
                   moneyMade += 6;
                   System.out.println("i have enough resources, making your coffee!" + "\n");
               }
               else
                   System.out.println("sorry, can't make a coffee \n" + "no enough ingredient"+ "\n");
                break;

            default:
                menu();
        }
    }

    public static void fill(){
        System.out.println("write how many ml of water you want to add");
        int addWater = input.nextInt();

        System.out.println("write how many ml of milk you want to add");
        int addMilk = input.nextInt();

        System.out.println("write how many grams of coffee beans you want to add");
        int addCoffeeBeans = input.nextInt();

        System.out.println("write how many disposable cup you want to add");
        int addCup = input.nextInt();

        waterAvailable += addWater;
        milkAvailable += addMilk;
        coffeeBeansAvailable += addCoffeeBeans;
        disposableCup += addCup;
        System.out.println();
    }

    public static void take(){
        System.out.println("i gave you $550" +"\n");
        moneyMade = 0;
    }

    public static void printAvailableResources(){
        System.out.printf("\nThe coffee machine has:\n"
                        + "%d ml of water\n"
                        + "%d ml of milk\n"
                        + "%d g of coffee beans\n"
                        + "%d cups of disposable cups\n"
                        +"$%d of money\n\n",
                waterAvailable, milkAvailable, coffeeBeansAvailable,disposableCup,moneyMade);
    }
}
