package fr.vulcainos.pokemonFinder.controllers;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.vulcainos.pokemonFinder.models.Catch;
import fr.vulcainos.pokemonFinder.models.Pokemon;
import fr.vulcainos.pokemonFinder.repositories.CatchRepository;
import fr.vulcainos.pokemonFinder.repositories.PokemonRepository;

@RestController
public class CatchController {

	@Autowired 
	private PokemonRepository pokemonRepository;
	@Autowired
	private CatchRepository catchRepository;

	@GetMapping(path = "/catch")
    public Iterable<Catch> getPokemon(HttpServletRequest request) {
        return catchRepository.findAll();
    }
	
	@GetMapping(path = "/catch/{idDiscord}")
    public Iterable<Catch> getPokemonByIdDiscord(@PathVariable String idDiscord, HttpServletRequest request) {
        return catchRepository.findByIdDiscord(idDiscord);
    }
	
	@PostMapping(path = "/catch")
    public Map<String, Boolean> newCatch(@RequestBody Map<String, String> catchPokemon, HttpServletRequest request) {
        Pokemon pokemonId = pokemonRepository.getRandomPokemon();
        Catch newCatch = new Catch(catchPokemon.get("idDiscord"), false, pokemonId);
        catchRepository.save(newCatch);
        return Collections.singletonMap("success", true);
    }
	
	

	@DeleteMapping(path = "/catch/{id}")
    public Map<String, Boolean> deleteTransaction(@PathVariable int id, HttpServletRequest request) {
        Map bad = Collections.singletonMap("success", false);
        if (!catchRepository.existsById(id)) return bad;
        catchRepository.deleteById(id);
        return Collections.singletonMap("success", true);
    }
	

}