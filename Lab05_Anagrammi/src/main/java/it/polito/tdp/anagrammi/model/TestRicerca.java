package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestRicerca {

	public static void main(String[] args) {
		
        Model ric = new Model() ;
		
		Set<String> ana_dog = ric.anagrammi("dog") ;
		System.out.println(ana_dog) ;
		
		Set<String> ana_vac = ric.anagrammi("vacanze") ;
		System.out.println(ana_vac) ;


	}

}
