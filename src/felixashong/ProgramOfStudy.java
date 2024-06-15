package felixashong;

import java.io.*;
import java.util.*;

public class ProgramOfStudy implements Iterable<Course>, Serializable {
    private List<Course> list;

    public ProgramOfStudy() {
        list = new LinkedList<>();
    }

    public void addCourse(Course course) {
        if (course != null)
            list.add(course);
    }

    public Course find(String prefix, int number) {
        for (Course course : list)
            if (prefix.equals(course.getPrefix()) && number == course.getNumber())
                return course;
        return null;
    }

    public void addCourseAfter(Course target, Course newCourse) {
        if (target == null || newCourse == null)
            return;

        int targetIndex = list.indexOf(target);
        if (targetIndex != -1)
            list.add(targetIndex + 1, newCourse);
    }

    public void replace(Course target, Course newCourse) {
        if (target == null || newCourse == null)
            return;

        int targetIndex = list.indexOf(target);
        if (targetIndex != -1)
            list.set(targetIndex, newCourse);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Course course : list)
            result.append(course).append("\n");
        return result.toString();
    }

    public Iterator<Course> iterator() {
        return list.iterator();
    }

    public void save(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        }
    }

    public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ProgramOfStudy) ois.readObject();
        }
    }

    public static void main(String[] args) {
        // Example usage
        ProgramOfStudy pos = new ProgramOfStudy();

        // Adding sample courses
        pos.addCourse(new Course("CS", 101));
        pos.addCourse(new Course("Math", 201));
        pos.addCourse(new Course("Physics", 301));

        // Displaying courses
        System.out.println("Program of Study:");
        System.out.println(pos);

        // Saving to file
        try {
            pos.save("program_of_study.ser");
            System.out.println("Program of Study saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save Program of Study: " + e.getMessage());
        }

        // Loading from file
        try {
            ProgramOfStudy loadedPOS = ProgramOfStudy.load("program_of_study.ser");
            System.out.println("Loaded Program of Study:");
            System.out.println(loadedPOS);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load Program of Study: " + e.getMessage());
        }
    }
}
