package elite.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elite.bean.Ordine;
import elite.bean.Vinile;

public class OrdineModel implements ClassModel<Ordine> {

	@Override
	public Ordine findByKey(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ordine> findAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Ordine o) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL="INSERT INTO ordine(id, idCliente, indirizzo, pagamento, data) VALUES (?,?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, o.getId());
			preparedStatement.setInt(2, o.getIdCliente());
			preparedStatement.setString(3, o.getIndirizzo().toString());
			preparedStatement.setString(4, o.getPagamento().toString());
			preparedStatement.setDate(5, Date.valueOf(o.getData()));
			

			System.out.println("OrdineModel-Save:" + preparedStatement.toString());
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
	public void update(Ordine obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ordine obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Ordine> findByClient(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Ordine> ordini = new ArrayList<Ordine>();

		String selectSQL = "SELECT * FROM ordine WHERE idCliente=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("OrdineModel: findByClient:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ordine p = new Ordine();

				p.setId(rs.getString("id"));
				p.setIdCliente(rs.getInt("idCliente"));
				p.getIndirizzoDB(rs.getString("indirizzo"));
				p.getPagamentoDB(rs.getString("pagamento"));
				p.setData(rs.getDate("data").toLocalDate());
				ordini.add(p);
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
		return ordini;
	}

	public void insertContenutoOrdine(Ordine o, Vinile v) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL="INSERT INTO itemOrdine(idOrdine, idVinile, prezzo, quantita) VALUES (?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, o.getId());
			preparedStatement.setString(2, v.getId());
			preparedStatement.setDouble(3, v.getPrezzo());
			preparedStatement.setInt(4, v.getQuantita());
			

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

}
