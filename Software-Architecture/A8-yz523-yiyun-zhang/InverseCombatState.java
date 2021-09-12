
class InverseCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attacker, Warrior defender) {

		if (attacker.calculateDefense() >= defender.calculateAttack()) {

			return attacker;

		} else {

			return defender;

		}
	}
}
