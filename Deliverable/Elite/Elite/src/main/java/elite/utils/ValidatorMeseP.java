package elite.utils;

import java.util.regex.Pattern;

public class ValidatorMeseP implements InputVal {

	@Override
	public boolean valida(String str) {
		if(Pattern.matches("^\\d{2}$", str)) {
			int mese=Integer.parseInt(str);
			return mese>=1 && mese<=12;
		}
		return false;
	}

}
