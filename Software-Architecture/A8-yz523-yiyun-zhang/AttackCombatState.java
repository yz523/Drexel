
class AttackCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attacker, Warrior defender) {

		if (attacker.calculateAttack() > defender.calculateAttack()) {

			return attacker;

		} else {

			return defender;

		}
	}
}
