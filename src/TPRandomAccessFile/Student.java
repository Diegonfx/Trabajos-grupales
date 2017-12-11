package TPRandomAccessFile;

/**
 * Created by Diego Mancini on 10/12/17.
 * Materia: AyED.
 */
public class Student {
    private int enrollmentId; //8
    private char gender; //1
    private int year; //6
    private boolean available; //1

    Student(int enrollmentId, char gender, int year) {
        this.enrollmentId = enrollmentId;
        this.gender = gender;
        this.year = year;
        available = true;
    }

    public int getYear() {
        return year;
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
