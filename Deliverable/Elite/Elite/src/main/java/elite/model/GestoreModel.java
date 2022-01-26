package elite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elite.bean.Gestore;

public class GestoreModel implements ClassModel<Gestore>, AccountModel<Gestore> {

	@Override
	public Gestore findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Gestore g=new Gestore();
		
		String selectSQL="SELECT * FROM gestore WHERE id=?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("GestoreModel-findByKey:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				g.setId(rs.getInt("id"));
				g.setNome(rs.getString("nome"));	
				g.setEmail(rs.getString("email"));
				g.setPassword(rs.getString("password"));
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
		return g;
	}

	@Override
	public ArrayList<Gestore> findAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Gestore> gestori = new ArrayList<Gestore>();

		String selectSQL = "SELECT * FROM gestore";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("GestoreModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Gestore g=new Gestore();
				
				g.setId(rs.getInt("id"));
				g.setNome(rs.getString("nome"));	
				g.setEmail(rs.getString("email"));
				gestori.add(g);
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
		return gestori;
	}

	@Override
	public void save(Gestore g) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL="INSERT INTO gestore(nome, email, password) VALUES (?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, g.getNome());
			preparedStatement.setString(2, g.getEmail());
			preparedStatement.setString(3, g.getPassword());
			

			System.out.println("GestoreModel-Save:" + preparedStatement.toString());
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
	public void update(Gestore g) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE gestore SET nome=?, email=?, password=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setString(1, g.getNome());
			preparedStatement.setString(2, g.getEmail());
			preparedStatement.setString(3, g.getPassword());
			preparedStatement.setInt(4, g.getId());

			System.out.println("GestoreModel-Update:" + preparedStatement.toString());
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
	public void delete(Gestore g) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM gestore WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, g.getId());

			System.out.println("GestoreModel-Delete:" + preparedStatement.toString());
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
	public boolean checkEmail(String e) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL="SELECT * FROM gestore WHERE email=?";
		
		Gestore g=new Gestore();
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, e);

			System.out.println("GestoreModel-checkEmail:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {				
				g.setEmail(rs.getString("email"));
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
		
		return g.getEmail()==null;
	}
	
	@Override
	public Gestore checkAccount(String e, String p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL="SELECT * FROM gestore WHERE email=? AND password=?";
		
		Gestore g=new Gestore();
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, e);
			preparedStatement.setString(2, p);

			System.out.println("GestoreModel-checkEmail:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {		
				g.setNome(rs.getString("nome"));
				g.setEmail(rs.getString("email"));
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
		
		return g;
	}
}
