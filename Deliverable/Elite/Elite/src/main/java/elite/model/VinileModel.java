package elite.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import elite.bean.Artista;
import elite.bean.Genere;
import elite.bean.Vinile;

public class VinileModel implements ClassModel<Vinile> {

	@Override
	public Vinile findByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Vinile v = new Vinile();

		String selectSQL = "SELECT V.*, A.nomeA, G.nomeG FROM vinile as V, artista as A, genere as G WHERE V.id=? AND V.idArtista=A.id AND V.idGenere=G.id";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel-findByKey:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				v.setId(rs.getString("id"));
				v.setNome(rs.getString("nome"));
				v.setGiri(rs.getString("giri"));
				v.setArtista(new Artista(rs.getInt("idArtista"), rs.getString("nomeA")));
				v.setGenere(new Genere(rs.getInt("idGenere"), rs.getString("nomeG")));
				v.setPrezzo(rs.getDouble("prezzo"));
				v.setQuantita(rs.getInt("quantita"));
				byte[] bt = rs.getBytes("copertina");
				if (bt == null) {
					v.setCopertina(false);
				} else {
					v.setCopertina(true);
				}
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
		return v;
	}

	@Override
	public ArrayList<Vinile> findAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Vinile> vinili = new ArrayList<Vinile>();

		String selectSQL = "SELECT V.*, A.nomeA, G.nomeG FROM vinile as V, artista as A, genere as G WHERE V.idArtista=A.id AND V.idGenere=G.id";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("VinileModel: findAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Vinile v = new Vinile();

				v.setId(rs.getString("id"));
				v.setNome(rs.getString("nome"));
				v.setGiri(rs.getString("giri"));
				v.setArtista(new Artista(rs.getInt("idArtista"), rs.getString("nomeA")));
				v.setGenere(new Genere(rs.getInt("idGenere"), rs.getString("nomeG")));
				v.setPrezzo(rs.getDouble("prezzo"));
				v.setQuantita(rs.getInt("quantita"));
				byte[] bt = rs.getBytes("copertina");
				if (bt == null) {
					v.setCopertina(false);
				} else {
					v.setCopertina(true);
				}

				vinili.add(v);
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
		return vinili;
	}

	@Override
	public void save(Vinile v) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO vinile(id, nome, giri, idArtista, idGenere, prezzo, quantita) VALUES (?,?,?,?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, v.getId());
			preparedStatement.setString(2, v.getNome());
			preparedStatement.setString(3, v.getGiri());
			preparedStatement.setInt(4, v.getIdArtista());
			preparedStatement.setInt(5, v.getIdGenere());
			preparedStatement.setDouble(6, v.getPrezzo());
			preparedStatement.setInt(7, v.getQuantita());

			System.out.println("VinileModel: save:" + preparedStatement.toString());
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
	public void update(Vinile v) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE vinile SET nome=?, giri=?, idArtista=?, idGenere=?, prezzo=?, quantita=? WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setString(1, v.getNome());
			preparedStatement.setString(2, v.getGiri());
			preparedStatement.setInt(3, v.getIdArtista());
			preparedStatement.setInt(4, v.getIdGenere());
			preparedStatement.setDouble(5, v.getPrezzo());
			preparedStatement.setInt(6, v.getQuantita());
			preparedStatement.setString(7, v.getId());

			System.out.println("VinileModel: update:" + preparedStatement.toString());
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
	public void delete(Vinile v) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM vinile WHERE id=?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setString(1, v.getId());

			System.out.println("VinileModel: Delete:" + preparedStatement.toString());
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

	public boolean checkCode(String i) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM vinile WHERE id=?";

		Vinile v = new Vinile();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, i);

			System.out.println("VinileModel-checkCode:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				v.setNome(rs.getString("nome"));
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

		return v.getNome() == null;
	}

	public ArrayList<Vinile> advancedSearch(String nome, String artista, String genere, String giri, String prezzoMax,
			String quantita, String sceltaQuantita, String sort) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Vinile> vinili = new ArrayList<Vinile>();

		String selectSQL = "SELECT V.*, A.nomeA, G.nomeG FROM vinile as V, artista as A, genere as G WHERE V.idArtista=A.id AND V.idGenere=G.id";

		if (nome != null && !nome.equals("")) {
			selectSQL += " AND nome LIKE '" + nome + "%'";
		}
		if (artista != null && !artista.equals("")) {
			selectSQL += " AND nomeA='" + artista + "'";
		}
		if (genere != null && !genere.equals("")) {
			selectSQL += " AND nomeG='" + genere + "'";
		}
		if (giri != null && !giri.equals("")) {
			selectSQL += " AND giri='" + giri + "'";
		}
		if (prezzoMax != null && !prezzoMax.equals("")) {
			selectSQL += " AND prezzo<=" + prezzoMax;
		}
		if (sceltaQuantita != null && !sceltaQuantita.equals("")) {
			if (sceltaQuantita.equals("minore")) {
				selectSQL += " AND quantita<=" + quantita;
			} else {
				selectSQL += " AND quantita>=" + quantita;
			}
		}
		if (sort != null && !sort.equals("")) {
			selectSQL += " ORDER BY " + sort;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("VinileModel: advancedSearch:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Vinile v = new Vinile();

				v.setId(rs.getString("id"));
				v.setNome(rs.getString("nome"));
				v.setGiri(rs.getString("giri"));
				v.setArtista(new Artista(rs.getInt("idArtista"), rs.getString("nomeA")));
				v.setGenere(new Genere(rs.getInt("idGenere"), rs.getString("nomeG")));
				v.setPrezzo(rs.getDouble("prezzo"));
				v.setQuantita(rs.getInt("quantita"));
				byte[] bt = rs.getBytes("copertina");
				if (bt == null) {
					v.setCopertina(false);
				} else {
					v.setCopertina(true);
				}

				vinili.add(v);
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

		return vinili;
	}

	public ArrayList<Vinile> barraDiRicerca(String ricerca) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Vinile> vinili = new ArrayList<Vinile>();

		String selectSQL = "SELECT * FROM vinile WHERE nome like '" + ricerca + "%' or nome like '%" + ricerca
				+ "%' or nome like '%" + ricerca + "' or artista like '" + ricerca + "%' or artista like '%" + ricerca
				+ "%' or artista like '%" + ricerca + "' or genere like '" + ricerca + "%' or genere like '%" + ricerca
				+ "%' or genere like '%" + ricerca + "'";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			System.out.println("ricarcaAvanzata:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Vinile v = new Vinile();

				v.setId(rs.getString("id"));
				v.setNome(rs.getString("nome"));
				v.setGiri(rs.getString("giri"));
				v.setArtista(new Artista(rs.getInt("idArtista"), rs.getString("nomeA")));
				v.setGenere(new Genere(rs.getInt("idGenere"), rs.getString("nomeG")));
				v.setPrezzo(rs.getDouble("prezzo"));
				v.setQuantita(rs.getInt("quantita"));
				byte[] bt = rs.getBytes("copertina");
				if (bt == null) {
					v.setCopertina(false);
				} else {
					v.setCopertina(true);
				}

				vinili.add(v);
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
		return vinili;
	}

	public synchronized static byte[] loadCopertina(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		byte[] bt = null;
		String selectSQL = "SELECT copertina FROM vinile WHERE id =?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);

			System.out.println("VinileModel: loadCopertina:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("copertina");
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bt;
	}
	
	public synchronized static void updateCopertina(String id, String copertina) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE vinile SET copertina = ? WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			
			File file = new File(copertina);
			try {
				FileInputStream fis = new FileInputStream(file);
				preparedStatement.setBinaryStream(1, fis, fis.available());
				preparedStatement.setString(2, id);
				
				preparedStatement.executeUpdate();
				connection.commit();
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}	

}
