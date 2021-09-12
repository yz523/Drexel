
class DefensiveWarrior extends Warrior {

	private DefensiveWarrior(int level) {

		this.level = level;

	}

	static class Builder extends AbstractBuilder {

		Builder(int level) {

			warrior = new DefensiveWarrior(level);
			warrior.attack = 2;
			warrior.defense = 3;

		}
	}
}
