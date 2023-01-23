import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PokemonTest {

    @Test
    void testPokemonWasCreatedSuccessfully() {
        String name = "Bulbasaur";
        int level = 10;
        Pokemon.Type type = Pokemon.Type.GRASS;
        Pokemon pokemon = new Pokemon(name, level, type);

        assertEquals(name, pokemon.getName());
        assertEquals(level, pokemon.getLevel());
        assertEquals(type, pokemon.getType());
    }

    @Test
    void testPokemonCanBeComparedTo() {
        Pokemon pokemon1 = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);
        Pokemon pokemon2 = new Pokemon("Bulbasaur", 10, Pokemon.Type.GRASS);
        Pokemon pokemon3 = new Pokemon("Bulbasaur", 11, Pokemon.Type.GRASS);
        Pokemon pokemon4 = new Pokemon("Charmander", 9, Pokemon.Type.FIRE);
        Pokemon pokemon5 = new Pokemon("Squirtle", 10, Pokemon.Type.WATER);

        assertTrue(pokemon1.compareTo(pokemon2) == 0);
        assertTrue(pokemon1.compareTo(pokemon3) < 0);
        assertTrue(pokemon3.compareTo(pokemon2) > 0);
        assertTrue(pokemon1.compareTo(pokemon4) < 0);
        assertTrue(pokemon5.compareTo(pokemon4) > 0);
    }
}
