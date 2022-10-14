import java.util.Scanner;
import javax.swing.*;

class World {

    static Player p1 = new Player();
    static Animal animal = new Animal();
    static Bush bush = new Retana();

    public static void main(String[] args)
    {
        start();
        return;
    }

    public static void print(Object o)
    {
        System.out.println(o);
        return;
    }

    public static void start()
    {
        String begin = "";

        print("You are in a cabin present in a clearing in the middle of the woods on a forested island...you have to escape this island alive...");
        print("Please type start to begin: ");

        Scanner scanner = new Scanner(System.in);

        begin  = scanner.nextLine();

        if (begin.equals("start")) {
            String name;
            print("Please enter your name: ");
            name = scanner.nextLine();

            p1.name(name);

            cabin();
        }

        else
        {
            print("Please type 'start' to begin!!");
            start();
        }

    }

    public static void cabin()
    {
        String next;

        print(p1.giveName() + " wakes up inside a cabin...your two options are: ");
        print("1.> see outside window");
        print("2.>go outside the cabin");

        Scanner scanner = new Scanner(System.in);

        next = scanner.nextLine();

        if (next.equals("see outside window"))
        {
            print("You see a dog wining painfully at the foot of the forest towards the end of the clearing at the start of the woods.");
            print("You then leave the cabin and go outside");
            startOfWoods();
        }

        else if(next.equals("go outside the cabin"))
        {
            print("You see a dog winning painfully at the foot of the forest towards the end of the clearing at the start of the woods.");
            startOfWoods();
        }

        else
        {
            print("Please enter a valid response!");
            cabin();
        }
    }

    public static void startOfWoods()
    {
        print("you can now also see a path leading into the forest");
        print("Your options are: ");
        print("1.> follow the path");
        print("2.>go to help the dog");

        String next;

        Scanner scanner = new Scanner(System.in);

        print("What do you wish to do: ");
        next = scanner.nextLine();

        if (next.equals("follow the path"))
        {
            animal = new Dog("bark", "Dog");  // polymorphism //
            animal.sad();
            intoTheWoods();
        }

        else if (next.equals("go to help the dog"))
        {
            HelpDog();
        }

        else
        {
            print("Please enter a valid option!");
            startOfWoods();
        }
        return;
    }

    public static void HelpDog()
    {

        print("You see that a sharp twig is stuck in the paw of the dog which you then remove...");
        Dog dog = new Dog("bark", "Dog");
        dog.happy();
        dog.dogHelp();

        p1.increaseScore();

        intoTheWoods();

        return;
    }

    public static void intoTheWoods()
    {

        String what_do;

        Scanner scanner = new Scanner(System.in);

        print("You then proceed into the woods...");
        print("After going into the woods for a while you come across a bush which seems edible");
        print("What do you wish to do: ");
        print("1.> keep walking");
        print("2.> inspect");

        what_do = scanner.nextLine();

        if(what_do.equals("keep walking"))
        {
            furtherIntoWoods();
        }

        else if(what_do.equals("inspect"))
        {
            firstBushInspect();
        }

        else
        {
            print("Please enter a valid option!");
            intoTheWoods();
        }
        return;
    }

    public static void firstBushInspect()
    {
        String a;

        Scanner scanner = new Scanner(System.in);

        print("after you go closer to the bush and inspecting the leaves you realise the leaves are edible...");
        print("however your health is " + p1.giveHealth() + "...so what do you want to do: ");
        print("1.> continue on the journey");
        print("2.> store the leaves for later use");

        a = scanner.nextLine();

        if(a.equals("continue on the journey"))
        {
            furtherIntoWoods();
        }

        else if(a.equals("store the leaves for later use"))
        {
            String first_bush = "Retana";
            String smell;

            p1.increaseScore();

            print("The bush you have encountered is called Retana which can be used to increase health");

            print("Do you like the smell of this bush: (yes or no)");
            smell = scanner.nextLine();

            if(smell.equals("yes"))
            {
                bush.add2Inventory(first_bush, smell, p1);
                bush.color(first_bush);
                p1.showInventory();

                furtherIntoWoods();
            }

            else if(smell.equals("no"))
            {
                bush.add2Inventory(first_bush, smell, p1);
                bush.characteristic();
                p1.showInventory();

                furtherIntoWoods();
            }

            else
            {
                print("Please enter a valid option!");
                firstBushInspect();
            }
        }

        else
        {
            print("Please enter a valid option!");
            firstBushInspect();
        }
        return;
    }

