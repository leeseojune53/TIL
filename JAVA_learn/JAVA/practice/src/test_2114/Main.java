package test_2114;

public class Main {
	public static void main(String[] args) {
		Creature creature = new Creature("생물");
		Plant plant = new Plant("식물", 170);
		Animal animal = new Animal(100, "동물");
		Person person = new Person(100, "인간", 17);
		Oxygen oxygen = new Oxygen(9999999L, "산소");
		creature.breath(oxygen);
		creature.eat();
		plant.breath(oxygen);
		plant.growUp();
		animal.eat();
		animal.eat("고기");
		person.old();
	}
}
