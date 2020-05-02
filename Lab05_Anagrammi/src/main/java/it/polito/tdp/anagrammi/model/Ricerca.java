package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Ricerca {
	
	private List<String> soluzione;
	private List<String> soluzioneerrata;
	private List<String> soluzionecorretta;
	private AnagrammaDAO anagrammadao = new AnagrammaDAO();
	
	public List<String> anagrammi(String parola){
		
		this.soluzione = new ArrayList<>();
		
        parola=parola.toUpperCase() ;
		
		List<Character> disponibili = new ArrayList<>() ;
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)) ;
		}
		cerca("",0,disponibili);
		return this.soluzione;
	}

	
	public void cerca(String parziale, int livello, List<Character> disponibili) {
		
		//caso terminale
		if(disponibili.size()==0) {
			
				this.soluzione.add(parziale);
			
		}
		
		//caso normale
		for(Character c : disponibili) {
			String tentativo = parziale + c;
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			rimanenti.remove(c);
			
			cerca( tentativo, livello+1, rimanenti);
		}
	}
	
	
}
