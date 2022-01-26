package elite.utils;

import java.util.regex.Pattern;

public class ValidatorPassword implements InputVal{

	@Override
	public boolean valida(String str) {
		return Pattern.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,15})", str);
	}
}
