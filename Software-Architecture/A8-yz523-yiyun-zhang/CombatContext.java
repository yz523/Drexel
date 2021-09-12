
class CombatContext {

	private CombatState combatState;

	CombatContext() {

		combatState = new PowerCombatState();

	}

	Warrior startCombat(Warrior attacker, Warrior defender) {

		Warrior winner = combatState.fight(attacker, defender);
		return winner;

	}

	void nextState() {
		if (combatState instanceof PowerCombatState) {

			this.combatState = new AttackCombatState();

		} else if (combatState instanceof AttackCombatState) {

			this.combatState = new DefenseCombatState();

		} else if (combatState instanceof DefenseCombatState) {

			this.combatState = new TraditionalCombatState();

		} else if (combatState instanceof TraditionalCombatState) {

			this.combatState = new InverseCombatState();

		}

	}
}
