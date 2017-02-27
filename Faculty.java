package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Scanner;

public class Faculty extends Person implements Serializable {

	private double salary;
	private static int idNumber = 0;
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();

	public Faculty(String name, double salary) {
		super(name);
		this.salary = salary;

		// try to open the id.txt file to read next available idNumber
		File file = new File("fId.txt");
		try {
			Scanner in = new Scanner(file);
			idNumber = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
		}

		super.setId("F" + String.valueOf(idNumber++));
		// id = String.valueOf(idNumber++);

		try {
			PrintWriter pw = new PrintWriter("fId.txt");
			pw.print(idNumber);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Faculty(Faculty f){
		super(f.getName(), f.getId());
		this.salary = f.salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
													
		return "Faculty [Name=" + getName() + ", Id=" + getId() + ", Salary=" + formatter.format(salary) + "]";
	}

}