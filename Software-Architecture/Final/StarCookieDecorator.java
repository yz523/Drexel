
public class StarCookieDecorator extends CookieDecorator {

	Cookie cookie;
	double star = 0.25;

	StarCookieDecorator(Cookie cookie) {
		super(cookie);
		// TODO Auto-generated constructor stub
	}

	@Override
	double calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
