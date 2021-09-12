
class Combat {

	private CombatContext combatContext;

	Combat(CombatContext combatContext) {

		this.combatContext = combatContext;

	}

	Warrior duel(Warrior attacker, Warrior defender) {

		Warrior roundFightWinner;
		int attackerWinsCount = 0;
		int defenderWinsCount = 0;

		for (int round = 0; round < 5; round++) {

			roundFightWinner = combatContext.startCombat(attacker, defender);

			if (isAttackerWin(roundFightWinner, attacker, defender)) {

				attackerWinsCount++;

			} else {

				defenderWinsCount++;

			}

			combatContext.nextState();
		}

		return getDuelWinner(attackerWinsCount, defenderWinsCount, attacker, defender);

	}

	private boolean isAttackerWin(Warrior roundFightWinner, Warrior attacker, Warrior defender) {

		if (roundFightWinner.equals(attacker)) {

			return true;

		} else {

			return false;

		}
	}

	private Warrior getDuelWinner(int attackerWinsCount, int defenderWinsCount, Warrior attacker, Warrior defender) {

		if (attackerWinsCount > defenderWinsCount) {

			return attacker;

		} else {

			return defender;

		}
	}

}
