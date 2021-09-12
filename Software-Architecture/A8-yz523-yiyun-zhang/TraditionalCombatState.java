
class TraditionalCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attacker, Warrior defender) {

		if (attacker.calculateAttack() > defender.calculateDefense()) {

			return attacker;

		} else {

			return defender;

		}
	}
}
