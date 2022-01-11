package fr.vulcainos.pokemonFinder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.vulcainos.pokemonFinder.models.Catch;


@Repository
public interface CatchRepository extends CrudRepository<Catch, Integer> {
	Iterable<Catch> findByIdDiscord( final String name );
	Catch findById( final int id );
}