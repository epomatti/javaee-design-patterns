package epomatti.fluid.logic;

public class UserService {

	public Boolean validatePermission(User user) {
		return (Boolean) RuleEngine.invokeMethod("validatePermission", user);
	}

}
