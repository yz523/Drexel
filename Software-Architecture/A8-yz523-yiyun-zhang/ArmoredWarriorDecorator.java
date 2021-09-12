
class ArmoredWarriorDecorator extends WarriorDecorator {

	Warrior warrior;

	ArmoredWarriorDecorator(Warrior warrior) {

		super(warrior);
		warrior.defense *= 2;

	}
}
