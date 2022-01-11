package fr.vulcainos.pokemonFinder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {

	public Pokemon(String name, Integer gen, boolean enabled) {
		this(name, "", gen, enabled);
	}
	public Pokemon(String name, String nameFr, Integer gen, boolean enabled) {
		this.name = name;
		this.nameFr = nameFr;
		this.gen = gen;
		this.enabled = enabled;
	}

	public Pokemon() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPokemon;
	private String name;
	private String nameFr;
	private Integer gen;
	private boolean enabled;
	
	public Integer getId() {
		return idPokemon;
	}

	public String getName() {
		return name;
	}

	public String getNameFr() {
		return nameFr;
	}
	
	public Integer getGen() {
		return gen;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean changeEnabled() {
		return enabled=!enabled;
	}

}
