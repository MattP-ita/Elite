package elite.utils;

import java.util.Calendar;
import java.util.regex.Pattern;

public class ValidatorAnnoP implements InputVal{

	@Override
	public boolean valida(String str) {
		if(Pattern.matches("^\\d{2}$", str)) {
			int anno=Integer.parseInt(str);
			anno=anno+2000;
			int current=Calendar.getInstance().get(Calendar.YEAR);
			return anno>=current;
		}
		return false;
	}

}
