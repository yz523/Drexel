
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

	@Override
	int calculateAttack() {

		return (this.attack + this.level);

	}

	@Override
	int calculateDefense() {

		return (this.defense + 2 * this.level);

	}

	@Override
	double calculateBoost() {

		return ((double) this.defense / 2);

	}
}
