public abstract class Bush{

    private String name;
    private Player player;

    public abstract void color(String first_bush);

    public void characteristic(){
        System.out.println("This increases your health by 10 points!!!");
    }

    public void add2Inventory(String na, String sm, Player pname)
    {
        this.player = pname;
        this.name = na;

        this.player.addInventory(na);

        if(sm.equals("yes"))
        {
            System.out.println(na + " which smells good has been added to inventory!");
        }

        else if(sm.equals("no"))
        {
            System.out.println(na + " which smells bad has been added to inventory!");
        }

        else
        {
            System.out.println("This condition isn't gonna print");
        }
    }
}
