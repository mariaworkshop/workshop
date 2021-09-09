package homeworknumber5mariaheres;

public class Human extends Character {
    private int ammo;
    private int ammoPerRound; // added this because it could vary depending on gun used

    public Human(){
        super(); // for isDead
        this.health = 100;
        this.ammo = 200;
        this.ammoPerRound = 15;
    }

    public int getAmmo() {
        return ammo;
    }

    public boolean isDead() {
        if(isDead) {
            System.out.println("The human is dead");
        }
        return isDead;
    }

    // ammo decreases by ammoPerRound=15, does 25 health damage to alien
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
        int damage = 25;
        this.ammo = this.ammo - ammoPerRound;
        alien.setHealth(-damage);
        System.out.println("Human shot alien for " + damage + " damage");
    }
}
