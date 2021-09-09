package homeworknumber5mariaheres;

public abstract class Character {
    protected int health;
    protected boolean isDead;

    // I think this is the only one common to both alien and human as far as value
    public Character(){
        this.isDead = false;
    }

    public int getHealth() {
        return this.health;
    }

    //increments or decrements health with specified amount
    //and if resulting health is low enough, kills the character
    public void setHealth(int healthChange) {
        this.health = this.health + healthChange;
        if (health <= 0) {
            die();
        }
    }

    // performs the actual killing of the character
    private void die(){
        this.isDead = true;
        this.health = 0;
    }

    // implemented differently in alien and human
    public abstract boolean isDead();
}
