public abstract class AbstractAnimal {
    public final String name;

    protected AbstractAnimal(String name) {
        this.name = name;
    }
    public abstract void cry();
}
