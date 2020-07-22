package it.enaip.cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import it.enaip.cinema.Film.Genere;

public class Sala implements Dao  {
	
	private static Sala sala;
	
	private Sala() {
	}
	
	public static Sala getInstance() {
		if(sala == null) {
			sala = new Sala();
		}
		return sala;
	}

	Film film = null;
	
//	List<Spettatore> listaSpect = new ArrayList();

	
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}


	
	public double calcolaIncasso(){
		double incasso = 0;
		final double prezzo = 100;
		List<Spettatore> list = new ArrayList();
		list = getAll();
		for(int i = 0; i < list.size(); i++) {
			Spettatore sp;
			sp = list.get(i);
			if(sp.getDataNasita().getYear() >= 70) {
				incasso+=0.9 * prezzo;
			 if(sp.getDataNasita().getYear() <= 5) {
				incasso+= prezzo/2;
			}
			}else{
			incasso+=prezzo;
			}
		}
		
		return incasso;
		
	}

	@Override
	public List<Spettatore> getAll() {
		
		Connection conn = null;
		Statement stm = null;
		ResultSet resultSet = null;
		List<Spettatore> listSpec = new ArrayList<>();
		String sql = "SELECT id,nome,cognome,datanasita FROM spect";

		try {

			conn = DbConnect.getInstance().getConnection();
			stm = conn.createStatement();
			
			resultSet = stm.executeQuery(sql);

			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String nome = resultSet.getString("nome");
				String surname = resultSet.getString("cognome");
				Date birthDate = resultSet.getDate("datanasita");
				
				
				int idInt = Integer.parseInt(id);
				
				
				Spettatore sp = new Spettatore.SpettatoreBuilder(nome)
						.idSpettatore(idInt)
						.cognome(surname)
						.dataNasita(birthDate)
						.build();
						
				listSpec.add(sp);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
		} finally {
			DbConnect.closeConnection(conn);
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}		
		if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listSpec;
	}
		
		
	
	@Override
	public boolean addSpect(Spettatore s) throws SQLException {
		
		boolean rowInserted = false;
		List<Spettatore> list = new ArrayList();
		
		list = getAll();
		
		
		if(list.size()==10) {
			System.out.println("Numero max");
			return false;
		}else {
			if(s.isMinor()&& film.getGenere().equals(Genere.Horor)) {
				System.out.println("Is minor and film is horror.....");
				return false;
			}
		
		Connection conn = null;
		String sql = "INSERT into spect (nome, cognome, datanasita)VALUES(?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		try {

			conn = DbConnect.getInstance().getConnection();
			
			String nome = s.getNome();
			String cognome = s.getCognome();
			java.util.Date utilDate = s.getDataNasita();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			final String stringDate = dateFormat.format(utilDate);
			final java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
			
		
			stm.setString(1, nome);
			stm.setString(2, cognome);
			stm.setDate(3, sqlDate);
		
			rowInserted = stm.executeUpdate() > 0;

		} finally {

			DbConnect.closeConnection(conn);

		}
		return rowInserted;

	} 
	}

	
	
	@Override
	public void delete(Object t) throws SQLException {
	
		Connection conn = null;
		
		try {

			conn = DbConnect.getInstance().getConnection();
			Statement stmt = conn.createStatement();
		    
		      String query = "Truncate table Spect";
		     
		      stmt.execute(query);
			
		} catch(SQLException e) {
			System.out.println("we have problem with truncate ");
		}
		
		finally {
			DbConnect.closeConnection(conn);
		}
	} 
	
	}



	
	
	
	

