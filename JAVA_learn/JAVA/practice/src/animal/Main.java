package animal;

public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println();
		
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		
		animal = new Cat();
		animal.sound();
		System.out.println();
		
		animalSound(cat);
		animalSound(dog);

	}
	
	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
