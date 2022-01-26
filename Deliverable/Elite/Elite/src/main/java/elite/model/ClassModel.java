package elite.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClassModel<T> {
	public T findByKey(String id) throws SQLException;

	public ArrayList<T> findAll(String order) throws SQLException;

	public void save(T obj) throws SQLException;

	public void update(T obj) throws SQLException;

	public void delete(T obj) throws SQLException;
}
