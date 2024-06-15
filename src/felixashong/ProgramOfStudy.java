package felixashong; // Defines the package for the class.

import java.io.*; // Imports necessary classes for input and output operations.
import java.util.*; // Imports necessary classes for collections and iterators.

public class ProgramOfStudy implements Iterable<Course>, Serializable { // Declares the ProgramOfStudy class, implements Iterable and Serializable interfaces.
    private List<Course> list; // Private field to store the list of courses.

    public ProgramOfStudy() { // Constructor to initialize the ProgramOfStudy object.
        list = new LinkedList<>(); // Initializes the course list as a LinkedList.
    }

    public void addCourse(Course course) { // Method to add a course to the list.
        if (course != null) // Checks if the course is not null.
            list.add(course); // Adds the course to the list.
    }

    public Course find(String prefix, int number) { // Method to find a course by prefix and number.
        for (Course course : list) // Iterates over the list of courses.
            if (prefix.equals(course.getPrefix()) && number == course.getNumber()) // Checks if the course matches the prefix and number.
                return course; // Returns the matching course.
        return null; // Returns null if no matching course is found.
    }

    public void addCourseAfter(Course target, Course newCourse) { // Method to add a course after a target course.
        if (target == null || newCourse == null) // Checks if either the target or new course is null.
            return;

        int targetIndex = list.indexOf(target); // Finds the index of the target course.
        if (targetIndex != -1) // Checks if the target course was found.
            list.add(targetIndex + 1, newCourse); // Adds the new course after the target course.
    }

    public void replace(Course target, Course newCourse) { // Method to replace a target course with a new course.
        if (target == null || newCourse == null) // Checks if either the target or new course is null.
            return;

        int targetIndex = list.indexOf(target); // Finds the index of the target course.
        if (targetIndex != -1) // Checks if the target course was found.
            list.set(targetIndex, newCourse); // Replaces the target course with the new course.
    }

    @Override // Overrides the toString method to provide a string representation of the ProgramOfStudy object.
    public String toString() {
        StringBuilder result = new StringBuilder(); // Uses StringBuilder to build the string.
        for (Course course : list) // Iterates over the list of courses.
            result.append(course).append("\n"); // Appends each course and a newline to the result.
        return result.toString(); // Returns the resulting string.
    }

    @Override // Overrides the iterator method to provide an iterator for the list of courses.
    public Iterator<Course> iterator() {
        return list.iterator(); // Returns an iterator for the course list.
    }

    public void save(String fileName) throws IOException { // Method to save the ProgramOfStudy to a file.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) { // Creates an ObjectOutputStream wrapped around a FileOutputStream.
            oos.writeObject(this); // Writes the ProgramOfStudy object to the file.
        }
    }

    public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException { // Static method to load a ProgramOfStudy from a file.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) { // Creates an ObjectInputStream wrapped around a FileInputStream.
            return (ProgramOfStudy) ois.readObject(); // Reads and returns the ProgramOfStudy object from the file.
        }
    }

    public static void main(String[] args) { // Main method for testing the ProgramOfStudy class.
        ProgramOfStudy pos = new ProgramOfStudy(); // Creates a new ProgramOfStudy object.

        pos.addCourse(new Course("DCIT302", 302)); // Adds a  course.
        pos.addCourse(new Course("DCIT304", 304)); // Adds another  course.
        pos.addCourse(new Course("DCIT308", 308)); // Adds another course.

        System.out.println("Program of Study:"); // Prints the header.
        System.out.println(pos); // Prints the list of courses.

        try {
            pos.save("program_of_study.ser"); // Saves the ProgramOfStudy to a file.
            System.out.println("Program of Study saved successfully."); // Prints success message.
        } catch (IOException e) {
            System.err.println("Failed to save Program of Study: " + e.getMessage()); // Prints error message if saving fails.
        }

        try {
            ProgramOfStudy loadedPOS = ProgramOfStudy.load("program_of_study.ser"); // Loads the ProgramOfStudy from the file.
            System.out.println("Loaded Program of Study:"); // Prints the header.
            System.out.println(loadedPOS); // Prints the loaded list of courses.
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load Program of Study: " + e.getMessage()); // Prints error message if loading fails.
        }
    }
}
