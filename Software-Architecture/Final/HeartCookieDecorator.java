
public class HeartCookieDecorator extends CookieDecorator {
	Cookie cookie;
	double heart = 0.5;

	HeartCookieDecorator(Cookie cookie) {
		super(cookie);
		// TODO Auto-generated constructor stub
	}

	@Override
	double calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
