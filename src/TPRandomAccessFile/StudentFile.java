package TPRandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Diego Mancini on 12/10/17.
 * Materia: AyED.
 */
public class StudentFile {
    private File file;
    private RandomAccessFile raf;
    private int studentSize;

    StudentFile(String name)throws FileNotFoundException {
        file = new File(name);
        raf = new RandomAccessFile(file,"rw");
        studentSize = 55;
    }

    public void write(Student student) throws IOException {
        raf.writeChars(student.getName());
        raf.writeChar(student.getGender());
        raf.writeInt(student.getEnrollmentId());
        raf.writeBoolean(student.isAvailable());
//        raf.close();
    }

    public Student search(int code) throws IOException{
        long cant = amountOfRegisters();
        beginning();
        Student student;
        for (int i =0 ; i < cant;i++){
            student = this.read();
            if(student.isAvailable() && (student.getEnrollmentId() == code))
                return student;
        }
        return new Student(null, 'X', -1);

    }

    public void close() throws IOException {
        raf.close();
    }

    boolean delete(int code) throws IOException{
        Student student = search(code);
        if (student.getEnrollmentId()!=0){
            raf.seek(raf.getFilePointer() - studentSize);
            student.setAvailable(false);
            write(student);
            return true;
        }
        else{
            return false;
        }
    }

    long replace(int code) throws IOException {
        long cant = amountOfRegisters();
        beginning();
        Student student;
        int counter = 0;
        for (int i = 0 ; i < cant;i++){
            student = read();
            if(student.isAvailable() && (student.getEnrollmentId() == code)){
                return (i * studentSize);

            }else {
               counter += studentSize;
            }

        }
        return -1;
    }

    void printEveryStudent() throws IOException {
        long cant = amountOfRegisters();
        beginning();
        Student student;
        for (int i =0 ; i < cant;i++){
            student = read();
            if( student.isAvailable()){
                printStudent(student);
            }
        }
    }

    void printEveryFemale() throws IOException {
        long cant = amountOfRegisters();
        beginning();
        Student student;
        for (int i =0 ; i < cant;i++){
            student = read();
            if (student.isAvailable() && isFemale(student)) {
                printStudent(student);
            }
        }
    }

    void printEveryMale() throws IOException {
        long cant = amountOfRegisters();
        beginning();
        Student student;
        for (int i =0 ; i < cant;i++){
            student = read();
            if (student.isAvailable() && !isFemale(student)) {
                printStudent(student);
            }
        }
    }

    int amountOfFemale() throws IOException {
        long cant = amountOfRegisters();
        int amount = 0;
        beginning();
        Student student;
        for (int i =0 ; i < cant;i++){
            student = read();
            if (student.isAvailable() && isFemale(student)){
                amount++;
            }
        }
        return amount;
    }

    int amountOfMale() throws IOException {
        long cant = amountOfRegisters();
        int amount = 0;
        beginning();
        Student student;
        for (int i =0 ; i < cant;i++){
            student = read();
            if (student.isAvailable() && !isFemale(student)){
                amount++;
            }
        }
        return amount;
    }

    private Student read() throws IOException{
        return new Student(raf.readUTF(), raf.readChar(), raf.readInt());
    }

    long amountOfRegisters() throws IOException {
        return raf.length()/studentSize;
    }

    private void beginning() throws IOException{
        raf.seek(0);
    }

    private boolean isFemale(Student student){
        return student.getGender() == 'F' || student.getGender() == 'f';
    }

    public void end() throws IOException{
        raf.seek(raf.length());
    }

    public void goTo(long refference) throws IOException{
        raf.seek((refference-1)*studentSize);
    }

    private void printStudent(Student student){
        System.out.println("Name: " + student.getName());
        System.out.println("Enrollment id: " + student.getEnrollmentId());
        System.out.println("Gender: " + student.getGender());

    }
}