    public static void furtherIntoWoods()
    {
        print("After walking into the forest for a you hear the bushes towards your right make some sound...");
        print("As soon as you turn around, you see a monster... ");

        Humungasoaurus hs = new Humungasoaurus();
        hs.growl();
        hs.attack(p1);

        secondBush();

        return;
    }

    public static void secondBush()
    {
        String next;

        Scanner scanner = new Scanner(System.in);

        print("After walking for a while you come across a second set of bushes!!");

        print("What do you chose to do: ");
        print("1.> continue on your journey");
        print("2.> inspect");
        print("3.> use inventory");

        next = scanner.nextLine();

        if (next.equals("continue on your journey"))
        {
            secondLastLeg();
        }

        else if(next.equals("use inventory"))
        {
            inventoryManipualtion();
            secondLastLeg();
        }

        else if(next.equals("inspect"))
        {
            bush = new Tinktoria();

            print("After going up to the bush you see that the leaves are edible...do you want to store these leaves? (yes or no)");

            String a;
            a = scanner.nextLine();

            if(a.equals("yes"))
            {
                String name = "Tinktoria";
                String smell;
                print("Do you like the smell of this bush?(yes or no");

                smell = scanner.nextLine();

                if (smell.equals("yes") || smell.equals("no")) {
                    p1.increaseScore();
                    bush.add2Inventory(name, smell, p1);
                    bush.characteristic();
                    bush.color(name);

                    p1.showInventory();

                    secondLastLeg();
                }

                else{
                    print("Please enter a valid option!");
                    secondBush();
                }
            }

            else if (a.equals("no"))
            {
                secondLastLeg();
            }

            else
            {
                print("Please enter a valid option!");
                secondBush();
            }
        }
        else {
            print("Please enter a valid option!!!");
            secondBush();
        }
        return;
    }

    public static void secondLastLeg()
    {
        String next;

        Scanner scanner = new Scanner(System.in);

        print("After walking into the forest for a while you come across a monkey who is squeaking painfully at near a tree!");

        print("What do you do? Your options are: ");
        print("1.> go to help the monkey");
        print("2.> keep walking");
        print("3.> use inventory");

        next = scanner.nextLine();

        if (next.equals("go to help the monkey"))
        {
            monkeyHelp();
        }

        else if(next.equals("use inventory"))
        {
            inventoryManipualtion();
            lastLeg();
        }

        else if (next.equals("keep walking"))
        {
            animal = new Animal("squeak", "Monkey");
            animal.sad();
            lastLeg();
        }

        else{
            print("Please enter a valid option next time!!");
            secondLastLeg();
        }
        return;
    }

    public static void monkeyHelp()
    {
        print("As soon as you step closer you see that the monkey had a sharp twig stuck on its tail...which you pull out.");

        Monkey m = new Monkey("squeal", "monkey");
        m.grateful();

        p1.increaseScore();

        print("However as soon as you turn around to continue on your journey a small monster comes out of nowhere!!");

        SmallMonster ls = new littlesaurus();

        ls.squeal();
        ls.attack(p1);

        print("After attacking you this monster runs away!!");

        lastLeg();

        return;
    }

    public static void lastLeg()
    {
        Scanner scanner = new Scanner(System.in);

        String next;
        print("What do you want to do?");
        print("1.> keep walking");

        next = scanner.nextLine();

        if(next.equals("keep walking"))
        {

            print("Out of nowhere a monster knows as Draka around these parts appears out of nowhere...");

            draka d = new draka();
            d.squeal();
            d.attack(p1);


            p1.increaseScore();

            print("After attacking you the draka runs away!");
            print("After walking for a while you reach the shore where a boat spots you and takes you home! CONGRATULATIONS YOU WON THE GAME!");

            EndofGame();

        }

        else
        {
            print("Please enter a valid option!!");
            lastLeg();
        }

        return;
    }

    public static void inventoryManipualtion()
    {
        String invent_item;
        Scanner scanner = new Scanner(System.in);

        p1.showInventory();

        print("You can type 'quit' to exit inventory page!");

        print("Which item in your inventory do you wish to use: ");

        invent_item = scanner.nextLine();

        if(invent_item.equals("quit"))
        {
            return;
        }

        else
        {
            p1.useInventory(invent_item);
            return;
        }

    }

    public static void EndofGame()
    {
        return;
    }


}
