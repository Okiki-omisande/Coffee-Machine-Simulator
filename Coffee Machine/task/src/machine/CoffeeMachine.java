package machine;
import java.util.Scanner;
public class CoffeeMachine {
    static Scanner input = new Scanner(System.in);
    static String query;
    static int moneyMade = 550;
    static int disposableCup = 10;
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
                    break;
            }
        }
        while (!(query.equals("exit")));
    }

    public static void buy(){
        System.out.println("Select the coffee you want to buy:" +
                "\n1- espresso coffee" +
                "\n2- latte coffee" +
                "\n3- cappuccino coffee" +
                "\n4- main menu");
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
                    System.out.println("I have enough resources, making your espresso coffee!" + "\n");
                }
                else
                    System.out.println("Sorry, can't make your espresso coffee \n" + "No enough ingredient" + "\n");
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
                    System.out.println("Your latte coffee is being served!"+ "\n");
                }
                else
                    System.out.println("Sorry, can't make your latte coffee \n" + "Insufficient resources" + "\n");
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
                   System.out.println("Please be patient, your creamy cappuccino coffee will be ready soon!" + "\n");
               }
               else
                   System.out.println("Oops, can't make your cappuccino coffee \n" + "I'm out of resources "+ "\n");
                break;

            case "4":
                menu();
                break;

            default:
                System.out.println("Invalid input");
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
        System.out.printf("$%d withdrawn" +"\n\n", moneyMade);
        moneyMade = 0;
    }

    public static void printAvailableResources(){
        System.out.printf("\nThe coffee machine has:\n"
                        + "%d ml of water\n"
                        + "%d ml of milk\n"
                        + "%d g of coffee beans\n"
                        + "%d cups of disposable cups\n"
                        +"$%d cash\n\n",
                waterAvailable, milkAvailable, coffeeBeansAvailable,disposableCup,moneyMade);
    }
}
