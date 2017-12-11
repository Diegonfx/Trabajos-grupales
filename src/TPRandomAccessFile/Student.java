package TPRandomAccessFile;

/**
 * Created by Diego Mancini on 12/10/17.
 * Materia: AyED.
 */
public class Student {
    private String name; //10
    private char gender; //1
    private int enrollmentId; //8
    private boolean available; //1

    Student(String name, char gender, int enrollmentId) {
        this.name = name;
        this.gender = gender;
        this.enrollmentId = enrollmentId;
        available = true;
    }

    public String getName() {
        return name;
    }

    char getGender() {
        return gender;
    }

    int getEnrollmentId() {
        return enrollmentId;
    }

    boolean isAvailable() {
        return available;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }
}
