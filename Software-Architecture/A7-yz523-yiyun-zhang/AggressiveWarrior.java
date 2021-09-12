
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

	@Override
	int calculateAttack() {

		return (this.attack + this.level * 2);

	}

	@Override
	int calculateDefense() {

		return (this.defense + this.level);

	}

	@Override
	double calculateBoost() {

		return ((double) this.attack / 2);

	}
}
