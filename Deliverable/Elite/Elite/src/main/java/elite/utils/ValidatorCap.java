package elite.utils;

import java.util.regex.Pattern;

public class ValidatorCap implements InputVal {

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^\\d{5}$", str);
	}

}
