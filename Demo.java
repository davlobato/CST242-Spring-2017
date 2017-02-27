package p1;

public class Demo {

	public static void main(String[] args) {
		Student s1 = new Student("Adam", 4.0);
		Student s2 = new Student("Billy", 3.5);
		StudentBag theBag = new StudentBag();
		theBag.insert(s1);
		theBag.insert(s2);
		System.out.println("\nBefore removal: ");
		theBag.display();
//		System.out.println(theBag.findById("0"));
		theBag.removeById("0");
		System.out.println("\nAfter removal: ");
		theBag.display();
	}

}