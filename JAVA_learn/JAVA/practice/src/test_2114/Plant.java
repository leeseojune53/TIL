package test_2114;

import java.util.ArrayList;
import java.util.List;

public class Plant extends Creature{
	
	private int height;
	private List<Leaf> leafs;

	public Plant(String name, int height) {
		super(name);
		this.height = height;
		leafs = new ArrayList<>();
	}
	
	public void growUp() {
		this.leafs.add(new Leaf("green"));
	}
	
	@Override
	public void breath(Environment environment) {
		if(environment instanceof Oxygen) {
			((Oxygen) environment).use(5L);
		}
		System.out.println("plant가 숨을 쉽니다.");
	}

}
