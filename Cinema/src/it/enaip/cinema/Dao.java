package it.enaip.cinema;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	 
	    
	    List<T> getAll();
	    
	    void delete(T t) throws SQLException;

		boolean addSpect(Spettatore s) throws SQLException;
	
}
