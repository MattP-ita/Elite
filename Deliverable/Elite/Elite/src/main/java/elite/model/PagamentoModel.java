package elite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elite.bean.Pagamento;

public class PagamentoModel implements ClassModel<Pagamento> {

	@Override
	public Pagamento findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Pagamento p = new Pagamento();

		String selectSQL = "SELECT * FROM pagamento WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("PagamentoModel-findByKey:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setTipo(rs.getString("tipo"));
				p.setIdCliente(rs.getInt("idCliente"));
				p.setNome(rs.getString("nome"));
				p.setNumero(rs.getString("numero"));
				p.setScadenza(rs.getString("scadenza"));
				p.setCodice(rs.getString("codice"));
				p.setValido(rs.getInt("valido"));
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
		return p;
	}

	@Override
	public ArrayList<Pagamento> findAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pagamento p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO pagamento(tipo, idCliente, nome, numero, scadenza, codice) VALUES (?,?,?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, p.getTipo());
			preparedStatement.setInt(1, p.getIdCliente());
			preparedStatement.setString(2, p.getNome());
			preparedStatement.setString(3, p.getNumero());
			preparedStatement.setString(4, p.getScadenza());
			preparedStatement.setString(5, p.getCodice());

			System.out.println("PagamentoModel-Save:" + preparedStatement.toString());
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
	public void update(Pagamento p) throws SQLException {
	}

	@Override
	public void delete(Pagamento p) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM pagamento WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, p.getId());

			System.out.println("PagamentoModel-Delete:" + preparedStatement.toString());
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
	
	public ArrayList<Pagamento> findByClient(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Pagamento> pagamenti = new ArrayList<Pagamento>();

		String selectSQL = "SELECT * FROM pagamento WHERE idCliente=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("PagamentoModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Pagamento p = new Pagamento();

				p.setId(rs.getInt("id"));
				p.setTipo(rs.getString("tipo"));
				p.setIdCliente(rs.getInt("idCliente"));
				p.setNome(rs.getString("nome"));
				p.setNumero(rs.getString("numero"));
				p.setScadenza(rs.getString("scadenza"));
				p.setCodice(rs.getString("codice"));
				p.setValido(rs.getInt("valido"));
				pagamenti.add(p);
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
		return pagamenti;
	}
	
	public boolean checkNumber(String n) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Pagamento p = new Pagamento();
		String selectSQL = "SELECT * FROM pagamento WHERE numero=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, n);

			System.out.println("PagamentoModel-findByKey:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				p.setNumero(rs.getString("numero"));
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
		return p.isEmpty();	
	}
}
