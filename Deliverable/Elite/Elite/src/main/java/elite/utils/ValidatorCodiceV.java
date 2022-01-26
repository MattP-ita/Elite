package elite.utils;

import java.util.regex.Pattern;

public class ValidatorCodiceV implements InputVal {

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^[A-Z0-9]{10}$", str);
	}

}
