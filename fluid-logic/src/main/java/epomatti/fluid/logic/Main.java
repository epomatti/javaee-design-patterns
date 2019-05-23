package epomatti.fluid.logic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {

	public static void main(String[] args) throws Exception {

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
		String path = "rules.js";

		try (InputStream is = Main.class.getClassLoader().getResourceAsStream(path);
				Reader reader = new InputStreamReader(is)) {

			engine.eval(reader);
			Invocable inv = (Invocable) engine;
			Object obj = engine.get("obj");

			User user = new User();
			user.setName("username");
			user.setProfile("admin");

			Boolean retorno = (Boolean) inv.invokeMethod(obj, "validatePermission", user);
			System.out.println("Validation: " + retorno);

		}
	}
}
