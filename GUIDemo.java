package p1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		StudentBag theSBag = new StudentBag();
		FacultyBag theFBag = new FacultyBag();
		// theBag.load();

		TextArea outputArea = new TextArea();

		Label nameLabel = new Label("Name: ");
		Button newSButton = new Button("NEW STUDENT");
		Button newFButton = new Button("NEW FACULTY");
		TextField nameField = new TextField();
		HBox myHBox1 = new HBox(20);
		myHBox1.setAlignment(Pos.CENTER);
		myHBox1.getChildren().addAll(nameLabel, nameField, newSButton, newFButton);

		newSButton.setOnAction(e -> {

			// ENTER GPA WINDOW
			Stage gpaStage = new Stage();
			gpaStage.setTitle("Student GPA");
			HBox GPAHBox = new HBox(20);
			GPAHBox.setAlignment(Pos.CENTER);

			Label gpaLabel = new Label("Enter student GPA: ");
			TextField gpaField = new TextField();
			Button gpaButton = new Button("SUBMIT");
			GPAHBox.getChildren().addAll(gpaLabel, gpaField, gpaButton);
			Scene gpaScene = new Scene(GPAHBox, 500, 150);
			gpaStage.setScene(gpaScene);
			gpaStage.show();

			gpaButton.setOnAction(e1 -> {
				double gpa = Double.parseDouble(gpaField.getText());
				String name = nameField.getText();
				Student s = new Student(name, gpa);
				theSBag.insert(s);
				nameField.clear();
				gpaStage.close();
				outputArea.appendText(s.toString() + "\n");
			});

		});

		newFButton.setOnAction(e -> {
			// ENTER GPA WINDOW
			Stage salaryStage = new Stage();
			salaryStage.setTitle("Faculty Salary");
			HBox salaryHBox = new HBox(20);
			salaryHBox.setAlignment(Pos.CENTER);

			Label salaryLabel = new Label("Enter faculty's salary: ");
			TextField salaryField = new TextField();
			Button salaryButton = new Button("SUBMIT");
			salaryHBox.getChildren().addAll(salaryLabel, salaryField, salaryButton);
			Scene salaryScene = new Scene(salaryHBox, 500, 150);
			salaryStage.setScene(salaryScene);
			salaryStage.show();

			salaryButton.setOnAction(e1 -> {
				double salary = Double.parseDouble(salaryField.getText());
				String name = nameField.getText();
				Faculty f = new Faculty(name, salary);
				theFBag.insert(f);
				nameField.clear();
				salaryStage.close();
				outputArea.appendText(f.toString() + "\n");
			});
		});

		Label idLabel1 = new Label("ID:   ");
		Button findButton = new Button("FIND");
		TextField idField = new TextField();
		HBox myHBox2 = new HBox(20);
		myHBox2.setAlignment(Pos.CENTER);
		myHBox2.getChildren().addAll(idLabel1, idField, findButton);

		findButton.setOnAction(e -> {
			String id = idField.getText().toUpperCase();
			if (theSBag.findById(id) == null && theFBag.findById(id) == null) {
				outputArea.appendText("ID not found.\n");
			} else if (theSBag.findById(id) != null) {
				outputArea.appendText("FOUND: " + theSBag.findById(id).toString() + "\n");
			} else if (theFBag.findById(id) != null) {
				outputArea.appendText("FOUND: " + theFBag.findById(id).toString() + "\n");
			}

			idField.clear();
		});

		Label idLabel2 = new Label("ID:   ");
		Button removeButton = new Button("REMOVE");
		TextField idField2 = new TextField();
		HBox myHBox3 = new HBox(20);
		myHBox3.setAlignment(Pos.CENTER);
		myHBox3.getChildren().addAll(idLabel2, idField2, removeButton);

		removeButton.setOnAction(e -> {
			String idToRemove = idField2.getText().toUpperCase();

			if (theSBag.findById(idToRemove) == null && theFBag.findById(idToRemove) == null) {
				outputArea.appendText("ID not found.\n");
			} else if (theSBag.findById(idToRemove) != null) {
				String studentRemoved = theSBag.findById(idToRemove).toString();
				theSBag.removeById(idToRemove);
				outputArea.appendText("REMOVED: " + studentRemoved + "\n");
			} else if (theFBag.findById(idToRemove) != null) {
				String facultyRemoved = theFBag.findById(idToRemove).toString();
				outputArea.appendText("REMOVED: " + facultyRemoved + "\n");
			}
			idField2.clear();
		});

		// SAVE AND LOAD STUDENT RECORDS
		HBox myHBox4 = new HBox(50);
		Button saveSButton = new Button("SAVE STUDENT");
		Button loadSButton = new Button("LOAD STUDENT");
		myHBox4.getChildren().addAll(saveSButton, loadSButton);
		myHBox4.setAlignment(Pos.CENTER);

		saveSButton.setOnAction(event -> {
			theSBag.save();
			outputArea.appendText("Saved.\n");
		});

		loadSButton.setOnAction(event -> {
			theSBag.load();
			outputArea.appendText("Loaded.\n");
		});

		// SAVE AND LOAD FACULTY RECORDS
		HBox myHBox5 = new HBox(50);
		Button saveFButton = new Button("SAVE FACULTY");
		Button loadFButton = new Button("LOAD FACULTY");
		myHBox5.getChildren().addAll(saveFButton, loadFButton);
		myHBox5.setAlignment(Pos.CENTER);
		
		saveFButton.setOnAction(e -> {
			theFBag.save();
			outputArea.appendText("Saved.\n");
		});
		
		loadFButton.setOnAction(e -> {
			theFBag.load();
			outputArea.appendText("Loaded.\n");
		});

		VBox root = new VBox(30);

		root.getChildren().addAll(myHBox1, myHBox2, myHBox3, outputArea, myHBox4, myHBox5);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 600, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My JavaFX");
		primaryStage.show();
	}

}