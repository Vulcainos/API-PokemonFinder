# API-PokemonFinder

## FR :fr:

REST API pour stocker et manipuler des pokemons.

### Fonctionnalités :floppy_disk:


- Gère une base de données de pokemon
- Permet de d'attrbuer un nouveau pokemon

### Documentation :open_file_folder:

#### Pokemon 
-------------------

| Type  | Field  | Description  |
|---|---|---|
| Integer  | idPokemon  |   |
| String  | name  |   |
| String  | nameFr  |   |
| Integer  | gen  |   |
| boolean  | enabled  |   |


 > GET /pokemon
 > 
 > Retourne la liste des pokemons présent dans la base.
 
 > PUT /pokemon
 > 
 > Ajoute un pokemon à la base. (Désactivé par defaut)
 > 
 > Exemple de JSON dans le body `{
    "name": "Ivysaur",
    "nameFr": "Herbizarre",
    "gen": 1
}`
 
 > POST /enabledPokemon/{id}
 > 
 > Active le pokemon. 
 
 > POST /disabledPokemon/{id}
 > 
 > Desactive le pokemon.
 
 > DELETE /pokemon/{id}
 > 
 > Supprime un pokemon de la base, seulement si il est désactivé. 


#### Catch
-------------------
| Type  | Field  | Description  |
|---|---|---|
| Integer  | idCatch  |   |
| String  | idUser  |   |
| boolean  | shiny  |   |
| Pokemon  | pokemon  |   |

 > GET /catch
 > 
 > Retourne la liste des catch.

 > GET /catch/{idUser}
 > 
 > Retourne la liste des catch d'un id de User.

 > POST /catch
 > 
 > Crée un catch avec un pokemon activé aléatoir.
 > 
 > Exemple de JSON dans le body `{
    "idUser": "152356445521655581",
}`

 > DELETE /catch/{id}
 > 
 > Supprime un catch de la base. 

## EN :gb: TODO

### Features :floppy_disk:



### Documentation :open_file_folder:

