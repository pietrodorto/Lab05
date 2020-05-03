package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AnagrammaDAO {
	
        public boolean isCorrect(String anagramma){
		
        	final String sql = "SELECT * FROM parola WHERE nome = ?";
		
        	boolean presente ;
		
        	try {
        		Connection conn = ConnectDB.getConnection();
        		PreparedStatement st = conn.prepareStatement(sql);
        		st.setString(1, anagramma);
        		
        		ResultSet rs = st.executeQuery();
			
        		if(rs.next()) {
				
        			presente = true;
				}
        		else {
        			presente = false;
        		}
        		conn.close();
        		return presente;
        	} 	catch(SQLException e) {
        		throw new RuntimeException("Errore Db", e);
        	}
	}
	
	

}
