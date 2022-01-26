package elite.model;

import java.sql.SQLException;

public interface AccountModel<T> {
	public boolean checkEmail(String e) throws SQLException;
	
	public T checkAccount(String e, String p) throws SQLException;
}
