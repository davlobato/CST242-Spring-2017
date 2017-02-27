package p1;

public abstract class Person {
	private String name;
	private String id;

	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

}