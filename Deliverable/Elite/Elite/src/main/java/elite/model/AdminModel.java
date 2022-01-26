package elite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import elite.bean.Admin;

public class AdminModel implements AccountModel<Admin> {

	@Override
	public boolean checkEmail(String e) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin checkAccount(String e, String p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL="SELECT * FROM admin WHERE email=? AND password=?";
		
		Admin a=new Admin();
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, e);
			preparedStatement.setString(2, p);

			System.out.println("AdminModel-checkEmail:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {						
				a.setEmail(rs.getString("email"));
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return a;
	}
}
