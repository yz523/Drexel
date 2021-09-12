
public class Gluten_freeCookie extends Cookie {

	private double gluten_free = 1.25;

	private Gluten_freeCookie(String base) {

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
