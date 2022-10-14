public class Monkey extends Animal{
    private String throw_food;
    private Player player;

    public Monkey(Player p)
    {
        player = p;
    }

    public Monkey()
    {
        throw_food = "";
    }

    public Monkey(String sound, String type)
    {
        super(sound, type);
    }

    public void grateful()
    {
        System.out.println("The monkey feels grateful towards you!!");
    }
}
