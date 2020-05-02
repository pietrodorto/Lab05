package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AnagrammaDAO {
	 /*
	public List<Word> getAllWord(){
		
		final String sql = "SELECT * FROM parola";
		
		List<Word> parole = new LinkedList<Word>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				Word w = new Word(rs.getInt("id"),rs.getString("nome"));
				parole.add(w);
				
			}
			
			conn.close();
			return parole;
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
	}
	*/
        public boolean isCorrect(String anagramma){
		
        	final String sql = "SELECT * FROM parola WHERE nome = ?";
		
        	boolean presente = false;
		
        	try {
        		Connection conn = ConnectDB.getConnection();
        		PreparedStatement st = conn.prepareStatement(sql);
			
        		ResultSet rs = st.executeQuery();
			
        		if(rs.next()) {
				
        			presente = true;
        			conn.close();
				}
        		else {
        			presente = false;
        			conn.close();
        		}
        		return presente;
        	} 	catch(SQLException e) {
        		throw new RuntimeException("Errore Db", e);
        	}
	}
	
	

}
