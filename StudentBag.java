package p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentBag {
	ArrayList<Student> myList = new ArrayList<>();

	public void insert(Student s) {
		myList.add(new Student(s));
	}

	public void display() {
		for (Student s : myList) {
			System.out.println(s);
		}
	}

	public Student findById(String id) {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getId().equals(id)) {
				return myList.get(i);
			}
		}
		return null;
	}

	public Student removeById(String id) {
		int counter = 0;
		for (Student s : myList) {

			if (s.getId().equals(id)) {
				break;
			}
			counter++;
		}
		if (counter < myList.size()) {
			return myList.remove(counter);
		} else {
			return null;
		}
	}

	public ArrayList<Student> getList() {
		return myList;
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("StudentBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(myList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void load() {
		try {
			FileInputStream fis = new FileInputStream("StudentBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			myList = (ArrayList<Student>)ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}