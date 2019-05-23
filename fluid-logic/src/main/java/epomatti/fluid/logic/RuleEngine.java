package epomatti.fluid.logic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class RuleEngine {

	static ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
	static Invocable inv;

	static {

		String path = "rules.js";
		try (InputStream is = Main.class.getClassLoader().getResourceAsStream(path);
				Reader reader = new InputStreamReader(is)) {
			engine.eval(reader);
			inv = (Invocable) engine;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object invokeMethod(String method, Object... args) {
		Object obj = engine.get("obj");
		try {
			return inv.invokeMethod(obj, method, args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
