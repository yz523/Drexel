
class PowerCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attacker, Warrior defender) {

		if (attacker.calculatePower() > defender.calculatePower()) {

			return attacker;

		} else {

			return defender;

		}
	}
}
