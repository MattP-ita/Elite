package elite.utils;

import java.util.regex.Pattern;

public class ValidatorName implements InputVal {

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^[A-Za-z]{2,20}$", str);
	}
}

