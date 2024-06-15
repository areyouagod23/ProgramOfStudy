package felixashong; // Defines the package for the class.

import java.io.Serializable; // Imports the Serializable interface for serialization.

public class Course implements Serializable { // Declares the Course class and implements Serializable for object serialization.
    private String prefix; // Private field to store the course prefix (e.g., "CS").
    private int number; // Private field to store the course number (e.g., 101).

    public Course(String prefix, int number) { // Constructor to initialize the Course object with a prefix and number.
        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() { // Getter method for the course prefix.
        return prefix;
    }

    public void setPrefix(String prefix) { // Setter method for the course prefix.
        this.prefix = prefix;
    }

    public int getNumber() { // Getter method for the course number.
        return number;
    }

    public void setNumber(int number) { // Setter method for the course number.
        this.number = number;
    }

    @Override // Overrides the toString method to provide a string representation of the Course object.
    public String toString() {
        return prefix + " " + number; // Returns a string in the format "prefix number" (e.g., "CS 101").
    }
}
