package elite.utils;

import java.util.regex.Pattern;

public class ValidatorNumber implements InputVal {

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^\\d{1,3}$", str);
	}
}