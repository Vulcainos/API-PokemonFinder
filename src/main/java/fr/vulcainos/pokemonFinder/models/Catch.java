package fr.vulcainos.pokemonFinder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Catch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCatch;
	private String idDiscord;
	private boolean shiny;
	
	@ManyToOne
	@JoinColumn(name="idPokemon")
	private Pokemon idPokemon;

	public Catch(String idDiscord, boolean shiny, Pokemon idPokemon) {
		this.idDiscord = idDiscord;
		this.shiny = shiny;
		this.idPokemon = idPokemon;
	}
	
	public Catch() {
	}

	public Integer getId() {
		return idCatch;
	}

	public String getIdDiscord() {
		return idDiscord;
	}

	public boolean isShiny() {
		return shiny;
	}

	public Pokemon getIdPokemon() {
		return idPokemon;
	}
	
	
}
