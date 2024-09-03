package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine(400, 540, 120, 9, 550);

        selectAction(scanner, machine);

        scanner.close();
    }

    public static void selectAction(Scanner scanner, Machine machine) {
        boolean exit = false;
        while (!exit) {
        println("Write action (buy, fill, take, remaining, exit):");
        Actions action = Actions.valueOf(scanner.next().toUpperCase());
            switch (action) {
                case BUY:
                    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                    String option = scanner.nextLine();
                    if (option.isEmpty()) {
                        option = scanner.nextLine();
                    }
                    if (Objects.equals(option, "back")) {
                        break;
                    }
                    int optionParsed = Integer.parseInt(option);
                    if (optionParsed < 1 || optionParsed > 3) {
                        break;
                    }
                    machine.buy(Coffee.values()[optionParsed - 1]);
                    break;
                case FILL:
                    println("Write how many ml of water do you want to add:");
                    int water = scanner.nextInt();
                    println("Write how many ml of milk do you want to add:");
                    int milk = scanner.nextInt();
                    println("Write how many grams of coffee beans do you want to add:");
                    int coffeeBeans = scanner.nextInt();
                    println("Write how many disposable cups of coffee do you want to add:");
                    int cups = scanner.nextInt();
                    machine.fill(water, milk, coffeeBeans, cups);
                    break;
                case TAKE:
                    machine.take();
                    break;
                case REMAINING:
                    machine.printMachineIngredients();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printSteps() {
        println("Starting to make a coffee");
        println("Grinding coffee beans");
        println("Boiling water");
        println("Mixing boiled water with crushed coffee beans");
        println("Pouring coffee into the cup");
        println("Pouring some milk into the cup");
        println("Coffee is ready!");
    }

    public void initiateMachine(Scanner scanner) {
        int water, milk, coffeeBeans, cups;

        println("Write how many ml of water the coffee machine has:");
        water = scanner.nextInt();

        println("Write how many ml of milk the coffee machine has:");
        milk = scanner.nextInt();

        println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeans = scanner.nextInt();

        println("Write how many cups of coffee you will need:");
        cups = scanner.nextInt();

        Machine machine = new Machine(water, milk, coffeeBeans);
        int maxCups = machine.maxCups();

        if (maxCups == cups) {
            println("Yes, I can make that amount of coffee");
        } else if (maxCups > cups) {
            println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that)");
        } else {
            println("No, I can make only " + maxCups + " cup(s) of coffee");
        }
    }
}
