public interface BigMonster extends Monster{
    String type = "punch";

    default void attack(Player p) {

        System.out.println("This monster starts to attack you by " + type + "ing you!!");
        String a = Dog.attack();

        if (a.equals("yes"))
        {
            System.out.println("However the dog you helped earlier came to save you out of nowhere and sacrificed itself...");
            p.smallMonsterAttack();
        }

        else{
            System.out.println("After attacking you the monster ran awayy!!");
            p.bigMonsterAttack();
        }

        p.increaseScore();

        return;
    }
}
