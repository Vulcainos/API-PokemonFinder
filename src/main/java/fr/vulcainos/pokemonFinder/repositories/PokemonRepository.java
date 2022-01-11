package fr.vulcainos.pokemonFinder.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.vulcainos.pokemonFinder.models.Pokemon;


@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
	Pokemon findByName( final String name );
	Pokemon findById( final int id );
	@Query(value = "SELECT * FROM pokemon WHERE enabled = true ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Pokemon getRandomPokemon();
}