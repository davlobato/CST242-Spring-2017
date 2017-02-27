package p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FacultyBag {
	ArrayList<Faculty> myList = new ArrayList<>();

	public void insert(Faculty f) {
		myList.add(new Faculty(f));
	}

	public void display() {
		for (Faculty f : myList) {
			System.out.println(f);
		}
	}

	public Faculty findById(String id) {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getId().equals(id)) {
				return myList.get(i);
			}
		}
		return null;
	}

	public Faculty removeById(String id) {
		int counter = 0;
		for (Faculty f : myList) {

			if (f.getId().equals(id)) {
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

	public ArrayList<Faculty> getList() {
		return myList;
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("FacultyBag.dat");
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
			FileInputStream fis = new FileInputStream("FacultyBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			myList = (ArrayList<Faculty>)ois.readObject();
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