package elite.utils;

import java.util.regex.Pattern;

public class ValidatorDouble implements InputVal {

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^\\d+(\\.\\d+)?$", str);
	}
}

