package elite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elite.bean.Cliente;

public class ClienteModel implements ClassModel<Cliente>, AccountModel<Cliente> {

	@Override
	public Cliente findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Cliente c=new Cliente();
		
		String selectSQL="SELECT * FROM cliente WHERE id=?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("ClienteModel-findByKey:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));	
				c.setTelefono(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
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
		return c;
	}
	
	@Override
	public ArrayList<Cliente> findAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Cliente c) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL="INSERT INTO cliente(nome, telefono, email, password) VALUES (?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, c.getNome());
			preparedStatement.setString(2, c.getTelefono());
			preparedStatement.setString(3, c.getEmail());
			preparedStatement.setString(4, c.getPassword());
			

			System.out.println("ClienteModel-Save:" + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}		
	}

	@Override
	public void update(Cliente c) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE cliente SET nome=?, telefono=?, email=?, password=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setString(1, c.getNome());
			preparedStatement.setString(2, c.getTelefono());
			preparedStatement.setString(3, c.getEmail());
			preparedStatement.setString(4, c.getPassword());
			preparedStatement.setInt(5, c.getId());

			System.out.println("ClienteModel-Update:" + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public void delete(Cliente c) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM cliente WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, c.getId());

			System.out.println("ClienteModel-Delete:" + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	public boolean checkEmail(String e) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL="SELECT * FROM cliente WHERE email=?";
		
		Cliente c=new Cliente();
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, e);

			System.out.println("ClienteModel-checkEmail:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {				
				c.setEmail(rs.getString("email"));
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
		
		return c.getEmail()==null;
	}
	
	public Cliente checkAccount(String e, String p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL="SELECT * FROM cliente WHERE email=? AND password=?";
		
		Cliente c=new Cliente();		
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, e);
			preparedStatement.setString(2, p);

			System.out.println("GestoreModel-checkEmail:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));	
				c.setTelefono(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
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
		
		return c;
	}
}
