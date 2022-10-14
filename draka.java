public class draka implements SmallMonster, BigMonster{
    @Override
    public void attack(Player p1) {
        System.out.println("draka starts attacking you by kicking and punching you!");
        p1.lastMonsterAttack();
    }

    @Override
    public void squeal() {
        System.out.println("draka starts squealing at you very angrily!!");
    }
}
