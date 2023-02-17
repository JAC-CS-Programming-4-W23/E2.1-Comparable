public class Pokemon implements Comparable<Pokemon> {
    
    public enum Type {
        GRASS, FIRE, WATER
    }

    private String name;
    private Type type;
    private int level;

    public Pokemon(String name, int level, Type type) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int compareTo(Pokemon rhs) {
        int cmp = this.name.compareTo(rhs.name);
        if (cmp == 0)
            return this.level - rhs.level;
        else
            return cmp;
    }

}
