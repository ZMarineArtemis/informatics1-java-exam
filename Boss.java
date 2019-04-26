
public class Boss extends Monster {
private int stage;
private final int initialHealth;

public Boss(int health, int power) {
	super(health,power);
    this.initialHealth = health;
    this.stage = 1;
}

public String toString() {
	return "stage:" + stage + "\n";
}

public void takeDamage(int damage) {
	super.takeDamage(damage);
	int half = (1/2) * initialHealth;
	int quater = (1/4) * initialHealth;
	if(health <= half && health > quater) {
		stage = 2;
		power = 2 * power;
	}
	if(health <= quater) {
		if(stage == 2) {
			stage = 3;
			power = 2 * power;
		}else {
		 stage = 3;
		 power = 4 * power;
		}
	}
}
}
