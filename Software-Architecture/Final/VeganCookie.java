
public class VeganCookie extends Cookie {

	private double vegan = 1.5;

	private VeganCookie(String base) {

	}

	static class Builder extends AbstractBuilder {

		Builder() {

		}
	}

	@Override
	double calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
