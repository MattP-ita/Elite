package elite.utils;

import java.util.regex.Pattern;

public class ValidatorAllLetter implements InputVal{
	@Override
	public boolean valida(String str) {
		return Pattern.matches("^[A-Za-z]+(\\s?[A-Za-z])*$", str);
	}
}
