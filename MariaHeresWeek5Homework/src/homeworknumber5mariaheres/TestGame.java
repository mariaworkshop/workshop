package homeworknumber5mariaheres;

public class TestGame {
    public static void main(String[] args) {
        Human human = new Human();
        Alien alien = new Alien();
        alienAttack(alien, human); // alien bites one
        humanAttack(human, alien); // human shoots twice
        alienEnraged(alien, human); // alien bites seven times
    }
    public static void alienAttack(Alien alien, Human human){
        //Alien bites human 1 time. Print human health and alien energy before and after this operation
        System.out.println("Human health: " + human.getHealth() + "\nAlien energy: " + alien.getEnergy());
        alien.biteHuman(human);
        System.out.println("Human health: " + human.getHealth() + "\nAlien energy: " + alien.getEnergy());
    }

    public static void humanAttack(Human human, Alien alien){
        //Human shoots alien 2 times. Print alien health and human ammo before and after this operation
        System.out.println("Alien health: " + alien.getHealth() + "\nHuman ammo: " + human.getAmmo());
        human.shootAlien(alien);
        human.shootAlien(alien);
        System.out.println("Alien health: " + alien.getHealth() + "\nHuman ammo: " + human.getAmmo());
    }

    public static void alienEnraged(Alien alien, Human human){
        // additional action that tests human dying and alien trying to bite dead human
        System.out.println("Alien didn't like that. It entered an unstoppable frenzy.");
        System.out.println("Human health: " + human.getHealth() + "\nAlien energy: " + alien.getEnergy());
        for (int i=0; i<=6; i++){
            alien.biteHuman(human);
        }
        System.out.println("Human health: " + human.getHealth() + "\nAlien energy: " + alien.getEnergy());
    }
}
