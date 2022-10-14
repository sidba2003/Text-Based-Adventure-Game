public class Animal
{
    static private String sound;
    static private String type;

    public Animal()
    {
        this.type = "";
        this.sound = "";
    }

    public Animal(String a, String b)
    {
        this.sound = a;
        this.type = b;
    }

    public static void happy()
    {
        System.out.println("The " + type + " happily " + sound + "s at you." );
    }

    public static void sad()
    {
        System.out.println("The " + type + " sadly " + sound + "s at you." );
    }

    public void run()
    {

        System.out.println("The " + this.type + " runs away!!");
    }

}
