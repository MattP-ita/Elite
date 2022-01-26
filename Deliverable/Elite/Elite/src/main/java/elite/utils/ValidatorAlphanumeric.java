package elite.utils;

import java.util.regex.Pattern;

public class ValidatorAlphanumeric implements InputVal {

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^[A-Za-z0-9]+(\\s?[A-Za-z0-9])*$", str);
	}

}
