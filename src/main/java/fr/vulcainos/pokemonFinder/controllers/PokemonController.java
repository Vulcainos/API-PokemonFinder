package fr.vulcainos.pokemonFinder.controllers;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vulcainos.pokemonFinder.models.Catch;
import fr.vulcainos.pokemonFinder.models.Pokemon;
import fr.vulcainos.pokemonFinder.repositories.PokemonRepository;

@RestController
public class PokemonController {

	@Autowired 
	private PokemonRepository pokemonRepository;

	@GetMapping(path = "/pokemon")
    public Iterable<Pokemon> getPokemon(HttpServletRequest request) {
        return pokemonRepository.findAll();
    }
	
	@PutMapping(path = "/pokemon")
    public Map<String, Boolean> addPokemon(@RequestBody Map<String, String> pokemon, HttpServletRequest request) {
        Pokemon newPokemon = new Pokemon(pokemon.get("name"), pokemon.get("nameFr"), Integer.parseInt(pokemon.get("gen")), false);
        pokemonRepository.save(newPokemon);
        return Collections.singletonMap("success", true);
    }
	
	@PutMapping(path = "/pokemons")
    public Map<String, Boolean> addPokemons(@RequestBody Iterable<Pokemon> pokemons, HttpServletRequest request) {
		pokemonRepository.saveAll(pokemons);
        return Collections.singletonMap("success", true);
    }
	
	@PostMapping(path = "/enabledPokemon/{id}")
    public Map<String, Boolean> enabledPokemon(@PathVariable int id, HttpServletRequest request) {
        Pokemon pokemon = pokemonRepository.findById(id);
        if(!pokemon.isEnabled()) {
        	pokemon.changeEnabled();
        	pokemonRepository.save(pokemon);
        }
        return Collections.singletonMap("success", true);
    }
	
	@PostMapping(path = "/disabledPokemon/{id}")
    public Map<String, Boolean> disabledPokemon(@PathVariable int id, HttpServletRequest request) {
        Pokemon pokemon = pokemonRepository.findById(id);
        if(pokemon.isEnabled()) {
        	pokemon.changeEnabled();
        	pokemonRepository.save(pokemon);
        }
        return Collections.singletonMap("success", true);
    }

	@DeleteMapping(path = "/pokemon/{id}")
    public Map<String, Boolean> deleteTransaction(@PathVariable int id, HttpServletRequest request) {
        Map bad = Collections.singletonMap("success", false);
        if (!pokemonRepository.existsById(id)) return bad;
        pokemonRepository.deleteById(id);
        return Collections.singletonMap("success", true);
    }
}