
class AggressiveWarrior extends Warrior {

	private AggressiveWarrior(int level) {

		this.level = level;

	}

	static class Builder extends AbstractBuilder {

		Builder(int level) {

			warrior = new AggressiveWarrior(level);
			warrior.attack = 3;
			warrior.defense = 2;

		}
	}
}
