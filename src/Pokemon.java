import java.util.Arrays;

/**
 * A creature from the hit show/game, Pokémon!
 */
public class Pokemon implements Comparable<Pokemon> {

    public enum Type {
        GRASS, WATER, FIRE
    }

    private final String name;
    private final int level;
    private final Type type;

    public Pokemon(String name, int level, Type type) {
        this.name = name;
        this.level = level;
        this.type = type;
    }

    /**
     * Compares two Pokémon, first alphabetically, then by level.
     * @param rhs The Pokémon to be compared.
     * @return Negative if less than, zero if equal to, positive if greater than.
     */
    @Override
    public int compareTo(Pokemon rhs) {
        int comparison = this.name.compareTo(rhs.name);

        if (comparison == 0) {
            comparison = this.level - rhs.level;
        }

        return comparison;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Type getType() {
        return type;
    }

}
