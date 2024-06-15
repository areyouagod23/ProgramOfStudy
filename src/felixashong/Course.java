package felixashong;


import java.io.Serializable;

public class Course implements Serializable {
    private String prefix;
    private int number;

    public Course(String prefix, int number) {
        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return prefix + " " + number;
    }
}
