package machine;

public class Machine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups = 0;
    private int money = 0;

    public Machine(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public Machine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public int maxCups() {
        int cupsWater = water / 200;
        int cupsMilk = milk / 50;
        int cupsCoffeeBeans = coffeeBeans / 15;
        return Math.min(cupsWater, Math.min(cupsMilk, cupsCoffeeBeans));
    }

    public void printMachineIngredients() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    public void buy(Coffee coffee) {
        if (water >= coffee.getWater() && milk >= coffee.getMilk() && coffeeBeans >= coffee.getCoffeeBeans()) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= coffee.getWater();
            milk -= coffee.getMilk();
            coffeeBeans -= coffee.getCoffeeBeans();
            money += coffee.getCost();
            cups--;
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    public void fill(int water, int milk, int coffeeBeans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        this.cups += cups;
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}
