package elite.utils;

import java.util.regex.Pattern;

public class ValidatorGiri implements InputVal {

	@Override
	public boolean valida(String str) {
		if (Pattern.matches("^\\d{2}$", str)) {
			int giri = Integer.parseInt(str);
			return giri == 33 || giri == 45 || giri == 78;
		}
		return false;
	}

}
