package elite.utils;

import java.util.Calendar;
import java.util.regex.Pattern;

public class ValidatorScadenza implements InputVal {

	@Override
	public boolean valida(String str) {
		if(Pattern.matches("^\\d{4}$", str)) {
			int m=Integer.parseInt(str.substring(0,2));
			int a=Integer.parseInt(str.substring(2));
			a=a+2000;
			int current=Calendar.getInstance().get(Calendar.YEAR);
			return a>=current && (m>=1 && m<=12);
		}
		return false;
	}

}
