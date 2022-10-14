public class Dog extends Animal{

    private static String help = "no";

    public Dog(String a, String b)
    {
        super(a, b);
    }

    public void dogHelp()
    {
        help = "yes";
    }

    public static String attack()
    {
        return help;
    }
}
