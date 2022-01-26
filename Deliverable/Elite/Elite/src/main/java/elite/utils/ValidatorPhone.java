package elite.utils;
import java.util.regex.Pattern;

public class ValidatorPhone implements InputVal{
	@Override
	public boolean valida(String str) {
		return Pattern.matches("^\\d{8,15}$", str);
	}
}
