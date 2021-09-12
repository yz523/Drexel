
abstract class Warrior {

	int level = 0;
	int attack = 0;
	int defense = 0;

	int getLevel() {

		return this.level;

	}

	int getAttack() {

		return this.attack;

	}

	int getDefense() {

		return this.defense;

	}

	static abstract class AbstractBuilder {

		Warrior warrior;

		AbstractBuilder attack(int attack) {

			warrior.attack = attack;
			return this;

		}

		AbstractBuilder defense(int defense) {

			warrior.defense = defense;
			return this;

		}

		Warrior build() {

			validate(warrior);
			return warrior;

		}

		private void validate(Warrior warrior) {

			String errorMessage = "";

			if (warrior.level <= 0) {

				errorMessage += "Level must be greater than 0. ";

			}

			if (warrior.attack <= 0) {

				errorMessage += "Attack must be greater than 0. ";

			}

			if (warrior.defense <= 0) {

				errorMessage += "Defense must be greater than 0. ";

			}

			if (!errorMessage.isEmpty()) {

				throw new IllegalStateException(errorMessage);

			}
		}
	}
}
