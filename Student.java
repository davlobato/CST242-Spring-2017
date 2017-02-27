package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {

	private double gpa;
	private static int idNumber = 0;
	

	public Student(String name, double gpa) {
		super(name);
		this.gpa = gpa;

		// try to open the id.txt file to read next available idNumber
		File file = new File("sId.txt");
		try {
			Scanner in = new Scanner(file);
			idNumber = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
		}

		super.setId("S" + String.valueOf(idNumber++));
		// id = String.valueOf(idNumber++);

		try {
			PrintWriter pw = new PrintWriter("sId.txt");
			pw.print(idNumber);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// overloaded constructor
	public Student(Student s) {
		super(s.getName(), s.getId());
		this.gpa = s.gpa;
	}

	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [Name=" + getName() + ", Id=" + getId() + ", GPA=" + gpa + "]";
	}

}