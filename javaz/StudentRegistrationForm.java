import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class representing a person
abstract class Person {
    private final String fullName; // Full name of the person
    private final String dateOfBirth; // Date of birth of the person
    private final String gender; // Gender of the person
    private final String nationality; // Nationality of the person

    public Person(String fullName, String dateOfBirth, String gender, String nationality) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public abstract void displayDetails(); // Abstract method to display the details of the person
}

// Class representing a student, inheriting from Person
class Student extends Person {
    private final String address; // Address of the student
    private final String phoneNumber; // Phone number of the student
    private final String email; // Email of the student
    private final String department; // Department of the student
    private final String studentId; // Student ID
    private final String collegeName; // College name
    private final String year; // Year of study

    public Student(String fullName, String dateOfBirth, String gender, String nationality, String address, String phoneNumber, String email, String department, String studentId, String collegeName, String year) {
        super(fullName, dateOfBirth, gender, nationality);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        this.studentId = studentId;
        this.collegeName = collegeName;
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getYear() {
        return year;
    }

    @Override
    public void displayDetails() {
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Gender: " + getGender());
        System.out.println("Nationality: " + getNationality());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + getDepartment());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("College Name: " + getCollegeName());
        System.out.println("Year: " + getYear());
    }
}

public class StudentRegistrationForm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Person> persons = new ArrayList<>(); // List to store registered persons

        System.out.println("\nWelcome to the Student Registration System!");

        int choice = 0;
        while (choice != 3) {
            System.out.print("Enter your choice(FOR_REGISTER:1\n" +
                    "FOR_DISPLAY STUDENT REGISTERED:2\n " +
                    "FOR_EXIT: 3) \n");
            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nStudent Registration");
                    try {
                        // Gather student information
                        System.out.print("Enter the full name (First Middle Last): ");
                        String fullName = input.nextLine();
                        String[] names = fullName.split(" ");

                        // Validate name format
                        if (names.length != 3) {
                            throw new IllegalArgumentException("Invalid name format. Please enter your first, middle, and last names separated by spaces.");
                        }

                        for (String name : names) {
                            // Validate name contains only letters
                            if (!name.matches("[a-zA-Z]+")) {
                                throw new IllegalArgumentException("Invalid name. Only letters are allowed.");
                            }
                        }

                        // Gather remaining information
                        System.out.print("Enter the date of birth (Numbers and / only): ");
                        String dateOfBirth = input.nextLine();
                        if (!dateOfBirth.matches("[0-9/]+")) {
                            throw new IllegalArgumentException("Invalid date of birth. Please enter only numbers and use '/' as the separator.");
                        }

                        System.out.print("Enter the gender (MALE or FEMALE): ");
                        String gender = input.nextLine();
                        if (!gender.equalsIgnoreCase("MALE") && !gender.equalsIgnoreCase("FEMALE")) {
                            throw new IllegalArgumentException("Invalid gender. Please enter either 'MALE' or 'FEMALE'.");
                        }

                        System.out.print("Enter the nationality: ");
                        String nationality = input.nextLine();
                        if (!nationality.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("Invalid nationality. Please enter only letters.");
                        }

                        System.out.print("Enter the address: ");
                        String address = input.nextLine();

                        System.out.print("Enter the phone number: ");
                        String phoneNumber = input.nextLine();
                        if (!phoneNumber.matches("\\d+")) {
                            throw new IllegalArgumentException("Invalid phone number. Please enter only numeric values.");
                        }

                        System.out.print("Enter the email: ");
                        String email = input.nextLine();

                        System.out.print("Enter the department: ");
                        String department = input.nextLine();
                        if (!department.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("Invalid department. Please enter correct department name by word.");
                        }

                        System.out.print("Enter the student ID: ");
                        String studentId = input.nextLine();
                        if (!studentId.matches("\\d+")) {
                            throw new IllegalArgumentException("Invalid student ID. Please enter only numeric values.");
                        }

                        System.out.print("Enter the college name: ");
                        String collegeName = input.nextLine();
                        if (!collegeName.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("Invalid college name. Please enter only letters.");
                        }

                        System.out.print("Enter the year: ");
                        String year = input.nextLine();
                        if (!year.matches("\\d+")) {
                            throw new IllegalArgumentException("Invalid year. Please enter only numeric values.");
                        }

                        // Create a new Student object and add it to the list
                        Student student = new Student(fullName, dateOfBirth, gender, nationality, address, phoneNumber, email, department, studentId, collegeName, year);
                        persons.add(student);
                    } catch (IllegalArgumentException e) {
                        System.out.println("An error occurred while registering the student: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\n--- Student Registration Details ---");
                    for (int i = 0; i < persons.size(); i++) {
                        Person person = persons.get(i);
                        System.out.println("\nStudent " + (i + 1));
                        person.displayDetails();
                    }
                    break;
                case 3:
                    System.out.println("\nThank you for using the Student Registration System. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        }

        input.close();
    }
}
