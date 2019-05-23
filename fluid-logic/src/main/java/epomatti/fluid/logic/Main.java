package epomatti.fluid.logic;

public class Main {

	public static void main(String[] args) throws Exception {

		// Sets Nashorn compatibility mode to allow reading object attributes.
		System.setProperty("polyglot.js.nashorn-compat", "true");
		UserService service = new UserService();

		// Tests authorized user
		User userAuthorized = new User();
		userAuthorized.setName("username");
		userAuthorized.setProfile("admin");
		boolean r1 = service.validatePermission(userAuthorized);
		System.out.println(r1);

		// Tests unauthorized user
		User userUnuthorized = new User();
		userAuthorized.setName("username");
		userAuthorized.setProfile("none");
		boolean r2 = service.validatePermission(userUnuthorized);
		System.out.println(r2);
		
	}
}
