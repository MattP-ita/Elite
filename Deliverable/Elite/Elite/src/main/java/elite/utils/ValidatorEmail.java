package elite.utils;

import java.util.regex.Pattern;

public class ValidatorEmail implements InputVal{

	@Override
	public boolean valida(String str) {
		return Pattern.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", str);
	}
}
