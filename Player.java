import java.io.*;
import java.util.ArrayList;
public class Player {

    private int health = 100;
    private int score = 0;
    private String name;
    private int prvs_score;

    private ArrayList<String> inventory = new ArrayList<String>();

    public Player()
    {
        try{

        BufferedReader br = new BufferedReader(new FileReader("..\\MiniOOP\\src\\score.txt"));
        prvs_score = Integer.parseInt(br.readLine());
        System.out.println("Your Highest score is " + prvs_score);
        br.close();
    }
        catch(Exception e)
        {
            System.out.println("Something went wrong while reading from file!");
        }
    }

    public void name(String a)
    {
        this.name = a;
    }

    public String giveName()
    {
        return this.name;
    }

    public void increaseScore()
    {
        this.score += 10;
        System.out.println("your new score is " + this.score);
        this.scoreUpdate();
        return;
    }

    public void addInventory(String a)   // adds items to the array list //
    {
        this.inventory.add(a);
        return;
    }

    public void showInventory()   // displays the inventory held by the user //
    {
        System.out.println("your inventory is as follows: ");
        int a = this.inventory.size();

        if(a == 0)
        {
            System.out.println("No inventory to show right now!");
        }

        else {
            for (int i = 0; i < a; i++) {
                System.out.println((i + 1) + ".> " + this.inventory.get(i));
            }
        }
        return;
    }

    public void increaseHealth()
    {
        this.health += 20;

        if(this.health > 100)
        {
            System.out.println("Your health is 100");
        }

        else {
            System.out.println("Your new health is " + this.health);
        }
        return;

    }

    public int giveScore()
    {
        return this.score;
    }

    public int giveHealth()
    {
        if (this.health > 100)
        {
            return 100;
        }

        else {
            return this.health;
        }
    }

    public void bigMonsterAttack()
    {
        this.health -= 50;
        checkHealth(this.health);
        System.out.println("Your new health is " + this.health);
        return;
    }

    public void lastMonsterAttack()
    {
        this.health -= 70;
        checkHealth(this.health);
        System.out.println("Your new health is " + giveHealth());
        return;
    }

    public void smallMonsterAttack()
    {
        this.health -= 30;
        checkHealth(this.health);
        System.out.println("your new health is " + this.health);
        return;
    }

    public void useInventory(String a)
    {
        int index = checkInventory(a);

        if (index == 9)
        {
            System.out.println("Please chose an existing item from the inventory!");
            World.inventoryManipualtion();
        }

        else{
            this.inventory.remove(index);
            this.increaseHealth();
        }
        return;
    }

    public int checkInventory(String a)
    {
        int len = this.inventory.size();
        int index = 9;

        for(int i = 0; i < len; i++)
        {
            if (a.equals(this.inventory.get(i)))
            {
                index = i;
            }
        }
        return index;
    }

    public void checkHealth(int a)
    {
        if (a <= 0)
        {
            System.out.println("YOU HAVE DIED...");
            System.out.println("You were not able to survive...GAME OVER!");
            World.EndofGame();
        }

        return;
    }

    public void scoreUpdate()
    {
        if (this.score > prvs_score)
        {
            try {
                    PrintStream p = new PrintStream("..\\MiniOOP\\src\\score.txt");

                    p.println(this.score);
                }

            catch (Exception e)
            {
                System.out.println("Something went wrong while writting to the file!");
            }
        }
    }


}
