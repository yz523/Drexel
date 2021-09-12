
class DefenseCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attacker, Warrior defender) {

		if (attacker.calculateDefense() > defender.calculateDefense()) {

			return attacker;

		} else {

			return defender;

		}
	}
}
