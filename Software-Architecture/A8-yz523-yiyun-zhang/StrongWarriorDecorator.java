
class StrongWarriorDecorator extends WarriorDecorator {

	Warrior warrior;

	StrongWarriorDecorator(Warrior warrior) {

		super(warrior);
		warrior.attack *= 2;

	}
}
