package elite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elite.bean.Indirizzo;

public class IndirizzoModel implements ClassModel<Indirizzo> {

	@Override
	public Indirizzo findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Indirizzo i = new Indirizzo();

		String selectSQL = "SELECT * FROM indirizzo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("IndirizzoModel-findByKey:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				i.setId(rs.getInt("id"));
				i.setIdCliente(rs.getInt("idCliente"));
				i.setNome(rs.getString("nome"));
				i.setTelefono(rs.getString("telefono"));
				i.setIndirizo(rs.getString("indirizzo"));
				i.setRegione(rs.getString("regione"));
				i.setProvincia(rs.getString("provincia"));
				i.setCitta(rs.getString("citta"));
				i.setCap(rs.getString("cap"));
				i.setDescrizione(rs.getString("descrizione"));
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
		return i;
	}

	@Override
	public ArrayList<Indirizzo> findAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Indirizzo i) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO indirizzo(idCliente, nome, telefono, indirizzo, regione, provincia, citta, cap, descrizione) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1, i.getIdCliente());
			preparedStatement.setString(2, i.getNome());
			preparedStatement.setString(3, i.getTelefono());
			preparedStatement.setString(4, i.getIndirizo());
			preparedStatement.setString(5, i.getRegione());
			preparedStatement.setString(6, i.getProvincia());
			preparedStatement.setString(7, i.getCitta());
			preparedStatement.setString(8, i.getCap());
			preparedStatement.setString(9, i.getDescrizione());

			System.out.println("IndirizzoModel-Save:" + preparedStatement.toString());
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
	public void update(Indirizzo i) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE indirizzo SET idCliente=?, nome=?, telefono=?, indirizzo=?, regione=?, provincia=?, citta=?, cap=?, descrizione=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, i.getIdCliente());
			preparedStatement.setString(2, i.getNome());
			preparedStatement.setString(3, i.getTelefono());
			preparedStatement.setString(4, i.getIndirizo());
			preparedStatement.setString(5, i.getRegione());
			preparedStatement.setString(6, i.getProvincia());
			preparedStatement.setString(7, i.getCitta());
			preparedStatement.setString(8, i.getCap());
			preparedStatement.setString(9, i.getDescrizione());
			preparedStatement.setInt(10, i.getId());

			System.out.println("IndirizzoModel-Update:" + preparedStatement.toString());
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
	public void delete(Indirizzo i) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM indirizzo WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, i.getId());

			System.out.println("IndirizzoModel-Delete:" + preparedStatement.toString());
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

	public ArrayList<Indirizzo> findByClient(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();

		String selectSQL = "SELECT * FROM indirizzo WHERE idCliente=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("IndirizzoModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Indirizzo i = new Indirizzo();

				i.setId(rs.getInt("id"));
				i.setIdCliente(rs.getInt("idCliente"));
				i.setNome(rs.getString("nome"));
				i.setTelefono(rs.getString("telefono"));
				i.setIndirizo(rs.getString("indirizzo"));
				i.setRegione(rs.getString("regione"));
				i.setProvincia(rs.getString("provincia"));
				i.setCitta(rs.getString("citta"));
				i.setCap(rs.getString("cap"));
				i.setDescrizione(rs.getString("descrizione"));
				indirizzi.add(i);
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
		return indirizzi;
	}
}
