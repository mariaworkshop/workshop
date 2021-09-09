package homeworknumber5mariaheres;

public class Alien {
    private int health;
    private int energy;
    private boolean isDead;

    public Alien(){
        this.health = 200;
        this.energy = 100;
        this.isDead = false;
    }

    public int getHealth() { //- gets the current health value
        return this.health;
    }

    public int getEnergy() { //- gets the current energy value
        return energy;
    }

    //increments or decrements health with specified amount
    //and if resulting health is low enough, kills the alien
    public void setHealth(int healthChange) {
        this.health = this.health + healthChange;
        if (health <= 0) {
            isDead();
        }
    }

    void die(){
        this.isDead = true;
        this.health = 0;
    }

    public boolean isDead() {
        if(isDead) {
            System.out.println("The alien is dead");
        }
        return isDead;
    }

    public void biteHuman(Human human) {
        // no point in biting dead enemies and dead aliens don't bite
        if (human.isDead() || isDead){
            return;
        }
        // if the alien does not have enough energy, it can't bite
        int energyPerBite = 10;
        if (energy<energyPerBite) {
            System.out.println("Not enough energy to bite");
            return;
        }
        // if energy is between 80-100, does 25 health damage to human,
        // 50-80 -> 15 damage,
        // less than 50 -> 10 damage.
        int highEnergyDamage = 25;
        int medEnergyDamage = 15;
        int lowEnergyDamage = 10;
        if (energy>80) {
            human.setHealth(-highEnergyDamage);
            System.out.println("Alien bit human for " + highEnergyDamage + " damage");
        } else if (energy>50) {
            human.setHealth(-medEnergyDamage);
            System.out.println("Alien bit human for " + medEnergyDamage + " damage");
        } else if (energy>0){
            human.setHealth(-lowEnergyDamage);
            System.out.println("Alien bit human for " + lowEnergyDamage + " damage");
        }
        // with every bite, the energy level decreases by 10
        this.energy = this.energy - energyPerBite;
    }
}
