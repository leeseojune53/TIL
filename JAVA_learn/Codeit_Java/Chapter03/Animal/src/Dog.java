public class Dog extends AbstractAnimal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.println("왈왈");
    }
}
