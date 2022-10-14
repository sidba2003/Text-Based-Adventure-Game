public interface SmallMonster extends Monster{
    String type = "kick";
    default void attack(Player p1)
    {
        System.out.println("This monster starts to attack you by " + type + "ing you");
        p1.smallMonsterAttack();
    }
    public void squeal();

}
