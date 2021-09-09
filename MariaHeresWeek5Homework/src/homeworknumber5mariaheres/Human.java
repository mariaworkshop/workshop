package homeworknumber5mariaheres;

public class Human implements Character {
    private int health;
    private int ammo;
    private boolean isDead;
    private int ammoPerRound; // added this because it could vary depending on gun used

    public Human(){
        this.health = 100;
        this.ammo = 200;
        this.isDead = false;
        this.ammoPerRound = 15;
    }

    public int getHealth() {
        return health;
    }

    public int getAmmo() {
        return ammo;
    }

    //increments or decrements health with specified amount
    //and if resulting health is low enough, kills the alien
    public void setHealth(int healthChange) {
        this.health = this.health + healthChange;
        if (health <= 0) {
            die();
        }
    }

    private void die(){
        this.isDead = true;
        this.health = 0;
    }

    public boolean isDead() {
        if(isDead) {
            System.out.println("The human is dead");
        }
        return isDead;
    }

    public void shootAlien(Alien alien) {
        // no point in shooting dead enemies and dead humans can't shoot
        if (alien.isDead() || isDead){
            return;
        }
        // if the human does not have enough ammo, they can't shoot
        if (ammo < ammoPerRound) {
            System.out.println("Not enough ammo to shoot");
            return;
        }
        // ammo decreases by 15, does 25 health damage to alien
        int damage = 25;
        this.ammo = this.ammo - ammoPerRound;
        alien.setHealth(-damage);
        System.out.println("Human shot alien for " + damage + " damage");
    }
}
