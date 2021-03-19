package practice;

public class Constructor {
	public static void main(String[] args) {
		Con c = new Con("이서준");
	}
	
}

class Con {
	String name, name2;
	
	Con(String name, String name2){
		this.name = name;
		this.name2 = name2;
	}
	
	Con(String name){
		this(name, "asdf");
	}
}